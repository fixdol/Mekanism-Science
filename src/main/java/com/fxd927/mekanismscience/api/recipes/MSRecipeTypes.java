package com.fxd927.mekanismscience.api.recipes;

import com.fxd927.mekanismscience.common.MekanismScience;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MSRecipeTypes {
    public static final ResourceLocation NAME_RADIATION_IRRADIATING = ResourceLocation.fromNamespaceAndPath(MekanismScience.MODID, "radiation_irradiating");
    public static final ResourceLocation NAME_ADSORPTION = ResourceLocation.fromNamespaceAndPath(MekanismScience.MODID, "adsorption");
    public static final DeferredHolder<RecipeType<?>, RecipeType<RadiationIrradiatingRecipe>> TYPE_RADIATION_IRRADIATING = DeferredHolder.create(Registries.RECIPE_TYPE, NAME_RADIATION_IRRADIATING);
    public static final DeferredHolder<RecipeType<?>, RecipeType<AdsorptionRecipe>> TYPE_ADSORPTION = DeferredHolder.create(Registries.RECIPE_TYPE, NAME_ADSORPTION);
}
