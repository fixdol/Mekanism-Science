package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.api.recipes.NeutronIrradiatingRecipe;
import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.recipe.impl.NeutronIrradiatingIRecipe;
import com.fxd927.mekanismscience.common.recipe.serializer.NeutronIrradiatorRecipeSerializer;
import mekanism.common.registration.impl.RecipeSerializerDeferredRegister;
import mekanism.common.registration.impl.RecipeSerializerRegistryObject;

public class MSRecipeSerializers {
    public static final RecipeSerializerDeferredRegister RECIPE_SERIALIZERS = new RecipeSerializerDeferredRegister(MekanismScience.MODID);

    public static final RecipeSerializerRegistryObject<NeutronIrradiatingRecipe> NEUTRON_IRRADIATING = RECIPE_SERIALIZERS.register("neutron_irradiating", () -> new NeutronIrradiatorRecipeSerializer<>(NeutronIrradiatingIRecipe::new));

    private MSRecipeSerializers(){
    }
}
