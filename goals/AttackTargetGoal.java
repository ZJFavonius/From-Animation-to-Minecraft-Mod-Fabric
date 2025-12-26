package mxa.modid.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class AttackTargetGoal extends Goal {
    private final MobEntity mob;
    private final PlayerEntity player;

    public AttackTargetGoal(MobEntity mob, PlayerEntity player) {
        this.mob = mob;
        this.player = player;
    }

    public boolean canStart() {
        return this.player.getAttacker() != null;
    }

    public void tick() {
        if (this.player.getAttacker() != null) {
            this.mob.setTarget(this.player.getAttacker());
        }

    }
}
