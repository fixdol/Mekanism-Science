package com.fxd927.mekanismscience.common.registration.impl;

import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import mekanism.common.registration.MekanismDeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Function;

public class MSRecipeTypeDeferredRegister extends MekanismDeferredRegister<RecipeType<?>> {
    public MSRecipeTypeDeferredRegister(String modid) {
        super(Registries.RECIPE_TYPE, modid, MSRecipeTypeRegistryObject::new);
    }

    public <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache>
    MSRecipeTypeRegistryObject<VANILLA_INPUT, RECIPE, INPUT_CACHE> registerMek(String name, Function<ResourceLocation, ? extends MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>> func) {
        return (MSRecipeTypeRegistryObject<VANILLA_INPUT, RECIPE, INPUT_CACHE>) super.register(name, func);
    }
}
