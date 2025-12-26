package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import mxa.modid.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;

public class VenomGlaiveItem extends SwordItem {
    public VenomGlaiveItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }
    private void itemPresent(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.POISON_CLOUD_EFFECT, 700, 2, true, true, true));
    }

    private boolean insideInventory(PlayerEntity player) {
        ItemStack headStack = player.getEquippedStack(EquipmentSlot.MAINHAND);
        return headStack.getItem() instanceof VenomGlaiveItem;
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
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (insideInventory(player) && player.isSprinting()) {
                itemPresent(player);
            }
        }

        world.addParticle(
                new DustParticleEffect(new Vector3f(0.0F, 1.0F, 0.0F), 1.0F), // Green color
                entity.getX() + 0.5,
                entity.getY() + 0.5,
                entity.getZ() + 0.5,
                0.0, 0.0, 0.0
        );


    super.inventoryTick(stack, world, entity, slot, selected);
}

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        return 12;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(3, attacker, EquipmentSlot.MAINHAND);
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);

        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        // Fetch the enchantment registry lookup
        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        addEnchantment(stack, enchantmentLookup);
    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup) {
        lookup.getOptional(ModEnchantments.POISON_CLOUD).ifPresent(entry -> stack.addEnchantment(entry, 3));
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("[UNIQUE]").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("◆Spawns poison clouds").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Damage type:").formatted(Formatting.RED));
        tooltip.add(Text.literal("Melee Poison").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("MINECRAFT DUNGEONS").formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("A toxic cloud seems to follow").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal("the Venom Glaive wherever it goes...").formatted(Formatting.DARK_GREEN));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Runes:").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Лਠ").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("Enchantment:").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}