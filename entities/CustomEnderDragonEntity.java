package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class CustomEnderDragonEntity extends EnderDragonEntity {
    private static PlayerEntity owner;

    public CustomEnderDragonEntity(EntityType<? extends EnderDragonEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomEnderDragonEntity create(ServerWorld world, PlayerEntity player) {
        CustomEnderDragonEntity dragon = new CustomEnderDragonEntity(EntityType.ENDER_DRAGON, world);
        String[] names = new String[]{"Diablo", "Dragonite", "Night", "Chaos", "Lucy", "Darkness", "Vans"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        dragon.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        dragon.initialize(world, world.getLocalDifficulty(dragon.getBlockPos()), SpawnReason.MOB_SUMMONED, null);
        dragon.setCustomName(Text.of(randomName));
        dragon.setCustomNameVisible(true);
        dragon.goalSelector.add(1, new FollowPlayerGoal(dragon, player));
        dragon.targetSelector.add(1, new AttackTargetGoal(dragon, player));
        setOwner(owner);
        return dragon;
    }

    public static void setOwner(PlayerEntity owner) {
        CustomEnderDragonEntity.owner = owner;
    }

    public void tick() {
        super.tick();
        if (this.getOwner() instanceof PlayerEntity owner) {
            // Follow the owner
            Vec3d ownerPos = owner.getPos();
            this.getNavigation().startMovingTo(ownerPos.x, ownerPos.y, ownerPos.z, 1.2);

            // Attack nearby hostile mobs
            List<HostileEntity> nearbyEnemies = this.getWorld().getEntitiesByClass(
                    HostileEntity.class,
                    this.getBoundingBox().expand(20),
                    entity -> true
            );

            if (!nearbyEnemies.isEmpty()) {
                this.setTarget(nearbyEnemies.getFirst()); // Attack the nearest hostile mob
            }
        }
    }

    private Object getOwner() {
        return null;
    }

    public static DefaultAttributeContainer.Builder createCustomEnderDragonAttributes() {
        return EnderDragonEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }
}