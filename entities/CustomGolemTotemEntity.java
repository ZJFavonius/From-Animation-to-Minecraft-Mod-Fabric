package mxa.modid.entities;

import mxa.modid.entity.ModEntities;
import mxa.modid.entity.custom.GolemTotemEntity;
import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class CustomGolemTotemEntity extends GolemTotemEntity {
    private static PlayerEntity owner;

    public CustomGolemTotemEntity(EntityType<GolemTotemEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomGolemTotemEntity create(ServerWorld world, PlayerEntity player) {
        CustomGolemTotemEntity golem = new CustomGolemTotemEntity(ModEntities.GOLEM_TOTEM, world);
        String[] names = new String[]{"Franky", "PX-Z", "Golem", "Pacifista", "Titan", "Cyborg", "Zeff"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        golem.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        golem.initialize(world, world.getLocalDifficulty(golem.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        golem.setCustomName(Text.of(randomName));
        golem.setCustomNameVisible(false);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(1000.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_ARMOR)).setBaseValue(100.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)).setBaseValue(100.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(100.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_KNOCKBACK)).setBaseValue(100.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE)).setBaseValue(100.0);
        Objects.requireNonNull(golem.getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(10.0);
        golem.goalSelector.add(0, new FollowPlayerGoal(golem, player));
        golem.goalSelector.add(1, new AttackTargetGoal(golem, player));
        setOwner(owner);
        return golem;
    }

    public static void setOwner(PlayerEntity owner) {
        CustomGolemTotemEntity.owner = owner;
    }
}