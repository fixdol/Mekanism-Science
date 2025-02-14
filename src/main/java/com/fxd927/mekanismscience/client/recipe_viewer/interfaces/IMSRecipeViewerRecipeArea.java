package com.fxd927.mekanismscience.client.recipe_viewer.interfaces;

import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSRecipeLookupHandler;
import mekanism.client.gui.element.GuiElement;
import net.minecraft.client.gui.components.events.GuiEventListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IMSRecipeViewerRecipeArea<ELEMENT extends GuiElement> extends GuiEventListener {
    @Nullable
    IMSRecipeViewerRecipeType<?>[] getRecipeCategories();

    default boolean isRecipeViewerAreaActive() {
        return true;
    }

    ELEMENT recipeViewerCategories(@NotNull IMSRecipeViewerRecipeType<?>... recipeCategories);

    default ELEMENT recipeViewerCategory(IMSRecipeLookupHandler<?> recipeLookup) {
        IMSRecipeViewerRecipeType<?> recipeType = recipeLookup.recipeViewerType();
        if (recipeType != null) {
            return recipeViewerCategories(recipeType);
        }
        return (ELEMENT) this;
    }

    default boolean isMouseOverRecipeViewerArea(double mouseX, double mouseY) {
        return isMouseOver(mouseX, mouseY);
    }

}
