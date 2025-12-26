package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class UnknownEffect extends StatusEffect {
    public UnknownEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity target, int amplifier) {
        if (target instanceof LivingEntity) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 500, 5, false, false));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 5, false, false));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 500, 5, false, false));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 500, 5, false, false));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 500, 5, false, false));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 500, 5, false, false));
        }

        return super.applyUpdateEffect(target, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}