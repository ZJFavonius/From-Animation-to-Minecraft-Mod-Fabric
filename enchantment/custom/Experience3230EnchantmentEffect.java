package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record Experience3230EnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<Experience3230EnchantmentEffect> CODEC = MapCodec.unit(Experience3230EnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            }

        if (level == 2) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            }

        if (level == 3) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            }

        if (level == 4) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 5) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 6) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 7) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 8) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 9) {
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.EXPERIENCE_ORB.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
