package mxa.modid.item.custom;

import mxa.modid.entity.custom.RedSteelSpearAxeProjectileEntity;
import mxa.modid.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.TridentItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RedSteelSpearAxeItem extends TridentItem {
    public RedSteelSpearAxeItem(ToolMaterials toolMaterials, Item.Settings settings) {
        super(settings);
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return 10000.0F;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(12, attacker, EquipmentSlot.MAINHAND);
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
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        return super.getBonusAttackDamage(target, baseAttackDamage, damageSource);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        // Start charging the throw
        user.setCurrentHand(hand);

        if (user.isSneaking())
        {
            user.setStackInHand(hand, new ItemStack(ModItems.REGULAR_RED_STEEL_AXE));
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    public int getMaxUseTime(ItemStack stack) {
        // Matches Trident's draw time
        return 72000;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return;

        int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;
        if (chargeTime < 10) return; // require a minimal charge like the trident

        if (!world.isClient) {
            // Create projectile and set velocity like a trident
            RedSteelSpearAxeProjectileEntity projectile = new RedSteelSpearAxeProjectileEntity(world, player);
            projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);

            // spawn and play throw sound
            world.spawnEntity(projectile);
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ITEM_TRIDENT_THROW, net.minecraft.sound.SoundCategory.PLAYERS,
                    1.0F, 1.0F);

            }
        }


    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        // Optional: let players repair with red steel ingots
        return ingredient.isOf(ModItems.RED_STEEL) || super.canRepair(stack, ingredient);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Ruby Axe").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("Spear Axe").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Illager King").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Illager King's Brother").formatted(Formatting.STRIKETHROUGH));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("It is prominently a heavy one-wielded axe, that can be used for").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("both ranged and melee combat, making it extremely adaptable to situations.").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("More. You can do more").formatted(Formatting.RED));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}