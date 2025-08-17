package dev.wp.craftoria_core.mixin.cataclysm_spellbooks;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedKoboldiator;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedKoboleton;
import net.minecraft.core.particles.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={SummonedKoboleton.class, SummonedKoboldiator.class})
public class SummonedKoboletonParticleFix {
    @WrapOperation(method="onUnSummon", at=@At(value="INVOKE", target="Lnet/neoforged/neoforge/registries/DeferredHolder;get()Ljava/lang/Object;"))
    private static Object FixSandstormParticleLookup(DeferredHolder<ParticleType<?>, SimpleParticleType> instance, Operation<Object> original) {
        if (instance == null || !(original.call(instance) instanceof ParticleOptions particleOptions)) return ParticleTypes.POOF;
        return particleOptions;
    }
}
