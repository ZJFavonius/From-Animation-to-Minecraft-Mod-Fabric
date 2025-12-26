package mxa.modid.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class TechnobladeSwordItem extends SwordItem {
    public TechnobladeSwordItem(ToolMaterials toolMaterials, Settings settings) {
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
        addEnchantment(stack, enchantmentLookup, Enchantments.FIRE_ASPECT, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.LOOTING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.UNBREAKING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.MENDING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.SHARPNESS, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.SWEEPING_EDGE, 10);

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
        tooltip.add(Text.literal("Human GPS").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Technoblade Never Dies by Squared Media").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Named by a Twitter poll.").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("It is his main weapon, as he realized that the extra 1 point of").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("damage from the axe is negligible against the 60% faster attack speed.").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("The Orphan Obliterator is an extension of Technoblade himself,").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.literal("reflecting his strength, determination, and legendary status.").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.literal("This stands as a beacon of Technoblade's legacy, a weapon").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("that has carved his name into the annals of Minecraft history.").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("[Press Shift for other info]").formatted(Formatting.UNDERLINE));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}