package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.content.blocktype.MSMachine;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionSeparator;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAirCompressor;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityRadiationIrradiator;
import com.fxd927.mekanismscience.common.tile.machine.TileEntitySeawaterPump;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.item.block.machine.ItemBlockMachine;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.resource.BlockResourceInfo;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class MSBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MekanismScience.MODID);
    public static final BlockDeferredRegister BUILDING_BLOCKS = new BlockDeferredRegister(MekanismScience.MODID);

    public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityAdsorptionSeparator,MSMachine<TileEntityAdsorptionSeparator>>,ItemBlockMachine> ADSORPTION_SEPARATOR;
    public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityAirCompressor,MSMachine<TileEntityAirCompressor>>,ItemBlockMachine> AIR_COMPRESSOR;
    public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityRadiationIrradiator,MSMachine<TileEntityRadiationIrradiator>>,ItemBlockMachine> RADIATION_IRRADIATOR;
    public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntitySeawaterPump,MSMachine<TileEntitySeawaterPump>>,ItemBlockMachine> SEAWATER_PUMP;

    public static final BlockRegistryObject<Block,BlockItem> HIGH_QUALITY_CONCRETE ;
    public static final BlockRegistryObject<Block,BlockItem> AQUA_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> BLACK_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> BLUE_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> GREEN_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> CYAN_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> DARK_RED_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> PURPLE_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> ORANGE_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_GRAY_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> GRAY_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_BLUE_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> LIME_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> RED_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> MAGENTA_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> YELLOW_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> WHITE_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> BROWN_HIGH_QUALITY_CONCRETE;
    public static final BlockRegistryObject<Block,BlockItem> PINK_HIGH_QUALITY_CONCRETE;

    public static final BlockRegistryObject<Block,BlockItem> HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> AQUA_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> BLACK_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> BLUE_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> GREEN_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> CYAN_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> DARK_RED_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> PURPLE_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> ORANGE_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_GRAY_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> GRAY_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_BLUE_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> LIME_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> RED_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> MAGENTA_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> YELLOW_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> WHITE_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> BROWN_HIGH_QUALITY_CONCRETE_STAIRS;
    public static final BlockRegistryObject<Block,BlockItem> PINK_HIGH_QUALITY_CONCRETE_STAIRS;

    public static final BlockRegistryObject<Block,BlockItem> HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> AQUA_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> BLACK_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> BLUE_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> GREEN_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> CYAN_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> DARK_RED_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> PURPLE_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> ORANGE_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_GRAY_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> GRAY_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_BLUE_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> LIME_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> RED_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> MAGENTA_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> YELLOW_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> WHITE_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> BROWN_HIGH_QUALITY_CONCRETE_SLABS;
    public static final BlockRegistryObject<Block,BlockItem> PINK_HIGH_QUALITY_CONCRETE_SLABS;

    public static final BlockRegistryObject<Block,BlockItem> HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> AQUA_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> BLACK_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> BLUE_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> GREEN_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> CYAN_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> DARK_RED_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> PURPLE_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> ORANGE_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_GRAY_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> GRAY_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> LIGHT_BLUE_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> LIME_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> RED_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> MAGENTA_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> YELLOW_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> WHITE_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> BROWN_HIGH_QUALITY_CONCRETE_POWDER;
    public static final BlockRegistryObject<Block,BlockItem> PINK_HIGH_QUALITY_CONCRETE_POWDER;

    static {
        ADSORPTION_SEPARATOR = BLOCKS.register("adsorption_separator",() -> new BlockTile.BlockTileModel<>(MSBlockTypes.ADSORPTION_SEPARATOR, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())),ItemBlockMachine::new);
        AIR_COMPRESSOR = BLOCKS.register("air_compressor",() -> new BlockTile.BlockTileModel<>(MSBlockTypes.AIR_COMPRESSOR, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())),ItemBlockMachine::new);
        RADIATION_IRRADIATOR = BLOCKS.register("radiation_irradiator", () -> new BlockTile.BlockTileModel<>(MSBlockTypes.RADIATION_IRRADIATOR, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())),ItemBlockMachine::new);
        SEAWATER_PUMP = BLOCKS.register("seawater_pump", () -> new BlockTile.BlockTileModel<>(MSBlockTypes.SEAWATER_PUMP, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())),ItemBlockMachine::new);

        HIGH_QUALITY_CONCRETE = BLOCKS.register("high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        AQUA_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("aqua_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        BLACK_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("black_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        BLUE_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("blue_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        GREEN_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("green_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        CYAN_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("cyan_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        DARK_RED_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("dark_red_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        PURPLE_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("purple_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        ORANGE_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("orange_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        LIGHT_GRAY_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("light_gray_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        GRAY_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("gray_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        LIGHT_BLUE_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("light_blue_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        LIME_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("lime_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        RED_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("red_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        MAGENTA_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("magenta_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        YELLOW_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("yellow_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        WHITE_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("white_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        BROWN_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("brown_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));
        PINK_HIGH_QUALITY_CONCRETE = BUILDING_BLOCKS.register("pink_high_quality_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

        HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("high_quality_concrete_stairs", () -> new StairBlock(HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        AQUA_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("aqua_high_quality_concrete_stairs", () -> new StairBlock(AQUA_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BLACK_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("black_high_quality_concrete_stairs", () -> new StairBlock(BLACK_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BLUE_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("blue_high_quality_concrete_stairs", () -> new StairBlock(BLUE_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        GREEN_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("green_high_quality_concrete_stairs", () -> new StairBlock(GREEN_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        CYAN_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("cyan_high_quality_concrete_stairs", () -> new StairBlock(CYAN_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        DARK_RED_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("dark_red_high_quality_concrete_stairs", () -> new StairBlock(DARK_RED_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        PURPLE_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("purple_high_quality_concrete_stairs", () -> new StairBlock(PURPLE_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        ORANGE_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("orange_high_quality_concrete_stairs", () -> new StairBlock(ORANGE_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIGHT_GRAY_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("light_gray_high_quality_concrete_stairs", () -> new StairBlock(LIGHT_GRAY_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        GRAY_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("gray_high_quality_concrete_stairs", () -> new StairBlock(GRAY_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIGHT_BLUE_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("light_blue_high_quality_concrete_stairs", () -> new StairBlock(LIGHT_BLUE_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIME_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("lime_high_quality_concrete_stairs", () -> new StairBlock(LIME_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        RED_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("red_high_quality_concrete_stairs", () -> new StairBlock(RED_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        MAGENTA_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("magenta_high_quality_concrete_stairs", () -> new StairBlock(MAGENTA_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        YELLOW_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("yellow_high_quality_concrete_stairs", () -> new StairBlock(YELLOW_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        WHITE_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("white_high_quality_concrete_stairs", () -> new StairBlock(WHITE_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BROWN_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("brown_high_quality_concrete_stairs", () -> new StairBlock(BROWN_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        PINK_HIGH_QUALITY_CONCRETE_STAIRS = BUILDING_BLOCKS.register("pink_high_quality_concrete_stairs", () -> new StairBlock(PINK_HIGH_QUALITY_CONCRETE.getBlock().defaultBlockState(), BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));

        HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        AQUA_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("aqua_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BLACK_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("black_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BLUE_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("blue_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        GREEN_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("green_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        CYAN_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("cyan_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        DARK_RED_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("dark_red_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        PURPLE_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("purple_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        ORANGE_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("orange_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIGHT_GRAY_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("light_gray_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        GRAY_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("gray_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIGHT_BLUE_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("light_blue_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        LIME_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("lime_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        RED_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("red_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        MAGENTA_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("magenta_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        YELLOW_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("yellow_high_quality_concrete_slab", () -> new SlabBlock( BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        WHITE_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("white_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        BROWN_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("brown_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));
        PINK_HIGH_QUALITY_CONCRETE_SLABS = BUILDING_BLOCKS.register("pink_high_quality_concrete_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HIGH_QUALITY_CONCRETE.getBlock())));

        HIGH_QUALITY_CONCRETE_POWDER = BLOCKS.register("high_quality_concrete_powder", () -> new ConcretePowderBlock(HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        AQUA_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("aqua_high_quality_concrete_powder", () -> new ConcretePowderBlock(AQUA_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        BLACK_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("black_high_quality_concrete_powder", () -> new ConcretePowderBlock(BLACK_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        BLUE_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("blue_high_quality_concrete_powder", () -> new ConcretePowderBlock(BLUE_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        GREEN_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("green_high_quality_concrete_powder", () -> new ConcretePowderBlock(GREEN_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        CYAN_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("cyan_high_quality_concrete_powder", () -> new ConcretePowderBlock(CYAN_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        DARK_RED_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("dark_red_high_quality_concrete_powder", () -> new ConcretePowderBlock(DARK_RED_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        PURPLE_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("purple_high_quality_concrete_powder", () -> new ConcretePowderBlock(PURPLE_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        ORANGE_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("orange_high_quality_concrete_powder", () -> new ConcretePowderBlock(ORANGE_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        LIGHT_GRAY_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("light_gray_high_quality_concrete_powder", () -> new ConcretePowderBlock(LIGHT_GRAY_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        GRAY_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("gray_high_quality_concrete_powder", () -> new ConcretePowderBlock(GRAY_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        LIGHT_BLUE_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("light_blue_high_quality_concrete_powder", () -> new ConcretePowderBlock(LIGHT_BLUE_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        LIME_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("lime_high_quality_concrete_powder", () -> new ConcretePowderBlock(LIME_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        RED_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("red_high_quality_concrete_powder", () -> new ConcretePowderBlock(RED_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        MAGENTA_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("magenta_high_quality_concrete_powder", () -> new ConcretePowderBlock(MAGENTA_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        YELLOW_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("yellow_high_quality_concrete_powder", () -> new ConcretePowderBlock(YELLOW_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        WHITE_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("white_high_quality_concrete_powder", () -> new ConcretePowderBlock(WHITE_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        BROWN_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("brown_high_quality_concrete_powder", () -> new ConcretePowderBlock(BROWN_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
        PINK_HIGH_QUALITY_CONCRETE_POWDER = BUILDING_BLOCKS.register("pink_high_quality_concrete_powder", () -> new ConcretePowderBlock(PINK_HIGH_QUALITY_CONCRETE.getBlock(), BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.SNARE).strength(1.8F).sound(SoundType.SAND)));
    }

    //public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityAdsorptionTypeSeawaterMetalExtractor,MSMachine<TileEntityAdsorptionTypeSeawaterMetalExtractor>>,ItemBlockMachine> ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR = BLOCKS.register("adsorption_type_seawater_metal_extractor",() -> new BlockTile.BlockTileModel<>(MSBlockTypes.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())),ItemBlockMachine::new);
    //public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityOrganicLiquidExtractor, MSMachine<TileEntityOrganicLiquidExtractor>>, ItemBlockMachine> ORGANIC_LIQUID_EXTRACTOR = BLOCKS.register("organic_liquid_extractor", () -> new BlockTile.BlockTileModel<>(MSBlockTypes.ORGANIC_LIQUID_EXTRACTOR, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), ItemBlockMachine::new);
    //public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntitySeawaterPump, MSMachine<TileEntitySeawaterPump>>, ItemBlockMachine> SEAWATER_PUMP = BLOCKS.register("seawater_pump", () -> new BlockTile.BlockTileModel<>(MSBlockTypes.SEAWATER_PUMP, properties -> properties.mapColor(BlockResourceInfo.STEEL.getMapColor())), ItemBlockMachine::new);

    private MSBlocks(){
    }
}
