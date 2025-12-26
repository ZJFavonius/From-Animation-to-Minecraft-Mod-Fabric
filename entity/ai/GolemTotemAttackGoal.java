package mxa.modid.entity.ai;

import mxa.modid.entity.custom.GolemTotemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class GolemTotemAttackGoal extends MeleeAttackGoal {
    private final GolemTotemEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public GolemTotemAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.entity = (GolemTotemEntity)mob;
    }

    public void start() {
        super.start();
        this.entity.setAttacking(true);
        this.attackDelay = 20;
        this.ticksUntilNextAttack = 20;
    }

    protected void attack(LivingEntity pEnemy) {
        if (this.isEnemyWithinAttackDistance(pEnemy)) {
            this.shouldCountTillNextAttack = true;
            if (this.isTimeToStartAttackAnimation()) {
                this.entity.setAttacking(true);
            }

            if (this.isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                this.performAttack(pEnemy);
            }
        } else {
            this.resetAttackCooldown();
            this.shouldCountTillNextAttack = false;
            this.entity.setAttacking(false);
            this.entity.attackAnimationTimeout = 0;
        }

    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 2.0F;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(this.attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= this.attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    public void tick() {
        super.tick();
        if (this.shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }

    }

    public void stop() {
        super.stop();
        this.entity.setAttacking(false);
    }
}
