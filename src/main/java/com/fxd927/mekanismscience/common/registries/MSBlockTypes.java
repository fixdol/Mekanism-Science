package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MSLang;
import com.fxd927.mekanismscience.common.config.MSConfig;
import com.fxd927.mekanismscience.common.content.blocktype.MSBlockShapes;
import com.fxd927.mekanismscience.common.content.blocktype.MSMachine;
import com.fxd927.mekanismscience.common.tile.machine.*;
import mekanism.api.Upgrade;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeSideConfig;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.blocktype.BlockShapes;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.registries.MekanismContainerTypes;
import mekanism.common.registries.MekanismSounds;
import mekanism.common.registries.MekanismTileEntityTypes;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;
import mekanism.generators.common.registries.GeneratorsSounds;

import java.util.EnumSet;

public class MSBlockTypes {
    public static final Machine<TileEntityRadiationIrradiator> RADIATION_IRRADIATOR = Machine.MachineBuilder
            .createMachine(() -> MSTileEntityTypes.RADIATION_IRRADIATOR, MSLang.DESCRIPTION_RADIATION_IRRADIATOR)
            .withGui(() -> MSContainerTypes.RADIATION_IRRADIATOR)
            .withSound(GeneratorsSounds.FISSION_REACTOR)
            .withEnergyConfig(MSConfig.usageConfig.radiationIrradiator, MSConfig.storageConfig.radiationIrradiator)
            .with(AttributeUpgradeSupport.DEFAULT_ADVANCED_MACHINE_UPGRADES)
            .with(AttributeSideConfig.ADVANCED_ELECTRIC_MACHINE)
            .withComputerSupport("radiationIrradiator")
            .replace(Attributes.ACTIVE_FULL_LIGHT)
    .build();
    private MSBlockTypes(){
    }
}
