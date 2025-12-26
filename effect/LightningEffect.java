package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class LightningEffect extends StatusEffect {
    public LightningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 3, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 500, 5, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}