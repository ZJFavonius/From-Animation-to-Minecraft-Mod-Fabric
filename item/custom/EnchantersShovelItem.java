package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EnchantersShovelItem extends ShovelItem {
    public EnchantersShovelItem(ToolMaterials toolMaterials, Settings settings) {
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

    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        return super.getBonusAttackDamage(target, 10.0F, damageSource);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return 10000.0F;
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Enchanter").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("The shovel, much like the generic shovel, is able to destroy").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("soil-based blocks in an instant, even against cobblestone,").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("which is not the appropriate block for mainstream shovels.").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal("It is mainly used for supportive purposes, by destroying the").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal("grounds of the battlefield (aka \"spleefing\") to distract").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("the user's opponent and make them vulnerable to attacks.").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}