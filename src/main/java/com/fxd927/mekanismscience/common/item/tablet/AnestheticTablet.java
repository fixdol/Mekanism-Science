package com.fxd927.mekanismscience.common.item.tablet;

import com.fxd927.mekanismscience.common.registries.MSEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class AnestheticTablet extends Item {
    public AnestheticTablet(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player) {
            Player player = (Player) entity;

            player.addEffect(new MobEffectInstance(MSEffects.SENSORY_PARALYSIS.get(),600,0));
            player.getCooldowns().addCooldown(this,9000);

            long invulnerableEndTime = player.level().getGameTime() + 600;

            if (player.level().getGameTime() >= invulnerableEndTime) {
                player.setInvulnerable(false);
            }
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }
}
