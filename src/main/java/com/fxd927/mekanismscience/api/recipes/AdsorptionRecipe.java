package com.fxd927.mekanismscience.api.recipes;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ItemStackChemicalToObjectRecipe;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

@NothingNullByDefault
public abstract class AdsorptionRecipe extends ItemStackChemicalToObjectRecipe<ChemicalStack> {
    private static final Holder<Item> ADSORPTION = DeferredHolder.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MekanismScience.MODID, "adsorption"));

    @Override
    public final RecipeType<AdsorptionRecipe> getType() {
        return MSRecipeTypes.TYPE_ADSORPTION.value();
    }

    @Override
    public String getGroup() {
        return "radiation_irradiator";
    }

    //@Override
    //public ItemStack getToastSymbol() {
        //return new ItemStack(MSBlocks.RADIATION_IRRADIATOR);
        //}
}
