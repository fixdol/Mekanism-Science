package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.item.IodineTablet;
import com.fxd927.mekanismscience.common.item.NeutronSourcePellet;
import com.fxd927.mekanismscience.common.item.RefinedCaliforniumIngot;
import com.fxd927.mekanismscience.common.item.UnstableCaliforniumMixture;
import com.fxd927.mekanismscience.common.item.syringe.AnestheticSyringe;
import com.fxd927.mekanismscience.common.item.syringe.FlameRetardantSyringe;
import com.fxd927.mekanismscience.common.item.syringe.LevitationSyringe;
import com.fxd927.mekanismscience.common.item.tablet.*;
import mekanism.api.text.EnumColor;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class MSItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismScience.MODID);

    public static final ItemRegistryObject<Item> SYRINGE;
    public static final ItemRegistryObject<Item> ANESTHETIC_SYRINGE;
    public static final ItemRegistryObject<Item> FLAME_RETARDANT_SYRINGE;
    public static final ItemRegistryObject<Item> LEVITATION_SYRINGE;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_BERYLLIUM;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_COPPER;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_GOLD;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_IRON;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_LEAD;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_OSMIUM;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_TIN;
    public static final ItemRegistryObject<Item> HIGH_PERFORMANCE_ADSORBENT_URANIUM;
    public static final ItemRegistryObject<Item> NEUTRON_SOURCE_PELLET;
    //public static final ItemRegistryObject<Item> HIGH_DENSITY_NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_high-density_neutron_source", () -> new HighDensityNeutronSourcePellet(new Item.Properties(), EnumColor.PURPLE));    public static final ItemRegistryObject<Item> DUST_CALCIUM_OXIDE;
    public static final ItemRegistryObject<Item> DUST_BARIUM_SULFATE;
    public static final ItemRegistryObject<Item> DUST_CALCIUM_OXIDE;
    //public static final ItemRegistryObject<Item> AQUA_DYE;
    //public static final ItemRegistryObject<Item> DARK_RED_DYE;
    //public static final ItemRegistryObject<Item> DUST_YTTRIUM = ITEMS.register("dust_yttrium");
    public static final ItemRegistryObject<Item> UNSTABLE_CALIFORNIUM_MIXTURE;
    public static final ItemRegistryObject<Item> REFINED_CALIFORNIUM_INGOT;
    //public static final ItemRegistryObject<Item> EXCIPIENT = ITEMS.register("excipient");
    //public static final ItemRegistryObject<Item> TABLET_ANESTHETIC = ITEMS.register("tablet_anesthetic", () -> new AnestheticTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_FIRE_RESISTANCE = ITEMS.register("tablet_fire_resistance", () -> new FireResistanceTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_IODINE;
    //public static final ItemRegistryObject<Item> TABLET_MUSCLE_ENHANCEMENT = ITEMS.register("tablet_muscle_enhancement", () -> new MuscleEnhancementTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_POISON = ITEMS.register("tablet_poison", () -> new PoisonTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_SLEEP_INDUCING = ITEMS.register("tablet_sleep_inducing", () -> new SleepInducingTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));


    static {
        SYRINGE = ITEMS.register("syringe");
        ANESTHETIC_SYRINGE = ITEMS.register("syringe_anesthetic", () -> new AnestheticSyringe(new Item.Properties()));
        FLAME_RETARDANT_SYRINGE = ITEMS.register("syringe_flame_retardant", () -> new FlameRetardantSyringe(new Item.Properties()));
        LEVITATION_SYRINGE = ITEMS.register("syringe_levitation", () -> new LevitationSyringe(new Item.Properties()));
        HIGH_PERFORMANCE_ADSORBENT = ITEMS.register("high_performance_adsorbent");
        HIGH_PERFORMANCE_ADSORBENT_BERYLLIUM = ITEMS.register("high_performance_adsorbent_beryllium");
        HIGH_PERFORMANCE_ADSORBENT_COPPER = ITEMS.register("high_performance_adsorbent_copper");
        HIGH_PERFORMANCE_ADSORBENT_GOLD = ITEMS.register("high_performance_adsorbent_gold");
        HIGH_PERFORMANCE_ADSORBENT_IRON = ITEMS.register("high_performance_adsorbent_iron");
        HIGH_PERFORMANCE_ADSORBENT_LEAD = ITEMS.register("high_performance_adsorbent_lead");
        HIGH_PERFORMANCE_ADSORBENT_OSMIUM = ITEMS.register("high_performance_adsorbent_osmium");
        HIGH_PERFORMANCE_ADSORBENT_TIN = ITEMS.register("high_performance_adsorbent_tin");
        HIGH_PERFORMANCE_ADSORBENT_URANIUM = ITEMS.register("high_performance_adsorbent_uranium");
        NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_neutron_source", () -> new NeutronSourcePellet(new Item.Properties(), EnumColor.YELLOW));
        DUST_BARIUM_SULFATE = ITEMS.register("dust_barium_sulfate");
        DUST_CALCIUM_OXIDE = ITEMS.register("dust_calcium_oxide");
        UNSTABLE_CALIFORNIUM_MIXTURE = ITEMS.register("unstable_californium_mixture", ()-> new UnstableCaliforniumMixture(new Item.Properties(), EnumColor.ORANGE));
        REFINED_CALIFORNIUM_INGOT = ITEMS.register("ingot_refined_californium", ()-> new RefinedCaliforniumIngot(new Item.Properties(), EnumColor.ORANGE));
        TABLET_IODINE = ITEMS.register("tablet_iodine", () -> new IodineTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
        }

    private MSItems(){
    }
}
