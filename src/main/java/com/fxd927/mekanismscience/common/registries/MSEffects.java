package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.effect.RadiationResistance;
import com.fxd927.mekanismscience.common.effect.SensoryParalysis;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MSEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MekanismScience.MODID);

    //public static final RegistryObject<MobEffect> GOOD_SLEEP = MOB_EFFECTS.register("good_sleep",()-> new GoodSleep(MobEffectCategory.BENEFICIAL,0xFFCF2Ae));
    public static final DeferredHolder<MobEffect, MobEffect> SENSORY_PARALYSIS = MOB_EFFECTS.register("sensory_paralysis",()-> new SensoryParalysis(MobEffectCategory.BENEFICIAL,0xFFCF2Ae));
    public static final DeferredHolder<MobEffect, MobEffect> RADIATION_RESISTANCE = MOB_EFFECTS.register("radiation_resistance",()-> new RadiationResistance(MobEffectCategory.BENEFICIAL,0xFFCF2Ae));

    private MSEffects(){
    }
}
