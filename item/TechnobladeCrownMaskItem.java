package mxa.modid.item;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class TechnobladeCrownMaskItem extends Item {
    public TechnobladeCrownMaskItem(Settings settings) {
        super(settings);
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

    private void hislegacy(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.TECHNOBLADE_AFTER_EFFECT, 700, 10, true, true, true));
    }

    private boolean isWearingtheCrown(PlayerEntity player) {
        ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
        return headStack.getItem() instanceof TechnobladeCrownMaskItem;
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (this.isWearingtheCrown(player) && player.isSprinting()) {
                this.hislegacy(player);
            }
        }

    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Technothepig").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("Human GPS").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Technoblade Never Dies by Squared Media").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("The Crown of Technoblade is a symbol of his unparalleled").formatted(Formatting.RED));
            tooltip.add(Text.literal("skill and dominance in battle. It represents his status").formatted(Formatting.RED));
            tooltip.add(Text.literal("as a legendary warrior, feared and respected by many.").formatted(Formatting.RED));
            tooltip.add(Text.literal("It is not just a physical object but a testament to his").formatted(Formatting.RED));
            tooltip.add(Text.literal("legacy and the impact he has had on those around him.").formatted(Formatting.RED));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}