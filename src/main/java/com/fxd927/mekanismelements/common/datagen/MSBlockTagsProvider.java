package com.fxd927.mekanismelements.common.datagen;

import com.fxd927.mekanismelements.common.MekanismElements;
import com.fxd927.mekanismelements.common.registries.MSBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class MSBlockTagsProvider extends BlockTagsProvider {

    public MSBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MekanismElements.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MSBlocks.ADSORPTION_SEPARATOR.get())
                .add(MSBlocks.AIR_COMPRESSOR.get())
                .add(MSBlocks.RADIATION_IRRADIATOR.get())
                .add(MSBlocks.SEAWATER_PUMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(MSBlocks.ADSORPTION_SEPARATOR.get())
                .add(MSBlocks.AIR_COMPRESSOR.get())
                .add(MSBlocks.RADIATION_IRRADIATOR.get())
                .add(MSBlocks.SEAWATER_PUMP.get());
    }
}