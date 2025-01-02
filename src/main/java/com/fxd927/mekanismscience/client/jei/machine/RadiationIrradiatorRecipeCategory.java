package com.fxd927.mekanismscience.client.jei.machine;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.registries.MSBlocks;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityRadiationIrradiator;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.ChemicalType;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.merged.BoxedChemicalStack;
import mekanism.client.gui.element.bar.GuiHorizontalPowerBar;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiGasGauge;
import mekanism.client.gui.element.gauge.GuiGauge;
import mekanism.client.gui.element.progress.ProgressType;
import mekanism.client.gui.element.slot.GuiSlot;
import mekanism.client.gui.element.slot.SlotType;
import mekanism.client.jei.BaseRecipeCategory;
import mekanism.client.jei.MekanismJEI;
import mekanism.client.jei.MekanismJEIRecipeType;
import mekanism.common.inventory.container.slot.SlotOverlay;
import mekanism.common.tile.component.config.DataType;
import mekanism.common.util.ChemicalUtil;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RadiationIrradiatorRecipeCategory extends BaseRecipeCategory<RadiationIrradiatingRecipe> {
    private final GuiGauge<?> inputGauge;
    private final GuiGauge<?> outputGauge;
    private final GuiSlot inputSlot;

    public RadiationIrradiatorRecipeCategory(IGuiHelper helper, MekanismJEIRecipeType<RadiationIrradiatingRecipe> recipeType) {
        super(helper, recipeType, MSBlocks.RADIATION_IRRADIATOR, 3, 3, 170, 79);
        inputGauge = addElement(GuiGasGauge.getDummy(GaugeType.STANDARD.with(DataType.INPUT), this, 28, 13));
        outputGauge = addElement(GuiGasGauge.getDummy(GaugeType.STANDARD.with(DataType.OUTPUT), this, 131, 13));
        inputSlot = addSlot(SlotType.INPUT, 7, 36);
        addSlot(SlotType.EXTRA, 7, 55).with(SlotOverlay.MINUS);
        addSlot(SlotType.OUTPUT, 152, 55).with(SlotOverlay.PLUS);
        addSlot(SlotType.POWER, 152, 14).with(SlotOverlay.POWER);
        addSimpleProgress(ProgressType.LARGE_RIGHT, 64, 40);
        addElement(new GuiHorizontalPowerBar(this, FULL_BAR, 115, 75));
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, RadiationIrradiatingRecipe recipe, @NotNull IFocusGroup focusGroup) {
        initItem(builder, RecipeIngredientRole.INPUT, inputSlot, recipe.getItemInput().getRepresentations());
        List<@NotNull GasStack> gasInputs = recipe.getGasInput().getRepresentations();
        List<GasStack> scaledGases = gasInputs.stream().map(gas -> new GasStack(gas, gas.getAmount() * TileEntityRadiationIrradiator.BASE_TICKS_REQUIRED))
                .toList();
        initChemical(builder, MekanismJEI.TYPE_GAS, RecipeIngredientRole.INPUT, inputGauge, scaledGases);
        List<BoxedChemicalStack> outputDefinition = recipe.getOutputDefinition();
        if (outputDefinition.size() == 1) {
            BoxedChemicalStack output = outputDefinition.get(0);
            initChemicalOutput(builder, MekanismJEI.getIngredientType(output.getChemicalType()), Collections.singletonList(output.getChemicalStack()));
        } else {
            Map<ChemicalType, List<ChemicalStack<?>>> outputs = new EnumMap<>(ChemicalType.class);
            for (BoxedChemicalStack output : outputDefinition) {
                outputs.computeIfAbsent(output.getChemicalType(), type -> new ArrayList<>());
            }
            for (BoxedChemicalStack output : outputDefinition) {
                ChemicalType chemicalType = output.getChemicalType();
                for (Map.Entry<ChemicalType, List<ChemicalStack<?>>> entry : outputs.entrySet()) {
                    if (entry.getKey() == chemicalType) {
                        entry.getValue().add(output.getChemicalStack());
                    } else {
                        entry.getValue().add(ChemicalUtil.getEmptyStack(entry.getKey()));
                    }
                }
            }
            for (Map.Entry<ChemicalType, List<ChemicalStack<?>>> entry : outputs.entrySet()) {
                initChemicalOutput(builder, MekanismJEI.getIngredientType(entry.getKey()), entry.getValue());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <STACK extends ChemicalStack<?>> void initChemicalOutput(IRecipeLayoutBuilder builder, IIngredientType<STACK> type, List<ChemicalStack<?>> stacks) {
        initChemical(builder, type, RecipeIngredientRole.OUTPUT, outputGauge, (List<STACK>) stacks);
    }
}