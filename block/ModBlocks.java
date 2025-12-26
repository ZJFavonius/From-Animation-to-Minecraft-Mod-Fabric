package mxa.modid.block;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.block.custom.TomatoCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block TAINTED_AMETHYST_BLOCK = registerBlock("tainted_amethyst_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_TAINTED_AMETHYST = registerBlock("raw_tainted_amethyst", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block RUBY_BLOCK1 = registerBlock("ruby_block1", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block RED_STEEL_BLOCK = registerBlock("red_steel_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block DARK_BLOCK = registerBlock("dark_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block ARCANE_OBSIDIAN = registerBlock("arcane_obsidian", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.BONE)));

    public static final Block BLACK_BLOCK = registerBlock("black_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block WHITE_BLOCK = registerBlock("white_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block GOLDEN_BLOCK = registerBlock("golden_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(8, 9), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block RUBY_ORE1 = registerBlock("ruby_ore1", new ExperienceDroppingBlock(UniformIntProvider.create(9, 10), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block RED_STEEL_ORE = registerBlock("red_steel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(7, 8), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block DARK_ORE = registerBlock("dark_ore", new ExperienceDroppingBlock(UniformIntProvider.create(10, 11), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block BLACK_ORE = registerBlock("black_ore", new ExperienceDroppingBlock(UniformIntProvider.create(11, 12), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block WHITE_ORE = registerBlock("white_ore", new ExperienceDroppingBlock(UniformIntProvider.create(11, 12), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block GOLDEN_ORE = registerBlock("golden_ore", new ExperienceDroppingBlock(UniformIntProvider.create(19, 20), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block CURSED_AMETHYST_ORE = registerBlock("cursed_amethyst_ore", new ExperienceDroppingBlock(UniformIntProvider.create(6, 9), AbstractBlock.Settings.create().strength(6.0F).requiresTool()));

    public static final Block TAINTED_AMETHYST_ORE = registerBlock("tainted_amethyst_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.create().strength(3.0F).requiresTool()));

    public static final Block NETHER_AMETHYST_ORE = registerBlock("nether_amethyst_ore", new ExperienceDroppingBlock(UniformIntProvider.create(5, 7), AbstractBlock.Settings.create().strength(4.0F).requiresTool()));

    public static final Block END_AMETHYST_ORE = registerBlock("end_amethyst_ore", new ExperienceDroppingBlock(UniformIntProvider.create(16, 19), AbstractBlock.Settings.create().strength(5.0F).requiresTool()));

    public static final Block EMERALD_MINECRAFT_BLOCK = registerBlock("emerald_minecraft_block", new Block(AbstractBlock.Settings.create().strength(4.0F).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_CRIMSON)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MinecraftXAnimation.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, Identifier.of(MinecraftXAnimation.MOD_ID, name), block);
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MinecraftXAnimation.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MinecraftXAnimation.LOGGER.info("Registering ModBlocks for " + MinecraftXAnimation.MOD_ID);
    }
}