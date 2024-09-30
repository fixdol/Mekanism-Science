package com.fxd927.mekanismscience.common.tile.machine;

import com.fxd927.mekanismscience.common.registries.MSFluids;
import mekanism.api.*;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.slot.FluidInventorySlot;
import mekanism.common.inventory.slot.OutputInventorySlot;
import mekanism.common.tile.prefab.TileEntityConfigurableMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;

public class TileEntityAdsorptionMetalExtractor extends TileEntityConfigurableMachine {
    private static final int BASE_TICKS_REQUIRED = 19;
    public static final FluidStack FLUID_STACK = new FluidStack(MSFluids.SEAWATER.getFluid(), 1000);

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerFluidTankWrapper.class, methodNames = {"getFluid", "getFluidCapacity", "getFluidNeeded", "getFluidFilledPercentage"}, docPlaceholder = "buffer tank")
    public BasicFluidTank fluidTank;
    public int ticksRequired = BASE_TICKS_REQUIRED;

    public int operatingTicks;

    private MachineEnergyContainer<TileEntitySeawaterPump> energyContainer;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "")
    FluidInventorySlot inputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getFirstOutputItem", docPlaceholder = "")
    OutputInventorySlot firstOutputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getSecondOutputItem", docPlaceholder = "")
    OutputInventorySlot secondOutputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getThirdOutputItem", docPlaceholder = "")
    OutputInventorySlot thirdOutputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getForthOutputItem", docPlaceholder = "")
    OutputInventorySlot forthOutputSlot;

    public TileEntityAdsorptionMetalExtractor(BlockPos pos, BlockState state){
        super(null, pos, state);
    }

    @Nonnull
    @Override
    public IFluidTankHolder getInitialFluidTanks(IContentsListener listener) {
        FluidTankHelper builder = FluidTankHelper.forSide(this::getDirection);
        builder.addTank(fluidTank = BasicFluidTank.output(10_000, listener), RelativeSide.TOP);
        return builder.build();
    }

    @Nonnull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(this::getDirection);
        builder.addSlot(inputSlot = FluidInventorySlot.drain(fluidTank, listener, 28, 20), RelativeSide.TOP);
        builder.addSlot(firstOutputSlot = OutputInventorySlot.at(listener, 116, 35));
        builder.addSlot(secondOutputSlot = OutputInventorySlot.at(listener, 132, 35));
        builder.addSlot(thirdOutputSlot = OutputInventorySlot.at(listener, 148,35));
        builder.addSlot(forthOutputSlot = OutputInventorySlot.at(listener, 162, 35));
        return builder.build();
    }

    @Override
    protected void onUpdateServer() {
        super.onUpdateServer();
    }

}
