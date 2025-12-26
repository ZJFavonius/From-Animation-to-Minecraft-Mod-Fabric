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

public class TechnobladeRobeItem extends ArmorItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public TechnobladeRobeItem(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "armor_modifier"), 200.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "knockback_resistance"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "max_health"), 90.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_damage"), 777.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_knockback"), 50.0, EntityAttributeModifier.Operation.ADD_VALUE));
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

    private void hislegend(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.TECHNOBLADE_AFTER_EFFECT, 700, 10, true, true, true));
    }

    private boolean isWearingtheRobe(PlayerEntity player) {
        ItemStack chestStack = player.getEquippedStack(EquipmentSlot.CHEST);
        return chestStack.getItem() instanceof TechnobladeRobeItem;
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (this.isWearingtheRobe(player) && player.isSneaking()) {
                this.hislegend(player);
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
            tooltip.add(Text.literal("This regal garment signifies his rightful place as a leader").formatted(Formatting.RED));
            tooltip.add(Text.literal("and a champion, adorned with intricate designs that reflect").formatted(Formatting.RED));
            tooltip.add(Text.literal("his victories and achievements. It complements the Crown of").formatted(Formatting.RED));
            tooltip.add(Text.literal("Technoblade, together representing his complete dominion over the").formatted(Formatting.RED));
            tooltip.add(Text.literal("battlefield and his enduring legacy as a warrior who never falters.").formatted(Formatting.RED));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}