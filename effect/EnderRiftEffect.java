package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

public class EnderRiftEffect extends StatusEffect {
    public EnderRiftEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity player, int amplifier) {
        if (player instanceof ServerPlayerEntity && !player.getWorld().isClient) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 6, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 6, false, false));
        }

        return super.applyUpdateEffect(player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}