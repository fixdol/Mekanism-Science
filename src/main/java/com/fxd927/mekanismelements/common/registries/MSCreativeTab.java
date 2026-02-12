package com.fxd927.mekanismelements.common.registries;

import com.fxd927.mekanismelements.common.MSLang;
import com.fxd927.mekanismelements.common.MekanismElements;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import mekanism.common.registration.MekanismDeferredHolder;
import mekanism.common.registries.MekanismCreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class MSCreativeTab {
    public static final CreativeTabDeferredRegister CREATIVE_TABS = new CreativeTabDeferredRegister(MekanismElements.MODID);

    public static final MekanismDeferredHolder<CreativeModeTab, CreativeModeTab> MEKANISM_ELEMENTS = CREATIVE_TABS.registerMain(
            MSLang.MEKANISM_ELEMENTS, 
            MSItems.NEUTRON_SOURCE_PELLET,
            builder -> builder.withSearchBar(65)
                    .withTabsBefore(ResourceKey.create(Registries.CREATIVE_MODE_TAB, MekanismCreativeTabs.MEKANISM.getId()))
                    .displayItems((displayParameters, output) -> {
                        CreativeTabDeferredRegister.addToDisplay(MSItems.ITEMS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSBlocks.BLOCKS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSFluids.FLUIDS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSItems.BUILDING_ITEMS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSBlocks.BUILDING_BLOCKS, output);
                    })
    );
}