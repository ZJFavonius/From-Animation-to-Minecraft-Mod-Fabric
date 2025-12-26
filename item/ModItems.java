package mxa.modid.item;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.block.ModBlocks;
import mxa.modid.entity.ModEntities;
import mxa.modid.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item CURSED = registerItem("amethyst", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item RAW_CURSED = registerItem("raw_cursed", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item RUBY = registerItem("ruby", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));
    public static final Item RUBY1 = registerItem("ruby1", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item RED_STEEL = registerItem("red_steel", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item DARK_FEATHER = registerItem("dark_feather", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));
    public static final Item DARK_GEM = registerItem("dark_gem", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item BLACK_JEWEL = registerItem("black_jewel", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item GOLDEN_CRYSTAL = registerItem("golden_crystal", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));
    public static final Item GOLDEN_NUTS = registerItem("golden_nuts", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));
    public static final Item GOLDEN_DUST = registerItem("golden_dust", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item WHITE_GEM = registerItem("white_gem", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item MCD = registerItem("minecraft_dungeons_logo", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item SWORD = registerItem("sword_steel", new SwordSteelItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(12000).attributeModifiers(SwordSteelItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -0.7f))));

    public static final Item DIAMOND_SWORD = registerItem("diamond_sword_mcd", new DiamondSwordItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(12000).attributeModifiers(DiamondSwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -0.7f))));

    public static final Item BATTLESTAFF = registerItem("battlestaff", new BattlestaffItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(11000).attributeModifiers(BattlestaffItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -0.9f)))); // 3.1 speed
    public static final Item BATTLESTAFF_TERROR = registerItem("battlestaff_of_terror", new BattlestaffTerrorItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(11000).attributeModifiers(BattlestaffTerrorItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -1.2f))));
    public static final Item GROWING_STAFF = registerItem("growing_staff", new GrowingStaffItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(11000).attributeModifiers(GrowingStaffItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -1.2f))));

    public static final Item GLAIVE = registerItem("glaive", new GlaiveItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(11000).attributeModifiers(GlaiveItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4f))));
    public static final Item GRAVE_GLAIVE = registerItem("grave_bane", new GraveBaneItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(12000).attributeModifiers(GraveBaneItem.createAttributeModifiers(ToolMaterials.NETHERITE,     3, -2.4f))));
    public static final Item VENOM_GLAIVE = registerItem("venom_glaive", new VenomGlaiveItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(12000).attributeModifiers(VenomGlaiveItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4f))));

    public static final Item BAMBOO = registerItem("bamboo_staff", new BambooSwordItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(12000).attributeModifiers(BambooSwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -0.7f))));

    public static final Item BEE_NEST = registerItem("bee_nest", new BeeNestItem(ModArmorMaterials.BEE_NEST, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item BEE = registerItem("bee", new BeeNestItem(ModArmorMaterials.BEE_NEST, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item NEST = registerItem("nest", new BeeNestItem(ModArmorMaterials.BEE_NEST, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item PUMPKIN_GHOST = registerItem("pumpkin_ghost", new PgItem(ModArmorMaterials.CARVED_PUMPKIN, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item PG = registerItem("pg", new PgItem(ModArmorMaterials.CARVED_PUMPKIN, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item GHOST = registerItem("ghost", new GhostItem(ModArmorMaterials.CARVED_PUMPKIN, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item PGHOST = registerItem("pghost", new PghostItem(ModArmorMaterials.CARVED_PUMPKIN, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item POST = registerItem("post", new PostItem(ModArmorMaterials.CARVED_PUMPKIN, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item SANTA_CLAUSE = registerItem("santa_clause", new SantaHatItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item SANTA_HAT = registerItem("santa_hat", new SantaHatItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item SANTA_JACKET = registerItem("santa_jacket", new SantaJacketItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item SANTA_PANTS = registerItem("santa_pants", new SantaPantsItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item SANTA_BOOTS = registerItem("santa_boots", new SantaBootsItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item EASTER_BUNNY = registerItem("easter_bunny", new EasterHeadItem(ModArmorMaterials.EGG, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_HEAD = registerItem("easter_head", new EasterHeadItem(ModArmorMaterials.EGG, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_COSTUME = registerItem("easter_costume", new EasterBodyItem(ModArmorMaterials.EGG, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_PANTS = registerItem("easter_pants", new EasterLegsItem(ModArmorMaterials.EGG, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_FEET = registerItem("easter_feet", new EasterFeetItem(ModArmorMaterials.EGG, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item EASTER_BUN = registerItem("easter_bun", new EasterBunHeadItem(ModArmorMaterials.DRAGON_EGG, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_BUN_HEAD = registerItem("easter_bun_head", new EasterBunHeadItem(ModArmorMaterials.DRAGON_EGG, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_BUN_COSTUME = registerItem("easter_bun_costume", new EasterBunBodyItem(ModArmorMaterials.DRAGON_EGG, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_BUN_PANTS = registerItem("easter_bun_pants", new EasterBunLegsItem(ModArmorMaterials.DRAGON_EGG, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item EASTER_BUN_FEET = registerItem("easter_bun_feet", new EasterBunFeetItem(ModArmorMaterials.DRAGON_EGG, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item AL = registerItem("animation_life_logo", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item LIGHTNING_SWORD = registerItem("lightning_sword", new LightningSwordItem(ToolMaterials.IRON, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(4000).attributeModifiers(LightningSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 11, -2.4F))));
    public static final Item SCYTHE = registerItem("scythe", new ScytheItem(ToolMaterials.IRON, new Item.Settings().fireproof().rarity(Rarity.EPIC).maxDamage(2000).attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.NETHERITE, 12, -2.4F))));
    public static final Item IRON_DAGGER = registerItem("iron_dagger", new IronDaggerItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(IronDaggerItem.createAttributeModifiers(ToolMaterials.IRON, 8, -2.4F))));
    public static final Item ANGEL_OF_DEATH_WINGS = registerItem("the_angel_of_death_wings", new AngelofDeathWingsItem(new Item.Settings().maxCount(1).fireproof().maxDamage(6666)));
    public static final Item IRON_BLADE = registerItem("iron_blade", new IronBladeItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(IronBladeItem.createAttributeModifiers(ToolMaterials.IRON, 7, -2.4F))));
    public static final Item IRON_BLADE1 = registerItem("iron_blade1", new IronBladeItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(IronBladeItem.createAttributeModifiers(ToolMaterials.IRON, 7, -2.4F))));
    public static final Item FISH = registerItem("fish", new FishSwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).attributeModifiers(FishSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 70, -2.4F))));

    public static final Item SHADOW_REAPER_BLADE = registerItem("shadow_reaper_blade", new ShadowreaperBladeItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(ShadowreaperBladeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 9, -2.4F))));

    public static final Item AV = registerItem("annoying_villagers_logo", new Item((new Item.Settings()).rarity(Rarity.EPIC).fireproof()));

    public static final Item ENDER_SLAYER_SCYTHE = registerItem("enderslayer_scythe", new EnderSlayerScytheItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(EnderSlayerScytheItem.createAttributeModifiers(ToolMaterials.NETHERITE, 9, -2.4F))));
    public static final Item DEMONIAC_VOLTAGE_REAVER = registerItem("demoniac_voltage_reaver", new DemoniacVoltageReaverItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).rarity(Rarity.EPIC).fireproof().attributeModifiers(DemoniacVoltageReaverItem.createAttributeModifiers(ToolMaterials.NETHERITE, 16, -2.4F))));
    public static final Item DEMONIAC_VOLTAGE_REAVER1 = registerItem("demoniac_voltage_reaver1", new DemoniacVoltageReaverItem1(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).rarity(Rarity.EPIC).fireproof().attributeModifiers(DemoniacVoltageReaverItem1.createAttributeModifiers(ToolMaterials.NETHERITE, 16, -2.4F))));
    public static final Item ENDER_AEGIS_SHIELD = registerItem("ender_aegis_shield", new EnderAegisShield((new Item.Settings()).rarity(Rarity.EPIC).maxDamage(9000)));
    public static final Item ENDER_AEGIS_SHIELDFB = registerItem("ender_aegis_shieldfb", new EnderAegisShieldFB((new Item.Settings()).rarity(Rarity.EPIC).maxDamage(9000)));
    public static final Item ENDER_GLAIVE = registerItem("ender_glaive", new EnderglaiveItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(EnderSlayerScytheItem.createAttributeModifiers(ToolMaterials.NETHERITE, 9, -2.4F))));
    public static final Item OBSIDIAN_SLEDGEHAMMER = registerItem("obsidian_sledgehammer", new ObsidianSledgehammerItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(ObsidianSledgehammerItem.createAttributeModifiers(ToolMaterials.NETHERITE, 12.0F, -2.4F))));
    public static final Item ARCANE_OBSIDIAN_FIST = registerItem("arcane_obsidian_fist", new ArcaneObsidianFistItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(ArcaneObsidianFistItem.createAttributeModifiers(ToolMaterials.NETHERITE, 8, -2.4F))));
    public static final Item ARCANE_OBSIDIAN_SHIELD = registerItem("arcane_obsidian_shield", new ArcaneObsidianShield((new Item.Settings()).rarity(Rarity.EPIC).maxDamage(9000)));

    public static final Item REGULAR_RED_STEEL_AXE = registerItem("regular_red_steel_axe", new RegularRedSteelAxeItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RegularRedSteelAxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 15.0F, -2.4F))));
    public static final Item RED_STEEL_SPEAR_AXE = registerItem("red_steel_spear_axe", new RedSteelSpearAxeItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().maxCount(1).attributeModifiers(RedSteelSpearAxeItem.createAttributeModifiers())));
    public static final Item RED_STEEL_AXE = registerItem("red_steel_axe", new RedSteelAxeItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RedSteelAxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 17.0F, -2.4F))));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new RubySwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RubySwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 16, -2.4F))));
    public static final Item RUBY_KNIGHTSWORD = registerItem("ruby_knightsword", new RubyKnightSwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RubyKnightSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 18, -2.4F))));
    public static final Item RUBY_LONGSWORD = registerItem("ruby_longsword", new RubyLongswordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RubyLongswordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 19, -2.4F))));
    public static final Item RUBY_GREATSWORD = registerItem("ruby_greatsword", new RubyGreatswordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(RubyGreatswordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 20, -2.4F))));

    public static final Item DARKNESS_SWORD = registerItem("darkness_sword", new DarknessSwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(DarknessSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 18, -2.4F))));

    public static final Item LEGENDARY_SWORD = registerItem("legendary_sword", new LegendarySwordItem(ToolMaterials.DIAMOND, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(LegendarySwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 16, -2.4F))));

    public static final Item SWORDSMAN_HEROBRINE_KATANA = registerItem("swordsman_herobrine_katana", new SwordsmanHerobrineKatanaItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(SwordsmanHerobrineKatanaItem.createAttributeModifiers(ToolMaterials.NETHERITE, 12, -2.4F))));

    public static final Item HOLY_LLAMA_HAMMER = registerItem("holy_llama_hammer", new HolyLlamaHammerItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(HolyLlamaHammerItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.4F))));
    public static final Item HOLY_LLAMA_HAMMER1 = registerItem("holy_llama_hammer1", new HolyLlamaHammerItem1(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(HolyLlamaHammerItem1.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.4F))));

    public static final Item DINNERBONE_HAT = registerItem("dinnerbone_hat", new DinnerboneHatItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(60000)));
    public static final Item ENCHANTED_POTATO = registerItem("enchanted_potato", new EnchantedPotatoItem((new Item.Settings()).rarity(Rarity.EPIC).fireproof().maxCount(64).food(ModFoodComponents.ENCHANTED_POTATO)));
    public static final Item ENCHANTER_S_SHOVEL = registerItem("enchanter_s_shovel", new EnchantersShovelItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(EnchantersShovelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 18.0F, -2.4F))));
    public static final Item FIRE_STAFF = registerItem("fire_staff", new FireStaffItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(FireStaffItem.createAttributeModifiers(ToolMaterials.NETHERITE, 15, -2.4F))));
    public static final Item GOLEM_TOTEM = registerItem("golem_totem", new GolemTotemItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.RARE).fireproof().attributeModifiers(GolemTotemItem.createAttributeModifiers(ToolMaterials.NETHERITE, 16, -2.4F))));
    public static final Item HOOK_GUN = registerItem("hook_gun", new HookGunItem((new Item.Settings()).rarity(Rarity.EPIC).fireproof().maxDamage(2900)));

    public static final Item SWORD_PROJECTILE = registerItem("sword_projectile", new SwordProjectileItem((new Item.Settings()).rarity(Rarity.EPIC).fireproof().maxCount(32)));
    public static final Item PICKAXE_PROJECTILE = registerItem("pickaxe_projectile", new PickaxeProjectileItem((new Item.Settings()).rarity(Rarity.EPIC).fireproof().maxCount(32)));

    public static final Item SWORDSMAN_HEROBRINE_HOOD = registerItem("swordsman_herobrine_hood", new SwordsmanHerobrineHoodItem(ModArmorMaterials.NETHERITE_INGOT, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item SWORDSMAN_HEROBRINE_SPAWN_EGG = registerItem("swordsman_herobrine_spawn_egg", new SpawnEggItem(ModEntities.SWORDSMAN_HEROBRINE, 9, 15, new Item.Settings()));
    public static final Item SWORDSMAN_HEROBRINE_TOTEM = registerItem("swordsman_herobrine_totem", new SpawnEggItem(ModEntities.SWORDSMAN_HEROBRINE, 9, 15, new Item.Settings()));

    public static final Item TECHNOBLADE_DIAMOND_SWORD = registerItem("technoblade_diamond_sword", new TechnobladeSwordItem(ToolMaterials.DIAMOND, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2100).attributeModifiers(TechnobladeSwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 12, -2.4F))));
    public static final Item TECHNOBLADE_NETHERITE_SWORD = registerItem("technoblade_netherite_sword", new TechnobladeSwordItem(ToolMaterials.DIAMOND, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2100).attributeModifiers(TechnobladeSwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 13, -2.4F))));

    public static final Item TECHNOBLADE_NETHERITE_AXE = registerItem("technoblade_netherite_axe", new TechnobladeAxeItem(ToolMaterials.DIAMOND, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2100).attributeModifiers(TechnobladeAxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 10, -2.4F))));
    public static final Item TECHNOBLADE_NETHERITE_AXE1 = registerItem("technoblade_netherite_axe1", new TechnobladeAxe1Item(ToolMaterials.DIAMOND, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2100).attributeModifiers(TechnobladeAxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 10, -2.4F))));

    public static final Item TECHNOBLADE_CROWN = registerItem("technoblade_crown", new TechnobladeCrownItem(ModArmorMaterials.GOLDEN_CRYSTAL, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof()));
    public static final Item TECHNOBLADE_CROWN1 = registerItem("technoblade_crown1", new TechnobladeCrownItem(ModArmorMaterials.GOLDEN_NUTS, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof()));
    public static final Item TECHNOBLADE_ROBE = registerItem("technoblade_robe", new TechnobladeRobeItem(ModArmorMaterials.GOLDEN_BLOCK, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof()));
    public static final Item TECHNOBLADE_ROBE1 = registerItem("technoblade_robe1", new TechnobladeRobeItem(ModArmorMaterials.GOLDEN_DUST, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof()));
    public static final Item TECHNOBLADE_CROWN_MASK = registerItem("technoblade_crown_mask", new TechnobladeCrownMaskItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(60000)));

    public static final Item DREAM_MASK = registerItem("dream_mask", new DreamMaskItem(ModArmorMaterials.WHITE_GEM, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(100)).rarity(Rarity.EPIC).fireproof()));

    public static final Item DIAMONDS_AND_LEMONS = registerItem("diamonds_and_lemons", new Item(new Item.Settings()));

    public static final Item ZOMBIE_CARROT = registerItem("zombie_carrot", new Item(new Item.Settings().food(ModFoodComponents.ZOMBIE_CARROT)));
    public static final Item LEMON_MINECRAFT = registerItem("lemon_minecraft", new Item(new Item.Settings().food(ModFoodComponents.LEMON_MINECRAFT)));
    public static final Item APPLE_MINECRAFT = registerItem("apple_minecraft", new Item(new Item.Settings().food(ModFoodComponents.APPLE_MINECRAFT)));

    public static final Item STICK_MINECRAFT = registerItem("stick_minecraft", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(64)));
    public static final Item STRING_MINECRAFT = registerItem("string_minecraft", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(64)));

    public static final Item BOW_MINECRAFT = registerItem("bow_minecraft", new BowItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(500)));
    public static final Item ARROW_MINECRAFT = registerItem("arrow_minecraft", new ArrowItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item PICKAXE_MINECRAFT = registerItem("pickaxe_minecraft", new PickaxeItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2100).attributeModifiers(SwordSteelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 9, -2.4F))));
    public static final Item SWORD_MINECRAFT = registerItem("sword_minecraft", new SwordSteelItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2500).attributeModifiers(SwordSteelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7, -2.4F))));
    public static final Item SHOVEL_MINECRAFT = registerItem("shovel_minecraft", new ShovelItem(ToolMaterials.IRON, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2300).attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -2.4F))));

    public static final Item SCARLET_MINECRAFT_SWORD = registerItem("scarlet_minecraft", new ScarletMinecraftSwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item ROOT_MINECRAFT_SWORD = registerItem("root_minecraft", new RootMinecraftSwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(2000).attributeModifiers(RootMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    public static final Item FRIES_HAT = registerItem("fries_hat", new ArmorItem(ModArmorMaterials.POTATO, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));
    public static final Item MCFRIES_HELMET = registerItem("the_mcfries_helmet", new TheFryHelmetItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item MC_FRIES = registerItem("mc_fries", new Item(new Item.Settings().food(ModFoodComponents.MC_FRIES)));

    public static final Item GARFIELD_SPAWN_EGG = registerItem("garfield_spawn_egg", new SpawnEggItem(ModEntities.GARFIELD, 9, 15, new Item.Settings()));
    public static final Item GARFIELD_ORANGE_CAR = registerItem("garfield_orange_car", new GarfieldCarItem(ModEntities.GARFIELD, 9, 15, new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item LASAGNA = registerItem("lasagna", new LasagnaFoodItem(new Item.Settings().food(ModFoodComponents.LASAGNA)));

    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));

    public static final Item HOT_WHEELS_BOX = registerItem("hot_wheels_box", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item HOT_WHEELS_BOX_MITSUBISHI = registerItem("hot_wheels_box_mitsubishi", new MitsubishiLancerEvolution9Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item HOT_WHEELS_MITSUBISHI = registerItem("hot_wheels_mitsubishi", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item MITSUBISHI = registerItem("mitsubishi_lancer", new MitsubishiLancerEvolution9Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item HOT_WHEELS_BOX_R34 = registerItem("hot_wheels_box_r34", new NissanR34GTRItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item HOT_WHEELS_R34 = registerItem("hot_wheels_r34", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item R34 = registerItem("nissan_r34_gtr", new NissanR34GTRItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item TAG_SHADES = registerItem("tag_shades", new ArmorItem(ModArmorMaterials.NETHERITE_BLOCK, ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(40000)));

    public static final Item TMNT = registerItem("tmnt_logo", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item ROKUSHAKUBO = registerItem("bo", new BoItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item DAISHO = registerItem("katana", new KatanaItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item NUNCHUCKS = registerItem("nunchaku", new NunchakuItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SAITACHI = registerItem("sai", new SaiItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    public static final Item RZRXMC = registerItem("razer_x_minecraft", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item RZRKB = registerItem("razer_blackwidow_v4_x_minecraft", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item RZRKP = registerItem("razer_minecraft_grass_block_keycap", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item RZRMS = registerItem("razer_cobra_minercaft_edition", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    public static final Item RZRMSP = registerItem("razer_gigantus_v2_m_minecraft_edition", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item ONE_PIECE_LOGO = registerItem("one_piece_logo", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(50000)));

    public static final Item STRAW_HAT = registerItem("straw_hat", new StrawHatItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(60000)));
    public static final Item CAPTAIN_COAT = registerItem("captain_coat", new CaptainCoatItem(ModArmorMaterials.WHEAT, ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(9000)));
    public static final Item CAPTAIN_SHORTS = registerItem("captain_shorts", new CaptainShortsItem(ModArmorMaterials.WHEAT, ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(5000)));

    public static final Item SPADE_HAT = registerItem("spade_pirates_hat", new SpadeHatItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(60000)));

    public static final Item BOAT_HAT = registerItem("boater_hat", new BoaterHatItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(60000)));

    public static final Item BANDANA = registerItem("zoro_bandana", new BandanaItem(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1).maxDamage(50000)));

    public static final Item BLACK_LEG_STYLE = registerItem("black_leg_style", new SanjiBlackLegItem(ModArmorMaterials.MAGMA_BLOCK, ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50)).rarity(Rarity.EPIC).fireproof().maxDamage(4000)));

    public static final Item WADO_HANDLE = registerItem("wado_handle", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item WADO_GUARD = registerItem("wado_guard", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item WADO_BLADE = registerItem("wado_blade", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item WADO_ICHI = registerItem("wado_ichimonji", new WadoIchimonjiItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item WADO_ICHI_SCAB = registerItem("wado_ichimonji_scabbard", new WadoIchimonjiScabbardItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item WADO_ICHI_SAY = registerItem("wado_ichimonji_saya", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    public static final Item SANDAI_KITET_HANDLE = registerItem("sandai_handle", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SANDAI_KITET_GUARD = registerItem("sandai_guard", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SANDAI_KITET_BLADE = registerItem("sandai_blade", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SANDAI_KITET = registerItem("sandai_kitetsu", new SandaiKitetsuItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SANDAI_KITET_SCAB = registerItem("sandai_kitetsu_scabbard", new SandaiKitetsuScabbardItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SANDAI_KITET_SAY = registerItem("sandai_kitetsu_saya", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    public static final Item SHUSUI = registerItem("shusui", new ShusuiItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SHUSUI_SCAB = registerItem("shusui_scabbard", new ShusuiScabbardItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item SHUSUI_SAY = registerItem("shusui_saya", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    public static final Item ENMA = registerItem("enma", new EnmaItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item ENMA_SCAB = registerItem("enma_scabbard", new EnmaScabbardItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));
    public static final Item ENMA_SAY = registerItem("enma_saya", new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(3000).attributeModifiers(ScarletMinecraftSwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 10, -2.4F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MinecraftXAnimation.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MinecraftXAnimation.LOGGER.info("Registering Mod Items for " + MinecraftXAnimation.MOD_ID);
    }
}