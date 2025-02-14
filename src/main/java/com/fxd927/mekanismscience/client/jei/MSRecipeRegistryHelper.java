package com.fxd927.mekanismscience.client.jei;

import com.fxd927.mekanismscience.client.MSJEI;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.common.recipe.IMekanismRecipeTypeProvider;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MSRecipeRegistryHelper {
    private MSRecipeRegistryHelper() {
    }

    public static <RECIPE extends MekanismRecipe<?>> void register(IRecipeRegistration registry, IMSRecipeViewerRecipeType<RECIPE> recipeType,
                                                                   IMSRecipeTypeProvider<?, RECIPE, ?> type) {
        registry.addRecipes(MSJEI.holderRecipeType(recipeType), type.getRecipes(null));
    }

    public static <RECIPE> void register(IRecipeRegistration registry, IMSRecipeViewerRecipeType<RECIPE> recipeType, Map<ResourceLocation, RECIPE> recipes) {
        register(registry, recipeType, List.copyOf(recipes.values()));
    }

    public static <RECIPE> void register(IRecipeRegistration registry, IMSRecipeViewerRecipeType<RECIPE> recipeType, List<RECIPE> recipes) {
        registry.addRecipes(MSJEI.recipeType(recipeType), recipes);
    }
}
