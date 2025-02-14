package com.fxd927.mekanismscience.common.config;

import mekanism.common.config.IMekanismConfig;
import mekanism.common.config.MekanismConfigHelper;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.IConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class MSConfig {
    private MSConfig() {
    }
    private static final Map<IConfigSpec, IMekanismConfig> KNOWN_CONFIGS = new HashMap<>();
    public static final MSStorageConfig storageConfig = new MSStorageConfig();
    public static final MSUsageConfig usageConfig = new MSUsageConfig();

    public static void registerConfigs(ModContainer modContainer) {
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, storageConfig);
        MekanismConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, usageConfig);
    }
}
