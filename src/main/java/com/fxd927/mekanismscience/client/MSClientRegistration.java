package com.fxd927.mekanismscience.client;

import com.fxd927.mekanismscience.client.gui.machine.*;
import com.fxd927.mekanismscience.common.registries.MSContainerTypes;
import com.fxd927.mekanismscience.common.registries.MSFluids;
import mekanism.api.gear.IModuleHelper;
import mekanism.client.ClientRegistration;
import mekanism.client.ClientRegistrationUtil;
import mekanism.client.model.baked.ExtensionBakedModel;
import mekanism.client.render.RenderPropertiesProvider;
import mekanism.client.render.lib.QuadTransformation;
import mekanism.generators.client.render.item.RenderWindGeneratorItem;
import mekanism.generators.common.MekanismGenerators;
import mekanism.generators.common.registries.GeneratorsBlocks;
import mekanism.generators.common.registries.GeneratorsFluids;
import mekanism.generators.common.registries.GeneratorsModules;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(
        modid = "mekanismscience",
        value = {Dist.CLIENT},
        bus = EventBusSubscriber.Bus.MOD
)
public class MSClientRegistration {

    private MSClientRegistration() {
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            for (Holder<Fluid> fluid : MSFluids.FLUIDS.getFluidEntries()) {
                ItemBlockRenderTypes.setRenderLayer(fluid.value(), RenderType.translucent());
            }
        });
}

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        // ClientRegistrationUtil.registerScreen(event, MSContainerTypes.RADIATION_IRRADIATOR, GuiRadiationIrradiator::new);
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        ClientRegistrationUtil.registerBucketColorHandler(event, MSFluids.FLUIDS);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
       ClientRegistrationUtil.registerFluidExtensions(event, MSFluids.FLUIDS);
    }
}
