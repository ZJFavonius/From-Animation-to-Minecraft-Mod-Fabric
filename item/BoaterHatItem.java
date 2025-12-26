package mxa.modid.item;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class BoaterHatItem extends Item {

    public BoaterHatItem(Settings settings) {
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

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Black Top Hat").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));

        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Sabo").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("\uD83D\uDC80NE P\uD83E\uDDCDEC€").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("Sabo's hat is primarily tied to his").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("noble heritage, his rejection of that").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("status, and his role in the Revolutionary Army.").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);
        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        addEnchantment(stack, enchantmentLookup, Enchantments.LOYALTY, 1);
        addEnchantment(stack, enchantmentLookup, Enchantments.RESPIRATION, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.PROTECTION, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.THORNS, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.AQUA_AFFINITY, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.UNBREAKING, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.MENDING, 10);
    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup, RegistryKey<Enchantment> enchantmentKey, int level) {
        lookup.getOptional(enchantmentKey).ifPresent(entry -> stack.addEnchantment(entry, level));
    }
}