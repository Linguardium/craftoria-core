package dev.wp.craftoria_core.mixin.foregoing;

import com.buuz135.industrial.block.agriculturehusbandry.tile.MobCrusherTile;
import com.direwolf20.justdirethings.common.fluids.xpfluid.XPFluid;
import com.direwolf20.justdirethings.setup.Registration;
import com.hrznstudio.titanium.fluid.TitaniumFluidInstance;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MobCrusherTile.class)
public class MobCrusherTileMixin {
    @Redirect(
            method = "instantKill",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/hrznstudio/titanium/fluid/TitaniumFluidInstance;getSourceFluid()Lnet/neoforged/neoforge/registries/DeferredHolder;"
            ))
    private DeferredHolder<Fluid, XPFluid> redirectEssenceFluid(TitaniumFluidInstance instance) {
        return Registration.XP_FLUID_SOURCE;
    }
}
