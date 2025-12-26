package mxa.modid.item.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class TechnobladeAxe1Item extends AxeItem {
    public TechnobladeAxe1Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    public TechnobladeAxe1Item(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);

        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        // Fetch the enchantment registry lookup
        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        // Apply vanilla enchantments
        addEnchantment(stack, enchantmentLookup, Enchantments.FORTUNE, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.UNBREAKING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.MENDING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.EFFICIENCY, 10);

    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup, RegistryKey<Enchantment> enchantmentKey, int level) {
        lookup.getOptional(enchantmentKey).ifPresent(entry -> stack.addEnchantment(entry, level));
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Technothepig").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("Ranboo").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Technoblade Never Dies by Squared Media").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Gifted to Technoblade by Ranboo as a gift for letting him move into the Arctic, it").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("was made as a replacement for the Axe of Peace, and was made to be a replica After").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("Ranboo's death, Techno states this axe is more important to him than the Axe of Peace.").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}