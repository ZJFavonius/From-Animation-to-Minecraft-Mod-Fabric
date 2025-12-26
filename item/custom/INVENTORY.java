package mxa.modid.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public interface INVENTORY {
    TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand);

    <Entity> void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected);

    void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected);
}
