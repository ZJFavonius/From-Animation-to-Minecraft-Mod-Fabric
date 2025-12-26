package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface Use {
    void inventoryTick(ItemStack stack, World world, LivingEntity entity, int slot, boolean selected);
}
