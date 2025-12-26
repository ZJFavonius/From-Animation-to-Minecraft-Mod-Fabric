package mxa.modid.item.custom;

import mxa.modid.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class RegularRedSteelAxeItem extends AxeItem {
    public RegularRedSteelAxeItem(ToolMaterials toolMaterials, Settings settings) {
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack heldItem = user.getStackInHand(hand);
            if (heldItem.isOf(ModItems.REGULAR_RED_STEEL_AXE)) {
                user.setStackInHand(hand, new ItemStack(ModItems.RED_STEEL_AXE));
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return 10000.0F;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(8.0F);
        Vec3d knockbackDirection = attacker.getPos().subtract(target.getPos()).normalize();
        target.addVelocity(knockbackDirection.x, 0.5, knockbackDirection.z);
        return super.postHit(stack, target, attacker);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        World world = player.getWorld();
        if (world.isClient) {
            return ActionResult.PASS;
        } else if (!(player.getAttackCooldownProgress(0.5F) > 0.9F)) {
            return super.useOnEntity(stack, player, target, hand);
        } else {
            Vec3d lookVec = player.getRotationVector();
            double range = 10.0;
            Vec3d startVec = player.getPos().add(0.0, (double)player.getEyeHeight(EntityPose.STANDING), 0.0);
            Vec3d endVec = startVec.add(lookVec.x * range, lookVec.y * range, lookVec.z * range);
            Box areaBox = new Box(startVec, endVec);
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, areaBox, (entityx) -> {
                return entityx != player;
            });
            Iterator var13 = entities.iterator();

            while(var13.hasNext()) {
                LivingEntity entity = (LivingEntity)var13.next();
                entity.damage(setBypassesArmor(), 10.0F);
            }

            world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
    }

    private DamageSource setBypassesArmor() {
        return null;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Brother's Axe").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("Base Axe").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Illager King").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Illager King's Brother").formatted(Formatting.STRIKETHROUGH));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Before, it was just a regular iron axe wielded by the Illager King's").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("brother until the axe changes to red after his former wielder's death.").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Live. You promised").formatted(Formatting.RED));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}