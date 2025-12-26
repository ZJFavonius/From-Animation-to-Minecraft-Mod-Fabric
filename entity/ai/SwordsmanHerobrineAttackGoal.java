package mxa.modid.entity.ai;

import mxa.modid.entity.custom.SwordsmanHerobrineEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class SwordsmanHerobrineAttackGoal extends MeleeAttackGoal {
    private final SwordsmanHerobrineEntity entity;
    private int attackDelay = 20;
    private int ticksUnitTillNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public SwordsmanHerobrineAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobidle) {
        super(mob, speed, pauseWhenMobidle);
        this.entity = (SwordsmanHerobrineEntity)mob;
    }

    public void start() {
        super.start();
        this.attackDelay = 20;
        this.ticksUnitTillNextAttack = 20;
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
        this.ticksUnitTillNextAttack = this.attackDelay * 2;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUnitTillNextAttack <= this.attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUnitTillNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    public void tick() {
        super.tick();
        if (this.shouldCountTillNextAttack) {
            this.ticksUnitTillNextAttack = Math.max(this.ticksUnitTillNextAttack - 1, 0);
        }

    }

    public void stop() {
        this.entity.setAttacking(false);
        super.stop();
    }
}

