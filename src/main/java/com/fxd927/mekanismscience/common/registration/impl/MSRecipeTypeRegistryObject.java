package com.fxd927.mekanismscience.common.registration.impl;

import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import mekanism.common.registration.MekanismDeferredHolder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

public class MSRecipeTypeRegistryObject <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache> extends
        MekanismDeferredHolder<RecipeType<?>, MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>> implements IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> {
    public MSRecipeTypeRegistryObject(ResourceKey<RecipeType<?>> key) {
        super(key);
    }

    @Override
    public MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE> getMSRecipeType() {
        return value();
    }
}
