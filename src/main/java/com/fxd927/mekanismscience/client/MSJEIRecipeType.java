package com.fxd927.mekanismscience.client;

import com.fxd927.mekanismscience.api.recipes.NeutronIrradiatingRecipe;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import mekanism.client.jei.MekanismJEIRecipeType;

public class MSJEIRecipeType{
    public static final MekanismJEIRecipeType<NeutronIrradiatingRecipe> NEUTRON_IRRADIATING = new MekanismJEIRecipeType<>(MSBlocks.NEUTRON_IRRADIATOR, NeutronIrradiatingRecipe.class);
}
