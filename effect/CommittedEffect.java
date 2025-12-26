package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;

public class CommittedEffect extends StatusEffect {
    public CommittedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 10, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 3, false, false));

        }

        else if (entity instanceof HostileEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));

            float newHealth = entity.getHealth() - 5.0F;

            if (newHealth <= 0.0F) {
                entity.kill();
            } else {
                entity.setHealth(newHealth);
            }
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}