package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class WerewolfsWrathEffect extends StatusEffect {
    public WerewolfsWrathEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof PlayerEntity) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 5, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 5, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}