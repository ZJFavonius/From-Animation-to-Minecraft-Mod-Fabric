package mxa.modid.item;

import com.google.common.collect.ImmutableMultimap;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class SanjiBlackLegItem extends ArmorItem {

    public SanjiBlackLegItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
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

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Diable Jambe").formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("Sky Walk").formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Red Leg Zeff").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Sanji").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("\uD83D\uDC80NE P\uD83E\uDDCDEC€").formatted(Formatting.DARK_BLUE));
            tooltip.add(Text.literal("Sanji's \"Black Leg Style\" is a kick-based").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("fighting style taught to him by his mentor,").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("\"Red Leg\" Zeff. The \"Sky Walk\" is a movement").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("technique Sanji developed to run through the air").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("by kicking the air itself. Both techniques are").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("essential to Sanji's fighting style, which").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("emphasizes kicks to keep his hands free for cooking.").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }

}