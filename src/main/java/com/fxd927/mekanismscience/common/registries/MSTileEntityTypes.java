package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.tile.machine.*;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;

public class MSTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismScience.MODID);

    public static final TileEntityTypeRegistryObject<TileEntityAirCompressor> AIR_COMPRESSOR;
    public static final TileEntityTypeRegistryObject<TileEntityNeutronIrradiator> NEUTRON_IRRADIATOR;


    //public static final TileEntityTypeRegistryObject<TileEntityAdsorptionTypeSeawaterMetalExtractor> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityAdsorptionTypeSeawaterMetalExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntityOrganicLiquidExtractor> ORGANIC_LIQUID_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityOrganicLiquidExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntitySeawaterPump> SEAWATER_PUMP = TILE_ENTITY_TYPES.register(null, TileEntitySeawaterPump::new);

    static {
        AIR_COMPRESSOR = TILE_ENTITY_TYPES.register(MSBlocks.AIR_COMPRESSOR, TileEntityAirCompressor::new);
        NEUTRON_IRRADIATOR = TILE_ENTITY_TYPES.register(MSBlocks.NEUTRON_IRRADIATOR, TileEntityNeutronIrradiator::new);
    }

    private MSTileEntityTypes(){
    }
}
