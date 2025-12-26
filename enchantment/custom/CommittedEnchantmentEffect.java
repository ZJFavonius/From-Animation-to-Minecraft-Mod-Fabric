package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import mxa.modid.effect.ModEffects;
import mxa.modid.item.custom.target;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public record CommittedEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<CommittedEnchantmentEffect> CODEC = MapCodec.unit(CommittedEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            if (user instanceof LivingEntity player) {
                target.addStatusEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 400, 0, true, true, true));

                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, player.getX(), player.getY(), player.getZ());
                cloud.addEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 100, 0, true, true, true));
                cloud.setParticleType(new DustParticleEffect(new Vector3f(1.0F, 1.0F, 1.0F), 1.0F));
                cloud.setDuration(60);
                cloud.setRadius(5.0F);
                world.spawnEntity(cloud);
            }
        }

        if (level == 2) {
            if (user instanceof LivingEntity player) {
                target.addStatusEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 400, 1, true, true, true));

                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, player.getX(), player.getY(), player.getZ());
                cloud.addEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 100, 1, true, true, true));
                cloud.setParticleType(new DustParticleEffect(new Vector3f(1.0F, 1.0F, 1.0F), 1.0F));
                cloud.setDuration(60);
                cloud.setRadius(6.0F);
                world.spawnEntity(cloud);
            }
        }

        if (level == 3) {
            if (user instanceof LivingEntity player) {
                target.addStatusEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 400, 2, true, true, true));

                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, player.getX(), player.getY(), player.getZ());
                cloud.addEffect(new StatusEffectInstance(ModEffects.COMMITTED_EFFECT, 100, 2, true, true, true));
                cloud.setParticleType(new DustParticleEffect(new Vector3f(1.0F, 1.0F, 1.0F), 1.0F));
                cloud.setDuration(60);
                cloud.setRadius(7.0F);
                world.spawnEntity(cloud);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
