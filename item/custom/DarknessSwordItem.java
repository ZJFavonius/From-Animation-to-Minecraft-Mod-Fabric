package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DarknessSwordItem extends SwordItem {
    private static final long USAGE_THRESHOLD = 7200000L;
    private static final long COOLDOWN_PERIOD = 3600000L;
    private final Map<UUID, Long> usageStartTime = new HashMap();
    private final Map<UUID, Long> cooldownEndTime = new HashMap();

    public DarknessSwordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.sendMessage(Text.of("Your human side are corrupting the more you use this sword."), true);
        if (user.isSneaking()) {
            HitResult hitResult = user.raycast(20.0, 0.0F, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult)hitResult;
                BlockPos targetPos = blockHitResult.getBlockPos();
                if (!world.isClient && world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)world;
                    serverWorld.createExplosion(user, (double)targetPos.getX(), (double)targetPos.getY(), (double)targetPos.getZ(), 2.0F, World.ExplosionSourceType.NONE);
                    serverWorld.setBlockState(targetPos, Blocks.END_PORTAL.getDefaultState());
                }
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
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

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity player) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.VOID_STRIKE_EFFECT, 200, 10, true, true, true));
        if (player instanceof PlayerEntity) {
            Vec3d targetPos = target.getPos();
            player.teleport(targetPos.x, targetPos.y + 1.0, targetPos.z, true);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 10, true, true, true));
        }

        return true;
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.DARK_SHIELD_EFFECT, 200, 10, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(ModEffects.ENDER_RIFT_EFFECT, 200, 10, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(ModEffects.ENDER_MASTERY_EFFECT, 200, 10, true, true, true));

            UUID playerUUID = player.getUuid();
            long currentTime = System.currentTimeMillis();
            if (this.cooldownEndTime.containsKey(playerUUID)) {
                if (currentTime < (Long) this.cooldownEndTime.get(playerUUID)) {
                    player.removeStatusEffect(ModEffects.CORRUPTING_INFLUENCE_EFFECT);
                } else {
                    this.cooldownEndTime.remove(playerUUID);
                }
            }

            if (!this.usageStartTime.containsKey(playerUUID)) {
                this.usageStartTime.put(playerUUID, currentTime);
            }

            long usageTime = currentTime - (Long) this.usageStartTime.get(playerUUID);
            if (usageTime >= 7200000L) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.CORRUPTING_INFLUENCE_EFFECT, 6000, 1, true, true, true));
                this.cooldownEndTime.put(playerUUID, currentTime + 3600000L);
                this.usageStartTime.remove(playerUUID);
                super.inventoryTick(stack, world, entity, slot, selected);
            }

        }
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Entity Blade").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Entity303's signature sword").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Entity303").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Entity Clones").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("This sword is sought after by ambitious villains and feared").formatted(Formatting.RED));
            tooltip.add(Text.literal("by heroes who understand its corrupting influence. The sword's").formatted(Formatting.RED));
            tooltip.add(Text.literal("very existence  serves as a reminder of the dangers of delving").formatted(Formatting.RED));
            tooltip.add(Text.literal("too deeply into dark magics and the consequences of unchecked ambition.").formatted(Formatting.RED));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("This Sword is not just a weapon but a symbol of power, temptation, and").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("the fragile balance between light and darkness in the Minecraft universe").formatted(Formatting.DARK_RED));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }
}