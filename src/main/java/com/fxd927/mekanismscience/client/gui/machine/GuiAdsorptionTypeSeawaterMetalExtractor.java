package com.fxd927.mekanismscience.client.gui.machine;

import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionTypeSeawaterMetalExtractor;
import mekanism.client.gui.GuiConfigurableTile;
import mekanism.client.gui.element.GuiRightArrow;
import mekanism.client.gui.element.bar.GuiVerticalPowerBar;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiFluidGauge;
import mekanism.client.gui.element.slot.GuiSlot;
import mekanism.client.gui.element.slot.SlotType;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.common.capabilities.energy.MachineEnergyContainer;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.inventory.warning.WarningTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

public class GuiAdsorptionTypeSeawaterMetalExtractor extends GuiConfigurableTile<TileEntityAdsorptionTypeSeawaterMetalExtractor, MekanismTileContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor>> {
    public GuiAdsorptionTypeSeawaterMetalExtractor(MekanismTileContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor> container, Inventory inv, Component title) {
        super(container, inv, title);
        inventoryLabelY += 2;
        dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        super.addGuiElements();
        addRenderableWidget(new GuiVerticalPowerBar(this, tile.getEnergyContainer(), 157, 23))
                .warning(WarningTracker.WarningType.NOT_ENOUGH_ENERGY, () -> {
                    MachineEnergyContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor> energyContainer = tile.getEnergyContainer();
                    return energyContainer.getEnergyPerTick().greaterThan(energyContainer.getEnergy());
                });
        addRenderableWidget(new GuiEnergyTab(this, tile.getEnergyContainer(), tile::getActive));
        addRenderableWidget(new GuiFluidGauge(() -> tile.fluidTank, () -> tile.getFluidTanks(null), GaugeType.STANDARD, this, 7, 4));
        addRenderableWidget(new GuiRightArrow(this, 40, 30));
    }

    @Override
    protected void drawForegroundText(@Nonnull GuiGraphics matrix, int mouseX, int mouseY) {
        renderTitleText(matrix);
        super.drawForegroundText(matrix, mouseX, mouseY);
    }
}
