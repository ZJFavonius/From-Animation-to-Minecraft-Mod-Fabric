package mxa.modid.item;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class DinnerboneHatItem extends Item {
    public DinnerboneHatItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 100;
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        return true;
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Dinnerbone").formatted(Formatting.DARK_BLUE));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("A legendary hat with mystical powers.").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Grants the wearer enhanced agility and protection.").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);
        EquipmentSlot slot = EquipmentSlot.HEAD;
        ItemStack headStack = user.getEquippedStack(slot);

        if (!world.isClient) {
            // Swap the items properly (no copy)
            user.equipStack(slot, handStack);
            user.setStackInHand(hand, headStack);
            user.playSound((SoundEvent) SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 1.0F);
        }

        return TypedActionResult.success(handStack, world.isClient());
    }

    private boolean isWearingDinnerboneHelmet(PlayerEntity player) {
        ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
        return headStack.getItem() instanceof DinnerboneHatItem;
    }

    public void overseerShockBlast(PlayerEntity player, World world) {
        Vec3d pos = player.getPos();
        List<HostileEntity> entities = world.getEntitiesByClass(HostileEntity.class, player.getBoundingBox().expand(5.0), (e) -> {
            return e instanceof HostileEntity && e.getTarget() == player;
        });

        HostileEntity entity;
        for(Iterator var5 = entities.iterator(); var5.hasNext(); entity.velocityModified = true) {
            entity = (HostileEntity)var5.next();
            Vec3d direction = entity.getPos().subtract(pos).normalize().multiply(5.0);
            entity.addVelocity(direction.x, direction.y, direction.z);
        }

    }

    public static void heavyEndurance(PlayerEntity player, World world) {
        ItemStack offhandStack = player.getOffHandStack();
        if (offhandStack.getItem() instanceof DinnerboneHatItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 5, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 5, true, true, true));
        }

    }

    private void flight(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.DINNERBONE_ROLE, 200, 10, true, true, true));
        player.playSound(SoundEvents.ENTITY_SHULKER_OPEN, 1.0F, 1.0F);
    }

    private void overseerHyperSpeed(PlayerEntity player, World world) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.DINNERBONE_PLAY, 300, 10, true, true, true));
        world.playSound((PlayerEntity)null, player.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_FLAP, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (this.isWearingDinnerboneHelmet(player)) {
                if (player.isSneaking()) {
                    this.flight(player);
                } else if (player.isSprinting()) {
                    this.overseerHyperSpeed(player, world);
                }
            }
        }

    }
}