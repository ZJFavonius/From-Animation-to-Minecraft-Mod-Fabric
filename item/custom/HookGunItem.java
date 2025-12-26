package mxa.modid.item.custom;

import mxa.modid.entity.custom.EnchantedPotatoProjectileEntity;
import mxa.modid.entity.custom.PickaxeProjectileEntity;
import mxa.modid.entity.custom.SwordProjectileEntity;
import mxa.modid.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class HookGunItem extends CrossbowItem {
    private static final int MAX_USE_TIME = 72000;

    public HookGunItem(Item.Settings settings) {
        super(settings);
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            player.setCurrentHand(hand);
        }

        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int chargeTime = MAX_USE_TIME - remainingUseTicks;

        if (chargeTime >= 20 && user instanceof PlayerEntity player && !world.isClient) {
            ItemStack offHandItem = user.getOffHandStack();

            if (offHandItem.getItem() == ModItems.PICKAXE_PROJECTILE) {
                firePickaxeProjectile(world, player);
            } else if (offHandItem.getItem() == ModItems.SWORD_PROJECTILE) {
                fireSwordProjectile(world, player);
            } else if (offHandItem.getItem() == ModItems.ENCHANTED_POTATO) {
                fireEnchantedPotatoProjectile(world, player);
            }
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    private void firePickaxeProjectile(World world, PlayerEntity player) {
        ItemStack offHandItem = player.getOffHandStack();
        if (!offHandItem.isEmpty() && offHandItem.getItem() == ModItems.PICKAXE_PROJECTILE) {
            offHandItem.decrement(1);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);

            PickaxeProjectileEntity pickaxeProjectile = new PickaxeProjectileEntity(world, player);
            setupProjectile(player, pickaxeProjectile);
            world.spawnEntity(pickaxeProjectile);

            // Teleport effect
            Vec3d targetPos = player.raycast(100.0, 0.0F, false).getPos();
            player.requestTeleport(targetPos.x, targetPos.y, targetPos.z);
        }
    }

    private void fireSwordProjectile(World world, PlayerEntity player) {
        ItemStack offHandItem = player.getOffHandStack();
        if (!offHandItem.isEmpty() && offHandItem.getItem() == ModItems.SWORD_PROJECTILE) {
            offHandItem.decrement(1);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0F, 1.0F);

            SwordProjectileEntity swordProjectile = new SwordProjectileEntity(world, player);
            setupProjectile(player, swordProjectile);
            world.spawnEntity(swordProjectile);
        }
    }

    private void fireEnchantedPotatoProjectile(World world, PlayerEntity player) {
        ItemStack offHandItem = player.getOffHandStack();
        if (!offHandItem.isEmpty() && offHandItem.getItem() == ModItems.ENCHANTED_POTATO) {
            offHandItem.decrement(1);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_EVOKER_FANGS_ATTACK, SoundCategory.PLAYERS, 1.0F, 1.0F);

            EnchantedPotatoProjectileEntity potatoProjectile = new EnchantedPotatoProjectileEntity(world, player);
            setupProjectile(player, potatoProjectile);
            world.spawnEntity(potatoProjectile);
        }
    }

    private void setupProjectile(LivingEntity player, ProjectileEntity projectile) {
        Vec3d direction = player.getRotationVec(1.0F);
        projectile.setVelocity(direction.x, direction.y, direction.z, 2.5F, 1.0F);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Hook Blaster").formatted(Formatting.GRAY));
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            ItemStack offHandItem = player.getOffHandStack();
            if (offHandItem.getItem() == ModItems.PICKAXE_PROJECTILE) {
                tooltip.add(Text.literal("Projectile: Pickaxe").formatted(Formatting.AQUA));
            } else if (offHandItem.getItem() == ModItems.SWORD_PROJECTILE) {
                tooltip.add(Text.literal("Projectile: Sword").formatted(Formatting.AQUA));
            } else if (offHandItem.getItem() == ModItems.ENCHANTED_POTATO) {
                tooltip.add(Text.literal("Projectile: Enchanted Potato").formatted(Formatting.GOLD));
            } else {
                tooltip.add(Text.literal("No Projectile Selected").formatted(Formatting.RED));
            }
        } else {
            tooltip.add(Text.literal("No Player Detected").formatted(Formatting.RED));
        }

        tooltip.add(Text.literal("Jev").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Alex").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Jev").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("It can shoot out either a sword, pickaxe, or potato, which makes it a multi-tool.").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));

        super.appendTooltip(stack, context, tooltip, type);
    }
}