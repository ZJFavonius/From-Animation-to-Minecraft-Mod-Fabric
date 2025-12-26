package mxa.modid.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public interface target {
    static void addStatusEffect(StatusEffectInstance statusEffectInstance) {

    }

    static void damage(DamageSource magic, float earthDamage) {

    }

    static void setFrozenTicks(int i) {

    }

    static void setFireTicks(int i) {

    }

    static Vec3d getPos() {
        return null;
    }

    static void teleport(double x, double v, double z, boolean b) {

    }


    void inventoryTick(ItemStack stack, World world, Entity entity, LivingEntity target, int slot, boolean selected);
}
