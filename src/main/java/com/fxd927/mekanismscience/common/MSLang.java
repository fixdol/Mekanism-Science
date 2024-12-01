package com.fxd927.mekanismscience.common;

import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

public enum MSLang implements ILangEntry {
    DESCRIPTION_AIR_COMPRESSOR("description", "air_compressor"),
    ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR("description", "adsorption_type_seawater_metal_extractor"),
    DESCRIPTION_ORGANIC_LIQUID_EXTRACTOR("description","organic_liquid_extractor"),
    DESCRIPTION_SEAWATER_PUMP("description", "seawater_pump"),
    MEKANISM_SCIENCE("constants","mod_name");

    private final String key;

    MSLang(String type,String path){
        this(Util.makeDescriptionId(type, MekanismScience.rl(path)));
    }

    MSLang(String key){
        this.key = key;
    }

    @Override
    public String getTranslationKey(){
        return key;
    }
}
