package mxa.modid.item;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MINECRAFT_DUNGEONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "minecraft_dungeons_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MCD))
                    .displayName(Text.translatable("itemgroup.minecraft_dungeons_logo"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.MCD);

                            entries.add(ModItems.BATTLESTAFF);
                            entries.add(ModItems.BATTLESTAFF_TERROR);
                            entries.add(ModItems.GROWING_STAFF);

                            entries.add(ModItems.GLAIVE);
                            entries.add(ModItems.GRAVE_GLAIVE);
                            entries.add(ModItems.VENOM_GLAIVE);

                            entries.add(ModItems.SWORD);

                            entries.add(ModItems.DIAMOND_SWORD);

                            entries.add(ModItems.BAMBOO);

                            entries.add(ModItems.BEE_NEST);
                            entries.add(ModItems.BEE);
                            entries.add(ModItems.NEST);

                            entries.add(ModItems.PUMPKIN_GHOST);
                            entries.add(ModItems.PG);
                            entries.add(ModItems.GHOST);
                            entries.add(ModItems.PGHOST);
                            entries.add(ModItems.POST);

                            entries.add(ModItems.SANTA_CLAUSE);
                            entries.add(ModItems.SANTA_HAT);
                            entries.add(ModItems.SANTA_JACKET);
                            entries.add(ModItems.SANTA_PANTS);
                            entries.add(ModItems.SANTA_BOOTS);

                            entries.add(ModItems.EASTER_BUNNY);
                            entries.add(ModItems.EASTER_HEAD);
                            entries.add(ModItems.EASTER_COSTUME);
                            entries.add(ModItems.EASTER_PANTS);
                            entries.add(ModItems.EASTER_FEET);

                            entries.add(ModItems.EASTER_BUN);
                            entries.add(ModItems.EASTER_BUN_HEAD);
                            entries.add(ModItems.EASTER_BUN_COSTUME);
                            entries.add(ModItems.EASTER_BUN_PANTS);
                            entries.add(ModItems.EASTER_BUN_FEET);

                        }).build());

    public static final ItemGroup THE_ANNOYING_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "annoying_villagers_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AV))
                    .displayName(Text.translatable("itemgroup.annoying_villagers_logo"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.AV);

                            entries.add(ModItems.ENDER_SLAYER_SCYTHE);
                            entries.add(ModItems.DEMONIAC_VOLTAGE_REAVER);
                            entries.add(ModItems.DEMONIAC_VOLTAGE_REAVER1);
                            entries.add(ModItems.ENDER_GLAIVE);
                            entries.add(ModItems.ENDER_AEGIS_SHIELD);
                            entries.add(ModItems.ENDER_AEGIS_SHIELDFB);
                            entries.add(ModItems.OBSIDIAN_SLEDGEHAMMER);
                            entries.add(ModItems.ARCANE_OBSIDIAN_FIST);
                            entries.add(ModItems.ARCANE_OBSIDIAN_SHIELD);

                            entries.add(ModItems.REGULAR_RED_STEEL_AXE);
                            entries.add(ModItems.RED_STEEL_SPEAR_AXE);
                            entries.add(ModItems.RED_STEEL_AXE);

                            entries.add(ModItems.RUBY_SWORD);
                            entries.add(ModItems.RUBY_KNIGHTSWORD);
                            entries.add(ModItems.RUBY_LONGSWORD);
                            entries.add(ModItems.RUBY_GREATSWORD);

                            entries.add(ModItems.DARKNESS_SWORD);
                            entries.add(ModItems.LEGENDARY_SWORD);

                            entries.add(ModItems.HOLY_LLAMA_HAMMER);
                            entries.add(ModItems.HOLY_LLAMA_HAMMER1);

                            entries.add(ModItems.DINNERBONE_HAT);
                            entries.add(ModItems.ENCHANTED_POTATO);
                            entries.add(ModItems.ENCHANTER_S_SHOVEL);
                            entries.add(ModItems.FIRE_STAFF);
                            entries.add(ModItems.GOLEM_TOTEM);
                            entries.add(ModItems.HOOK_GUN);

                            entries.add(ModItems.SWORD_PROJECTILE);
                            entries.add(ModItems.PICKAXE_PROJECTILE);

                            entries.add(ModItems.SWORDSMAN_HEROBRINE_KATANA);
                            entries.add(ModItems.SWORDSMAN_HEROBRINE_HOOD);
                            entries.add(ModItems.SWORDSMAN_HEROBRINE_SPAWN_EGG);
                            entries.add(ModItems.SWORDSMAN_HEROBRINE_TOTEM);

                            entries.add(ModItems.RUBY);
                            entries.add(ModItems.RUBY1);
                            entries.add(ModItems.RED_STEEL);
                            entries.add(ModItems.BLACK_JEWEL);

                            entries.add(ModBlocks.RUBY_BLOCK);
                            entries.add(ModBlocks.RUBY_BLOCK1);
                            entries.add(ModBlocks.RED_STEEL_BLOCK);
                            entries.add(ModBlocks.BLACK_BLOCK);
                            entries.add(ModBlocks.ARCANE_OBSIDIAN);

                            entries.add(ModBlocks.RUBY_ORE);
                            entries.add(ModBlocks.RUBY_ORE1);
                            entries.add(ModBlocks.RED_STEEL_ORE);
                            entries.add(ModBlocks.BLACK_ORE);
    }).build());

    public static final ItemGroup ANIMATION_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "animation_logo"),
            FabricItemGroup.builder() .icon(() -> new ItemStack(ModItems.AL))
                    .displayName(Text.translatable("itemgroup.animation_life_logo"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.AL);

                        entries.add(ModItems.LIGHTNING_SWORD);
                        entries.add(ModItems.SCYTHE);

                        entries.add(ModItems.IRON_DAGGER);

                        entries.add(ModItems.IRON_BLADE);
                        entries.add(ModItems.IRON_BLADE1);

                        entries.add(ModItems.FISH);

                        entries.add(ModItems.ANGEL_OF_DEATH_WINGS);

                        entries.add(ModItems.DARK_FEATHER);

                        entries.add(ModItems.DARK_GEM);

                        entries.add(ModBlocks.DARK_BLOCK);

                        entries.add(ModBlocks.DARK_ORE);
    }).build());

    public static final ItemGroup TECHNOBLADE_LIVES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "technoblade_crown_mask"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TECHNOBLADE_CROWN_MASK))
                    .displayName(Text.translatable("itemgroup.technoblade_crown_mask"))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.TECHNOBLADE_DIAMOND_SWORD);
                    entries.add(ModItems.TECHNOBLADE_NETHERITE_SWORD);

                    entries.add(ModItems.TECHNOBLADE_NETHERITE_AXE);
                    entries.add(ModItems.TECHNOBLADE_NETHERITE_AXE1);

                    entries.add(ModItems.TECHNOBLADE_CROWN);
                    entries.add(ModItems.TECHNOBLADE_CROWN1);

                    entries.add(ModItems.TECHNOBLADE_ROBE);
                    entries.add(ModItems.TECHNOBLADE_ROBE1);

                    entries.add(ModItems.TECHNOBLADE_CROWN_MASK);

                    entries.add(ModItems.DREAM_MASK);

                    entries.add(ModItems.GOLDEN_CRYSTAL);
                    entries.add(ModItems.GOLDEN_NUTS);
                    entries.add(ModItems.GOLDEN_DUST);
                    entries.add(ModItems.WHITE_GEM);

                    entries.add(ModBlocks.GOLDEN_BLOCK);
                    entries.add(ModBlocks.WHITE_BLOCK);

                    entries.add(ModBlocks.GOLDEN_ORE);
                    entries.add(ModBlocks.WHITE_ORE);
    }).build());

    public static final ItemGroup HEROBRINE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "shadow_reaper_blade"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SHADOW_REAPER_BLADE))
                    .displayName(Text.translatable("itemgroup.shadow_reaper_blade"))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.CURSED);
                    entries.add(ModItems.RAW_CURSED);
                    entries.add(ModItems.SHADOW_REAPER_BLADE);
                    entries.add(ModBlocks.TAINTED_AMETHYST_BLOCK);
                    entries.add(ModBlocks.RAW_TAINTED_AMETHYST);
                    entries.add(ModBlocks.CURSED_AMETHYST_ORE);
                    entries.add(ModBlocks.TAINTED_AMETHYST_ORE);
                    entries.add(ModBlocks.NETHER_AMETHYST_ORE);
                    entries.add(ModBlocks.END_AMETHYST_ORE);

    }).build());

    public static final ItemGroup GARFIELD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "garfield_spawn_egg"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GARFIELD_SPAWN_EGG))
                    .displayName(Text.translatable("itemgroup.garfield_spawn_egg"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.GARFIELD_SPAWN_EGG);
                        entries.add(ModItems.GARFIELD_ORANGE_CAR);

                        entries.add(ModItems.LASAGNA);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                    }).build());

    public static final ItemGroup HOT_WHEELS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "hot_wheels_box"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.HOT_WHEELS_BOX))
                    .displayName(Text.translatable("itemgroup.hot_wheels_box"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.HOT_WHEELS_BOX);

                        entries.add(ModItems.HOT_WHEELS_BOX_MITSUBISHI);
                        entries.add(ModItems.HOT_WHEELS_MITSUBISHI);
                        entries.add(ModItems.MITSUBISHI);

                        entries.add(ModItems.HOT_WHEELS_BOX_R34);
                        entries.add(ModItems.HOT_WHEELS_R34);
                        entries.add(ModItems.R34);

                    }).build());

    public static final ItemGroup PIXELS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "tag_shades"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TAG_SHADES))
                    .displayName(Text.translatable("itemgroup.tag_shades"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.TAG_SHADES);

                    }).build());

    public static final ItemGroup ADVENTURE_TIME = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "diamonds_and_lemons"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DIAMONDS_AND_LEMONS))
                    .displayName(Text.translatable("itemgroup.diamonds_and_lemons"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.DIAMONDS_AND_LEMONS);

                        entries.add(ModBlocks.EMERALD_MINECRAFT_BLOCK);

                        entries.add(ModItems.ZOMBIE_CARROT);
                        entries.add(ModItems.LEMON_MINECRAFT);
                        entries.add(ModItems.APPLE_MINECRAFT);

                        entries.add(ModItems.STICK_MINECRAFT);
                        entries.add(ModItems.STRING_MINECRAFT);

                        entries.add(ModItems.ARROW_MINECRAFT);
                        entries.add(ModItems.BOW_MINECRAFT);

                        entries.add(ModItems.PICKAXE_MINECRAFT);
                        entries.add(ModItems.SWORD_MINECRAFT);
                        entries.add(ModItems.SHOVEL_MINECRAFT);

                        entries.add(ModItems.SCARLET_MINECRAFT_SWORD);
                        entries.add(ModItems.ROOT_MINECRAFT_SWORD);

                    }).build());

    public static final ItemGroup MC_X_MCDO = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "mc_fries"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MC_FRIES))
                    .displayName(Text.translatable("itemgroup.mc_fries"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.FRIES_HAT);
                        entries.add(ModItems.MCFRIES_HELMET);
                        entries.add(ModItems.MC_FRIES);

                    }).build());

    public static final ItemGroup TMNT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "tmnt_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TMNT))
                    .displayName(Text.translatable("itemgroup.tmnt_logo"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.TMNT);

                        entries.add(ModItems.ROKUSHAKUBO);
                        entries.add(ModItems.DAISHO);
                        entries.add(ModItems.NUNCHUCKS);
                        entries.add(ModItems.SAITACHI);

                    }).build());

    public static final ItemGroup RZRXM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "razer_x_minecraft"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RZRXMC))
                    .displayName(Text.translatable("itemgroup.razer_x_minecraft"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.RZRXMC);

                        entries.add(ModItems.RZRKB);
                        entries.add(ModItems.RZRKP);
                        entries.add(ModItems.RZRMS);
                        entries.add(ModItems.RZRMSP);

                    }).build());

