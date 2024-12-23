package com.fxd927.mekanismscience.common.gas;

import mekanism.common.base.IChemicalConstant;

public enum MSChemicalConstants implements IChemicalConstant {
    AMMONIA("ammonia", 0xFFC8B3FF, 0, 240F, 0.6942F),
    AMMONIUM_NITRATE("ammonium_nitrate", 0xFF5E89FF, 0, 483.15F, 1700F),
    AQUA_REGIA("aqua_regia", 0xFFF3DC44, 0, 381F, 1210F),
    BARIUM("barium", 0xFF6B9BA1, 0, 1910F, 3510F),
    BARIUM_SULFATE("barium_sulfate", 0xFF86C4C0, 0, 1873.15F, 4500F),
    BENZODIAZEPINE("benzodiazepine", 0xFF66D0BA, 0, 573F, 900F),
    BERYLLIUM("beryllium", 0xFF00DB1B, 0, 1560.15F, 1850F),
    BROMINE("bromine", 0xFFBA1A08, 0, 332F, 3102.8F),
    CHLOROMETHANE("chloromethane", 0xFF87E7C3, 0, 249.3F, 2.22F),
    COMPRESSED_AIR("compressed_air", 0xFFFFFFFF, 0, 78.80F, 870F),
    CONCENTRATED_SEAWATER("concentrated_seawater", 0xFF06C9E6, 0, 373.15F, 1000F),
    ETHANOL("ethanol", 0xFFFBCAFF, 0, 351F, 789F),
    HELIUM("helium", 0xFFE0F0FF, 0, 4.22F, 124.9F),
    SUPERHEATED_HELIUM("superheated_helium", 0xFFFFDDB5, 0, 2_000F, 124.9F),
    IODINE("iodine", 0xFF8536B2, 0, 363.7F, 4933F),
    NETHERITE_ACID("netherite_acid", 0xFF4D4C4C, 0, 381F, 1210F),
    NITRIC_ACID("nitric_acid", 0xFFB5BCFF, 0, 363.7F, 4933F),
    NITROGEN("nitrogen", 0xFFFA8FF0, 0, 77.36F, 1.251F),
    NITROGEN_OXIDE("nitrogen_oxide", 0xFE19DF2, 0, 77.36F, 1.251F),
    NITROGEN_DIOXIDE("nitrogen_dioxide", 0xFFD6A3F3, 0, 77.36F, 1.251F),
    POTASSIUM("potassium", 0xFFFF82D1, 0, 1302F, 890F),
    POTASSIUM_IODIDE("potassium_iodide", 0xFFC25CC1, 0, 1603.15F, 3130F),
    STRONTIUM("strontium", 0xFFFFC1B2, 0, 1050.15F, 2375F),
    LACTOSE("lactose", 0xFFFFFFEF, 0, 941.05F, 1525F),
    METHANOL("methanol", 0xFF66DE9E, 0, 338F, 791.8F),
    METHYLAMINE("methylamine", 0xFFA7CDE1, 0, 267.15F, 700F),
    METHYLAMMONIUM_LEAD_IODIDE("methylammonium_lead_iodide", 0xFFC3B4B1, 0, 358.15F, 4160F),
    MILK("milk", 0xFFFFFFFF, 0, 373.7F, 1040F),
    SEAWATER("seawater", 0xFF06C9E6, 0, 373.15F, 1000F),
    TETRODOTOXIN("tetrodotoxin", 0xFF5DC86F, 0, 593.15F, 1000F),
    WHEY("whey", 0xFFF7FFA2, 0, 373.15F, 1030F),
    XENON("xenon", 0xFF665BFF, 0, 373.15F, 1030F),
    YTTRIUM("yttrium", 0xFFCCE5FF, 0, 1799.15F, 4240F);

    private final String name;
    private final int color;
    private final int lightLevel;
    private final float temperature;
    private final float density;

    MSChemicalConstants(String name, int color, int lightLevel, float temperature, float density) {
        this.name = name;
        this.color = color;
        this.lightLevel = lightLevel;
        this.temperature = temperature;
        this.density = density;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public int getLightLevel() {
        return lightLevel;
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public float getDensity() {
        return density;
    }

}

