package com.fxd927.mekanismscience.client;

import com.fxd927.mekanismscience.client.gui.machine.GuiAdsorptionTypeSeawaterMetalExtractor;
import com.fxd927.mekanismscience.client.gui.machine.GuiOrganicLiquidExtractor;
import com.fxd927.mekanismscience.client.gui.machine.GuiSeawaterPump;
import com.fxd927.mekanismscience.common.MekanismScience;
import com.fxd927.mekanismscience.common.registries.MSContainerTypes;
import mekanism.client.ClientRegistrationUtil;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = MekanismScience.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MSClientRegistration {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registries.MENU, helper -> {
            ClientRegistrationUtil.registerScreen(MSContainerTypes.ADSORPTION_TYPE_SEAWATER_METAL_EXTRACTOR, GuiAdsorptionTypeSeawaterMetalExtractor::new);
            ClientRegistrationUtil.registerScreen(MSContainerTypes.ORGANIC_LIQUID_EXTRACTOR, GuiOrganicLiquidExtractor::new);
            ClientRegistrationUtil.registerScreen(MSContainerTypes.SEAWATER_PUMP, GuiSeawaterPump::new);
        });
    }

    private MSClientRegistration(){
    }
}
