package com.fxd927.mekanismscience.common;

import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.common.recipe.MekanismRecipeType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.jetbrains.annotations.NotNull;

public class MSReloadListener implements ResourceManagerReloadListener {
    @Override
    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {
        MSRecipeType.clearCache();
    }
}
