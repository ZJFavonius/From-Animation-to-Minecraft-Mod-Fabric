package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RubyGreatswordItem extends SwordItem {
    private static final String[] ELEMENTS = new String[]{"fire", "ice", "lightning", "earth"};

    public RubyGreatswordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
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
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient && attacker instanceof PlayerEntity player) {
            String element = getCurrentElement(stack);
            applyNegativeElementalEffects(target, element, player);
            player.heal(0.25F);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof PlayerEntity player && selected) {
            String element = getCurrentElement(stack);
            applyElementalEffects(player, element);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            cycleElement(stack, user);
        }
        return TypedActionResult.success(stack);
    }

    /** ✅ Proper NBT save using DataComponents (1.21.1) */
    private void cycleElement(ItemStack stack, PlayerEntity player) {
        String current = getCurrentElement(stack);
        int nextIndex = (indexOf(current) + 1) % ELEMENTS.length;
        String next = ELEMENTS[nextIndex];

        NbtCompound tag = getOrCreateTag(stack);
        tag.putString("CurrentElement", next);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(tag));

        player.sendMessage(Text.literal("Element changed to " + next).formatted(getElementColor(next)), true);
    }

    /** ✅ Reads element safely */
    private String getCurrentElement(ItemStack stack) {
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (comp != null) {
            NbtCompound tag = comp.copyNbt();
            if (tag.contains("CurrentElement")) {
                return tag.getString("CurrentElement");
            }
        }
        return "fire";
    }

    /** ✅ Helper for creating or updating the item NBT */
    private NbtCompound getOrCreateTag(ItemStack stack) {
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        return comp != null ? comp.copyNbt() : new NbtCompound();
    }

    private int indexOf(String value) {
        for (int i = 0; i < ELEMENTS.length; ++i) {
            if (ELEMENTS[i].equals(value)) return i;
        }
        return 0;
    }

    /** ✅ Tooltip correctly shows element */
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        String element = getCurrentElement(stack);
        Formatting elementColor = getElementColor(element);

        tooltip.add(Text.literal("Creator Weapon").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("Current Element: " + element).formatted(elementColor));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Notch").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Corrupted Iron Golem").formatted(Formatting.STRIKETHROUGH));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal(""));

        // Hold Shift for more details
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Flaming Strike: Upon striking, ignites foes in searing flames.")
                    .formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("Life Leech: Channels life force of struck enemies to the wielder.")
                    .formatted(Formatting.GREEN));
            tooltip.add(Text.literal("Titan’s Grip: Enhances strength and fortitude of the wielder.")
                    .formatted(Formatting.BLUE));
            tooltip.add(Text.literal("Elemental Mastery: Attunes to elements, shifting between forms with unique abilities.")
                    .formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("Wielder’s Guardian: Empowered with ancient consciousness, aids and protects the wielder.")
                    .formatted(Formatting.BOLD));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for abilities details.").formatted(Formatting.GRAY));
        }

        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }

    private Formatting getElementColor(String element) {
        return switch (element) {
            case "fire" -> Formatting.RED;
            case "ice" -> Formatting.AQUA;
            case "lightning" -> Formatting.YELLOW;
            case "earth" -> Formatting.GREEN;
            default -> Formatting.WHITE;
        };
    }

    private void applyElementalEffects(PlayerEntity player, String element) {
        player.clearStatusEffects();
        switch (element) {
            case "fire" -> {
                player.setFireTicks(0);
                player.setHealth(20.0F);
                player.addStatusEffect(new StatusEffectInstance(ModEffects.FIRE_EFFECT, 200, 5, true, true, true));
            }
            case "ice" -> {
                player.setFrozenTicks(0);
                player.setHealth(20.0F);
                player.addStatusEffect(new StatusEffectInstance(ModEffects.ICE_EFFECT, 200, 5, true, true, true));
            }
            case "lightning" -> {
                player.setHealth(20.0F);
                player.addStatusEffect(new StatusEffectInstance(ModEffects.LIGHTNING_EFFECT, 200, 5, true, true, true));
            }
            case "earth" -> {
                player.setHealth(20.0F);
                player.addStatusEffect(new StatusEffectInstance(ModEffects.EARTH_EFFECT, 200, 5, true, true, true));
            }
        }
    }

    private void applyNegativeElementalEffects(LivingEntity target, String element, PlayerEntity player) {
        World world = player.getWorld();
        switch (element) {
            case "fire" -> {
                target.setOnFireFor(5.0F);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 5));
                if (target instanceof HostileEntity) {
                    FireballEntity fireball = new FireballEntity(EntityType.FIREBALL, world);
                    fireball.setPos(player.getX(), player.getBodyY(0.5) + 0.5, player.getZ());
                    world.spawnEntity(fireball);
                }
            }
            case "ice" -> {
                target.setFrozenTicks(5);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 200, 1));
            }
            case "lightning" -> {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 5));
                if (target instanceof HostileEntity) {
                    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                    lightning.refreshPositionAfterTeleport(target.getPos());
                    world.spawnEntity(lightning);
                }
            }
            case "earth" -> {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 5));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 5));
                if (target instanceof HostileEntity) {
                    EvokerFangsEntity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS, world);
                    evokerFangs.refreshPositionAndAngles(target.getX(), target.getY(), target.getZ(), target.getYaw(), 0.0F);
                    world.spawnEntity(evokerFangs);
                }
            }
        }
    }
}