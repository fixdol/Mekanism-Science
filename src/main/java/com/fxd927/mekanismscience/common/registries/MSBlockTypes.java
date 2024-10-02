package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MSLang;
import com.fxd927.mekanismscience.common.config.MSConfig;
import com.fxd927.mekanismscience.common.content.blocktype.MSMachine;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionTypeSeawaterMetalExtractor;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityOrganicLiquidExtractor;
import com.fxd927.mekanismscience.common.tile.machine.TileEntitySeawaterPump;
import mekanism.api.Upgrade;
import mekanism.common.block.attribute.Attributes;

import java.util.EnumSet;

public class MSBlockTypes {
    public static final MSMachine<TileEntityAdsorptionTypeSeawaterMetalExtractor> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = MSMachine.MSMachineBuilder
            .createMSMachine(() -> MSTileEntityTypes.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR, MSLang.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR)
            .withGui(() -> MSContainerTypes.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR)
            .withEnergyConfig(MSConfig.usageConfig.adsorptionTypeSeawaterMetalExtractor, MSConfig.storageConfig.adsorptionTypeSeawaterMetalExtractor)
            .withComputerSupport("adsorptionTypeSeawaterMetalExtractor")
            .replace(Attributes.ACTIVE)
            .build();

    public static final MSMachine<TileEntityOrganicLiquidExtractor> ORGANIC_LIQUID_EXTRACTOR = MSMachine.MSMachineBuilder
            .createMSMachine(() -> MSTileEntityTypes.ORGANIC_LIQUID_EXTRACTOR, MSLang.DESCRIPTION_ORGANIC_LIQUID_EXTRACTOR)
            .withGui(() -> MSContainerTypes.ORGANIC_LIQUID_EXTRACTOR)
            .withEnergyConfig(MSConfig.usageConfig.organicLiquidExtractor, MSConfig.storageConfig.organicLiquidExtractor)
            .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY))
            .withComputerSupport("organicLiquidExtractor")
            .replace(Attributes.ACTIVE)
            .build();
    public static final MSMachine<TileEntitySeawaterPump> SEAWATER_PUMP = MSMachine.MSMachineBuilder
            .createMSMachine(() -> MSTileEntityTypes.SEAWATER_PUMP, MSLang.DESCRIPTION_SEAWATER_PUMP)
            .withGui(() -> MSContainerTypes.SEAWATER_PUMP)
            .withEnergyConfig(MSConfig.usageConfig.seawaterPump, MSConfig.storageConfig.seawaterPump)
            .withSupportedUpgrades(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY))
            .withComputerSupport("seawaterPump")
            .replace(Attributes.ACTIVE)
            .build();

    private MSBlockTypes(){
    }
}
