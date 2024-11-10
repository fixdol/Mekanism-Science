package com.fxd927.mekanismscience.common.block;

import com.fxd927.mekanismscience.common.tile.misc.TileEntityXenonLight;
import mekanism.api.math.FloatingLong;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class XenonLight extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public XenonLight() {
        super(BlockBehaviour.Properties.of().strength(3.0F).lightLevel(state -> state.getValue(ACTIVE) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TileEntityXenonLight xenonLightBlockEntity) {
                if (xenonLightBlockEntity.getEnergy().greaterThan(FloatingLong.ZERO)) {
                    if (!state.getValue(ACTIVE)) {
                        activateLight(level, pos);
                    }
                } else {
                    if (state.getValue(ACTIVE)) {
                        deactivateLight(level, pos);
                    }
                }
            }
        }
    }

    private void activateLight(Level level, BlockPos pos) {
        BlockState newState = this.defaultBlockState().setValue(ACTIVE, true);
        level.setBlock(pos, newState, 3);
        level.setBlockAndUpdate(pos, newState);
        illuminateAround(level, pos);
    }

    private void deactivateLight(Level level, BlockPos pos) {
        BlockState newState = this.defaultBlockState().setValue(ACTIVE, false);
        level.setBlock(pos, newState, 3);
        level.setBlockAndUpdate(pos, newState);
        removeIllumination(level, pos);
    }

    private void illuminateAround(Level level, BlockPos pos) {
        BlockPos.betweenClosedStream(pos.offset(-50, -50, -50), pos.offset(50, 50, 50)).forEach(p -> {
            if (level.isEmptyBlock(p)) {
                level.setBlock(p, Blocks.LIGHT.defaultBlockState().setValue(LightBlock.LEVEL, 15), 3);
            }
        });
    }

    private void removeIllumination(Level level, BlockPos pos) {
        BlockPos.betweenClosedStream(pos.offset(-50, -50, -50), pos.offset(50, 50, 50)).forEach(p -> {
            if (level.getBlockState(p).is(Blocks.LIGHT)) {
                level.setBlock(p, Blocks.AIR.defaultBlockState(), 3);
            }
        });
    }
}
