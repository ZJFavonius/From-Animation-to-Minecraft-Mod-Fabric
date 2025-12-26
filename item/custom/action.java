package mxa.modid.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public interface action {
    TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand);
}
