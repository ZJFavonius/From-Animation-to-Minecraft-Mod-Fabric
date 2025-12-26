package mxa.modid.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mxa.modid.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class EnderAegisShield extends ShieldItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private final boolean isEnderSightActive;

    public EnderAegisShield(Item.Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 30.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 6.2, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 20.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 369.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 40.0, EntityAttributeModifier.Operation.ADD_VALUE));
        this.attributeModifiers = builder.build();
        this.isEnderSightActive = false;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

            if (user.isSneaking()) {
                if (itemStack.isOf(ModItems.ENDER_AEGIS_SHIELD)) {
                    user.setStackInHand(hand, new ItemStack(ModItems.ENDER_AEGIS_SHIELDFB));
                }
                user.setCurrentHand(hand);
            }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    public Object getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers();
    }

    public boolean isEnderSightActive() {
        return this.isEnderSightActive;
    }

    public void activateBarrier(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 4));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 4));
    }

    public void dragonResilience(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 2));
    }

    public void teleportationWard(PlayerEntity player) {
        Box box = player.getBoundingBox().expand(0.0, 5.0, 5.0);
        Iterator var3 = player.getEntityWorld().getEntitiesByType(EntityType.SHULKER, box, (entity) -> {
            return true;
        }).iterator();

        while(var3.hasNext()) {
            ShulkerEntity shulkerEntity = (ShulkerEntity)var3.next();
            shulkerEntity.setTarget(player);
        }

    }

    public void enderSight(PlayerEntity player) {
        Box box = player.getBoundingBox().expand(8.0, 8.0, 8.0);
        player.getEntityWorld().getEntitiesByType(EntityType.ENDERMAN, box, (entity) -> {
            return true;
        }).forEach((entity) -> {
            entity.setGlowing(true);
        });
    }

    public void dimensionalStability(World world) {
        Box box = new Box(-1000.0, -1000.0, -1000.0, 1000.0, 1000.0, 1000.0);
        world.getEntitiesByType(EntityType.ENDERMAN, box, (entity) -> {
            return true;
        }).forEach((entity) -> {
            if (entity instanceof EndermanEntity) {
                entity.setTarget((LivingEntity)null);
            }

        });
    }

    public void enderPulse(PlayerEntity player, World world) {
        try {
            List<HostileEntity> entities = world.getEntitiesByClass(HostileEntity.class, player.getBoundingBox().expand(5.0), (ex) -> {
                return ex instanceof MobEntity && ex.getTarget() == player;
            });
            Iterator var4 = entities.iterator();

            while(var4.hasNext()) {
                HostileEntity entity = (HostileEntity)var4.next();
                double dx = entity.getX() - player.getX();
                double dz = entity.getZ() - player.getZ();
                entity.takeKnockback(3.5, dx, dz);
                entity.addVelocity(dx * 0.8, 1.0, dz * 0.8);
            }
        } catch (Exception var10) {
            Exception e = var10;
            e.printStackTrace();
        }

    }

    public void enderboundProtection(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 1));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600, 1));
    }

    public void handlePlayerInput(PlayerEntity player) {
        if (player.isUsingItem() && player.getActiveItem().getItem() instanceof EnderAegisShield) {
            ItemStack stack = player.getActiveItem();
            Item var4 = stack.getItem();
            if (var4 instanceof EnderAegisShield) {
                EnderAegisShield shield = (EnderAegisShield)var4;
                shield.activateBarrier(player);
                shield.enderboundProtection(player);
                shield.dragonResilience(player);
            }
        }

    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(" ").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.literal("Aegis Herobrine").copy().formatted(Formatting.BOLD));
        tooltip.add(Text.literal(" ").copy().formatted(Formatting.GRAY));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").copy().formatted(Formatting.GREEN));
            tooltip.add(Text.literal(" ").copy().formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Depicts a triangular-shaped shield with a distinctive pattern").copy().formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("in the middle resembling the letter H,  likely short for \"Herobrine\".").copy().formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("It can be expanded to increase its protective range").copy().formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("as well as emitting purple lightning particles.").copy().formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" ").copy().formatted(Formatting.GRAY));
        super.appendTooltip(stack, context, tooltip, type);
    }
}