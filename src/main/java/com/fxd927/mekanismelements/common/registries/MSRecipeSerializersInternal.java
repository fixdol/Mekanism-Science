package com.fxd927.mekanismelements.common.registries;

import com.fxd927.mekanismelements.api.recipes.MSRecipeSerializers;
import com.fxd927.mekanismelements.api.recipes.basic.BasicAdsorptionRecipe;
import com.fxd927.mekanismelements.api.recipes.basic.BasicRadiationIrradiatingRecipe;
import com.fxd927.mekanismelements.common.MekanismElements;
import com.fxd927.mekanismelements.common.recipe.serializer.MSRecipeSerializer;
import mekanism.api.recipes.MekanismRecipeSerializers;
import mekanism.api.recipes.basic.BasicChemicalDissolutionRecipe;
import mekanism.common.Mekanism;
import mekanism.common.recipe.serializer.MekanismRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MSRecipeSerializersInternal {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MekanismElements.MODID);

    static {
        MSRecipeSerializers.RADIATION_IRRADIATING = RECIPE_SERIALIZERS.register("radiation_irradiating", () -> MSRecipeSerializer.radiationIrradiating(BasicRadiationIrradiatingRecipe::new));
        MSRecipeSerializers.ADSORPTION = RECIPE_SERIALIZERS.register("adsorption", () -> MSRecipeSerializer.adsorption(BasicAdsorptionRecipe::new));
    }

    private MSRecipeSerializersInternal(){
    }
}
