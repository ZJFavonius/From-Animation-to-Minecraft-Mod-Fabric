package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class ProtectionEffect extends StatusEffect {
    public ProtectionEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 400, 0, true, true, true));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}