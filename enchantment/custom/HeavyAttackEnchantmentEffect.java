package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import mxa.modid.item.custom.target;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record HeavyAttackEnchantmentEffect () implements EnchantmentEntityEffect {
    public static final MapCodec<HeavyAttackEnchantmentEffect> CODEC = MapCodec.unit(HeavyAttackEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 0, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 0, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 0, true, true, true));
            }
        }

        if (level == 2) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 1, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 1, true, true, true));
            }
        }

        if (level == 3) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 2, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 2, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 2, true, true, true));
            }
        }

        if (level == 4) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 3, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 3, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 3, true, true, true));
            }
        }

        if (level == 5) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 4, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 4, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 4, true, true, true));
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
