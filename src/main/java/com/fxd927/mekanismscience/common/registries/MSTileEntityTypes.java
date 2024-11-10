package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionTypeSeawaterMetalExtractor;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityOrganicLiquidExtractor;
import com.fxd927.mekanismscience.common.tile.machine.TileEntitySeawaterPump;
import com.fxd927.mekanismscience.common.tile.misc.TileEntityXenonLight;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;

public class MSTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismScience.MODID);

    public static final TileEntityTypeRegistryObject<TileEntityXenonLight> XENON_LIGHT;
    //public static final TileEntityTypeRegistryObject<TileEntityAdsorptionTypeSeawaterMetalExtractor> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityAdsorptionTypeSeawaterMetalExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntityOrganicLiquidExtractor> ORGANIC_LIQUID_EXTRACTOR = TILE_ENTITY_TYPES.register(null, TileEntityOrganicLiquidExtractor::new);
    //public static final TileEntityTypeRegistryObject<TileEntitySeawaterPump> SEAWATER_PUMP = TILE_ENTITY_TYPES.register(null, TileEntitySeawaterPump::new);

    static {
        XENON_LIGHT = TILE_ENTITY_TYPES.register(null, TileEntityXenonLight::new);
    }

    private MSTileEntityTypes(){
    }
}
