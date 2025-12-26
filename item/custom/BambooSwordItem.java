package mxa.modid.item.custom;

import mxa.modid.entities.CustomPandaEntity;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class BambooSwordItem extends SwordItem {
    public BambooSwordItem(ToolMaterials toolMaterials, Settings settings) {
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
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(10, attacker, EquipmentSlot.MAINHAND);
    }

    public void summonbackup(World world, PlayerEntity player) {
        if (!world.isClient) {
            player.sendMessage(Text.of("Panda Summoned"), true);
            pandaAllies(player.getWorld(), player);
        }

    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            BlockPos userPos = user.getBlockPos();
            world.playSound((PlayerEntity)null, userPos, SoundEvents.ENTITY_PANDA_AMBIENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            summonbackup(world, user);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private void pandaAllies(World world, PlayerEntity player) {
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld)world;
            CustomPandaEntity ally = CustomPandaEntity.create(serverWorld, player);
            serverWorld.spawnEntity(ally);
        }

    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("[MYTHIC]").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("♦Summons Panda Allies").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Damage type:").formatted(Formatting.RED));
        tooltip.add(Text.literal("Melee").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("MINECRAFT DUNGEONS(Custom)").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Panda's favorite food.").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.literal("Also a protective weapon.").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Runes:").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("δл").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.literal("Enchantment:").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}