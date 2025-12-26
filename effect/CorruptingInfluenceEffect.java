package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class CorruptingInfluenceEffect extends StatusEffect {
    public CorruptingInfluenceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity && !entity.getWorld().isClient) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 3, false, false));
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}