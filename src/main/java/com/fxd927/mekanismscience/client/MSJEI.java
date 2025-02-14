package com.fxd927.mekanismscience.client;

import com.fxd927.mekanismscience.client.jei.MSRecipeRegistryHelper;
import com.fxd927.mekanismscience.client.jei.machine.RadiationIrradiatorRecipeCategory;
import com.fxd927.mekanismscience.client.recipe_viewer.jei.MSCatalystRegistryHelper;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.client.recipe_viewer.type.MSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.client.recipe_viewer.jei.CatalystRegistryHelper;
import mekanism.client.recipe_viewer.jei.MekanismSubtypeInterpreter;
import mekanism.client.recipe_viewer.type.IRecipeViewerRecipeType;
import mekanism.client.recipe_viewer.type.RecipeViewerRecipeType;
import mekanism.common.capabilities.Capabilities;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import static com.fxd927.mekanismscience.common.registries.MSTileEntityTypes.RADIATION_IRRADIATOR;
import static mekanism.client.recipe_viewer.jei.MekanismJEI.shouldLoad;

@JeiPlugin
public class MSJEI implements IModPlugin {
    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return MekanismScience.rl("jei_plugin");
    }
    private static final ISubtypeInterpreter<ItemStack> MEKANISMSCIENCE_DATA_INTERPRETER = new MekanismSubtypeInterpreter();
    private static final Map<IMSRecipeViewerRecipeType<?>, RecipeType<?>> recipeTypeInstanceCache = new HashMap<>();

    public static void registerItemSubtypes(ISubtypeRegistration registry, Collection<? extends Holder<? extends ItemLike>> itemProviders) {
        for (Holder<? extends ItemLike> itemProvider : itemProviders) {
            ItemStack stack = new ItemStack(itemProvider.value());
            if (Capabilities.STRICT_ENERGY.hasCapability(stack) || Capabilities.CHEMICAL.hasCapability(stack) || Capabilities.FLUID.hasCapability(stack)) {
                registry.registerSubtypeInterpreter(stack.getItem(), MEKANISMSCIENCE_DATA_INTERPRETER);
            }
        }
    }

    public static <TYPE> RecipeType<TYPE> recipeType(IMSRecipeViewerRecipeType<TYPE> recipeType) {
        if (recipeType.requiresHolder()) {
            throw new IllegalStateException("Basic recipe type requested for a recipe that uses holders");
        }
        return (RecipeType<TYPE>) genericRecipeType(recipeType);
    }

    public static <TYPE extends Recipe<?>> RecipeType<RecipeHolder<TYPE>> holderRecipeType(IMSRecipeViewerRecipeType<TYPE> recipeType) {
        if (!recipeType.requiresHolder()) {
            throw new IllegalStateException("Holder recipe type requested for a recipe that doesn't use holders");
        }
        return (RecipeType<RecipeHolder<TYPE>>) genericRecipeType(recipeType);
    }

    public static RecipeType<?>[] recipeType(IMSRecipeViewerRecipeType<?>... recipeTypes) {
            return Arrays.stream(recipeTypes).map(MSJEI::genericRecipeType).toArray(RecipeType[]::new);
        }

    public static RecipeType<?> genericRecipeType(IMSRecipeViewerRecipeType<?> recipeType) {
        return recipeTypeInstanceCache.computeIfAbsent(recipeType, r -> {
            if (r.requiresHolder()) {
                return new RecipeType<>(r.id(), RecipeHolder.class);
            }
            return new RecipeType<>(r.id(), r.recipeClass());
        });
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        if (!shouldLoad()) {
            return;
        }
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new RadiationIrradiatorRecipeCategory(guiHelper, MSRecipeViewerRecipeType.RADIATION_IRRADIATING));
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registry) {
        MSCatalystRegistryHelper.register(registry, MSRecipeViewerRecipeType.RADIATION_IRRADIATING);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        if (!shouldLoad()) {
            return;
        }
        MSRecipeRegistryHelper.register(registry, MSRecipeViewerRecipeType.RADIATION_IRRADIATING, MSRecipeType.RADIATION_IRRADIATING);
    }
}
