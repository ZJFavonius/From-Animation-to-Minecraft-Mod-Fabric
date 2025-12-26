package mxa.modid.enchantment;

import com.mojang.serialization.MapCodec;
import mxa.modid.MinecraftXAnimation;
import mxa.modid.enchantment.custom.*;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> SHARPNESS =
            registerEntityEffect("sharpness", SharpnessEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> SMITE =
            registerEntityEffect("smite", SmiteEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> KNOCKBACK =
            registerEntityEffect("knockback", KnockbackEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> UNBREAKING =
            registerEntityEffect("unbreaking", UnbreakingEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> MENDING =
            registerEntityEffect("mending", MendingEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> ENERGY =
            registerEntityEffect("energy", EnergyEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> HEAVY_ATTACK =
            registerEntityEffect("heavy_attack", HeavyAttackEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> ARROW_DEFLECTION =
            registerEntityEffect("arrow_deflection", ArrowDeflectionEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> PROTECTION =
            registerEntityEffect("protection", ProtectionEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> QUICK_DRAW =
            registerEntityEffect("quickdraw", QuickDrawEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> POSSESSION =
            registerEntityEffect("possession", PossessionEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> HOLY_BLESSING =
            registerEntityEffect("holy_blessing", HolyBlessingEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> EXPERIENCE_3230 =
            registerEntityEffect("experience_3230", Experience3230EnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> LEARNING_547 =
            registerEntityEffect("learning_547", Learning547EnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> UNKNOWN =
            registerEntityEffect("unknown", UnknownEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> ERROR_785A =
            registerEntityEffect("error_785a", Error785AEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> POISON_CLOUD =
            registerEntityEffect("poison_cloud", PoisonCloudEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CRITICAL_HIT =
                registerEntityEffect("critical_hit", CriticalHitEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> SHARPNESS_ =
                registerEntityEffect("sharpness_", Sharpness_EnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> SMITING =
                    registerEntityEffect("smiting", SmitingEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> COMMITTED =
                        registerEntityEffect("committed", CommittedEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> EXPLODING =
                        registerEntityEffect("exploding", ExplodingEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MinecraftXAnimation.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        MinecraftXAnimation.LOGGER.info("Registering Mod Enchantment Effects for " + MinecraftXAnimation.MOD_ID);
    }
}