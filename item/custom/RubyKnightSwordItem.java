package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RubyKnightSwordItem extends SwordItem {
    public RubyKnightSwordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(100);
        return true;
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 10));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 5));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 10));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 10));
        user.playSound(SoundEvents.ITEM_TOTEM_USE, 1.0F, 1.0F);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Creator Weapon").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Notch").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("BoopNotch").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Imbued with the power of fire, the sword can summon flames").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("to incinerate enemies, while also providing its wielder").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("with unmatched strength and protection. It was once wielded").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("by the legendary Ruby Knight, who defended the Villager").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Kingdom against the onslaught of hostile mobs.").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
