package dev.wp.craftoria_core.mixin.modpatches.justdirethings;


import com.direwolf20.justdirethings.client.entityrenders.CreatureCatcherEntityRender;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreatureCatcherEntityRender.class)
public class PreventMobRenderReentrance {
    @Unique
    private static final ThreadLocal<Boolean> renderingMobInCatcher = ThreadLocal.withInitial(() -> false);

    @WrapOperation(method="render(Lcom/direwolf20/justdirethings/common/entities/CreatureCatcherEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/EntityRenderer;render(Lnet/minecraft/world/entity/Entity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"))
    private void shouldRenderInnerEntity$alreadyRenderingCheck(EntityRenderer renderer, Entity mob, float yBodyRot, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Operation<Void> original) {
        if (renderer != null && ! renderingMobInCatcher.get()) {
            renderingMobInCatcher.set(true);
            try {
                original.call(renderer, mob, yBodyRot, partialTick, poseStack, bufferSource, packedLight);
            } catch (Exception ignored) { }
            renderingMobInCatcher.set(false);
        }
    }
}
