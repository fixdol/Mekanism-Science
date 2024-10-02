package com.fxd927.mekanismscience.client.gui.machine;

import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionTypeSeawaterMetalExtractor;
import mekanism.client.gui.GuiMekanismTile;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

public class GuiAdsorptionTypeSeawaterMetalExtractor extends GuiMekanismTile<TileEntityAdsorptionTypeSeawaterMetalExtractor, MekanismTileContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor>> {
    public GuiAdsorptionTypeSeawaterMetalExtractor(MekanismTileContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor> container, Inventory inv, Component title) {
        super(container, inv, title);
        inventoryLabelY += 2;
        dynamicSlots = true;
    }
    @Override
    protected void addGuiElements() {
        super.addGuiElements();
    }

    @Override
    protected void drawForegroundText(@Nonnull GuiGraphics matrix, int mouseX, int mouseY) {
        renderTitleText(matrix);
        drawString(matrix, playerInventoryTitle, inventoryLabelX, inventoryLabelY, titleTextColor());
        super.drawForegroundText(matrix, mouseX, mouseY);
    }
}
