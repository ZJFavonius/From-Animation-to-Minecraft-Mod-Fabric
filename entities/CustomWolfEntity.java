package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class CustomWolfEntity extends WolfEntity {
    private static PlayerEntity owner;

    public CustomWolfEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomWolfEntity create(World world, PlayerEntity player) {
        CustomWolfEntity wolf = new CustomWolfEntity(EntityType.WOLF, world);
        String[] names = new String[]{"Luna", "Grim", "Sven", "Pup", "Browny", "Doggo"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        wolf.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        wolf.initialize((ServerWorldAccess)world, world.getLocalDifficulty(wolf.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        wolf.setCustomName(Text.of(randomName));
        wolf.setCustomNameVisible(true);
        wolf.setTamed(true, true);
        Objects.requireNonNull(wolf.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(60.0);
        wolf.goalSelector.add(0, new FollowPlayerGoal(wolf, player));
        wolf.targetSelector.add(0, new AttackTargetGoal(wolf, player));
        wolf.setOwner(owner);
        return wolf;
    }

}
