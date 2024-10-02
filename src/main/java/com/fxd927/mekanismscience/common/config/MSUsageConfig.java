package com.fxd927.mekanismscience.common.config;

import mekanism.api.math.FloatingLong;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedFloatingLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MSUsageConfig extends BaseMekanismConfig {
    public final CachedFloatingLongValue adsorptionTypeSeawaterMetalExtractor;
    public final CachedFloatingLongValue seawaterPump;
    public final CachedFloatingLongValue organicLiquidExtractor;

    private final ForgeConfigSpec configSpec;

    MSUsageConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("MS Energy Usage Config. This config is synced from server to client.").push("storage");

        adsorptionTypeSeawaterMetalExtractor = CachedFloatingLongValue.define(this, builder, "Energy per operation tick (Joules).", "adsorptionTypeSeawaterMetalExtractor", FloatingLong.createConst(100));
        organicLiquidExtractor = CachedFloatingLongValue.define(this, builder, "Energy per operation tick (Joules).", "organicLiquidExtractor", FloatingLong.createConst(100));
        seawaterPump = CachedFloatingLongValue.define(this, builder, "Energy per operation tick (Joules).", "seawaterPump", FloatingLong.createConst(100));

        builder.pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "science-usage";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }

    @Override
    public boolean addToContainer() {
        return false;
    }
}
