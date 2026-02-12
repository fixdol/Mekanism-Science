package com.fxd927.mekanismelements.client.recipe_viewer.type;

import com.fxd927.mekanismelements.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismelements.common.recipe.MSRecipeType;
import com.fxd927.mekanismelements.common.recipe.lookup.cache.MSInputRecipeCache;
import com.fxd927.mekanismelements.common.registries.MSBlocks;
import mekanism.api.providers.IItemProvider;
import mekanism.api.recipes.vanilla_input.SingleItemChemicalRecipeInput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MSRecipeViewerRecipeType {
    private MSRecipeViewerRecipeType() {
    }

    public static final MSRVRecipeTypeWrapper<SingleItemChemicalRecipeInput, RadiationIrradiatingRecipe, MSInputRecipeCache.ItemChemical<RadiationIrradiatingRecipe>> RADIATION_IRRADIATING = new MSRVRecipeTypeWrapper<SingleItemChemicalRecipeInput, RadiationIrradiatingRecipe, MSInputRecipeCache.ItemChemical<RadiationIrradiatingRecipe>>(
            MSRecipeType.RADIATION_IRRADIATING, 
            RadiationIrradiatingRecipe.class, 
            -3, 
            -3, 
            170, 
            79, 
            new IItemProvider() {
                @Override
                public Item asItem() {
                    return MSBlocks.RADIATION_IRRADIATOR.asItem();
                }

                @Override
                public ItemStack getItemStack() {
                    return new ItemStack(asItem());
                }

                @Override
                public Component getTextComponent() {
                    return Component.translatable(asItem().getDescriptionId());
                }
            }
    );

}