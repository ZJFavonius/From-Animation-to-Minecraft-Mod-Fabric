package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import mxa.modid.effect.ModEffects;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.UUID;

public record EnergyEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<EnergyEnchantmentEffect> CODEC = MapCodec.unit(EnergyEnchantmentEffect::new);

    private static final HashMap<UUID, Integer> wieldingTime = new HashMap<>();
    private static final int BOOST_DURATION = 600; // 30 seconds in ticks

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            if (user instanceof LivingEntity player) {
                UUID userId = user.getUuid();
                int timeHeld = wieldingTime.getOrDefault(userId, 0) + 1;
                wieldingTime.put(userId, timeHeld);

                if (timeHeld < BOOST_DURATION) {
                    // First 30 seconds - Energy Boost
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGY_EFFECT, 40, 0, true, true));
                } else {
                    // After 30 seconds - Exhaustion
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0, true, false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, 0, true, false));
                }
            }
        }

        if (level == 2) {
        if (user instanceof LivingEntity player) {
            UUID userId = user.getUuid();
            int timeHeld = wieldingTime.getOrDefault(userId, 0) + 1;
            wieldingTime.put(userId, timeHeld);

            if (timeHeld < BOOST_DURATION) {
                // First 30 seconds - Energy Boost
                player.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGY_EFFECT, 40, level - 1, true, true));
            } else {
                // After 30 seconds - Exhaustion
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, level - 1, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, level - 1, true, false));
            }
        }
    }
        if (level == 3) {
        if (user instanceof LivingEntity player) {
            UUID userId = user.getUuid();
            int timeHeld = wieldingTime.getOrDefault(userId, 0) + 1;
            wieldingTime.put(userId, timeHeld);

            if (timeHeld < BOOST_DURATION) {
                // First 30 seconds - Energy Boost
                player.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGY_EFFECT, 40, level - 2, true, true));
            } else {
                // After 30 seconds - Exhaustion
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, level - 2, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, level - 2, true, false));
            }
        }
    }

        if (level == 4) {
        if (user instanceof LivingEntity player) {
            UUID userId = user.getUuid();
            int timeHeld = wieldingTime.getOrDefault(userId, 0) + 1;
            wieldingTime.put(userId, timeHeld);

            if (timeHeld < BOOST_DURATION) {
                // First 30 seconds - Energy Boost
                player.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGY_EFFECT, 40, level - 3, true, true));
            } else {
                // After 30 seconds - Exhaustion
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, level - 3, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, level - 3, true, false));
            }
        }
    }
}
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}