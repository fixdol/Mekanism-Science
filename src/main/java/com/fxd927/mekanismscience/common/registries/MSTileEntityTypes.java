package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.tile.machine.*;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;

public class MSTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismScience.MODID);

    //public static final TileEntityTypeRegistryObject<TileEntityAdsorptionSeparator> ADSORPTION_SEPARATOR;
    //public static final TileEntityTypeRegistryObject<TileEntityAirCompressor> AIR_COMPRESSOR;
    //public static final TileEntityTypeRegistryObject<TileEntityRadiationIrradiator> RADIATION_IRRADIATOR = TILE_ENTITY_TYPES
            //.mekBuilder(MSBlocks.RADIATION_IRRADIATOR, TileEntityRadiationIrradiator::new)
            //.clientTicker(TileEntityMekanism::tickClient)
            //.serverTicker(TileEntityMekanism::tickServer)
            //.withSimple(Capabilities.CONFIG_CARD)
    //.build();
    //public static final TileEntityTypeRegistryObject<TileEntitySeawaterPump> SEAWATER_PUMP;


    //public static final TileEntityTypeRegistryObject<TileEntityAdsorptionTypeSeawaterMetalExtractor> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityAdsorptionTypeSeawaterMetalExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntityOrganicLiquidExtractor> ORGANIC_LIQUID_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityOrganicLiquidExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntitySeawaterPump> SEAWATER_PUMP = TILE_ENTITY_TYPES.register(null, TileEntitySeawaterPump::new);

    static {
        //ADSORPTION_SEPARATOR = TILE_ENTITY_TYPES.register(MSBlocks.ADSORPTION_SEPARATOR, TileEntityAdsorptionSeparator::new, TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
        //AIR_COMPRESSOR = TILE_ENTITY_TYPES.register(MSBlocks.AIR_COMPRESSOR, TileEntityAirCompressor::new, TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
        //SEAWATER_PUMP = TILE_ENTITY_TYPES.register(MSBlocks.SEAWATER_PUMP, TileEntitySeawaterPump::new, TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    }

    private MSTileEntityTypes(){
    }
}
