package com.fxd927.mekanismscience.client.recipe_viewer.jei;

import com.fxd927.mekanismscience.client.MSJEI;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import mekanism.client.recipe_viewer.jei.BaseRecipeCategory;
import mekanism.client.recipe_viewer.jei.MekanismJEI;
import mekanism.client.recipe_viewer.type.IRecipeViewerRecipeType;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;

public abstract class MSHolderRecipeCategory <RECIPE extends Recipe<?>> extends MSBaseRecipeCategory<RecipeHolder<RECIPE>> {
    protected MSHolderRecipeCategory(IGuiHelper helper, IMSRecipeViewerRecipeType<RECIPE> recipeType) {
        super(helper, MSJEI.holderRecipeType(recipeType), recipeType.getTextComponent(), createIcon(helper, recipeType), recipeType.xOffset(), recipeType.yOffset(), recipeType.width(), recipeType.height());
    }

    @NotNull
    @Override
    public ResourceLocation getRegistryName(RecipeHolder<RECIPE> recipe) {
        return recipe.id();
    }
}
