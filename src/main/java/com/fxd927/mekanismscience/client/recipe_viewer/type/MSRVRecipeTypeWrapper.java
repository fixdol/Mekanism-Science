package com.fxd927.mekanismscience.client.recipe_viewer.type;

import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.api.providers.IItemProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public record MSRVRecipeTypeWrapper <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache>(

        ResourceLocation id, IItemProvider item, Class<? extends RECIPE> recipeClass, IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> vanillaProvider,
        int xOffset, int yOffset, int width, int height, List<IItemProvider> workstations
) implements IMSRecipeViewerRecipeType<RECIPE>, IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> {
    public MSRVRecipeTypeWrapper(IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> vanillaProvider, Class<? extends RECIPE> recipeClass,
                                 int xOffset, int yOffset, int width, int height, IItemProvider icon, IItemProvider... altWorkstations) {
        this(vanillaProvider.getRegistryName(), icon, recipeClass, vanillaProvider, xOffset, yOffset, width, height, List.of(altWorkstations));
    }

    public MSRVRecipeTypeWrapper {
        if (workstations.isEmpty()) {
            workstations = List.of(item);
        } else {
            workstations = Stream.concat(Stream.of(item), workstations.stream()).toList();
        }
    }

    @Override
    public Component getTextComponent() {
        return item.getTextComponent();
    }

    @Override
    public boolean requiresHolder() {
        return true;
    }

    @Override
    public ItemStack iconStack() {
        return item.getItemStack();
    }

    @Nullable
    @Override
    public ResourceLocation icon() {
        //Handled by the icon stack
        return null;
    }

    @Override
    public MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE> getMSRecipeType() {
        return vanillaProvider.getMSRecipeType();
    }
}
