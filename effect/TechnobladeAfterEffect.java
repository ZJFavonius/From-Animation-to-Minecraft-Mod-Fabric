package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class TechnobladeAfterEffect extends StatusEffect {
    public TechnobladeAfterEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 7, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 7, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 7, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 7, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 7, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 7, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}