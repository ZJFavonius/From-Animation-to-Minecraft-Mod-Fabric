package mxa.modid.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class FollowPlayerGoal extends Goal {
    private final MobEntity mob;
    private final PlayerEntity player;
    private final double followSpeed;
    private final float maxDistance;

    public FollowPlayerGoal(MobEntity mob, PlayerEntity player) {
        this.mob = mob;
        this.player = player;
        this.followSpeed = 2.0;
        this.maxDistance = 10.0F;
    }

    public boolean canStart() {
        return !this.mob.isGlowing() && this.mob.squaredDistanceTo(this.player) > (double)(this.maxDistance * this.maxDistance);
    }

    public void tick() {
        this.mob.getNavigation().startMovingTo(this.player, this.followSpeed);
    }
}