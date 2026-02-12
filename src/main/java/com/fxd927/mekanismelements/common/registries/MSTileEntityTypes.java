package com.fxd927.mekanismelements.common.registries;

import com.fxd927.mekanismelements.common.MekanismElements;
import com.fxd927.mekanismelements.common.tile.machine.*;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;

public class MSTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismElements.MODID);

    public static final TileEntityTypeRegistryObject<TileEntityAdsorptionSeparator> ADSORPTION_SEPARATOR;
    public static final TileEntityTypeRegistryObject<TileEntityAirCompressor> AIR_COMPRESSOR;
    public static final TileEntityTypeRegistryObject<TileEntityRadiationIrradiator> RADIATION_IRRADIATOR;
    //public static final TileEntityTypeRegistryObject<TileEntitySeawaterPump> SEAWATER_PUMP;

    static {
        RADIATION_IRRADIATOR = TILE_ENTITY_TYPES
            .mekBuilder(MSBlocks.RADIATION_IRRADIATOR, TileEntityRadiationIrradiator::new)
            .clientTicker(TileEntityMekanism::tickClient)
            .serverTicker(TileEntityMekanism::tickServer)
            .withSimple(Capabilities.CONFIG_CARD)
            .build();
        
        ADSORPTION_SEPARATOR = TILE_ENTITY_TYPES
            .mekBuilder(MSBlocks.ADSORPTION_SEPARATOR, TileEntityAdsorptionSeparator::new)
            .clientTicker(TileEntityMekanism::tickClient)
            .serverTicker(TileEntityMekanism::tickServer)
            .withSimple(Capabilities.CONFIG_CARD)
            .build();
        
        AIR_COMPRESSOR = TILE_ENTITY_TYPES
            .mekBuilder(MSBlocks.AIR_COMPRESSOR, TileEntityAirCompressor::new)
            .clientTicker(TileEntityMekanism::tickClient)
            .serverTicker(TileEntityMekanism::tickServer)
            .withSimple(Capabilities.CONFIG_CARD)
            .build();
    }

    private MSTileEntityTypes(){
    }
}