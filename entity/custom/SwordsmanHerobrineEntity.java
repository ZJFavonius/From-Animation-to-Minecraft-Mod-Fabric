package mxa.modid.entity.custom;

import mxa.modid.entity.ai.SwordsmanHerobrineAttackGoal;
import mxa.modid.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SwordsmanHerobrineEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING;
    private static final TrackedData<Boolean> ANGRY;
    private static final TrackedData<Boolean> PROVOKED;
    private static final TrackedData<Integer> INVUL_TIMER;
    private final ServerBossBar bossBar;
    public AnimationState idleAnimateState;
    private int idleAnimationTimeout;
    public final AnimationState attackAnimationState;
    public int attackAnimationTimeout;
    private boolean attacking;
    private int attackTimer;
    private boolean isAttacking;
    private static PlayerEntity targetedPlayer;
    private int lastAngrySoundAge;
    private int ageWhenTargetSet;
    private static final UniformIntProvider ANGER_TIME_RANGE;
    private int angerTime;
    private @Nullable UUID angryAt;
    private final AnimationState idleAnimationState;
    private int teleportCooldown;

    public SwordsmanHerobrineEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.NOTCHED_20)).setDarkenSky(true);
        this.idleAnimateState = new AnimationState();
        this.idleAnimationTimeout = 0;
        this.attackAnimationState = new AnimationState();
        this.attackAnimationTimeout = 0;
        this.attacking = false;
        this.attackTimer = 0;
        this.lastAngrySoundAge = Integer.MIN_VALUE;
        this.idleAnimationState = new AnimationState();
        this.teleportCooldown = 0;
        this.idleAnimateState = new AnimationState();
    }

    public Text getDisplayName() {
        return this.hasCustomName() ? this.getCustomName() : Text.of("Swordsman Herobrine");
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setInvulTimer(nbt.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }

    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Invul", this.getInvulTimer());
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
        builder.add(ANGRY, false);
        builder.add(PROVOKED, false);
        builder.add(INVUL_TIMER, 0);
    }

    private void setupAnimationStates() {
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

        if (this.isAttacking()) {
            this.attackAnimationState.stop();
        }

        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }

        if (this.idleAnimateState != null) {
            this.idleAnimationState.start(this.age);
        }

        if (this.isAttacking()) {
            this.attackAnimationState.start(this.age);
            this.goalSelector.add(1, new SwordsmanHerobrineAttackGoal(this, 1.0, true));
        } else {
            this.attackAnimationState.stop();
        }

        if (this.teleportCooldown > 0) {
            --this.teleportCooldown;
        }

    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ChasePlayerGoal(this));
        this.goalSelector.add(0, new SwordsmanHerobrineAttackGoal(this, 1.0, true));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(1, new TeleportTowardsPlayerGoal(this));
        this.targetSelector.add(0, new RevengeGoal(this, new Class[0]));
    }

    public static DefaultAttributeContainer.Builder createSwordsmanHerobrineAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3499999940395355).add(EntityAttributes.GENERIC_ARMOR, 30.0).add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0).add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 4.0);
    }

    public void setInvulTimer(int ticks) {
        this.dataTracker.set(INVUL_TIMER, ticks);
    }

    public int getInvulTimer() {
        return (Integer)this.dataTracker.get(INVUL_TIMER);
    }

    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WITHER_HURT;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_PLAYER_SWIM;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WITHER_DEATH;
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return (Boolean)this.dataTracker.get(ATTACKING);
    }

    public void setProvoked(boolean provoked) {
        this.dataTracker.set(PROVOKED, provoked);
    }

    public boolean isProvoked() {
        return (Boolean)this.dataTracker.get(PROVOKED);
    }

    public static PlayerEntity getTargetedPlayer() {
        return targetedPlayer;
    }

    public static void setTargetedPlayer(PlayerEntity targetedPlayer) {
        SwordsmanHerobrineEntity.targetedPlayer = targetedPlayer;
    }

    public void onDeath(DamageSource source) {
        super.onDeath(source);
        this.bossBar.setPercent(0.0F);
    }

    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        World var4 = this.getWorld();
        if (var4 instanceof ServerWorld serverWorld) {
            this.dropItem(Items.TOTEM_OF_UNDYING, this.random.nextInt(3) + 1);
            this.dropItem(ModItems.SWORDSMAN_HEROBRINE_KATANA);
        }

    }

    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl && target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200), this);
        }

        return bl;
    }

    protected void pushAway(Entity entity) {
        super.pushAway(entity);
        if (entity instanceof IronGolemEntity) {
            this.setProvoked(true);
        }

    }

    public boolean damage(DamageSource source, float amount) {
        boolean isDamaged = super.damage(source, amount);
        if (isDamaged && this.teleportCooldown <= 0) {
            this.teleportRandomly();
            this.teleportCooldown = 100;
        }

        return isDamaged;
    }

    public void teleportRandomly() {
        double x = this.getX() + (this.random.nextDouble() - 0.5) * 16.0;
        double y = this.getY() + ((double)this.random.nextInt(16) - 8.0);
        double z = this.getZ() + (this.random.nextDouble() - 0.5) * 16.0;
        this.teleport(x, y, z, true);
    }

    public void teleportToEntity(Entity entity) {
        Vec3d vec3d = new Vec3d(this.getX() - entity.getX(), this.getBodyY(0.5) - entity.getEyeY(), this.getZ() - entity.getZ());
        vec3d = vec3d.normalize();
        double d = 0.5 * (2.0 + this.random.nextDouble());
        double e = vec3d.x * d;
        double f = vec3d.y * d;
        double g = vec3d.z * d;
        this.teleport(this.getX() - e, this.getY() - f, this.getZ() - g, true);
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

    static {
        ATTACKING = DataTracker.registerData(SwordsmanHerobrineEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        ANGRY = DataTracker.registerData(SwordsmanHerobrineEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        PROVOKED = DataTracker.registerData(SwordsmanHerobrineEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        INVUL_TIMER = DataTracker.registerData(SwordsmanHerobrineEntity.class, TrackedDataHandlerRegistry.INTEGER);
        ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    }

    static class ChasePlayerGoal extends Goal {
        private final SwordsmanHerobrineEntity entity;

        public ChasePlayerGoal(SwordsmanHerobrineEntity entity) {
            this.entity = entity;
        }

        public boolean canStart() {
            PlayerEntity player = this.entity.getWorld().getClosestPlayer(this.entity, 10.0);
            if (player == null) {
                return false;
            } else {
                SwordsmanHerobrineEntity var10000 = this.entity;
                SwordsmanHerobrineEntity.setTargetedPlayer(player);
                return true;
            }
        }

        public void tick() {
            SwordsmanHerobrineEntity var10000 = this.entity;
            PlayerEntity player = SwordsmanHerobrineEntity.getTargetedPlayer();
            if (player != null) {
                this.entity.getLookControl().lookAt(player, 30.0F, 30.0F);
                if (this.entity.squaredDistanceTo(player) > 16.0) {
                    this.entity.getNavigation().startMovingTo(player, 1.0);
                    if (this.entity.teleportCooldown <= 0) {
                        this.entity.teleportToEntity(player);
                        this.entity.teleportCooldown = 100;
                    }
                } else {
                    this.entity.tryAttack(player);
                }
            }

        }
    }

    static class TeleportTowardsPlayerGoal extends Goal {
        private final SwordsmanHerobrineEntity entity;
        private int cooldown;

        public TeleportTowardsPlayerGoal(SwordsmanHerobrineEntity entity) {
            this.entity = entity;
        }

        public boolean canStart() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.squaredDistanceTo(this.entity) > 16.0 && this.entity.teleportCooldown <= 0;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                if (this.entity.canSee(target)) {
                    ++this.cooldown;
                    if (this.cooldown >= 100) {
                        this.entity.tryAttack(target);
                        this.cooldown = 0;
                    }
                } else {
                    this.cooldown = 0;
                }

                this.entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                if (this.entity.squaredDistanceTo(target) > 16.0) {
                    this.entity.teleportToEntity(target);
                    this.entity.teleportCooldown = 100;
                }
            }

        }
    }
}