package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;

public class SmitingEffect extends StatusEffect {
    public SmitingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 10, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 3, false, false));

        }

        if (entity instanceof ZombieEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));
        }

        if (entity instanceof SkeletonEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));
        }

        if (entity instanceof WitherSkeletonEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));
        }

        else if (entity instanceof WardenEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
        }

        else if (entity instanceof PiglinBruteEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));
        }

        else if (entity instanceof WitherEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}