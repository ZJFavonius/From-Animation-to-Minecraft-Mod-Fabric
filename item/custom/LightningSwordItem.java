package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class LightningSwordItem extends SwordItem {
    public LightningSwordItem(ToolMaterials toolMaterials, Settings settings) {
            super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            BlockPos pos = user.getBlockPos();
            world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.addStatusEffect(new StatusEffectInstance(ModEffects.HEROBRINE_LIGHTNING_EFFECT, 600, 9, true, true, true));
        }

        return super.use(world, user, hand);
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

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient && entity != null && !(entity instanceof PlayerEntity)) {
            World world = user.getEntityWorld();
            world.playSound((PlayerEntity)null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, entity.getSoundCategory(), 1.0F, 1.0F);
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.refreshPositionAfterTeleport(entity.getX(), entity.getY(), entity.getZ());
            world.spawnEntity(lightning);
            if (user instanceof ServerPlayerEntity) {
                lightning.setChanneler((ServerPlayerEntity)user);
            }

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Right-click to summon lightning and smite your foes.").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Herobrine").copy().formatted(Formatting.BLUE));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
        tooltip.add(Text.literal("From Animation Life by Squared Media").copy().formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Forged by Herobrine himself, this sword harnesses the").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("power of the storm. It was forged in the heart of a raging").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("thunderstorm, Herobrine's Lightning Sword crackles with the raw power").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("of the skies. This legendary blade, often whispered about in the").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("darkest corners of the Minecraft world, is as feared as its wielder.").copy().formatted(Formatting.YELLOW));
        tooltip.add(Text.literal(" "));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}