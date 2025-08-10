package dev.wp.craftoria_core.mixin.xycraft;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.datafixers.util.Either;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tv.soaryn.xycraft.machines.client.EnergyTooltipHelper;

import java.util.ArrayList;

@Mixin(EnergyTooltipHelper.class)
public class EnergyTooltipHelperMixin {
    @Inject(
            method = "renderTooltip",
            at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V"),
            cancellable = true)
    private static void renderTooltip(RenderTooltipEvent.GatherComponents event, CallbackInfo ci, @Local ArrayList<Either<FormattedText, TooltipComponent>> elements) {
        if (elements.isEmpty()) ci.cancel();
    }
}
