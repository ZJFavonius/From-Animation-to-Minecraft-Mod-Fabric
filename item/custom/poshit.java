package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface poshit {
    boolean postHit(World world, ItemStack stack, LivingEntity target, LivingEntity attacker);
}
