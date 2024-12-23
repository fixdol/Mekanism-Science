package com.fxd927.mekanismscience.client;

import com.fxd927.mekanismscience.client.jei.MSRecipeRegistryHelper;
import com.fxd927.mekanismscience.client.jei.machine.AdsorptionSeparatorRecipeCategory;
import com.fxd927.mekanismscience.client.jei.machine.RadiationIrradiatorRecipeCategory;
import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import mekanism.client.jei.CatalystRegistryHelper;
import mekanism.client.jei.MekanismJEI;
import mekanism.client.jei.MekanismJEIRecipeType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static com.fxd927.mekanismscience.client.MSJEIRecipeType.ADSORPTION_SEPARATOR;
import static com.fxd927.mekanismscience.client.MSJEIRecipeType.RADIATION_IRRADIATOR;

@JeiPlugin
public class MSJEI implements IModPlugin {
    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return MekanismScience.rl("jei_plugin");
    }

    @Override
    public void registerItemSubtypes(@Nonnull ISubtypeRegistration registry) {
        MekanismJEI.registerItemSubtypes(registry, MSBlocks.BLOCKS.getAllBlocks());
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new AdsorptionSeparatorRecipeCategory(guiHelper, MSJEIRecipeType.ADSORPTION_SEPARATOR));
        registry.addRecipeCategories(new RadiationIrradiatorRecipeCategory(guiHelper, MSJEIRecipeType.RADIATION_IRRADIATOR));
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registry) {
        CatalystRegistryHelper.register(registry, MSBlocks.ADSORPTION_SEPARATOR, MekanismJEIRecipeType.GAS_CONVERSION);
        CatalystRegistryHelper.register(registry, MSBlocks.RADIATION_IRRADIATOR, MekanismJEIRecipeType.GAS_CONVERSION);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        MSRecipeRegistryHelper.register(registry, ADSORPTION_SEPARATOR, MSRecipeType.ADSORPTION);
        MSRecipeRegistryHelper.register(registry, RADIATION_IRRADIATOR, MSRecipeType.RADIATION_IRRADIATING);
    }
}
