package mxa.modid.entity.custom;

import mxa.modid.entity.ModEntities;
import mxa.modid.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GarfieldEntity extends CatEntity {

    // Animation states
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    public GarfieldEntity(EntityType<? extends CatEntity> entityType, World world) {
        super(entityType, world);
    }

    // === ANIMATION HANDLING ===
    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        // Idle animation timing
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(10) + 20;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationTimeout--;
        }

        // Walking animation control
        if (this.getVelocity().horizontalLengthSquared() > 0.002 && !this.isSitting()) {
            if (!this.walkAnimationState.isRunning()) {
                this.walkAnimationState.start(this.age);
            }
        } else {
            this.walkAnimationState.stop();
        }
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new TemptGoal(this, 0.6, net.minecraft.recipe.Ingredient.ofItems(
                Items.COD, Items.SALMON, ModItems.LASAGNA
        ), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.0, 5.0F, 2.0F));
        this.goalSelector.add(5, new AnimalMateGoal(this, 0.8));
        this.goalSelector.add(6, new WanderAroundGoal(this, 0.8));
        this.goalSelector.add(7, new LookAtEntityGoal(this, GarfieldEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }
    // === TAMING ===
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.COD) || stack.isOf(Items.SALMON) || stack.isOf(ModItems.LASAGNA);
    }

    @Override
    public boolean isReadyToBreed() {
        return super.isReadyToBreed();
    }

    @Nullable
    @Override
    public CatEntity createChild(ServerWorld world, PassiveEntity entity) {
        GarfieldEntity garfield = ModEntities.GARFIELD.create(world);
        if (garfield != null && this.isTamed()) {
            garfield.setOwnerUuid(this.getOwnerUuid());
            garfield.setTamed(true);
        }
        return garfield;
    }

    private void setTamed(boolean b) {
    }

    // === SOUNDS ===
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }
}
