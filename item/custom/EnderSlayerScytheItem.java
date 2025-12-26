package mxa.modid.item.custom;

import mxa.modid.entities.CustomEnderDragonEntity;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EnderSlayerScytheItem extends SwordItem {
    private int dragonSouls = 0;
    private boolean dragonPresent = false;
    private static final int MAX_SOULS = 5;
    private static final int COOLDOWN_TICKS = 100;

    public EnderSlayerScytheItem(ToolMaterials toolMaterials, Settings settings) {
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

    private void performEnderpulse(LivingEntity target, LivingEntity player) {
        if (player instanceof PlayerEntity) {
            Vec3d targetPos = target.getPos();
            player.teleport(targetPos.x, targetPos.y + 1.0, targetPos.z, true);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 10, true, true, true));
            target.damage(player.getDamageSources().magic(), 5.0F);
        }
    }

    private void performVoidrend(LivingEntity user) {
        LivingEntity target = user.getAttacking();
        if (target instanceof HostileEntity) {
            target.damage(user.getDamageSources().magic(), 10.0F);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 10));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 10));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 10));
        }
    }

    public void summonEnderDragon(World world, PlayerEntity player) {
        if (dragonSouls > 0 && !dragonPresent) {
            if (world instanceof ServerWorld serverWorld) {
                CustomEnderDragonEntity dragon = new CustomEnderDragonEntity(EntityType.ENDER_DRAGON, world);
                dragon.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), 0.0F, 0.0F);
                serverWorld.spawnEntity(dragon);
                dragonSouls--;
                dragonPresent = true;
                player.sendMessage(Text.of("I call thy Ender Dragon"), true);
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            }
        } else {
            player.sendMessage(Text.of("No Ender Dragon souls stored!"), true);
        }
    }

    public void recallEnderDragon(World world, PlayerEntity player) {
        CustomEnderDragonEntity dragon = this.getSummonedDragon(world, player);
        if (dragon != null) {
            dragon.remove(Entity.RemovalReason.DISCARDED);
            dragonPresent = false;
            player.sendMessage(Text.of("Return"), true);
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_DEATH, SoundCategory.PLAYERS, 1.0F, 1.0F);
            player.getItemCooldownManager().set(this, COOLDOWN_TICKS);
        } else {
            player.sendMessage(Text.of("No Ender Dragon to return!"), true);
        }
    }

    public void absorbEnderDragonSoul(ItemStack heldItem, PlayerEntity player) {
        if (dragonSouls < MAX_SOULS) {
            dragonSouls++;
            player.sendMessage(Text.of("Ender Dragon soul absorbed! Total souls: " + dragonSouls), true);
        }
    }

    private CustomEnderDragonEntity getSummonedDragon(World world, PlayerEntity player) {
        for (CustomEnderDragonEntity entity : world.getEntitiesByClass(CustomEnderDragonEntity.class, player.getBoundingBox().expand(50.0), entity -> true)) {
            return entity;
        }
        return null;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            this.performVoidrend(user);
            user.sendMessage(Text.of("Voidrend activated!"), true);
            if (user.isSneaking()) {
                BlockPos pos = user.getBlockPos();
                world.playSound(null, pos, SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                world.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0, 0.0, 0.0);

                if (dragonPresent) {
                    this.recallEnderDragon(world, user);
                } else {
                    this.summonEnderDragon(world, user);
                }
            }
        }
        return TypedActionResult.pass(itemStack);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.performEnderpulse(target, attacker);
        if (attacker instanceof PlayerEntity) {
            ((PlayerEntity) attacker).sendMessage(Text.of("Enderpulse activated!"), true);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Reaper Herobrine").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("Depicts a tall pole weapon with a large, curved blade on one side and two").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("small blades on the other. It has the ability to store Ender Dragons").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("souls as well as summoning, controlling, and absorbing them at will.").formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Caught Ender Dragon Souls: " + dragonSouls).formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}