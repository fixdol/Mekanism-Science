package com.fxd927.mekanismscience.common.recipe.serializer;

import com.fxd927.mekanismscience.api.recipes.AdsorptionRecipe;
import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.api.recipes.basic.BasicAdsorptionRecipe;
import com.fxd927.mekanismscience.api.recipes.basic.BasicRadiationIrradiatingRecipe;
import com.mojang.datafixers.util.Function4;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mekanism.api.SerializationConstants;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public record MSRecipeSerializer<RECIPE extends Recipe<?>>(MapCodec<RECIPE> codec, StreamCodec<RegistryFriendlyByteBuf, RECIPE> streamCodec)
        implements RecipeSerializer<RECIPE> {
    public static MSRecipeSerializer<BasicRadiationIrradiatingRecipe> radiationIrradiating(
            Function4<ItemStackIngredient, ChemicalStackIngredient, ChemicalStack, Boolean, BasicRadiationIrradiatingRecipe> factory) {
        return new MSRecipeSerializer<>(RecordCodecBuilder.mapCodec(instance -> instance.group(
                ItemStackIngredient.CODEC.fieldOf(SerializationConstants.ITEM_INPUT).forGetter(RadiationIrradiatingRecipe::getItemInput),
                IngredientCreatorAccess.chemicalStack().codec().fieldOf(SerializationConstants.CHEMICAL_INPUT).forGetter(RadiationIrradiatingRecipe::getChemicalInput),
                ChemicalStack.CODEC.fieldOf(SerializationConstants.OUTPUT).forGetter(BasicRadiationIrradiatingRecipe::getOutputRaw),
                Codec.BOOL.fieldOf(SerializationConstants.PER_TICK_USAGE).forGetter(BasicRadiationIrradiatingRecipe::perTickUsage)
        ).apply(instance, factory)), StreamCodec.composite(
                ItemStackIngredient.STREAM_CODEC, BasicRadiationIrradiatingRecipe::getItemInput,
                IngredientCreatorAccess.chemicalStack().streamCodec(), BasicRadiationIrradiatingRecipe::getChemicalInput,
                ChemicalStack.STREAM_CODEC, BasicRadiationIrradiatingRecipe::getOutputRaw,
                ByteBufCodecs.BOOL, BasicRadiationIrradiatingRecipe::perTickUsage,
                factory
        ));
    }

    public static MSRecipeSerializer<BasicAdsorptionRecipe> adsorption(
            Function4<ItemStackIngredient, ChemicalStackIngredient, ChemicalStack, Boolean, BasicAdsorptionRecipe> factory) {
        return new MSRecipeSerializer<>(RecordCodecBuilder.mapCodec(instance -> instance.group(
                ItemStackIngredient.CODEC.fieldOf(SerializationConstants.ITEM_INPUT).forGetter(AdsorptionRecipe::getItemInput),
                IngredientCreatorAccess.chemicalStack().codec().fieldOf(SerializationConstants.CHEMICAL_INPUT).forGetter(AdsorptionRecipe::getChemicalInput),
                ChemicalStack.CODEC.fieldOf(SerializationConstants.OUTPUT).forGetter(BasicAdsorptionRecipe::getOutputRaw),
                Codec.BOOL.fieldOf(SerializationConstants.PER_TICK_USAGE).forGetter(BasicAdsorptionRecipe::perTickUsage)
        ).apply(instance, factory)), StreamCodec.composite(
                ItemStackIngredient.STREAM_CODEC, BasicAdsorptionRecipe::getItemInput,
                IngredientCreatorAccess.chemicalStack().streamCodec(), BasicAdsorptionRecipe::getChemicalInput,
                ChemicalStack.STREAM_CODEC, BasicAdsorptionRecipe::getOutputRaw,
                ByteBufCodecs.BOOL, BasicAdsorptionRecipe::perTickUsage,
                factory
        ));
    }
}
