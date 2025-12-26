package mxa.modid.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class TechnobladeCrownItem extends ArmorItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public TechnobladeCrownItem(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "technoblade_crown"), 100.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "technoblade_crown"), 9.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "technoblade_crown"), 80.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "technoblade_crown"), 555.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "technoblade_crown"), 40.0, EntityAttributeModifier.Operation.ADD_VALUE));
        this.attributeModifiers = builder.build();
    }

    public Object getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.HEAD ? this.attributeModifiers : super.getAttributeModifiers();
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
        return headStack.getItem() instanceof TechnobladeCrownItem;
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (this.isWearingtheCrown(player) && player.isSprinting()) {
                this.hislegacy(player);
            }
        }

    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
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