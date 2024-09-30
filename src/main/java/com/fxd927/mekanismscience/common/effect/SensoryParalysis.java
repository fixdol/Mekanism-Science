package com.fxd927.mekanismscience.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SensoryParalysis extends MobEffect {
    private static final long INVULNERABLE_DURATION_MS = 30000; // 30秒
    private long effectStartTime = 0;

    public SensoryParalysis(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            if (!player.isInvulnerable()) {
                player.setInvulnerable(true);
                effectStartTime = System.currentTimeMillis();
            }
            long elapsedTime = System.currentTimeMillis() - effectStartTime;
            if (elapsedTime >= INVULNERABLE_DURATION_MS) {
                player.setInvulnerable(false);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
