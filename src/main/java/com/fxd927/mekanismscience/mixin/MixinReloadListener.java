package com.fxd927.mekanismscience.mixin;

import com.fxd927.mekanismscience.common.recipe.MSRecipeType;
import mekanism.common.ReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ReloadListener.class, remap = false)
public class MixinReloadListener {
    @Inject(method = "onResourceManagerReload", at = @At("TAIL"))
    public void onResourceManagerReload(ResourceManager resourceManager, CallbackInfo ci) {
        MSRecipeType.clearCache();
    }
}
