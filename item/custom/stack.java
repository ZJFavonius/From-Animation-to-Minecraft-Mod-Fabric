package mxa.modid.item.custom;

import com.ibm.icu.impl.UResource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public interface stack {
    static UResource.Value getOrCreateNbt() {
        return null;
    }

    static NbtCompound get(Object o) {
        return null;
    }

    // Override the onItemFinishedUse method to trigger abilities upon using the item
    ItemStack onItemFinishedUse(ItemStack stack, World world, LivingEntity user);
}
