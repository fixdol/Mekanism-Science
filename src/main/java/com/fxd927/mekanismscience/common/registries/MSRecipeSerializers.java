package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.api.recipes.AdsorptionRecipe;
import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.recipe.impl.AdsorptionIRecipe;
import com.fxd927.mekanismscience.common.recipe.impl.RadiationIrradiatingIRecipe;
import com.fxd927.mekanismscience.common.recipe.serializer.AdsorptionRecipeSerializer;
import com.fxd927.mekanismscience.common.recipe.serializer.RadiationIrradiatorRecipeSerializer;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import mekanism.common.registration.impl.RecipeSerializerDeferredRegister;
import mekanism.common.registration.impl.RecipeSerializerRegistryObject;
import net.minecraft.resources.ResourceLocation;

public class MSRecipeSerializers {
    public static final RecipeSerializerDeferredRegister RECIPE_SERIALIZERS = new RecipeSerializerDeferredRegister(MekanismScience.MODID);

    public static final RecipeSerializerRegistryObject<AdsorptionRecipe> ADSORPTION_SEPARATOR = RECIPE_SERIALIZERS.register("adsorption", () -> new AdsorptionRecipeSerializer<>((ResourceLocation id, ItemStackIngredient itemInput, ChemicalStackIngredient.GasStackIngredient fluidInput, ChemicalStack<?> output) -> new AdsorptionIRecipe(id, itemInput, fluidInput, output)));
    public static final RecipeSerializerRegistryObject<RadiationIrradiatingRecipe> RADIATION_IRRADIATOR = RECIPE_SERIALIZERS.register("radiation_irradiating", () -> new RadiationIrradiatorRecipeSerializer<>(RadiationIrradiatingIRecipe::new));

    private MSRecipeSerializers(){
    }
}
