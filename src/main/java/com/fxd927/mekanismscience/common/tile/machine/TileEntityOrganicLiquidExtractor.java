package com.fxd927.mekanismscience.common.tile.machine;

import com.fxd927.mekanismscience.common.registries.MSBlocks;
import com.fxd927.mekanismscience.common.registries.MSFluids;
import mekanism.api.*;
import mekanism.api.math.FloatingLong;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.capabilities.resolver.BasicCapabilityResolver;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.inventory.slot.FluidInventorySlot;
import mekanism.common.inventory.slot.OutputInventorySlot;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.tile.base.SubstanceType;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.component.TileComponentConfig;
import mekanism.common.tile.component.TileComponentEjector;
import mekanism.common.tile.prefab.TileEntityConfigurableMachine;
import mekanism.common.util.FluidUtils;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.UpgradeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class TileEntityOrganicLiquidExtractor extends TileEntityConfigurableMachine implements IConfigurable {
    private static final int BASE_TICKS_REQUIRED = 19;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerFluidTankWrapper.class, methodNames = {"getFluid", "getFluidCapacity", "getFluidNeeded", "getFluidFilledPercentage"}, docPlaceholder = "buffer tank")
    public BasicFluidTank fluidTank;
    public int ticksRequired = BASE_TICKS_REQUIRED;

    public int operatingTicks;

    private MachineEnergyContainer<TileEntityOrganicLiquidExtractor> energyContainer;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "")
    FluidInventorySlot inputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getOutputItem", docPlaceholder = "")
    OutputInventorySlot outputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getEnergyItem", docPlaceholder = "")
    private EnergyInventorySlot energySlot;

    public TileEntityOrganicLiquidExtractor(BlockPos pos, BlockState state) {
        super(MSBlocks.ORGANIC_LIQUID_EXTRACTOR, pos, state);
        addCapabilityResolver(BasicCapabilityResolver.constant(Capabilities.CONFIGURABLE, this));
        addCapabilityResolver(BasicCapabilityResolver.constant(Capabilities.CONFIG_CARD, this));
        configComponent = new TileComponentConfig(this, TransmissionType.ITEM, TransmissionType.FLUID, TransmissionType.ENERGY);
        configComponent.setupItemIOConfig(List.of(inputSlot),List.of(outputSlot),energySlot,true);
        configComponent.setupOutputConfig(TransmissionType.FLUID , fluidTank);
        configComponent.setupInputConfig(TransmissionType.ENERGY , energyContainer);

        ejectorComponent = new TileComponentEjector(this);
        ejectorComponent.setOutputData(configComponent,TransmissionType.ITEM)
                .setCanEject(type -> MekanismUtils.canFunction(this));
        ejectorComponent.setOutputData(configComponent,TransmissionType.FLUID)
                .setCanEject(type -> MekanismUtils.canFunction(this));
    }

    @Nonnull
    @Override
    public IFluidTankHolder getInitialFluidTanks(IContentsListener listener) {
        FluidTankHelper builder = FluidTankHelper.forSide(this::getDirection);
        builder.addTank(fluidTank = BasicFluidTank.output(10_000, listener));
        return builder.build();
    }

    @Nonnull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSide(this::getDirection);
        builder.addContainer(energyContainer = MachineEnergyContainer.input(this, listener));
        return builder.build();
    }

    @Nonnull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(this::getDirection);
        builder.addSlot(inputSlot = FluidInventorySlot.drain(fluidTank, listener, 28, 20));
        builder.addSlot(outputSlot = OutputInventorySlot.at(listener, 28, 51));
        builder.addSlot(energySlot = EnergyInventorySlot.fillOrConvert(energyContainer, this::getLevel, listener, 143, 35));
        return builder.build();
    }

    @Override
    protected void onUpdateServer() {
        List<Entity> nearbyEntities = this.getLevel().getEntitiesOfClass(Entity.class, new AABB(this.getBlockPos()).inflate(2)); // 半径5ブロック内のモブを探す
        FluidStack fluidToGenerate = FluidStack.EMPTY;

        for (Entity entity : nearbyEntities) {
            if (entity instanceof Cow || entity instanceof Goat) {
                fluidToGenerate = new FluidStack(MSFluids.MILK.getFluid(), 100); // 牛ならミルクを生成
                break; // 牛がいた場合、それ以上探す必要はない
            } else if (entity instanceof Pufferfish) {
                fluidToGenerate = new FluidStack(MSFluids.TETRODOTOXIN.getFluid(), 100); // フグなら毒を生成
                break; // フグがいた場合、それ以上探す必要はない
            } else if (entity instanceof Phantom) {
                fluidToGenerate = new FluidStack(MSFluids.BENZODIAZEPINE.getFluid(), 100); // フグなら毒を生成
                break;
            }
        }

        if (!fluidToGenerate.isEmpty()) {
            energySlot.fillContainerOrConvert();
            inputSlot.drainTank(outputSlot);

            if (MekanismUtils.canFunction(this) && fluidToGenerate.getAmount() <= fluidTank.getNeeded()) {
                FloatingLong energyPerTick = energyContainer.getEnergyPerTick();

                if (energyContainer.extract(energyPerTick, Action.SIMULATE, AutomationType.INTERNAL).equals(energyPerTick)) {
                    operatingTicks++;

                    if (operatingTicks >= ticksRequired) {
                        operatingTicks = 0;
                        energyContainer.extract(energyPerTick, Action.EXECUTE, AutomationType.INTERNAL);
                        fluidTank.insert(fluidToGenerate, Action.EXECUTE, AutomationType.INTERNAL);
                    }
                }
            }
            if (!fluidTank.isEmpty()) {
                FluidUtils.emit(Collections.singleton(Direction.UP), fluidTank, this, 256 * (1 + upgradeComponent.getUpgrades(Upgrade.SPEED)));
            }
        }
    }

    @Override
    public void saveAdditional(@Nonnull CompoundTag nbtTags) {
        super.saveAdditional(nbtTags);
        nbtTags.putInt(NBTConstants.PROGRESS, operatingTicks);
    }

    @Override
    public void load(@Nonnull CompoundTag nbt) {
        super.load(nbt);

        operatingTicks = nbt.getInt(NBTConstants.PROGRESS);
    }

    @Override
    public InteractionResult onSneakRightClick(Player player) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult onRightClick(Player player) {
        return InteractionResult.PASS;
    }

    @Override
    public boolean canPulse() {
        return true;
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (upgrade == Upgrade.SPEED) {
            ticksRequired = MekanismUtils.getTicks(this, BASE_TICKS_REQUIRED);
        }
    }

    @Override
    public int getRedstoneLevel() {
        return MekanismUtils.redstoneLevelFromContents(fluidTank.getFluidAmount(), fluidTank.getCapacity());
    }

    @Override
    protected boolean makesComparatorDirty(@Nullable SubstanceType type) {
        return type == SubstanceType.FLUID;
    }

    @Override
    public List<Component> getInfo(Upgrade upgrade) {
        return UpgradeUtils.getMultScaledInfo(this, upgrade);
    }

    public MachineEnergyContainer<TileEntityOrganicLiquidExtractor> getEnergyContainer() {
        return energyContainer;
    }
}
