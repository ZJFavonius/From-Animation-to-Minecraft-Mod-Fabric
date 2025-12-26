package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ExplodingEffect extends StatusEffect {
    public ExplodingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 10, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 3, false, false));

        }

        else if (entity instanceof HostileEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }
        else if (entity instanceof ZombieEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof SkeletonEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof WitherSkeletonEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof WardenEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof SpiderEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof CreeperEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof EndermanEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof CaveSpiderEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof PillagerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof EvokerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof RavagerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof VindicatorEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof IllusionerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof BlazeEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof WitchEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof PiglinEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof PiglinBruteEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof ElderGuardianEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof GuardianEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);
            }
        }

        else if (entity instanceof WitherEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 3, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 3, false, false));

            if (entity.isDead() || entity.getHealth() <= 0.0F) {
                entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.0F, World.ExplosionSourceType.NONE);

            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}