package com.fxd927.mekanismscience.common.item.syringe;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.registries.MSItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

@SuppressWarnings("removal")
public abstract class DrugSyringe extends Item {
    private static final String USE_COUNT_TAG = "UseCount";
    private final int maxUses;

    public DrugSyringe(Properties properties, int maxUses) {
        super(properties.stacksTo(1));
        this.maxUses = maxUses;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        player.hurt(player.damageSources().magic(), 1);

        if (!level.isClientSide) {
            int useCount = getUseCount(stack);

            if (useCount < maxUses) {
                setUseCount(stack, useCount + 1);
                applyEffect(level, player, stack);
            } else {
                ItemStack filledSyringe = getEmptySyringe();
                player.setItemInHand(hand, filledSyringe);
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level level = target.level();

        if (!level.isClientSide) {
            int useCount = getUseCount(stack);

            if (useCount < maxUses) {
                setUseCount(stack, useCount + 1);
                applyEffectToEntity(level, target, attacker);
                level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.PLAYERS, 1.0F, 1.0F);
            } else {
                ItemStack filledSyringe = getEmptySyringe();
                if (attacker instanceof Player player) {
                    player.setItemInHand(player.getUsedItemHand(), filledSyringe);
                } else {
                    stack.shrink(1);
                }
                level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.BOTTLE_EMPTY, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    private int getUseCount(ItemStack stack) {
        CustomData data = stack.get(DataComponents.CUSTOM_DATA);
        if (data != null && data.getUnsafe().contains(USE_COUNT_TAG)) {
            return data.getUnsafe().getInt(USE_COUNT_TAG);
        }
        return 0;
    }

    private void setUseCount(ItemStack stack, int count) {
        CompoundTag tag = new CompoundTag();
        tag.putInt(USE_COUNT_TAG, count);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        ItemProperties.register(this, ResourceLocation.fromNamespaceAndPath("use_count", MekanismScience.MODID),
                (stack, level, entity, seed) -> {
                    CustomData data = stack.get(DataComponents.CUSTOM_DATA);
                    if (data != null && data.getUnsafe().contains(USE_COUNT_TAG)) {
                        return data.getUnsafe().getInt(USE_COUNT_TAG);
                    }
                    return 0;
                });
    }

    protected void applyEffect(Level level, Player player, ItemStack stack) {
        MobEffectInstance current = player.getEffect(getEffectType());
        int newDuration = getBaseDuration();
        if (current != null) newDuration += current.getDuration();

        player.addEffect(new MobEffectInstance(getEffectType(), newDuration, getEffectAmplifier()));
    }

    protected void applyEffectToEntity(Level level, LivingEntity target, LivingEntity attacker) {
        MobEffectInstance current = target.getEffect(getEffectType());
        int newDuration = getBaseDuration();
        if (current != null) newDuration += current.getDuration();

        target.addEffect(new MobEffectInstance(getEffectType(), newDuration, getEffectAmplifier()));
    }

    protected ItemStack getEmptySyringe() {
        return new ItemStack(MSItems.SYRINGE.get());
    }

    protected abstract Holder<MobEffect> getEffectType();
    protected abstract int getBaseDuration();
    protected abstract int getEffectAmplifier();
}
