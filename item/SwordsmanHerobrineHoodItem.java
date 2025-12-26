package mxa.modid.item;

import com.google.common.collect.ImmutableMultimap;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class SwordsmanHerobrineHoodItem extends ArmorItem {

    public SwordsmanHerobrineHoodItem(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "armor_modifier"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "knockback_resistance"), 4.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "max_health"), 1000.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_damage"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_knockback"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE));
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
        tooltip.add(Text.literal("Swordsman Herobrine").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Cursed hood from Swordsman Herobrine").formatted(Formatting.RED));
        tooltip.add(Text.literal("Cursed with curse of binding.").formatted(Formatting.RED));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack headStack = user.getEquippedStack(EquipmentSlot.HEAD);
        if (headStack.isEmpty()) {
            user.equipStack(EquipmentSlot.HEAD, stack.copy());
            stack.decrement(1);
            return TypedActionResult.success(user.getEquippedStack(EquipmentSlot.HEAD), world.isClient());
        } else {
            return TypedActionResult.success(stack, world.isClient());
        }
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);

        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        addEnchantment(stack, enchantmentLookup, Enchantments.BINDING_CURSE, 1);
        addEnchantment(stack, enchantmentLookup, Enchantments.RESPIRATION, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.PROTECTION, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.THORNS, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.AQUA_AFFINITY, 10);
    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup, RegistryKey<Enchantment> enchantmentKey, int level) {
        lookup.getOptional(enchantmentKey).ifPresent(entry -> stack.addEnchantment(entry, level));
    }
}