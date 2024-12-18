package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.tile.machine.*;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class MSContainerTypes {
    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(MekanismScience.MODID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityAirCompressor>> AIR_COMPRESSOR;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityNeutronIrradiator>> NEUTRON_IRRADIATOR;

    //public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityAdsorptionTypeSeawaterMetalExtractor>> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = CONTAINER_TYPES.register(MSBlocks.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR, TileEntityAdsorptionTypeSeawaterMetalExtractor.class);
    //public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityOrganicLiquidExtractor>> ORGANIC_LIQUID_EXTRACTOR = CONTAINER_TYPES.register(MSBlocks.ORGANIC_LIQUID_EXTRACTOR, TileEntityOrganicLiquidExtractor.class);
    //public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntitySeawaterPump>> SEAWATER_PUMP = CONTAINER_TYPES.register(MSBlocks.SEAWATER_PUMP, TileEntitySeawaterPump.class);

    static {
        AIR_COMPRESSOR = CONTAINER_TYPES.register(MSBlocks.AIR_COMPRESSOR, TileEntityAirCompressor.class);
        NEUTRON_IRRADIATOR = CONTAINER_TYPES.register(MSBlocks.NEUTRON_IRRADIATOR, TileEntityNeutronIrradiator.class);
    }

    private MSContainerTypes(){
    }
}
