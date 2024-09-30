package com.fxd927.mekanismscience.common;

import com.fxd927.mekanismscience.common.advancements.MSAdvancements;
import com.fxd927.mekanismscience.common.config.MSConfig;
import com.fxd927.mekanismscience.common.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismScience.MODID)
public class MekanismScience
{
    public static final String MODID = "mekanismscience";

    public MekanismScience()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MSConfig.registerConfigs(ModLoadingContext.get());
        MSCreativeTabs.CREATIVE_TABS.register(modEventBus);
        MSBlocks.BLOCKS.register(modEventBus);
        MSContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MSEffects.MOB_EFFECTS.register(modEventBus);
        MSFluids.FLUIDS.register(modEventBus);
        MSGases.GASES.register(modEventBus);
        MSItems.ITEMS.register(modEventBus);
        MSTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation rl(String path){
        return new ResourceLocation(MekanismScience.MODID,path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