public static final ItemGroup ONE_PIECE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MinecraftXAnimation.MOD_ID, "one_piece_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ONE_PIECE_LOGO))
                    .displayName(Text.translatable("itemgroup.one_piece_logo"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.ONE_PIECE_LOGO);

                        entries.add(ModItems.STRAW_HAT);
                        entries.add(ModItems.CAPTAIN_COAT);
                        entries.add(ModItems.CAPTAIN_SHORTS);

                        entries.add(ModItems.SPADE_HAT);

                        entries.add(ModItems.BOAT_HAT);

                        entries.add(ModItems.BANDANA);

                        entries.add(ModItems.BLACK_LEG_STYLE);

                        entries.add(ModItems.WADO_HANDLE);
                        entries.add(ModItems.WADO_GUARD);
                        entries.add(ModItems.WADO_BLADE);
                        entries.add(ModItems.WADO_ICHI);
                        entries.add(ModItems.WADO_ICHI_SAY);
                        entries.add(ModItems.WADO_ICHI_SCAB);

                        entries.add(ModItems.SANDAI_KITET_HANDLE);
                        entries.add(ModItems.SANDAI_KITET_GUARD);
                        entries.add(ModItems.SANDAI_KITET_BLADE);
                        entries.add(ModItems.SANDAI_KITET);
                        entries.add(ModItems.SANDAI_KITET_SAY);
                        entries.add(ModItems.SANDAI_KITET_SCAB);

                        entries.add(ModItems.SHUSUI);
                        entries.add(ModItems.SHUSUI_SAY);
                        entries.add(ModItems.SHUSUI_SCAB);

                        entries.add(ModItems.ENMA);
                        entries.add(ModItems.ENMA_SAY);
                        entries.add(ModItems.ENMA_SCAB);

                    }).build());

    public static void registerItemGroups() {
        MinecraftXAnimation.LOGGER.info("Registering Item Groups for" + MinecraftXAnimation.MOD_ID);
    }
}