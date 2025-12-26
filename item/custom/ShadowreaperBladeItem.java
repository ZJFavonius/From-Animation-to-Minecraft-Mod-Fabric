package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ShadowreaperBladeItem extends SwordItem {
    public ShadowreaperBladeItem(ToolMaterials toolMaterials, Settings settings) {
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

    public void Shadowslash(LivingEntity target) {
        target.damage(setBypassesArmor(), 20.0F);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1000, 6));
    }

    private DamageSource setBypassesArmor() {
        return null;
    }

    public void HerobrineCurse(LivingEntity target) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 2000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 2000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 2000, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 2000, 6));
    }

    private boolean isHostileEntity(LivingEntity entity) {
        return entity instanceof HostileEntity;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient && player.isSneaking()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000, 13));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1000, 3));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 19));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 19));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 19));
            return TypedActionResult.success(player.getStackInHand(hand));
        } else {
            Vec3d startVec = player.getCameraPosVec(1.0F);
            Vec3d lookVec = player.getRotationVec(1.0F);
            startVec.add(lookVec.multiply(5.0));
            HitResult hitResult = player.raycast(5.0, 1.0F, false);
            if (hitResult.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult)hitResult;
                Entity var10 = entityHitResult.getEntity();
                if (var10 instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity)var10;
                    if (this.isHostileEntity(target)) {
                        this.Shadowslash(target);
                        return TypedActionResult.success(player.getStackInHand(hand));
                    }
                }
            }

            return super.use(world, player, hand);
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            this.HerobrineCurse(target);
        }

        return super.postHit(stack, target, attacker);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("This blade emanates dark energy...").copy().formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("From Imagination by Anonymous").copy().formatted(Formatting.WHITE));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("It is a sinister weapon forged from the darkest").copy().formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("corners of the Minecraft universe. Its sleek, obsidian").copy().formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("blade shimmers with an eerie purple glow, hinting at").copy().formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("the malevolent power infused within. Legends say that").copy().formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("the blade is imbued with the essence of Herobrine").copy().formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("himself, granting its wielder terrifying abilities.").copy().formatted(Formatting.DARK_BLUE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));
        super.appendTooltip(stack, context, tooltip, type);
    }
}