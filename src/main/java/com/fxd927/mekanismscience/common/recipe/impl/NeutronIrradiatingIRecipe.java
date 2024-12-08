package com.fxd927.mekanismscience.common.recipe.impl;

import com.fxd927.mekanismscience.api.recipes.NeutronIrradiatingRecipe;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import com.fxd927.mekanismscience.common.registries.MSRecipeSerializers;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class NeutronIrradiatingIRecipe extends NeutronIrradiatingRecipe {
    public NeutronIrradiatingIRecipe(ResourceLocation id, ItemStackIngredient itemInput, ChemicalStackIngredient.GasStackIngredient gasInput, ChemicalStack<?> output) {
        super(id, itemInput, gasInput, output);
    }

    @Override
    public RecipeType<NeutronIrradiatingRecipe> getType() {
        return MSRecipeType.NEUTRON_IRRADIATING.get();
    }

    @Override
    public RecipeSerializer<NeutronIrradiatingRecipe> getSerializer() {
        return MSRecipeSerializers.NEUTRON_IRRADIATING.get();
    }

    @Override
    public String getGroup() {
        return MSBlocks.NEUTRON_IRRADIATOR.getName();
    }

    @Override
    public ItemStack getToastSymbol() {
        return MSBlocks.NEUTRON_IRRADIATOR.getItemStack();
    }
}
