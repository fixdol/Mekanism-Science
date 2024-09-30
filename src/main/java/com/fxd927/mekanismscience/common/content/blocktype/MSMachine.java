package com.fxd927.mekanismscience.common.content.blocktype;

import mekanism.api.text.ILangEntry;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

import java.util.function.Supplier;

public class MSMachine <TILE extends TileEntityMekanism> extends BlockTypeTile<TILE> {
    public MSMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        super(tileEntityRegistrar, description);
        add(Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), Attributes.SECURITY, Attributes.INVENTORY, Attributes.REDSTONE, Attributes.COMPARATOR);
    }

    public static class MSMachineBuilder<MACHINE extends MSMachine<TILE>, TILE extends TileEntityMekanism, T extends MSMachineBuilder<MACHINE, TILE, T>> extends BlockTileBuilder<MACHINE, TILE, T> {
        protected MSMachineBuilder(MACHINE holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> MSMachineBuilder<MSMachine<TILE>, TILE, ?> createMSMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar,
                                                                                                                   ILangEntry description) {
            return new MSMachineBuilder<>(new MSMachine<>(tileEntityRegistrar, description));
        }
    }
}
