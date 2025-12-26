package mxa.modid.item.custom;

import mxa.modid.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class WadoIchimonjiScabbardItem extends SwordItem {
    public WadoIchimonjiScabbardItem(ToolMaterials toolMaterials, Settings settings) {
            super(toolMaterials, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            user.setStackInHand(hand, new ItemStack(ModItems.WADO_ICHI));
            user.dropItem(ModItems.WADO_ICHI_SAY);
            user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP);
        }

        return TypedActionResult.success(stack);
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
        stack.damage(9, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("和道一文字").copy().formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Straight Line through the Path of Harmony").copy().formatted(Formatting.BOLD));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Zoro").copy().formatted(Formatting.GREEN));
        tooltip.add(Text.literal("Kuina").copy().formatted(Formatting.STRIKETHROUGH));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("\uD83D\uDC80NE P\uD83E\uDDCDEC€").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.literal("Belonged to Zoro's childhood friend.").copy().formatted(Formatting.WHITE));
            tooltip.add(Text.literal("This sword became Zoro's most treasured").copy().formatted(Formatting.WHITE));
            tooltip.add(Text.literal("possession, embodying his promise to Kuina").copy().formatted(Formatting.WHITE));
            tooltip.add(Text.literal("to become the world's greatest swordsman.").copy().formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));

        super.appendTooltip(stack, context, tooltip, type);
    }
}