package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class FishSwordItem extends SwordItem {
    public FishSwordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(10, attacker, EquipmentSlot.MAINHAND);
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

    public boolean postHit(ItemStack stack, LivingEntity user, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 5, true, true, true));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 5, true, true, true));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 300, 5, true, true, true));
        if (attacker instanceof PlayerEntity) {
            Vec3d targetPos = attacker.getPos();
            attacker.teleport(targetPos.x, targetPos.y + 1.0, targetPos.z, true);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 10, true, true, true));
        }

        double dx = 0.0;
        double dz = 0.0;
        attacker.takeKnockback(4.5, dx, dz);
        attacker.addVelocity(dx * 0.0, 4.0, dz * 0.0);
        return super.postHit(stack, user, attacker);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Friend/Weapon").formatted(Formatting.GOLD));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Derp").formatted(Formatting.GOLD));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("From Animation Life by Squared Media").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Use to slap enemies or friends for fun.").formatted(Formatting.AQUA));
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
