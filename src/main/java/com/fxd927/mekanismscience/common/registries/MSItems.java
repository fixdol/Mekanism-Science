package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.item.NeutronSourcePellet;
import com.fxd927.mekanismscience.common.item.tablet.*;
import mekanism.api.text.EnumColor;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;

public class MSItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismScience.MODID);

    public static final ItemRegistryObject<Item> NEUTRON_SOURCE_PELLET;
    //public static final ItemRegistryObject<Item> HIGH_DENSITY_NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_high-density_neutron_source", () -> new HighDensityNeutronSourcePellet(new Item.Properties(), EnumColor.PURPLE));    public static final ItemRegistryObject<Item> DUST_CALCIUM_OXIDE;
    public static final ItemRegistryObject<Item> DUST_BARIUM_SULFATE;
    public static final ItemRegistryObject<Item> DUST_CALCIUM_OXIDE;
    //public static final ItemRegistryObject<Item> AQUA_DYE;
    //public static final ItemRegistryObject<Item> DARK_RED_DYE;
    //public static final ItemRegistryObject<Item> DUST_YTTRIUM = ITEMS.register("dust_yttrium");
    //public static final ItemRegistryObject<Item> REFINED_CALIFORNIUM_INGOT = ITEMS.register("ingot_refined_californium", EnumColor.ORANGE);
    //public static final ItemRegistryObject<Item> EXCIPIENT = ITEMS.register("excipient");
    //public static final ItemRegistryObject<Item> TABLET_ANESTHETIC = ITEMS.register("tablet_anesthetic", () -> new AnestheticTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_FIRE_RESISTANCE = ITEMS.register("tablet_fire_resistance", () -> new FireResistanceTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    public static final ItemRegistryObject<Item> TABLET_IODINE;
    //public static final ItemRegistryObject<Item> TABLET_MUSCLE_ENHANCEMENT = ITEMS.register("tablet_muscle_enhancement", () -> new MuscleEnhancementTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_POISON = ITEMS.register("tablet_poison", () -> new PoisonTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
    //public static final ItemRegistryObject<Item> TABLET_SLEEP_INDUCING = ITEMS.register("tablet_sleep_inducing", () -> new SleepInducingTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));

    static {
        NEUTRON_SOURCE_PELLET = ITEMS.register("pellet_neutron_source", () -> new NeutronSourcePellet(new Item.Properties(), EnumColor.YELLOW));
        DUST_BARIUM_SULFATE = ITEMS.register("dust_barium_sulfate");
        DUST_CALCIUM_OXIDE = ITEMS.register("dust_calcium_oxide");
        TABLET_IODINE = ITEMS.register("tablet_iodine", () -> new IodineTablet(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).build())));
        //AQUA_DYE = ITEMS.register("aqua_dye", () -> new DyeItem(DyeColor.LIGHT_BLUE, new Item.Properties()));
        //DARK_RED_DYE = ITEMS.register("dark_red_dye", () ->  new DyeItem(DyeColor.RED, new Item.Properties()));
    }

    private MSItems(){
    }
}
