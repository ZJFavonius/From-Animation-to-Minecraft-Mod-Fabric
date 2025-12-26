package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class IronBladeItem extends SwordItem {
    public IronBladeItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 5, true, true, true));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 5, true, true, true));
        return super.postHit(stack, target, attacker);
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

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Twin Blade").formatted(Formatting.BOLD));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Alex").formatted(Formatting.GOLD));
        tooltip.add(Text.literal(""));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From Animation Life by Squared Media").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("These blades were passed down through").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("generations of warriors, each adding their").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("own mark to the weapons’ storied history. Each").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("wielder of the Twin Iron Blades has been tested").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("by their power, requiring not only skill but also the").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("strength of character to harness their full potential.").formatted(Formatting.YELLOW));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
