package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

public class VoidStrikeEffect extends StatusEffect {
    public VoidStrikeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity && !entity.getWorld().isClient) {
            entity.damage(setBypassesArmor(), 2.0F + (float)amplifier);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 7, true, true));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 7, true, true));
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    private DamageSource setBypassesArmor() {
            return null;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
