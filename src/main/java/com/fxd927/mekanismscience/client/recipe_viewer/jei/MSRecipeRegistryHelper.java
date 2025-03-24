package com.fxd927.mekanismscience.client.recipe_viewer.jei;

import com.fxd927.mekanismscience.client.MSJEI;
import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.client.recipe_viewer.type.IRecipeViewerRecipeType;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public class MSRecipeRegistryHelper {
    private MSRecipeRegistryHelper() {
    }

    public static <RECIPE extends MekanismRecipe<?>> void register(IRecipeRegistration registry, IRecipeViewerRecipeType<RECIPE> recipeType,
                                                                   IMSRecipeTypeProvider<?, RECIPE, ?> type) {
        registry.addRecipes(MSJEI.holderRecipeType(recipeType), type.getRecipes(null));
    }

    public static <RECIPE> void register(IRecipeRegistration registry, IRecipeViewerRecipeType<RECIPE> recipeType, Map<ResourceLocation, RECIPE> recipes) {
        register(registry, recipeType, List.copyOf(recipes.values()));
    }

    public static <RECIPE> void register(IRecipeRegistration registry, IRecipeViewerRecipeType<RECIPE> recipeType, List<RECIPE> recipes) {
        registry.addRecipes(MSJEI.recipeType(recipeType), recipes);
    }
}
