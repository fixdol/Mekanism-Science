package com.fxd927.mekanismscience.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.MekanismConfigTranslations;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MSUsageConfig extends BaseMekanismConfig {

    public final CachedLongValue airCompressor;
    public final CachedLongValue radiationIrradiator;
    public final CachedLongValue adsorptionSeparator;
    public final CachedLongValue seawaterPump;
    public final CachedLongValue organicLiquidExtractor;

    private final ModConfigSpec configSpec;

    MSUsageConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("MS Energy Usage Config. This config is synced from server to client.").push("storage");

        airCompressor = CachedLongValue.definePositive(this, builder, MekanismConfigTranslations.ENERGY_USAGE_COMPRESSOR, "airCompressor",100);
        radiationIrradiator = CachedLongValue.definePositive(this, builder,  MekanismConfigTranslations.ENERGY_USAGE_COMPRESSOR, "radiationIrradiator", 1_000);
        adsorptionSeparator = CachedLongValue.definePositive(this, builder,  MekanismConfigTranslations.ENERGY_USAGE_COMPRESSOR, "adsorptionTypeSeawaterMetalExtractor", 500);
        organicLiquidExtractor = CachedLongValue.definePositive(this, builder,  MekanismConfigTranslations.ENERGY_USAGE_COMPRESSOR, "organicLiquidExtractor", 100);
        seawaterPump = CachedLongValue.definePositive(this, builder,  MekanismConfigTranslations.ENERGY_USAGE_COMPRESSOR, "seawaterPump", 100);

        builder.pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "science-usage";
    }

    @Override
    public String getTranslation() {
        return "Usage Config";
    }

    @Override
    public ModConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}
