package mxa.modid.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;

import java.util.List;

public class LasagnaFoodItem extends Item {

    public LasagnaFoodItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Garfield").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From The Garfield Movie").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Garfield's favorite food, The LASAGNA!!!").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
