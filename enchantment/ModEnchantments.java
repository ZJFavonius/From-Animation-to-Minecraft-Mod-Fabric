package mxa.modid.enchantment;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.enchantment.custom.*;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> ARROW_DEFLECTION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "arrow_deflection"));

    public static final RegistryKey<Enchantment> ENERGY =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "energy"));
    public static final RegistryKey<Enchantment> EXPERIENCE_3230 =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "experience_3230"));
    public static final RegistryKey<Enchantment> HEAVY_ATTACK =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "heavy_attack"));
    public static final RegistryKey<Enchantment> HOLY_BLESSING =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "holy_blessing"));
    public static final RegistryKey<Enchantment> LEARNING_547 =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "learning_547"));
    public static final RegistryKey<Enchantment> POSSESSION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "possession"));
    public static final RegistryKey<Enchantment> PROTECTION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "protection"));
    public static final RegistryKey<Enchantment> QUICKDRAW =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "quickdraw"));
    public static final RegistryKey<Enchantment> UNKNOWN =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "unknown"));
    public static final RegistryKey<Enchantment> ERROR_785A =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "error_785a"));

    public static final RegistryKey<Enchantment> POISON_CLOUD =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "poison_cloud"));
    public static final RegistryKey<Enchantment> CRITICAL_HIT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "critical_hit"));
    public static final RegistryKey<Enchantment> SHARPNESS_ =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "sharpness_"));
    public static final RegistryKey<Enchantment> SMITING =
                RegistryKey.of(RegistryKeys.ENCHANTMENT,
                        Identifier.of(MinecraftXAnimation.MOD_ID, "smiting"));
    public static final RegistryKey<Enchantment> COMMITTED =
                RegistryKey.of(RegistryKeys.ENCHANTMENT,
                        Identifier.of(MinecraftXAnimation.MOD_ID, "committed"));
    public static final RegistryKey<Enchantment> EXPLODING =
                RegistryKey.of(RegistryKeys.ENCHANTMENT,
                        Identifier.of(MinecraftXAnimation.MOD_ID, "exploding"));

    // Bootstrap Method to Register Enchantments
    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

    register(registerable, ARROW_DEFLECTION, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                5, 7,
                                Enchantment.leveledCost(4, 6),
                                Enchantment.leveledCost(12, 8),
                                2,
                                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new ArrowDeflectionEnchantmentEffect()));

        register(registerable, ENERGY, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5, 4,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new EnergyEnchantmentEffect()));

        register(registerable, EXPERIENCE_3230, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5, 3230,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new Experience3230EnchantmentEffect()));

        register(registerable, HEAVY_ATTACK, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        6, 5,
                        Enchantment.leveledCost(6, 8),
                        Enchantment.leveledCost(30, 10),
                        3, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new HeavyAttackEnchantmentEffect()));

        register(registerable, HOLY_BLESSING, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        4, 10,
                        Enchantment.leveledCost(4, 6),
                        Enchantment.leveledCost(20, 7),
                        1, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new HolyBlessingEnchantmentEffect()));

        register(registerable, LEARNING_547, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5, 547,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new Learning547EnchantmentEffect()));

        register(registerable, POSSESSION, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        6, 10,
                        Enchantment.leveledCost(6, 8),
                        Enchantment.leveledCost(30, 10),
                        3, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new PossessionEnchantmentEffect()));

        register(registerable, PROTECTION, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        4, 10,
                        Enchantment.leveledCost(4, 6),
                        Enchantment.leveledCost(20, 7),
                        1, AttributeModifierSlot.CHEST))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new ProtectionEnchantmentEffect()));

        register(registerable, QUICKDRAW, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        4, 10,
                        Enchantment.leveledCost(4, 6),
                        Enchantment.leveledCost(20, 7),
                        1, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new QuickDrawEnchantmentEffect()));

        register(registerable, POISON_CLOUD, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5, 3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new PoisonCloudEnchantmentEffect()));

        register(registerable, CRITICAL_HIT, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5, 3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2, AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new CriticalHitEnchantmentEffect()));

        register(registerable, SHARPNESS_, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                5, 7,
                                Enchantment.leveledCost(4, 6),
                                Enchantment.leveledCost(12, 8),
                                2,
                                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new Sharpness_EnchantmentEffect()));

        register(registerable, SMITING, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                5, 7,
                                Enchantment.leveledCost(4, 6),
                                Enchantment.leveledCost(12, 8),
                                2,
                                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new SmitingEnchantmentEffect()));

        register(registerable, COMMITTED, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                5, 7,
                                Enchantment.leveledCost(4, 6),
                                Enchantment.leveledCost(12, 8),
                                2,
                                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new CommittedEnchantmentEffect()));

        register(registerable, EXPLODING, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                5, 7,
                                Enchantment.leveledCost(4, 6),
                                Enchantment.leveledCost(12, 8),
                                2,
                                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new ExplodingEnchantmentEffect()));

    }
        // Helper method to register enchantments
        private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder){
            registry.register(key, builder.build(key.getValue()));
        }
    }