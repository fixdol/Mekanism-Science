package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.gas.MSChemicalConstants;
import com.fxd927.mekanismscience.mixin.CoolantAccessor;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.attribute.GasAttributes;
import mekanism.common.registration.impl.GasDeferredRegister;
import mekanism.common.registration.impl.GasRegistryObject;

public class MSGases {
    public static final GasDeferredRegister GASES = new GasDeferredRegister(MekanismScience.MODID);

    public static final GasRegistryObject<Gas> AMERICIUM;
    //public static final GasRegistryObject<Gas> AMMONIA;
    public static final GasRegistryObject<Gas> BARIUM;
    public static final GasRegistryObject<Gas> BARIUM_SULFATE;
    //public static final GasRegistryObject<Gas> BENZODIAZEPINE;
    //public static final GasRegistryObject<Gas> BROMINE;
    public static final GasRegistryObject<Gas> BERYLLIUM;
    //public static final GasRegistryObject<Gas> CALIFORNIUM;
    //public static final GasRegistryObject<Gas> CHLOROMETHANE;
    //public static final GasRegistryObject<Gas> CONCENTRATED_SEAWATER;
    //public static final GasRegistryObject<Gas> ETHANOL;
    public static final GasRegistryObject<Gas> HELIUM;
    public static final GasRegistryObject<Gas> SUPERHEATED_HELIUM;
    public static final GasRegistryObject<Gas> IODINE;
    //public static final GasRegistryObject<Gas> LACTOSE;
    //public static final GasRegistryObject<Gas> METHANOL;
    //public static final GasRegistryObject<Gas> METHYLAMINE;
    //public static final GasRegistryObject<Gas> METHYLAMMONIUM_LEAD_IODIDE;
    public static final GasRegistryObject<Gas> POTASSIUM;
    public static final GasRegistryObject<Gas> POTASSIUM_IODIDE;
    //public static final GasRegistryObject<Gas> SEAWATER;
    public static final GasRegistryObject<Gas> STRONTIUM;
    //public static final GasRegistryObject<Gas> TETRODOTOXIN;
    //public static final GasRegistryObject<Gas> WHEY;
    public static final GasRegistryObject<Gas> XENON;
    public static final GasRegistryObject<Gas> YTTRIUM;

    static {
        AMERICIUM = GASES.register("americium", 13983840, new GasAttributes.Radiation(0.05));
        //AMMONIA = GASES.register(MSChemicalConstants.AMMONIA);
        BARIUM = GASES.register(MSChemicalConstants.BARIUM);
        BARIUM_SULFATE = GASES.register(MSChemicalConstants.BARIUM_SULFATE);
        //BENZODIAZEPINE = GASES.register(MSChemicalConstants.BENZODIAZEPINE);
        //BROMINE = GASES.register(MSChemicalConstants.BROMINE);
        BERYLLIUM = GASES.register(MSChemicalConstants.BERYLLIUM);
        //CALIFORNIUM = GASES.register("californium", 0xFFF08B00, new GasAttributes.Radiation(0.1));
        //CHLOROMETHANE = GASES.register(MSChemicalConstants.CHLOROMETHANE);
        //CONCENTRATED_SEAWATER = GASES.register(MSChemicalConstants.CONCENTRATED_SEAWATER);
        //ETHANOL = GASES.register(MSChemicalConstants.ETHANOL);
        HELIUM = GASES.register(MSChemicalConstants.HELIUM, Coolants.HELIUM_COOLANT);
        SUPERHEATED_HELIUM = GASES.register(MSChemicalConstants.SUPERHEATED_HELIUM, Coolants.HEATED_HELIUM_COOLANT);
        IODINE = GASES.register(MSChemicalConstants.IODINE);
        //LACTOSE = GASES.register(MSChemicalConstants.LACTOSE);
        //METHANOL = GASES.register(MSChemicalConstants.METHANOL);
        //METHYLAMINE = GASES.register(MSChemicalConstants.METHYLAMINE);
        //METHYLAMMONIUM_LEAD_IODIDE = GASES.register(MSChemicalConstants.METHYLAMMONIUM_LEAD_IODIDE);
        POTASSIUM = GASES.register(MSChemicalConstants.POTASSIUM);
        POTASSIUM_IODIDE = GASES.register(MSChemicalConstants.POTASSIUM_IODIDE);
        //SEAWATER = GASES.register(MSChemicalConstants.SEAWATER);
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
