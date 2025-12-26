package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import mxa.modid.entities.CustomWolfEntity;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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

public class IronDaggerItem extends SwordItem {
    public IronDaggerItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (player.isSneaking()) {
            this.spectralCommand(world, player);
            this.werewolfsWrath(world, player);
            BlockPos pos = player.getBlockPos();
            world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_WOLF_HOWL, SoundCategory.PLAYERS, 1.0F, 1.0F);
        } else {
            this.lunarRestoration(player);
            this.silentFury(player);
        }

        return TypedActionResult.success(itemStack);
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

    private void shadowStrike(LivingEntity target) {
        if (target.getWorld().isNight()) {
            target.damage(setBypassesArmor(), 10.0F);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 6));
        }

    }

    private DamageSource setBypassesArmor() {
        return null;
    }

    private void silentFury(LivingEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100, 10, true, false, true));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 6));
    }

    private void lunarRestoration(LivingEntity player) {
        if (player.getWorld().isNight()) {
            player.heal(5.0F);
        }

    }

    private void spectralCommand(World world, PlayerEntity player) {
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld)world;
            CustomWolfEntity wolf = CustomWolfEntity.create(world, player);
            serverWorld.spawnEntity(wolf);
        }

    }

    private void werewolfsWrath(World world, PlayerEntity player) {
        if (world.isNight()) {
            player.sendMessage(Text.of("You're becoming less of a human and more of a beast"), true);
            player.addStatusEffect(new StatusEffectInstance(ModEffects.WEREWOLFS_WRATH_EFFECT, 200, 10, true, true, true));
        }

    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.shadowStrike(target);
        return super.postHit(stack, target, attacker);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Horvat the Werewolf").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal(""));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From Animation Life by Squared Media").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("This dagger is a tool of silent death and unwavering loyalty.").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Its true power was revealed in the hands of a master.").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("The dagger's dark enchantments always whispers, a").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("constant reminder of the price of the power and allegiance.").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }
}