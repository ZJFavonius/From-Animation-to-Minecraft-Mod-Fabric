package mxa.modid.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ArcaneObsidianShield extends ShieldItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public ArcaneObsidianShield(Item.Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 30.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 6.199999809265137, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 20.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 40.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(ShieldItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 4.0, EntityAttributeModifier.Operation.ADD_VALUE));
        this.attributeModifiers = builder.build();
    }

    public Object getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers();
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Arcane Obsidian").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Shadow Herobrine").copy().formatted(Formatting.GRAY));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").copy().formatted(Formatting.GREEN));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.literal("Small arcane obsidian rods shaped like a shield, allowing").copy().formatted(Formatting.BOLD));
            tooltip.add(Text.literal("the user to block attacks and immune to physical attacks.").copy().formatted(Formatting.BOLD));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));
        super.appendTooltip(stack, context, tooltip, type);
    }
}