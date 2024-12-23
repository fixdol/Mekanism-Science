package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.gas.MSChemicalConstants;
import com.fxd927.mekanismscience.mixin.CoolantAccessor;
import mekanism.api.chemical.attribute.ChemicalAttribute;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.attribute.GasAttributes;
import mekanism.common.registration.impl.GasDeferredRegister;
import mekanism.common.registration.impl.GasRegistryObject;

public class MSGases {
    public static final GasDeferredRegister GASES = new GasDeferredRegister(MekanismScience.MODID);

    public static final GasRegistryObject<Gas> ACTIVATED_CARBON;
    public static final GasRegistryObject<Gas> AMERICIUM;
    public static final GasRegistryObject<Gas> AMMONIA;
    public static final GasRegistryObject<Gas> AMMONIUM_NITRATE;
    public static final GasRegistryObject<Gas> AQUA_REGIA;
    public static final GasRegistryObject<Gas> BARIUM;
    public static final GasRegistryObject<Gas> BARIUM_SULFATE;
    //public static final GasRegistryObject<Gas> BENZODIAZEPINE;
    //public static final GasRegistryObject<Gas> BROMINE;
    public static final GasRegistryObject<Gas> BERYLLIUM;
    public static final GasRegistryObject<Gas> CALIFORNIUM;
    //public static final GasRegistryObject<Gas> CHLOROMETHANE;
    public static final GasRegistryObject<Gas> COMPRESSED_AIR;
    public static final GasRegistryObject<Gas> CURIUM;
    public static final GasRegistryObject<Gas> DISSOLVED_SPENT_NUCLEAR_WASTE;
    //public static final GasRegistryObject<Gas> CONCENTRATED_SEAWATER;
    //public static final GasRegistryObject<Gas> ETHANOL;
    public static final GasRegistryObject<Gas> HELIUM;
    public static final GasRegistryObject<Gas> SUPERHEATED_HELIUM;
    public static final GasRegistryObject<Gas> IODINE;
    //public static final GasRegistryObject<Gas> LACTOSE;
    //public static final GasRegistryObject<Gas> METHANOL;
    //public static final GasRegistryObject<Gas> METHYLAMINE;
    //public static final GasRegistryObject<Gas> METHYLAMMONIUM_LEAD_IODIDE;
    public static final GasRegistryObject<Gas> NITROGEN_DIOXIDE;
    public static final GasRegistryObject<Gas> NITRIC_ACID;
    public static final GasRegistryObject<Gas> NITROGEN;
    public static final GasRegistryObject<Gas> NETHERITE_ACID;
    public static final GasRegistryObject<Gas> NITROGEN_OXIDE;
    public static final GasRegistryObject<Gas> POTASSIUM;
    public static final GasRegistryObject<Gas> POTASSIUM_IODIDE;
    public static final GasRegistryObject<Gas> SEAWATER;
    public static final GasRegistryObject<Gas> STRONTIUM;
    //public static final GasRegistryObject<Gas> TETRODOTOXIN;
    //public static final GasRegistryObject<Gas> WHEY;
    public static final GasRegistryObject<Gas> XENON;
    public static final GasRegistryObject<Gas> YTTRIUM;

