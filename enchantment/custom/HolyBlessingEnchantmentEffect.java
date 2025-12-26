package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import mxa.modid.effect.ModEffects;
import mxa.modid.item.custom.target;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record HolyBlessingEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<HolyBlessingEnchantmentEffect> CODEC = MapCodec.unit(HolyBlessingEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 0, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 0, true, true, true));
            }
        }

        if (level == 2) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 1, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 1, true, true, true));
            }
        }

        if (level == 3) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 2, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 2, true, true, true));
            }
        }

        if (level == 4) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 3, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 3, true, true, true));
            }
        }

        if (level == 5) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 4, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 4, true, true, true));
            }
        }

        if (level == 6) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 5, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 5, true, true, true));
            }
        }

        if (level == 7) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 6, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 6, true, true, true));
            }
        }

        if (level == 8) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 7, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 7, true, true, true));
            }
        }

        if (level == 9) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 8, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 8, true, true, true));
            }
        }

        if (level == 10) {
            if (user instanceof LivingEntity player) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 400, 9, true, true, true));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 9, true, true, true));
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}