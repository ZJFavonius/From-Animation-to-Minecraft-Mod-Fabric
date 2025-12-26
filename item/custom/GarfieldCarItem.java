package mxa.modid.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class GarfieldCarItem extends SpawnEggItem {

    public GarfieldCarItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Garfield").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Jim Davis").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From The Garfield Movie").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Is an overweight, bipedal").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("orange tabby cat known for").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("his laziness, sarcasm, arrogance").formatted(Formatting.GOLD));
        tooltip.add(Text.literal(", selfishness, and love for").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("food, especially lasagna.").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("[Press Shift for cat knowledge]").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("(Suggested by my girlfriend).").formatted(Formatting.GOLD));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
