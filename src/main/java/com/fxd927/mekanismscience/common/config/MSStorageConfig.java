package com.fxd927.mekanismscience.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.MekanismConfigTranslations;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MSStorageConfig extends BaseMekanismConfig {
    private final ModConfigSpec configSpec;

    public final CachedLongValue airCompressor;
    public final CachedLongValue radiationIrradiator;
    public final CachedLongValue adsorptionSeparator;
    public final CachedLongValue seawaterPump;

    MSStorageConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Science Energy Storage Config. This config is synced from server to client.").push("storage");

        airCompressor = CachedLongValue.definedMin(this, builder, MekanismConfigTranslations.ENERGY_STORAGE_COMBINER, "airCompressor",
                40_000,1);

        radiationIrradiator = CachedLongValue.definedMin(this, builder, MekanismConfigTranslations.ENERGY_STORAGE_COMBINER, "radiation_irradiator",
                40_000,1);

        adsorptionSeparator = CachedLongValue.definedMin(this, builder, MekanismConfigTranslations.ENERGY_STORAGE_COMBINER, "adsorption",
                40_000,1);

        seawaterPump = CachedLongValue.definedMin(this, builder, MekanismConfigTranslations.ENERGY_STORAGE_COMBINER, "seawaterPump",
                40_000,1);

        builder.pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "science-storage";
    }

    @Override
    public String getTranslation() {
        return "Storage Config";
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
