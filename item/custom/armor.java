package mxa.modid.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface armor {
    void onArmorTick(ItemStack stack, World world, PlayerEntity player);
}
