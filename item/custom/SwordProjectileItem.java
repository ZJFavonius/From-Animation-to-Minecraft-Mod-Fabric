package mxa.modid.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mxa.modid.entity.custom.SwordProjectileEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SwordProjectileItem extends Item {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public SwordProjectileItem(Item.Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(TridentItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED.value(), new EntityAttributeModifier(TridentItem.BASE_ATTACK_SPEED_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE));
        this.attributeModifiers = builder.build();
    }

    public Object getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers();
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(stack);
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;
            stack.decrement(1);
            SwordProjectileEntity swordProjectile = new SwordProjectileEntity(world, player);
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0F, 1.0F);
            swordProjectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(swordProjectile);
            if (chargeTime >= 20) {
                this.setupProjectile(player, swordProjectile);
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                    swordProjectile.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    player.getInventory().removeOne(stack);
                }
            }

            super.onStoppedUsing(stack, world, user, remainingUseTicks);
        }

    }

    private int getMaxUseTime(ItemStack stack) {
        return 0;
    }

    private void setupProjectile(PlayerEntity player, ProjectileEntity projectile) {
        Vec3d direction = player.getRotationVec(1.0F);
        projectile.setVelocity(direction.x, direction.y, direction.z, 2.0F, 0.5F);
    }
}