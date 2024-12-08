package com.fxd927.mekanismscience.common.registries;

import com.fxd927.mekanismscience.common.MekanismScience;
import mekanism.common.registration.impl.SoundEventDeferredRegister;
import mekanism.common.registration.impl.SoundEventRegistryObject;
import net.minecraft.sounds.SoundEvent;

public class MSSounds {
    public static final SoundEventDeferredRegister SOUND_EVENTS = new SoundEventDeferredRegister(MekanismScience.MODID);

    public static final SoundEventRegistryObject<SoundEvent> AIR_COMPRESSOR = SOUND_EVENTS.register("tile.machine.air_compressor");

    private MSSounds(){
    }
}
