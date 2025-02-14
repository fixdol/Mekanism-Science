package com.fxd927.mekanismscience.client.jei.machine;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.client.recipe_viewer.jei.MSHolderRecipeCategory;
import com.fxd927.mekanismscience.client.recipe_viewer.type.IMSRecipeViewerRecipeType;
import com.fxd927.mekanismscience.client.recipe_viewer.type.MSRVRecipeTypeWrapper;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityRadiationIrradiator;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.recipes.ChemicalDissolutionRecipe;
import mekanism.client.gui.element.bar.GuiHorizontalPowerBar;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiChemicalGauge;
import mekanism.client.gui.element.gauge.GuiGauge;
import mekanism.client.gui.element.progress.ProgressType;
import mekanism.client.gui.element.slot.GuiSlot;
import mekanism.client.gui.element.slot.SlotType;
import mekanism.client.recipe_viewer.jei.HolderRecipeCategory;
import mekanism.client.recipe_viewer.type.IRecipeViewerRecipeType;
import mekanism.common.inventory.container.slot.SlotOverlay;
import mekanism.common.tile.component.config.DataType;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static mekanism.client.recipe_viewer.RecipeViewerUtils.FULL_BAR;

public class RadiationIrradiatorRecipeCategory extends MSHolderRecipeCategory<RadiationIrradiatingRecipe> {
    private final GuiGauge<?> inputGauge;
    private final GuiGauge<?> outputGauge;
    private final GuiSlot inputSlot;

    public RadiationIrradiatorRecipeCategory(IGuiHelper helper, IMSRecipeViewerRecipeType<RadiationIrradiatingRecipe> recipeType) {
        super(helper, recipeType);
        inputGauge = addElement(GuiChemicalGauge.getDummy(GaugeType.STANDARD.with(DataType.INPUT), this, 28, 13));
        outputGauge = addElement(GuiChemicalGauge.getDummy(GaugeType.STANDARD.with(DataType.OUTPUT), this, 131, 13));
        inputSlot = addSlot(SlotType.INPUT, 7, 36);
        addSlot(SlotType.EXTRA, 7, 55).with(SlotOverlay.MINUS);
        addSlot(SlotType.OUTPUT, 152, 55).with(SlotOverlay.PLUS);
        addSlot(SlotType.POWER, 152, 14).with(SlotOverlay.POWER);
        addSimpleProgress(ProgressType.LARGE_RIGHT, 64, 40);
        addElement(new GuiHorizontalPowerBar(this, FULL_BAR, 115, 75));
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, RecipeHolder<RadiationIrradiatingRecipe> recipeHolder, @NotNull IFocusGroup focusGroup) {
        RadiationIrradiatingRecipe recipe = recipeHolder.value();
        initItem(builder, RecipeIngredientRole.INPUT, inputSlot, recipe.getItemInput().getRepresentations());
        List<ChemicalStack> scaledChemicals = recipe.getChemicalInput().getRepresentations();
        if (recipe.perTickUsage()) {
            scaledChemicals = scaledChemicals.stream()
                    .map(chemical -> chemical.copyWithAmount(chemical.getAmount() * TileEntityRadiationIrradiator.BASE_TICKS_REQUIRED))
                    .toList();
        }
        initChemical(builder, RecipeIngredientRole.INPUT, inputGauge, scaledChemicals);
        initChemical(builder, RecipeIngredientRole.OUTPUT, outputGauge, recipe.getOutputDefinition());
    }
}
