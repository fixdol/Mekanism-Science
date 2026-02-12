package com.fxd927.mekanismelements.common.registries;

import com.fxd927.mekanismelements.common.MekanismElements;
import com.fxd927.mekanismelements.common.tile.machine.*;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class MSContainerTypes {
    public static final ContainerTypeDeferredRegister CONTAINER_TYPES = new ContainerTypeDeferredRegister(MekanismElements.MODID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityRadiationIrradiator>> RADIATION_IRRADIATOR;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityAdsorptionSeparator>> ADSORPTION_SEPARATOR;
    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityAirCompressor>> AIR_COMPRESSOR;

    static {
        RADIATION_IRRADIATOR = CONTAINER_TYPES.register(MSBlocks.RADIATION_IRRADIATOR, TileEntityRadiationIrradiator.class);
        ADSORPTION_SEPARATOR = CONTAINER_TYPES.register(MSBlocks.ADSORPTION_SEPARATOR, TileEntityAdsorptionSeparator.class);
        AIR_COMPRESSOR = CONTAINER_TYPES.register(MSBlocks.AIR_COMPRESSOR, TileEntityAirCompressor.class);
    }

    private MSContainerTypes(){
    }
}