package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class HerobrineLightningEffect extends StatusEffect {
    public HerobrineLightningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 9, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 9, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}