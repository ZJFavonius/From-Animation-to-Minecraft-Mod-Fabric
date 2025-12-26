package mxa.modid.item.custom;

import mxa.modid.enchantment.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class DiamondSwordItem extends SwordItem {
    public DiamondSwordItem(ToolMaterials toolMaterials, Settings settings) {
            super(toolMaterials, settings);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(3, attacker, EquipmentSlot.MAINHAND);
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);

        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        // Fetch the enchantment registry lookup
        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        addEnchantment(stack, enchantmentLookup);
    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup) {
        lookup.getOptional(ModEnchantments.SHARPNESS_).ifPresent(entry -> stack.addEnchantment(entry, 3));
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("[UNIQUE]").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("◆Extra damage").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Damage type:").formatted(Formatting.RED));
        tooltip.add(Text.literal("Melee").formatted(Formatting.AQUA));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("MINECRAFT DUNGEONS").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("The Diamond Sword is the").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("true mark of a hero and an").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("accomplished adventurer.").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Runes:").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Ṭ").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("Enchantment:").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}