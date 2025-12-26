package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface status {
    boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker);

    void onCraft(ItemStack stack, World world, PlayerEntity player);
}
