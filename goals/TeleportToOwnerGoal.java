package mxa.modid.goals;

import mxa.modid.entities.CustomEndermanEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.EnumSet;

public class TeleportToOwnerGoal extends Goal {
    private final CustomEndermanEntity enderman;
    private final PlayerEntity owner;
    private final double maxDistance;

    public TeleportToOwnerGoal(CustomEndermanEntity enderman, PlayerEntity owner, double maxDistance) {
        this.enderman = enderman;
        this.owner = owner;
        this.maxDistance = maxDistance;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    public boolean canStart() {
        return this.owner != null && !this.owner.isDead() && !(this.enderman.squaredDistanceTo(this.owner) <= this.maxDistance * this.maxDistance);
    }

    public void start() {
        BlockPos targetPos = this.owner.getBlockPos();
        if (targetPos != null) {
            this.enderman.teleport((double)targetPos.getX(), (double)targetPos.getY(), (double)targetPos.getZ(), true);
        }

    }

    public void start(int age) {
    }
}