package mxa.modid.event;

import mxa.modid.item.DinnerboneHatItem;
import mxa.modid.item.custom.EnderAegisShield;
import mxa.modid.item.custom.EnderSlayerScytheItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class ModEvents {
    public ModEvents() {
    }

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register((world) -> {
            if (world instanceof ServerWorld serverWorld) {
                handleEntityDeaths(serverWorld);
                for (ServerPlayerEntity player : serverWorld.getPlayers()) {
                    onEntityAttack(player, serverWorld);
                    handleEntityDetection(player, serverWorld);
                    handleTick(player);
                }
            }
        });

        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (!world.isClient && hand == Hand.OFF_HAND) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.getItem() instanceof EnderAegisShield shield) {
                    shield.handlePlayerInput(player);
                    return TypedActionResult.success(stack);
                }
            }
            return TypedActionResult.pass(ItemStack.EMPTY);
        });
    }
    private static void onEntityAttack(ServerPlayerEntity player, ServerWorld world) {
        ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);
        Item var4 = stack.getItem();
        if (var4 instanceof DinnerboneHatItem hat) {
            Box box = player.getBoundingBox().expand(8.0, 8.0, 8.0);
            TypeFilter<Entity, ?> typeFilter = TypeFilter.instanceOf(Entity.class);
            world.getEntitiesByType(typeFilter, box, (entity) -> true).forEach((entity) -> {
                if (entity instanceof HostileEntity) {
                    ((HostileEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 3));
                    ((HostileEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 3));
                    ((HostileEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 3));
                    ((HostileEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 3));
                } else if (entity instanceof ProjectileEntity) {
                    entity.remove(Entity.RemovalReason.DISCARDED);
                }

            });
            hat.overseerShockBlast(player, world);
            DinnerboneHatItem.heavyEndurance(player, world);
        }

    }

    public static void handleEntityDetection(PlayerEntity player, World world) {
        ItemStack stack = player.getOffHandStack();
        Item var4 = stack.getItem();
        if (var4 instanceof EnderAegisShield shield) {
            Box box = player.getBoundingBox().expand(8.0, 8.0, 8.0);
            TypeFilter<Entity, ?> typeFilter = TypeFilter.instanceOf(Entity.class);
            world.getEntitiesByType(typeFilter, box, (entity) -> true).forEach((entity) -> {
                if (entity instanceof HostileEntity) {
                    ((HostileEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 3));
                } else if (entity instanceof ProjectileEntity) {
                    entity.remove(Entity.RemovalReason.DISCARDED);
                }

            });
            shield.teleportationWard(player);
            shield.dimensionalStability(world);
            shield.enderPulse(player, world);
        }

    }

    private static void handleTick(PlayerEntity player) {
        ItemStack stack = player.getOffHandStack();
        Item var3 = stack.getItem();
        if (var3 instanceof EnderAegisShield shield) {
            if (shield.isEnderSightActive()) {
                shield.enderSight(player);
            }
        }

    }

    private static void handleEntityDeaths(ServerWorld world) {
        world.getPlayers().forEach((player) -> world.getEntitiesByClass(LivingEntity.class, player.getBoundingBox().expand(50.0), (entity) -> true).forEach((entity) -> {
            if (entity instanceof LivingEntity && !entity.isRemoved()) {
                handleEntityDeath(entity);
            }

        }));
    }

    private static void handleEntityDeath(LivingEntity entity) {
        if (entity instanceof EnderDragonEntity) {
            net.minecraft.entity.damage.DamageSource source = entity.getRecentDamageSource();
            if (source != null) {
                Entity var3 = source.getAttacker();
                if (var3 instanceof PlayerEntity player) {
                    ItemStack heldItem = player.getMainHandStack();
                    if (heldItem.getItem() instanceof EnderSlayerScytheItem) {
                        ((EnderSlayerScytheItem)heldItem.getItem()).absorbEnderDragonSoul(heldItem, player);
                    }
                }
            }
        }

    }
}