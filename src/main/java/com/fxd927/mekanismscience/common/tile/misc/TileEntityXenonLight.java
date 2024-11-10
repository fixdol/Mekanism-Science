package com.fxd927.mekanismscience.common.tile.misc;

import com.fxd927.mekanismscience.common.registries.MSBlocks;
import mekanism.api.Action;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.energy.IStrictEnergyHandler;
import mekanism.api.math.FloatingLong;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TileEntityXenonLight extends TileEntityMekanism{
    private final BasicEnergyContainer energyContainer = BasicEnergyContainer.create(
            FloatingLong.createConst(10000),
            type -> true,
            type -> true,
            this
    );

    private final LazyOptional<IEnergyContainer> energyContainerLazyOptional = LazyOptional.of(() -> energyContainer);

    public TileEntityXenonLight(BlockPos pos, BlockState state) {
        super(null, pos, state);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability) {
        if (capability == Capabilities.STRICT_ENERGY) {
            return LazyOptional.of(() -> new StrictEnergyHandlerWrapper(energyContainer)).cast();
        }
        return super.getCapability(capability);
    }

    public FloatingLong getEnergy() {
        return energyContainer.getEnergy();
    }

    public static class StrictEnergyHandlerWrapper implements IStrictEnergyHandler {
        private final IEnergyContainer energyContainer;

        public StrictEnergyHandlerWrapper(IEnergyContainer energyContainer) {
            this.energyContainer = energyContainer;
        }

        @Override
        public int getEnergyContainerCount() {
            return 0;
        }

        @Override
        public FloatingLong getEnergy(int container) {
            return energyContainer.getEnergy();
        }

        @Override
        public void setEnergy(int container, FloatingLong energy) {
            energyContainer.setEnergy(energy);
        }

        @Override
        public FloatingLong getMaxEnergy(int container) {
            return energyContainer.getMaxEnergy();
        }

        @Override
        public FloatingLong getNeededEnergy(int container) {
            return energyContainer.getNeeded();
        }

        @Override
        public FloatingLong insertEnergy(int container, FloatingLong amount, Action action) {
            return FloatingLong.ZERO;
        }

        @Override
        public FloatingLong extractEnergy(int container, FloatingLong amount, Action action) {
            return FloatingLong.ZERO;
        }
    }
}
