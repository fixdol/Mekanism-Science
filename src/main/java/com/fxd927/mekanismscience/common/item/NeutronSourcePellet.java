package com.fxd927.mekanismscience.common.item;

import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NeutronSourcePellet extends Item{
    protected EnumColor color;

    public NeutronSourcePellet(Item.Properties properties, EnumColor color) {
        super(properties);
        this.color = color;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide && entity instanceof Player player) {
            if (world.getGameTime() % 100 == 0) {
                applyRadiationDamage(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void applyRadiationDamage(Player player) {
        double radiationLevel = 0.5;
        RadiationManager.INSTANCE.radiate(player, radiationLevel);
    }

    @Override
    public Component getName(ItemStack stack) {
        return TextComponentUtil.build(this.color, super.getName(stack));
    }
}
