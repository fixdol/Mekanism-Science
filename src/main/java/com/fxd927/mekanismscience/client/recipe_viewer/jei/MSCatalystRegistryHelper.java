package com.fxd927.mekanismscience.client.recipe_viewer.jei;

import com.fxd927.mekanismscience.client.MSJEI;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.providers.IItemProvider;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeFactoryType;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tier.FactoryTier;
import mekanism.common.util.EnumUtils;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;

import java.util.List;

public class MSCatalystRegistryHelper {
    private MSCatalystRegistryHelper() {
    }

    public static void register(IRecipeCatalystRegistration registry, IMSRecipeViewerRecipeType<?>... categories) {
        for (IMSRecipeViewerRecipeType<?> category : categories) {
            register(registry, MSJEI.genericRecipeType(category), category.workstations());
        }
    }

    public static void register(IRecipeCatalystRegistration registry, RecipeType<?> recipeType, List<IItemProvider> workstations) {
        for (IItemProvider workstation : workstations) {
            registry.addRecipeCatalyst(workstation.getItemStack(), recipeType);
            if (workstation instanceof IBlockProvider mekanismBlock) {
                AttributeFactoryType factoryType = Attribute.get(mekanismBlock.getBlock(), AttributeFactoryType.class);
                if (factoryType != null) {
                    for (FactoryTier tier : EnumUtils.FACTORY_TIERS) {
                        registry.addRecipeCatalyst(MekanismBlocks.getFactory(tier, factoryType.getFactoryType()).getItemStack(), recipeType);
                    }
                }
            }
        }
    }
}
