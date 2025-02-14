package com.fxd927.mekanismscience.common.tile.machine;

import com.fxd927.mekanismscience.common.registries.MSChemicals;
import mekanism.api.*;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalTank;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.slot.EnergyInventorySlot;
import mekanism.common.inventory.slot.chemical.ChemicalInventorySlot;
import mekanism.common.tile.prefab.TileEntityConfigurableMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityAirCompressor extends TileEntityConfigurableMachine implements IConfigurable {
    private static final int BASE_TICKS_REQUIRED = 19;
    public static final ChemicalStack COMPRESSED_AIR_STACK = new ChemicalStack(MSChemicals.YTTRIUM, 100);

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerChemicalTankWrapper.class, methodNames = {"getGas", "getGasCapacity", "getGasNeeded", "getGasFilledPercentage"}, docPlaceholder = "buffer tank")
    public IChemicalTank gasTank;
    public int ticksRequired = BASE_TICKS_REQUIRED;

    public int operatingTicks;

    private MachineEnergyContainer<TileEntityAirCompressor> energyContainer;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "")
    ChemicalInventorySlot inputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getOutputItem", docPlaceholder = "")
    ChemicalInventorySlot outputSlot;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getEnergyItem", docPlaceholder = "")
    private EnergyInventorySlot energySlot;


    public TileEntityAirCompressor(BlockPos pos, BlockState state) {
        super(null, pos, state);
    }

    @Override
    public InteractionResult onSneakRightClick(Player player) {
        return null;
    }

    @Override
    public InteractionResult onRightClick(Player player) {
        return null;
    }
}
