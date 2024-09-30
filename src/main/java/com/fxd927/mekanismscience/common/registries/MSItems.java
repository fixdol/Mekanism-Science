package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.item.tablet.*;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class MSItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismScience.MODID);

    //public static final ItemRegistryObject<Item> NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_neutron_source", () -> new NeutronSourcePellet(new Item.Properties(), EnumColor.YELLOW));
    //public static final ItemRegistryObject<Item> HIGH_DENSITY_NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_high-density_neutron_source", () -> new HighDensityNeutronSourcePellet(new Item.Properties(), EnumColor.PURPLE));
    //public static final ItemRegistryObject<Item> DUST_CALCIUM_OXIDE = ITEMS.register("dust_calcium_oxide");
    //public static final ItemRegistryObject<Item> REFINED_CALIFORNIUM_INGOT = ITEMS.register("ingot_refined_californium", EnumColor.ORANGE);
    public static final ItemRegistryObject<Item> EXCIPIENT = ITEMS.register("excipient");
    public static final ItemRegistryObject<Item> TABLET_ANESTHETIC = ITEMS.register("tablet_anesthetic", () -> new AnestheticTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_FIRE_RESISTANCE = ITEMS.register("tablet_fire_resistance", () -> new FireResistanceTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_IODINE = ITEMS.register("tablet_iodine", () -> new IodineTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_MUSCLE_ENHANCEMENT = ITEMS.register("tablet_muscle_enhancement", () -> new MuscleEnhancementTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_POISON = ITEMS.register("tablet_poison", () -> new PoisonTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_SLEEP_INDUCING = ITEMS.register("tablet_sleep_inducing", () -> new SleepInducingTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));

    private MSItems(){
    }
}
