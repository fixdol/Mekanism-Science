package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MSLang;
import com.fxd927.mekanismscience.common.MekanismScience;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import mekanism.common.registration.impl.CreativeTabRegistryObject;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismCreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

public class MSCreativeTab {
    public static final CreativeTabDeferredRegister CREATIVE_TABS = new CreativeTabDeferredRegister(MekanismScience.MODID);

    public static final CreativeTabRegistryObject MEKANISM_SCIENCE = CREATIVE_TABS.registerMain(MSLang.MEKANISM_SCIENCE, MSItems.NEUTRON_SOURCE_PELLET, builder ->
              builder.withBackgroundLocation(MekanismScience.rl("textures/gui/creative_tab.png"))
                      .withSearchBar(70)
                      .withTabsBefore(MekanismCreativeTabs.MEKANISM.key())
                      .displayItems((displayParameters, output) -> {
                          CreativeTabDeferredRegister.addToDisplay(MSItems.ITEMS, output);
                          CreativeTabDeferredRegister.addToDisplay(MSBlocks.BLOCKS, output);
                          CreativeTabDeferredRegister.addToDisplay(MSFluids.FLUIDS, output);
                    })
    );
}
