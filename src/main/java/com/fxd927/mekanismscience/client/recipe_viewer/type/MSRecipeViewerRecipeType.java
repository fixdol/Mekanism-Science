package com.fxd927.mekanismscience.client.recipe_viewer.type;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import com.fxd927.mekanismscience.common.registries.MSBlocks;

public class MSRecipeViewerRecipeType {
    private MSRecipeViewerRecipeType() {
    }

    public static final MSRVRecipeTypeWrapper<?, RadiationIrradiatingRecipe, ?> RADIATION_IRRADIATING = new MSRVRecipeTypeWrapper<>(MSRecipeType.RADIATION_IRRADIATING, RadiationIrradiatingRecipe.class, -3, -3, 170, 79,null);

}
