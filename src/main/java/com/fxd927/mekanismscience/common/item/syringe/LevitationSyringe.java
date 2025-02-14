package com.fxd927.mekanismscience.common.item.syringe;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LevitationSyringe extends DrugSyringe{
    public LevitationSyringe(Properties properties) {
        super(properties,4);
    }

    //@Override
    //protected MobEffect getEffectType() {
        //return MobEffects.LEVITATION;
    //}

    //@Override
    protected int getBaseDuration() {
        return 20 * 60;
    }

    //@Override
    protected int getEffectAmplifier() {
        return 0;
    }
}
