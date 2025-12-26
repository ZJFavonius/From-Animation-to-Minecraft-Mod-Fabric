package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface enchhit {
    boolean postHit(ItemStack stack, LivingEntity player, LivingEntity attacker, int level);
}
