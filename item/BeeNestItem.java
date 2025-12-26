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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class BeeNestItem extends ArmorItem {

    public BeeNestItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "armor_modifier"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "knockback_resistance"), 4.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "max_health"), 1000.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_damage"), 10.0, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK.value(), new EntityAttributeModifier(Identifier.of("minecraft_x_animation", "attack_knockback"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof net.minecraft.entity.player.PlayerEntity player) {
            if (player.getEquippedStack(this.type.getEquipmentSlot()).getItem() == this) {
                if (world.getTime() % 200 == 0) {
                    world.playSound(
                            null,
                            player.getBlockPos(),
                            SoundEvents.ENTITY_BEE_LOOP,
                            SoundCategory.PLAYERS,
                            0.6f,
                            1.0f
                    );
                }
            }
        }
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
        tooltip.add(Text.literal("[COMMON][RARE]").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("♦30% chance to summon").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("a bee when hit (max 3)").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("♦Health potions heal nearby allies").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Type:").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("Armor").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("MINECRAFT DUNGEONS").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("There always seems to be a").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("slight buzz around the Beenest").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Armor. Or maybe the buzz is").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("coming from within?").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Runes:").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("д߂").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("Enchantment:").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}