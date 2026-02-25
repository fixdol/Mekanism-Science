package com.fxd927.mekanismelements.common.datagen;

import com.fxd927.mekanismelements.common.registries.MSBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Set;

public class MSBlockLootTables extends BlockLootSubProvider {

    protected MSBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(MSBlocks.ADSORPTION_SEPARATOR.get());
        dropSelf(MSBlocks.AIR_COMPRESSOR.get());
        dropSelf(MSBlocks.RADIATION_IRRADIATOR.get());
        dropSelf(MSBlocks.SEAWATER_PUMP.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return List.of(
                MSBlocks.ADSORPTION_SEPARATOR.get(),
                MSBlocks.AIR_COMPRESSOR.get(),
                MSBlocks.RADIATION_IRRADIATOR.get(),
                MSBlocks.SEAWATER_PUMP.get()
        );
    }
}