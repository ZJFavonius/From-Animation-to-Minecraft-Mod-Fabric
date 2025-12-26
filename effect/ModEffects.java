package mxa.modid.effect;

import mxa.modid.MinecraftXAnimation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> VOID_STRIKE_EFFECT =
            registerStatusEffect("void_strike", (
                    new VoidStrikeEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "void_strike")
                            , -0.25, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> ENDER_RIFT_EFFECT =
            registerStatusEffect("ender_rift", (
                    new EnderRiftEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_ABSORPTION,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "ender_rift")
                            , 5.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> DARK_SHIELD_EFFECT =
            registerStatusEffect("dark_shield", (
                    new DarkShieldEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "dark_shield")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> CORRUPTING_INFLUENCE_EFFECT =
            registerStatusEffect("corrupting_influence", (
                    new CorruptingInfluenceEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "corrupting_influence")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> ENDER_MASTERY_EFFECT =
            registerStatusEffect("ender_mastery", (
                    new EnderMasteryEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "ender_mastery")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> ENERGY_EFFECT =
            registerStatusEffect("energy", (
                    new EnergyEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "energy"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> PROTECTION_EFFECT =
            registerStatusEffect("protection", (
                    new ProtectionEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "protection"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> HOLY_BLESSING_EFFECT =
            registerStatusEffect("holy_blessing", (
                    new HolyBlessingEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "holy_blessing"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> LEARNING_EFFECT =
            registerStatusEffect("learning", (
                    new LearningEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "learning"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> UNKNOWN_EFFECT =
            registerStatusEffect("unknown", (
                    new UnknownEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "unknown"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> POSSESSION_EFFECT =
            registerStatusEffect("possession", (
                    new PossessionEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "possession"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> FIRE_EFFECT =
            registerStatusEffect("fire_effect", (
                    new FireEffect(StatusEffectCategory.NEUTRAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_BURNING_TIME,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "fire_effect"), 2.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> ICE_EFFECT =
            registerStatusEffect("ice_effect", (
                    new IceEffect(StatusEffectCategory.NEUTRAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_ABSORPTION,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "ice_effect"), 10.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> LIGHTNING_EFFECT =
            registerStatusEffect("lightning_effect", (
                    new LightningEffect(StatusEffectCategory.NEUTRAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "lightning_effect"), 3.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> EARTH_EFFECT =
            registerStatusEffect("earth_effect", (
                    new EarthEffect(StatusEffectCategory.NEUTRAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "earth_effect"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> NOTCH_PROTECTION_EFFECT =
            registerStatusEffect("notch_protection", (
                    new NotchProtectionEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "notch_protection"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> SWORDSMAN_HEROBRINE_EFFECT =
            registerStatusEffect("swordsman_herobrine", (
                    new SwordsmanHerobrineEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "swordsman_herobrine"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> HEROBRINE_LIGHTNING_EFFECT =
            registerStatusEffect("herobrine_lightning", (
                    new HerobrineLightningEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "herobrine_lightning"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> WEREWOLFS_WRATH_EFFECT =
            registerStatusEffect("werewolfs_wrath", (
                    new WerewolfsWrathEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "werewolfs_wrath"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> DINNERBONE_ROLE =
            registerStatusEffect("dinnerbone_role", (
                    new DinnerboneLevitateEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "dinnerbone_role"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> DINNERBONE_PLAY =
            registerStatusEffect("dinnerbone_play", (
                    new DinnerboneRunEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "dinnerbone_play"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> TECHNOBLADE_AFTER_EFFECT =
            registerStatusEffect("techno_legacy", (
                    new TechnobladeAfterEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "techno_legacy"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> DREAM_SPEEDRUN =
            registerStatusEffect("dream_speedrun", (
                    new DreamSpeedRunEffect(StatusEffectCategory.BENEFICIAL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "dream_speedrun"), 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> POISON_CLOUD_EFFECT =
            registerStatusEffect("poison_cloud", (
                    new PoisonCloudEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "poison_cloud")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));
    public static final RegistryEntry<StatusEffect> CRITICAL_HIT_EFFECT =
            registerStatusEffect("critical_hit", (
                    new CriticalHitEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "critical_hit")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));
public static final RegistryEntry<StatusEffect> SHARPNESS_EFFECT =
            registerStatusEffect("sharpness_", (
                    new SharpnessEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "sharpness_")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));
public static final RegistryEntry<StatusEffect> SMITING_EFFECT =
            registerStatusEffect("smiting", (
                    new SmitingEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "smiting")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));

public static final RegistryEntry<StatusEffect> COMMITTED_EFFECT =
            registerStatusEffect("committed", (
                    new CommittedEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "committed")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));

public static final RegistryEntry<StatusEffect> EXPLODING_EFFECT =
            registerStatusEffect("exploding", (
                    new ExplodingEffect(StatusEffectCategory.HARMFUL, 0))
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(MinecraftXAnimation.MOD_ID, "exploding")
                            , 50.0, Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MinecraftXAnimation.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MinecraftXAnimation.LOGGER.info("Registering Mod Effects for " + MinecraftXAnimation.MOD_ID);
    }
}