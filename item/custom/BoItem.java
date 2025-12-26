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

public class BoItem extends SwordItem {
    public BoItem(ToolMaterials toolMaterials, Settings settings) {
            super(toolMaterials, settings);
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

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(10, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Rokushakubō").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Donatello").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Teenage Mutant Ninja Turtles").copy().formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.literal("Splinter gives Donatello a bō staff to").copy().formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal("teach him that innovation also comes from").copy().formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal("learning to solve problems with what's available,").copy().formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal("instead of relying on complex gadgets.").copy().formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));

        super.appendTooltip(stack, context, tooltip, type);
    }
}