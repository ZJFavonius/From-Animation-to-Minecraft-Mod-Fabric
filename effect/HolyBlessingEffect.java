package mxa.modid.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class HolyBlessingEffect extends StatusEffect {
    public HolyBlessingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(PlayerEntity player, int amplifier) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 500, 5, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 500, 5, false, false));

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}