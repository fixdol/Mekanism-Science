package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MSLang;
import com.fxd927.mekanismscience.common.MekanismScience;
import mekanism.common.MekanismLang;
import mekanism.common.registration.MekanismDeferredHolder;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismCreativeTabs;
import net.minecraft.world.item.CreativeModeTab;

public class MSCreativeTab {
    public static final CreativeTabDeferredRegister CREATIVE_TABS = new CreativeTabDeferredRegister(MekanismScience.MODID);

    public static final MekanismDeferredHolder<CreativeModeTab, CreativeModeTab> MEKANISM = CREATIVE_TABS.registerMain(MSLang.MEKANISM_SCIENCE, MSItems.NEUTRON_SOURCE_PELLET, builder ->
            builder.backgroundTexture(MekanismScience.rl("textures/gui/creative_tab.png"))
                    .withSearchBar(70)
                    .withTabsBefore(MekanismCreativeTabs.MEKANISM.getKey())
                    .displayItems((displayParameters, output) -> {
                        CreativeTabDeferredRegister.addToDisplay(MSItems.ITEMS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSBlocks.BLOCKS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSFluids.FLUIDS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSItems.BUILDING_ITEMS, output);
                        CreativeTabDeferredRegister.addToDisplay(MSBlocks.BUILDING_BLOCKS, output);
                    })
    );
}
