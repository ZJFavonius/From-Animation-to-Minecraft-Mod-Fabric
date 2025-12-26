package mxa.modid.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface tag {
    void inventoryTick(ItemStack stack, World world, net.minecraft.entity.LivingEntity entity, int slot, boolean selected);
}
