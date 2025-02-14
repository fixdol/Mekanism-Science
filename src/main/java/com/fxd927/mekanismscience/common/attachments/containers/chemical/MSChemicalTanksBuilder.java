package com.fxd927.mekanismscience.common.attachments.containers.chemical;

import com.fxd927.mekanismscience.common.recipe.IMSRecipeTypeProvider;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.common.attachments.containers.ContainsRecipe;
import mekanism.common.attachments.containers.chemical.AttachedChemicals;
import mekanism.common.attachments.containers.chemical.ComponentBackedChemicalTank;
import mekanism.common.attachments.containers.creator.BaseContainerCreator;
import mekanism.common.attachments.containers.creator.IBasicContainerCreator;
import mekanism.common.config.MekanismConfig;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

public class MSChemicalTanksBuilder {
    public static MSChemicalTanksBuilder builder() {
        return new MSChemicalTanksBuilder();
    }

    protected final List<IBasicContainerCreator<? extends ComponentBackedChemicalTank>> tankCreators = new ArrayList<>();

    protected MSChemicalTanksBuilder() {
    }

    public BaseContainerCreator<AttachedChemicals, ComponentBackedChemicalTank> build() {
        return new BaseChemicalTankBuilder(tankCreators);
    }

    public <VANILLA_INPUT extends RecipeInput, RECIPE extends MekanismRecipe<VANILLA_INPUT>, INPUT_CACHE extends IInputRecipeCache> MSChemicalTanksBuilder addBasic(long capacity,
                                                                                                                                                                    IMSRecipeTypeProvider<VANILLA_INPUT, RECIPE, INPUT_CACHE> recipeType, ContainsRecipe<INPUT_CACHE, ChemicalStack> containsRecipe) {
        return addBasic(capacity, chemical -> containsRecipe.check(recipeType.getInputCache(), null, chemical.getStack(1)));
    }

    public MSChemicalTanksBuilder addBasic(long capacity, Predicate<Chemical> isValid) {
        return addBasic(() -> capacity, isValid);
    }

    public MSChemicalTanksBuilder addBasic(LongSupplier capacity, Predicate<@NotNull Chemical> isValid) {
        return addTank((type, attachedTo, containerIndex) -> new ComponentBackedChemicalTank(attachedTo, containerIndex, BasicChemicalTank.manualOnly,
                BasicChemicalTank.alwaysTrueBi, isValid, MekanismConfig.general.chemicalItemFillRate, capacity, null));
    }

    public MSChemicalTanksBuilder addBasic(long capacity) {
        return addBasic(() -> capacity);
    }

    public MSChemicalTanksBuilder addBasic(LongSupplier capacity) {
        return addTank((type, attachedTo, containerIndex) -> new ComponentBackedChemicalTank(attachedTo, containerIndex, BasicChemicalTank.manualOnly,
                BasicChemicalTank.alwaysTrueBi, BasicChemicalTank.alwaysTrue, MekanismConfig.general.chemicalItemFillRate, capacity, null));
    }

    public MSChemicalTanksBuilder addInternalStorage(LongSupplier rate, LongSupplier capacity, Predicate<@NotNull Chemical> isValid) {
        return addTank((type, attachedTo, containerIndex) -> new ComponentBackedChemicalTank(attachedTo, containerIndex, BasicChemicalTank.notExternal,
                BasicChemicalTank.alwaysTrueBi, isValid, rate, capacity, null));
    }

    public MSChemicalTanksBuilder addTank(IBasicContainerCreator<? extends ComponentBackedChemicalTank> tank) {
        tankCreators.add(tank);
        return this;
    }

    private static class BaseChemicalTankBuilder extends BaseContainerCreator<AttachedChemicals, ComponentBackedChemicalTank> {

        public BaseChemicalTankBuilder(List<IBasicContainerCreator<? extends ComponentBackedChemicalTank>> creators) {
            super(creators);
        }

        @Override
        public AttachedChemicals initStorage(int containers) {
            return AttachedChemicals.create(containers);
        }
    }
}
