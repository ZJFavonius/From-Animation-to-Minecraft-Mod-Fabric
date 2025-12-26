package mxa.modid.entity.custom;

import mxa.modid.entity.ModEntities;
import mxa.modid.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RedSteelSpearAxeProjectileEntity extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;
    private static final ItemStack DEFAULT_STACK;

    public RedSteelSpearAxeProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public RedSteelSpearAxeProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.RED_STEEL_SPEAR_AXE_PROJECTILE, player, world, new ItemStack(ModItems.RED_STEEL_SPEAR_AXE), (ItemStack)null);
    }

    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.RED_STEEL_SPEAR_AXE);
    }

    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.RED_STEEL_SPEAR_AXE);
    }

    public float getRenderingRotation() {
        this.rotation += 0.05F;
        if (this.rotation >= 360.0F) {
            this.rotation = 0.0F;
        }

        return this.rotation;
    }

    public boolean isGrounded() {
        return super.inGround;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 8.0F);
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }

        Vec3d currentVelocity = this.getVelocity();
        Vec3d bounceDirection = currentVelocity.multiply(-1); // Reverse direction
        this.setVelocity(bounceDirection.multiply(0.8)); // Apply bounce with speed reduction
    }

    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (result.getSide() == Direction.SOUTH) {
            this.groundedOffset = new Vector2f(215.0F, 180.0F);
        }

        if (result.getSide() == Direction.NORTH) {
            this.groundedOffset = new Vector2f(215.0F, 0.0F);
        }

        if (result.getSide() == Direction.EAST) {
            this.groundedOffset = new Vector2f(215.0F, -90.0F);
        }

        if (result.getSide() == Direction.WEST) {
            this.groundedOffset = new Vector2f(215.0F, 90.0F);
        }

        if (result.getSide() == Direction.DOWN) {
            this.groundedOffset = new Vector2f(115.0F, 0.0F);
        }

        if (result.getSide() == Direction.UP) {
            this.groundedOffset = new Vector2f(285.0F, 0.0F);
        }

    }

    static {
        DEFAULT_STACK = new ItemStack(ModItems.RED_STEEL_SPEAR_AXE);
    }
}