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
import mekanism.common.registries.MekanismItems;
import mekanism.common.tile.component.TileComponentConfig;
import mekanism.common.tile.component.TileComponentEjector;
import mekanism.common.tile.prefab.TileEntityConfigurableMachine;
import mekanism.common.util.MekanismUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class TileEntityAdsorptionTypeSeawaterMetalExtractor extends TileEntityConfigurableMachine implements IConfigurable {
    private static final int BASE_TICKS_REQUIRED = 20;

    //内部タンク
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerFluidTankWrapper.class, methodNames = {"getFluid", "getFluidCapacity", "getFluidNeeded", "getFluidFilledPercentage"}, docPlaceholder = "buffer tank")
    public BasicFluidTank fluidTank;
    //tick取得
    public int ticksRequired = BASE_TICKS_REQUIRED;
    public int operatingTicks;

    private MachineEnergyContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor> energyContainer;


    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputFluid", docPlaceholder = "")
    FluidInventorySlot inputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getFirstOutputItem", docPlaceholder = "")
    OutputInventorySlot firstOutputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getSecondOutputItem", docPlaceholder = "")
    OutputInventorySlot secondOutputSlot;
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getEnergyItem", docPlaceholder = "")
    EnergyInventorySlot energySlot;

    public TileEntityAdsorptionTypeSeawaterMetalExtractor(BlockPos pos, BlockState state) {
        super(MSBlocks.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR, pos, state);
        addCapabilityResolver(BasicCapabilityResolver.constant(Capabilities.CONFIGURABLE, this));
        addCapabilityResolver(BasicCapabilityResolver.constant(Capabilities.CONFIG_CARD, this));
        configComponent = new TileComponentConfig(this, TransmissionType.ITEM, TransmissionType.FLUID, TransmissionType.ENERGY);
        configComponent.setupItemIOConfig(List.of(inputSlot),List.of(firstOutputSlot,secondOutputSlot),energySlot,true);
        configComponent.setupInputConfig(TransmissionType.FLUID , fluidTank);
        configComponent.setupInputConfig(TransmissionType.ENERGY , energyContainer);

        ejectorComponent = new TileComponentEjector(this);
        ejectorComponent.setOutputData(configComponent,TransmissionType.ITEM,TransmissionType.ITEM)
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

    //インベントリGUI
    @Nonnull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(this::getDirection);
        builder.addSlot(inputSlot = FluidInventorySlot.drain(fluidTank, listener, 8, 65));
        builder.addSlot(firstOutputSlot = OutputInventorySlot.at(listener, 20, 20));
        builder.addSlot(secondOutputSlot = OutputInventorySlot.at(listener, 40, 20));
        builder.addSlot(energySlot = EnergyInventorySlot.fillOrConvert(energyContainer, this::getLevel, listener, 152, 5));
        return builder.build();
    }

    //update
    @Override
    protected void onUpdateServer() {
        super.onUpdateServer();
    }

    @Override
    public void saveAdditional(@Nonnull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putInt(NBTConstants.PROGRESS, operatingTicks);
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

    public MachineEnergyContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor> getEnergyContainer() {return energyContainer;}
}