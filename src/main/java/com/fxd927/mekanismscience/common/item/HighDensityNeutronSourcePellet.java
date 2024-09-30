package com.fxd927.mekanismscience.common.item;

import mekanism.api.text.EnumColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HighDensityNeutronSourcePellet extends NeutronSourcePellet {
    public HighDensityNeutronSourcePellet(Item.Properties properties, EnumColor color) {
        super(properties, color);
        this.color = color;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
