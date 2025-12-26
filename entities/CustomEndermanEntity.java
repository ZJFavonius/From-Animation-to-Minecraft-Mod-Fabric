package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import mxa.modid.goals.TeleportToOwnerGoal;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Random;

public class CustomEndermanEntity extends EndermanEntity {
    private static PlayerEntity owner;

    public CustomEndermanEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomEndermanEntity create(ServerWorld world, PlayerEntity player) {
        CustomEndermanEntity enderman = new CustomEndermanEntity(EntityType.ENDERMAN, world);
        String[] names = new String[]{"Shadow", "Specter", "Void", "Nightmare", "Phantom", "Abyss", "Slender"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        enderman.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        enderman.initialize(world, world.getLocalDifficulty(enderman.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        enderman.setCustomName(Text.of(randomName));
        enderman.setCustomNameVisible(true);
        enderman.goalSelector.add(0, new FollowPlayerGoal(enderman, player));
        enderman.targetSelector.add(0, new AttackTargetGoal(enderman, player));
        setOwner(owner);
        return enderman;
    }

    public static void setOwner(PlayerEntity owner) {
        CustomEndermanEntity.owner = owner;
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new TeleportToOwnerGoal(this, owner, 20.0));
    }
}