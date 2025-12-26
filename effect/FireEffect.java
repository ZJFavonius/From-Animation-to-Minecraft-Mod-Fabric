package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class FireEffect extends StatusEffect {
    public FireEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 500, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 500, 5, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}