package com.fxd927.mekanismelements.common.recipe;

import com.fxd927.mekanismelements.api.recipes.MSRecipeTypes;
import com.fxd927.mekanismelements.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismelements.common.MekanismElements;
import com.fxd927.mekanismelements.common.recipe.lookup.cache.MSInputRecipeCache;
import com.fxd927.mekanismelements.common.registration.impl.MSRecipeTypeDeferredRegister;
import com.fxd927.mekanismelements.common.registration.impl.MSRecipeTypeRegistryObject;
import mekanism.api.recipes.ItemStackToChemicalRecipe;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.MekanismRecipeTypes;
import mekanism.api.recipes.vanilla_input.SingleItemChemicalRecipeInput;
import mekanism.client.MekanismClient;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import mekanism.common.recipe.lookup.cache.InputRecipeCache;
import mekanism.common.registration.impl.RecipeTypeRegistryObject;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MSRecipeType<VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache>
        implements RecipeType<RECIPE>, IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> {
    public static final MSRecipeTypeDeferredRegister RECIPE_TYPES = new MSRecipeTypeDeferredRegister(MekanismElements.MODID);

    public static final MSRecipeTypeRegistryObject<SingleItemChemicalRecipeInput, RadiationIrradiatingRecipe, MSInputRecipeCache.ItemChemical<RadiationIrradiatingRecipe>> RADIATION_IRRADIATING =
            register(MSRecipeTypes.NAME_RADIATION_IRRADIATING, recipeType -> new MSInputRecipeCache.ItemChemical<>(recipeType, RadiationIrradiatingRecipe::getItemInput, RadiationIrradiatingRecipe::getChemicalInput));
    public static final MSRecipeTypeRegistryObject<SingleRecipeInput, ItemStackToChemicalRecipe, MSInputRecipeCache.SingleItem<ItemStackToChemicalRecipe>> CHEMICAL_CONVERSION =
            register(MSRecipeTypes.NAME_CHEMICAL_CONVERSION, recipeType -> new MSInputRecipeCache.SingleItem<>(recipeType, ItemStackToChemicalRecipe::getInput));

    private static <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache>
    MSRecipeTypeRegistryObject<VANILLA_INPUT, RECIPE, INPUT_CACHE> register(
            ResourceLocation name,
            Function<MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>, INPUT_CACHE> inputCacheCreator
    ) {
        if (!MekanismElements.MODID.equals(name.getNamespace())) {
            throw new IllegalStateException("Name must be in " + MekanismElements.MODID + " namespace");
        }
        return RECIPE_TYPES.registerMek(name.getPath(), registryName -> new MSRecipeType<>(registryName, inputCacheCreator));
    }

    public static void clearCache() {
        for (Holder<RecipeType<?>> entry : RECIPE_TYPES.getEntries()) {
            if (entry.value() instanceof MSRecipeType<?, ?, ?> recipeType) {
                recipeType.clearCaches();
            }
        }
    }

    private List<RecipeHolder<RECIPE>> cachedRecipes = Collections.emptyList();
    private final ResourceLocation registryName;
    private final INPUT_CACHE inputCache;

    private MSRecipeType(ResourceLocation name, Function<MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>, INPUT_CACHE> inputCacheCreator) {
        this.registryName = name;
        this.inputCache = inputCacheCreator.apply(this);
    }

    @Override
    public String toString() {
        return registryName.toString();
    }

    @Override
    public ResourceLocation getRegistryName() {
        return registryName;
    }

    @Override
    public MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE> getMSRecipeType() {
        return this;
    }

    private void clearCaches() {
        cachedRecipes = Collections.emptyList();
        inputCache.clear();
    }

    @Override
    public INPUT_CACHE getInputCache() {
        return inputCache;
    }

    @Nullable
    private Level getLevel(@Nullable Level level) {
        if (level == null) {
            if (FMLEnvironment.dist.isClient()) {
                return MekanismClient.tryGetClientWorld();
            }
            return ServerLifecycleHooks.getCurrentServer().overworld();
        }
        return level;
    }

    @NotNull
    @Override
    public List<RecipeHolder<RECIPE>> getRecipes(@Nullable Level world) {
        world = getLevel(world);
        if (world == null) {
            return Collections.emptyList();
        }
        return getRecipes(world.getRecipeManager(), world);
    }

    @NotNull
    @Override
    public List<RecipeHolder<RECIPE>> getRecipes(RecipeManager recipeManager, @Nullable Level world) {
        if (cachedRecipes.isEmpty()) {
            List<RecipeHolder<RECIPE>> recipes = recipeManager.getAllRecipesFor(this);
            cachedRecipes = recipes.stream()
                    .filter(recipe -> !recipe.value().isIncomplete())
                    .toList();
        }
        return cachedRecipes;
    }

    @SuppressWarnings("unchecked")
    private RECIPE castRecipe(MekanismRecipe<?> o) {
        if (o.getType() != this) {
            throw new IllegalArgumentException("Wrong recipe type");
        }
        return (RECIPE) o;
    }

    /**
     * Helper for getting a recipe from a world's recipe manager.
     */
    public static <I extends RecipeInput, RECIPE_TYPE extends Recipe<I>> Optional<RecipeHolder<RECIPE_TYPE>> getRecipeFor(RecipeType<RECIPE_TYPE> recipeType, I input,
                                                                                                                          Level level) {
        return level.getRecipeManager().getRecipeFor(recipeType, input, level)
                .filter(recipe -> recipe.value().isSpecial() || !recipe.value().isIncomplete());
    }

    /**
     * Helper for getting a recipe from a world's recipe manager.
     */
    public static Optional<RecipeHolder<?>> byKey(Level level, ResourceLocation id) {
        return level.getRecipeManager().byKey(id)
                .filter(recipe -> recipe.value().isSpecial() || !recipe.value().isIncomplete());
    }
}
