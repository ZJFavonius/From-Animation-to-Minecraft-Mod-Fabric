package mxa.modid.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public interface useon {
    ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand);
}
