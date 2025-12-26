package mxa.modid.item.custom;

import mxa.modid.entity.custom.PickaxeProjectileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PickaxeProjectileItem extends Item {

    public PickaxeProjectileItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            int chargeTime = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (chargeTime >= 20) {
                // Teleportation
                Vec3d targetPos = user.raycast(100.0, 0.0F, false).getPos();
                user.requestTeleport(targetPos.x, targetPos.y, targetPos.z);
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                // Projectile
                PickaxeProjectileEntity projectile = new PickaxeProjectileEntity(world, player);

                Vec3d direction = player.getRotationVec(1.0F);
                projectile.setVelocity(direction.x, direction.y, direction.z, 2.0F, 0.5F);
                world.spawnEntity(projectile);

                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
        }
    }
}