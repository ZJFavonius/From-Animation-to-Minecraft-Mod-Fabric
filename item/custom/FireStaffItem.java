package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FireStaffItem extends SwordItem {
    public FireStaffItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            FireballEntity fireball = new FireballEntity(EntityType.FIREBALL, world);
            fireball.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            fireball.setPosition(player.getX() + player.getRotationVec(1.0F).x, player.getEyeY() - 0.1, player.getZ() + player.getRotationVec(1.0F).z);
            world.playSound((PlayerEntity)null, player.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            world.spawnEntity(fireball);
            MinecraftClient.getInstance().particleManager.addEmitter((Entity)null, ParticleTypes.FLAME, 10);
            target.setFireTicks(100);
            fireball.setFireTicks(10);
            fireball.setOnFire(true);
        }

        return new TypedActionResult(ActionResult.SUCCESS, itemStack);
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

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        MinecraftClient.getInstance().particleManager.addEmitter(target, ParticleTypes.FLAME, 10);
        target.setFireTicks(100);
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Mustard").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Corrupted Iron Golem").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("This staff is immensely powerful, and can do insane damage.").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}