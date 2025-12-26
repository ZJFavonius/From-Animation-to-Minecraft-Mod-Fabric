package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class CustomIllusionerEntity extends IllusionerEntity {
    private static PlayerEntity owner;

    public CustomIllusionerEntity(EntityType<? extends IllusionerEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomIllusionerEntity create(ServerWorld world, PlayerEntity player) {
        CustomIllusionerEntity illusioner = new CustomIllusionerEntity(EntityType.ILLUSIONER, world);
        illusioner.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        illusioner.initialize(world, world.getLocalDifficulty(illusioner.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        illusioner.goalSelector.add(0, new FollowPlayerGoal(illusioner, player));
        illusioner.targetSelector.add(0, new AttackTargetGoal(illusioner, player));
        setOwner(owner);
        return illusioner;
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

    public static void setOwner(PlayerEntity owner) {
        CustomIllusionerEntity.owner = owner;
    }
}
