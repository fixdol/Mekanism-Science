package com.fxd927.mekanismscience.common;


import com.fxd927.mekanismscience.common.config.MSConfig;
import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import com.fxd927.mekanismscience.common.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(MekanismScience.MODID)
public class MekanismScience
{
    public static final String MODID = "mekanismscience";

    public MekanismScience(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        MSConfig.registerConfigs(modContainer);
        MSCreativeTab.CREATIVE_TABS.register(modEventBus);
        MSFluids.FLUIDS.register(modEventBus);
        MSChemicals.CHEMICALS.register(modEventBus);
        MSItems.ITEMS.register(modEventBus);
        MSItems.BUILDING_ITEMS.register(modEventBus);
        MSBlocks.BLOCKS.register(modEventBus);
        MSBlocks.BUILDING_BLOCKS.register(modEventBus);
        MSContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MSTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        MSEffects.MOB_EFFECTS.register(modEventBus);
        MSRecipeType.RECIPE_TYPES.register(modEventBus);
        MSRecipeSerializersInternal.RECIPE_SERIALIZERS.register(modEventBus);
        MSSounds.SOUND_EVENTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation rl(String path){
        return ResourceLocation.fromNamespaceAndPath(MekanismScience.MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
