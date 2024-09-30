package com.fxd927.mekanismscience.common.mixin;

import mekanism.api.chemical.gas.attribute.GasAttributes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = GasAttributes.Coolant.class, remap = false)
public interface CoolantAccessor {
    @Mutable // 元のフィールドがfinalの場合に使用すると無視して書き換えられるようになる
    @Accessor
    void setConductivity(double conductivity);
}