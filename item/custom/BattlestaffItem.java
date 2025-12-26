package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class BattlestaffItem extends SwordItem {
    public BattlestaffItem(ToolMaterials toolMaterials, Settings settings) {
            super(toolMaterials, settings);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(10, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 100;
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        return true;
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("[COMMON | RARE]").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Damage type:").formatted(Formatting.RED));
        tooltip.add(Text.literal("Melee").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("MINECRAFT DUNGEONS").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("The battlestaff is a").formatted(Formatting.RED));
            tooltip.add(Text.literal("perfectly balanced staff").formatted(Formatting.RED));
            tooltip.add(Text.literal("that is ready for any battle.").formatted(Formatting.RED));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Runes:").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Ṭ").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("Enchantment:").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}