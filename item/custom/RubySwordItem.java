package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class RubySwordItem extends SwordItem {
     public RubySwordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
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

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        target.setFireTicks(100);
        if (attacker instanceof PlayerEntity player) {
            player.heal(5.0F);
        }

        target.takeKnockback(2.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        if (!world.isClient) {
            MinecraftClient.getInstance().particleManager.addEmitter(target, ParticleTypes.FLAME, 10);
        }

        if (attacker instanceof PlayerEntity player) {
            player.sendMessage(Text.of("Incinerate"), true);
        }

        return super.postHit(stack, target, attacker);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.NOTCH_PROTECTION_EFFECT, 700, 10, true, true, true));
            if (player.getHealth() <= 4.0F) {
                world.getEntitiesByClass(LivingEntity.class, player.getBoundingBox().expand(5.0), (e) -> {
                    return e != player;
                }).forEach((e) -> {
                    e.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 10, true, true, true));
                });
                world.getEntitiesByClass(LivingEntity.class, player.getBoundingBox().expand(5.0), (e) -> {
                    return e != player;
                }).forEach((e) -> {
                    e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 10, true, true, true));
                });
                world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Creator Weapon").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Notch").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("BoopNotch").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("A legendary sword forged from the rarest rubies, imbued with ancient magic.").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Once wielded by the great heroes who saved the kingdom from eternal darkness.").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Its blade burns with the flames of a thousand suns, scorching all who stand in its way.").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}