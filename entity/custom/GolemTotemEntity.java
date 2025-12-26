package mxa.modid.entity.custom;

import mxa.modid.entity.ai.GolemTotemAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GolemTotemEntity extends GolemEntity {
    private static final TrackedData<Boolean> ATTACKING;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public AnimationState idleAnimateState = new AnimationState();
    private final ServerBossBar bossBar;

    public GolemTotemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(Text.of("Golem Totem"), BossBar.Color.GREEN, BossBar.Style.NOTCHED_20);
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    public void tickMovement() {
        super.tickMovement();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void onDeath(DamageSource source) {
        super.onDeath(source);
        this.bossBar.setPercent(0.0F);
    }

    private void setupAnimationState() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && this.attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout = 20;
            this.attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            this.attackAnimationState.stop();
        }

        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.5F);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return (Boolean)this.dataTracker.get(ATTACKING);
    }

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationState();
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }

        if (this.isAttacking()) {
            this.attackAnimationState.start(this.age);
        } else {
            this.attackAnimationState.stop();
        }

    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.goalSelector.add(1, new GolemTotemAttackGoal(this, 1.0, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(5, new LookAtEntityGoal(this, LivingEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        World var4 = this.getWorld();
        if (var4 instanceof ServerWorld serverWorld) {
            this.dropItem(Items.IRON_BLOCK, this.random.nextInt(3) + 1);
        }

    }

    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_STEP;
    }

    public static DefaultAttributeContainer.Builder createGolemTotemAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000.0).add(EntityAttributes.GENERIC_ARMOR, 100.0).add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 100.0).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0).add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 10.0);
    }

    static {
        ATTACKING = DataTracker.registerData(GolemTotemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}