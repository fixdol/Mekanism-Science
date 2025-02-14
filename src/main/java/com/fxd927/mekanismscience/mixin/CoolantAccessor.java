package com.fxd927.mekanismscience.mixin;

import mekanism.api.chemical.attribute.ChemicalAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ChemicalAttributes.Coolant.class, remap = false)
public interface CoolantAccessor {
    @Mutable
    @Accessor
    void setConductivity(double conductivity);
}
