package mxa.modid.entity.custom;

import mxa.modid.entity.ModEntities;
import mxa.modid.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SwordProjectileEntity extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;
    private static final ItemStack DEFAULT_STACK;
    private boolean dealtDamage;

    public SwordProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public SwordProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.SWORD_PROJECTILE, player, world, new ItemStack(ModItems.SWORD_PROJECTILE), null);
    }

    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }

    }

    public float getRenderingRotation() {
        this.rotation += 0.05F;
        if (this.rotation >= 360.0F) {
            this.rotation = 0.0F;
        }

        return this.rotation;
    }

    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.SWORD_PROJECTILE);
    }

    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.SWORD_PROJECTILE);
    }

    protected SoundEvent getHitSound() {
        return SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP;
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

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    static {
        DEFAULT_STACK = new ItemStack(ModItems.SWORD_PROJECTILE);
    }
}