    static {
        ACTIVATED_CARBON = GASES.register("activated_carbon", 0x3F3232);
        AMERICIUM = GASES.register("americium", 13983840, new GasAttributes.Radiation(0.05));
        AMMONIA = GASES.register(MSChemicalConstants.AMMONIA);
        AMMONIUM_NITRATE = GASES.register(MSChemicalConstants.AMMONIUM_NITRATE);
        AQUA_REGIA = GASES.register(MSChemicalConstants.AQUA_REGIA);
        BARIUM = GASES.register(MSChemicalConstants.BARIUM);
        BARIUM_SULFATE = GASES.register(MSChemicalConstants.BARIUM_SULFATE);
        //BENZODIAZEPINE = GASES.register(MSChemicalConstants.BENZODIAZEPINE);
        //BROMINE = GASES.register(MSChemicalConstants.BROMINE);
        BERYLLIUM = GASES.register(MSChemicalConstants.BERYLLIUM);
        CALIFORNIUM = GASES.register("californium", 0xFFF08B00, new GasAttributes.Radiation(0.1));
        //CHLOROMETHANE = GASES.register(MSChemicalConstants.CHLOROMETHANE);
        COMPRESSED_AIR = GASES.register(MSChemicalConstants.COMPRESSED_AIR);
        CURIUM = GASES.register("curium",15725501,new GasAttributes.Radiation(0.07));
        DISSOLVED_SPENT_NUCLEAR_WASTE = GASES.register("dissolved_spent_nuclear_waste",0x8588b1);
        //CONCENTRATED_SEAWATER = GASES.register(MSChemicalConstants.CONCENTRATED_SEAWATER);
        //ETHANOL = GASES.register(MSChemicalConstants.ETHANOL);
        HELIUM = GASES.register(MSChemicalConstants.HELIUM, Coolants.HELIUM_COOLANT);
        SUPERHEATED_HELIUM = GASES.register(MSChemicalConstants.SUPERHEATED_HELIUM, Coolants.HEATED_HELIUM_COOLANT);
        IODINE = GASES.register(MSChemicalConstants.IODINE);
        //LACTOSE = GASES.register(MSChemicalConstants.LACTOSE);
        //METHANOL = GASES.register(MSChemicalConstants.METHANOL);
        //METHYLAMINE = GASES.register(MSChemicalConstants.METHYLAMINE);
        //METHYLAMMONIUM_LEAD_IODIDE = GASES.register(MSChemicalConstants.METHYLAMMONIUM_LEAD_IODIDE);
        NETHERITE_ACID = GASES.register(MSChemicalConstants.NETHERITE_ACID);
        NITRIC_ACID = GASES.register(MSChemicalConstants.NITRIC_ACID);
        NITROGEN = GASES.register(MSChemicalConstants.NITROGEN);
        NITROGEN_DIOXIDE = GASES.register(MSChemicalConstants.NITROGEN_DIOXIDE);
        NITROGEN_OXIDE = GASES.register(MSChemicalConstants.NITROGEN_OXIDE);
        POTASSIUM = GASES.register(MSChemicalConstants.POTASSIUM);
        POTASSIUM_IODIDE = GASES.register(MSChemicalConstants.POTASSIUM_IODIDE);
        SEAWATER = GASES.register(MSChemicalConstants.SEAWATER);
        STRONTIUM = GASES.register(MSChemicalConstants.STRONTIUM);
        //TETRODOTOXIN = GASES.register(MSChemicalConstants.TETRODOTOXIN);
        //WHEY = GASES.register(MSChemicalConstants.WHEY);
        XENON = GASES.register(MSChemicalConstants.XENON);
        YTTRIUM = GASES.register(MSChemicalConstants.YTTRIUM);
    }

    private MSGases() {
    }

    public static class Coolants{
        public static void init(){
            setHeliumCoolantConductivity();
            setSuperheatedHeliumCoolantConductivity();
        }

        public static final GasAttributes.CooledCoolant HELIUM_COOLANT = new GasAttributes.CooledCoolant(() -> SUPERHEATED_HELIUM.get(), 100, 1.0);
        public static final GasAttributes.HeatedCoolant HEATED_HELIUM_COOLANT = new GasAttributes.HeatedCoolant(() -> HELIUM.get(), 100, 1.0);

        public static void setHeliumCoolantConductivity() {
            ((CoolantAccessor) HELIUM_COOLANT).setConductivity(1.5);
        }
        public static void setSuperheatedHeliumCoolantConductivity() {
            ((CoolantAccessor) HEATED_HELIUM_COOLANT).setConductivity(1.5);
        }
    }
}
