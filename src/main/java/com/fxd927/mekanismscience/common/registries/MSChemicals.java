package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.gas.MSChemicalConstants;
import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.ChemicalDeferredRegister;
import mekanism.common.registration.impl.DeferredChemical;

public class MSChemicals {
    public static final ChemicalDeferredRegister CHEMICALS = new ChemicalDeferredRegister(MekanismScience.MODID);

    public static DeferredChemical<Chemical> AMERICIUM;
    //public static DeferredChemical<Chemical> AMMONIA;
    //public static DeferredChemical<Chemical> AMMONIUM_NITRATE;
    //public static DeferredChemical<Chemical> AQUA_REGIA;
    //public static DeferredChemical<Chemical> BROMINE;
    public static DeferredChemical<Chemical> BERYLLIUM;
    //public static DeferredChemical<Chemical> CALIFORNIUM;
    public static DeferredChemical<Chemical> COMPRESSED_AIR;
    //public static DeferredChemical<Chemical> CURIUM;
    //public static DeferredChemical<Chemical> DISSOLVED_SPENT_NUCLEAR_WASTE;
    public static DeferredChemical<Chemical> HELIUM;
    public static DeferredChemical<Chemical> HYDROGEN_CYANIDE;
    public static DeferredChemical<Chemical> SUPERHEATED_HELIUM;
    public static DeferredChemical<Chemical> IODINE;
    public static DeferredChemical<Chemical> METHANE;
    public static DeferredChemical<Chemical> NITROGEN_DIOXIDE;
    public static DeferredChemical<Chemical> NITRIC_ACID;
    public static DeferredChemical<Chemical> NITROGEN;
    //public static final DeferredChemical<Chemical> NETHERITE_ACID;
    public static DeferredChemical<Chemical> NITRIC_OXIDE;
    public static DeferredChemical<Chemical> POTASSIUM_CHLORIDE;
    public static DeferredChemical<Chemical> POTASSIUM_CYANIDE;
    public static DeferredChemical<Chemical> POTASSIUM_HYDROXIDE;
    public static DeferredChemical<Chemical> POTASSIUM_IODIDE;
    public static DeferredChemical<Chemical> SEAWATER;
    public static DeferredChemical<Chemical> STRONTIUM;
    public static DeferredChemical<Chemical> XENON;
    public static DeferredChemical<Chemical> YTTRIUM;

    static {
        AMERICIUM = CHEMICALS.register("americium", 13983840);
        //AMMONIA = CHEMICALS.register(MSChemicalConstants.AMMONIA, new ChemicalAttributes.Fuel(()-> 100, ()-> 600000));
        //AMMONIUM_NITRATE = CHEMICALS.register(MSChemicalConstants.AMMONIUM_NITRATE);
        // AQUA_REGIA = CHEMICALS.register(MSChemicalConstants.AQUA_REGIA);
        //BROMINE = CHEMICALS.register(MSChemicalConstants.BROMINE);
        BERYLLIUM = CHEMICALS.register(MSChemicalConstants.BERYLLIUM);
        //CALIFORNIUM = CHEMICALS.register("californium", 0xFFF08B00);
        COMPRESSED_AIR = CHEMICALS.register(MSChemicalConstants.COMPRESSED_AIR);
        //CURIUM = CHEMICALS.register("curium",15725501);
        //DISSOLVED_SPENT_NUCLEAR_WASTE = CHEMICALS.register("dissolved_spent_nuclear_waste",0x8588b1);
        HELIUM = CHEMICALS.register(MSChemicalConstants.HELIUM);
        //HYDROGEN_CYANIDE = CHEMICALS.register(MSChemicalConstants.HYDROGEN_CYANIDE);
        SUPERHEATED_HELIUM = CHEMICALS.register(MSChemicalConstants.SUPERHEATED_HELIUM);
        //IODINE = CHEMICALS.register(MSChemicalConstants.IODINE);
        //METHANE = CHEMICALS.register(MSChemicalConstants.METHANE);
        //NETHERITE_ACID = CHEMICALS.register(MSChemicalConstants.NETHERITE_ACID);
        //NITRIC_ACID = CHEMICALS.register(MSChemicalConstants.NITRIC_ACID);
        //NITROGEN = CHEMICALS.register(MSChemicalConstants.NITROGEN);
        //NITROGEN_DIOXIDE = CHEMICALS.register(MSChemicalConstants.NITROGEN_DIOXIDE);
        //NITRIC_OXIDE = CHEMICALS.register(MSChemicalConstants.NITRIC_OXIDE);
        //POTASSIUM_CHLORIDE = CHEMICALS.register(MSChemicalConstants.POTASSIUM_CHLORIDE);
        //POTASSIUM_CYANIDE = CHEMICALS.register(MSChemicalConstants.POTASSIUM_CYANIDE);
        //POTASSIUM_HYDROXIDE = CHEMICALS.register(MSChemicalConstants.POTASSIUM_HYDROXIDE);
        //POTASSIUM_IODIDE = CHEMICALS.register(MSChemicalConstants.POTASSIUM_IODIDE);
        //SEAWATER = CHEMICALS.register(MSChemicalConstants.SEAWATER);
        STRONTIUM = CHEMICALS.register(MSChemicalConstants.STRONTIUM);
        //XENON = CHEMICALS.register(MSChemicalConstants.XENON);
        YTTRIUM = CHEMICALS.register(MSChemicalConstants.YTTRIUM);
    }

    private MSChemicals() {
    }
}
