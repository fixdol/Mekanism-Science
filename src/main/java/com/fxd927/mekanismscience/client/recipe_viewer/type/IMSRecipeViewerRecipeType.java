package com.fxd927.mekanismscience.client.recipe_viewer.type;

import mekanism.api.providers.IItemProvider;
import mekanism.api.text.IHasTextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IMSRecipeViewerRecipeType<RECIPE> extends IHasTextComponent {
    ResourceLocation id();

    Class<? extends RECIPE> recipeClass();

    boolean requiresHolder();

    ItemStack iconStack();

    @Nullable
    ResourceLocation icon();

    int xOffset();

    int yOffset();

    int width();

    int height();

    List<IItemProvider> workstations();
}
