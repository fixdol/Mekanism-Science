package com.fxd927.mekanismscience.common.recipe;

import com.fxd927.mekanismscience.common.registration.impl.MSRecipeTypeDeferredRegister;
import com.fxd927.mekanismscience.common.registration.impl.MSRecipeTypeRegistryObject;
import mekanism.api.recipes.*;
import mekanism.client.MekanismClient;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

public class MSRecipeType<VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache>
        implements RecipeType<RECIPE>, IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> {
    public static final MSRecipeTypeDeferredRegister RECIPE_TYPES = new MSRecipeTypeDeferredRegister("mekanismelements");

    private List<RecipeHolder<RECIPE>> cachedRecipes = Collections.emptyList();
    private final ResourceLocation registryName;
    private final INPUT_CACHE inputCache;

    private static <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache> MSRecipeTypeRegistryObject<VANILLA_INPUT, RECIPE, INPUT_CACHE> register(ResourceLocation name, Function<MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>, INPUT_CACHE> inputCacheCreator) {
        if (!"mekanismelements".equals(name.getNamespace())) {
            throw new IllegalStateException("Name must be in mekanism namespace");
        } else {
            return RECIPE_TYPES.registerMek(name.getPath(), (registryName) -> {
                return new MSRecipeType(registryName, inputCacheCreator);
            });
        }
    }

    public static void clearCache() {
        Iterator var0 = RECIPE_TYPES.getEntries().iterator();

        while(var0.hasNext()) {
            Holder<RecipeType<?>> entry = (Holder)var0.next();
            Object var3 = entry.value();
            if (var3 instanceof MSRecipeType<?, ?, ?> recipeType) {
                recipeType.clearCaches();
            }
        }

    }

    private MSRecipeType(ResourceLocation name, Function<MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE>, INPUT_CACHE> inputCacheCreator) {
        this.registryName = name;
        this.inputCache = (IInputRecipeCache)inputCacheCreator.apply(this);
    }

    public String toString() {
        return this.registryName.toString();
    }

    public ResourceLocation getRegistryName() {
        return this.registryName;
    }

    public MSRecipeType<VANILLA_INPUT, RECIPE, INPUT_CACHE> getMSRecipeType() {
        return this;
    }

    private void clearCaches() {
        this.cachedRecipes = Collections.emptyList();
        this.inputCache.clear();
    }

    public INPUT_CACHE getInputCache() {
        return this.inputCache;
    }

    private @Nullable Level getLevel(@Nullable Level level) {
        if (level == null) {
            return (Level)(FMLEnvironment.dist.isClient() ? MekanismClient.tryGetClientWorld() : ServerLifecycleHooks.getCurrentServer().overworld());
        } else {
            return level;
        }
    }

    public @NotNull List<RecipeHolder<RECIPE>> getRecipes(@Nullable Level world) {
        world = this.getLevel(world);
        return world == null ? Collections.emptyList() : this.getRecipes(world.getRecipeManager(), world);
    }

    private RECIPE castRecipe(MekanismRecipe<?> o) {
        if (o.getType() != this) {
            throw new IllegalArgumentException("Wrong recipe type");
        } else {
            return o;
        }
    }

    public static <I extends RecipeInput, RECIPE_TYPE extends Recipe<I>> Optional<RecipeHolder<RECIPE_TYPE>> getRecipeFor(RecipeType<RECIPE_TYPE> recipeType, I input, Level level) {
        return level.getRecipeManager().getRecipeFor(recipeType, input, level).filter((recipe) -> {
            return recipe.value().isSpecial() || !recipe.value().isIncomplete();
        });
    }

    public static Optional<RecipeHolder<?>> byKey(Level level, ResourceLocation id) {
        return level.getRecipeManager().byKey(id).filter((recipe) -> {
            return recipe.value().isSpecial() || !recipe.value().isIncomplete();
        });
    }
}
