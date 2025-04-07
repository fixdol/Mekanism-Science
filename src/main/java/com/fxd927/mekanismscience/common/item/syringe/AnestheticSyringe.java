package com.fxd927.mekanismscience.common.item.syringe;

import com.fxd927.mekanismscience.common.registries.MSEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnestheticSyringe extends DrugSyringe {
    public AnestheticSyringe(Properties properties) {
        super(properties,4);
    }

    @Override
    protected Holder<MobEffect> getEffectType() {
        return MSEffects.SENSORY_PARALYSIS;
    }

    @Override
    protected int getBaseDuration() {
        return 20 * 20;
    }

    @Override
    protected int getEffectAmplifier() {
        return 0;
    }
}
