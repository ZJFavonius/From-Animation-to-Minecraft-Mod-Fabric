package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ArcaneObsidianFistItem extends SwordItem {
    public ArcaneObsidianFistItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient && world instanceof ServerWorld) {
            world.playSound((PlayerEntity)null, user.getBlockPos(), SoundEvents.ITEM_SHIELD_BLOCK, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.setAbsorptionAmount(10.0F);
            user.getItemCooldownManager().set(this, 40);
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity target, Hand hand) {
        if (!user.getWorld().isClient && user.isUsingItem() && user.getActiveItem() == stack) {
            float reducedDamage = 2.5F;
            user.damage(setBypassesArmor(), reducedDamage);
            user.getWorld().playSound((PlayerEntity)null, user.getBlockPos(), SoundEvents.ITEM_SHIELD_BLOCK, SoundCategory.PLAYERS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    private DamageSource setBypassesArmor() {
        return null;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Arcane Obsidian").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Shadow Herobrine").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").copy().formatted(Formatting.GREEN));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.literal("A secondary defense used in a similar manner of an armguard:").copy().formatted(Formatting.BOLD));
            tooltip.add(Text.literal("to block incoming attacks such as swords.").copy().formatted(Formatting.BOLD));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));
        super.appendTooltip(stack, context, tooltip, type);
    }
}