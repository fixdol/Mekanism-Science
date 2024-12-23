package com.fxd927.mekanismscience.common.item;

import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.common.capabilities.Capabilities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RefinedCaliforniumIngot extends Item {
    protected EnumColor color;

    public RefinedCaliforniumIngot(Item.Properties properties, EnumColor color) {
        super(properties);
        this.color = color;
    }

    @Override
    public boolean isFoil(ItemStack itemStack){
        return true;
    }

    @Override
    public Component getName(ItemStack stack) {
        return TextComponentUtil.build(this.color, super.getName(stack));
    }
}

