package mxa.modid.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class MitsubishiLancerEvolution9Item extends Item {
    public MitsubishiLancerEvolution9Item(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("SAN915").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("HOT WHEELS").formatted(Formatting.RED));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
