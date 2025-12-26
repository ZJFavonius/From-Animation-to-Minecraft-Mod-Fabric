package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class RubyLongswordItem extends SwordItem implements tick {
    public RubyLongswordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(100);
        attacker.heal(2.0F);
        return super.postHit(stack, target, attacker);
    }

    private DamageSource setBypassesArmor() {
        return null;
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

    public void inventoryTick(ItemStack stack, World world, LivingEntity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof PlayerEntity player) {
            if (selected) {
                if (player.isOnFire()) {
                    player.heal(5.0F);
                    player.extinguish();
                }

                if (player.getHealth() <= 2.0F && !player.getWorld().isClient) {
                    this.phoenixRebirth(player, stack);
                }
            }
        }

    }

    private void phoenixRebirth(PlayerEntity player, ItemStack stack) {
        player.setOnFireFor(10.0F);
        player.heal(20.0F);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
        player.playSound(SoundEvents.ENTITY_BLAZE_BURN, 1.0F, 1.0F);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            this.infernoStrike(user);
        }

        return TypedActionResult.success(stack);
    }

    private void infernoStrike(PlayerEntity user) {
        World world = user.getWorld();
        Vec3d position = user.getPos();
        Iterator var4 = world.getEntitiesByClass(LivingEntity.class, new Box(position.add(-5.0, -5.0, -5.0), position.add(5.0, 5.0, 5.0)), (e) -> {
            return e != user;
        }).iterator();

        while(var4.hasNext()) {
            LivingEntity entity = (LivingEntity)var4.next();
            entity.setOnFireFor(10.0F);
            entity.damage(setBypassesArmor(), 10.0F);
        }

        world.playSound((PlayerEntity)null, user.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Creator Weapon").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("X_Grave_X").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("UnityPusheen").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("Greg").formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("The Ruby Longsword is one of the Creator Weapons, said").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("to be forged by the Gods themselves. It was once wielded by").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("legendary heroes who defended their realms from darkness. The").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("sword has seen countless battles and has absorbed the essence of many").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("fallen foes, making it one of the most powerful weapons in existence.").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("This Ruby Longsword stands as a testament to the legacy of the heroes").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("who once wielded it, and now waits for its next champion to rise and").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("continue the fight against the forces of darkness.").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}