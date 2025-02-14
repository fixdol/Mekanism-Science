package com.fxd927.mekanismscience.api.recipes;

import com.fxd927.mekanismscience.api.recipes.basic.BasicAdsorptionRecipe;
import com.fxd927.mekanismscience.api.recipes.basic.BasicRadiationIrradiatingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MSRecipeSerializers {
    public static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BasicRadiationIrradiatingRecipe>> RADIATION_IRRADIATING;
    public static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BasicAdsorptionRecipe>> ADSORPTION;
}
