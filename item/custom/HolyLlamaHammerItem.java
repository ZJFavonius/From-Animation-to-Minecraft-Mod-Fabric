package mxa.modid.item.custom;

import mxa.modid.entities.CustomLlamaEntity;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
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

import java.util.Iterator;
import java.util.List;

public class HolyLlamaHammerItem extends AxeItem {
    public HolyLlamaHammerItem(ToolMaterials toolMaterials, Settings settings) {
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

    public void summonbackup(World world, PlayerEntity player) {
        if (!world.isClient) {
            player.sendMessage(Text.of("You've been Blessed"), true);
            blessingoftheLlama(player.getWorld(), player);
        }

    }

    private void blessingoftheLlama(World world, PlayerEntity player) {
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld)world;
            CustomLlamaEntity ally = CustomLlamaEntity.create(serverWorld, player);
            serverWorld.spawnEntity(ally);
        }

    }
    private DamageSource setBypassesArmor() {
        return null;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof HostileEntity) {
            target.damage(setBypassesArmor(), 10.0F);
        }

        World world = attacker.getWorld();
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, attacker.getBoundingBox().expand(5.0), (entityx) -> {
            return entityx != attacker && entityx.isAlive() && !(entityx instanceof MobEntity);
        });
        Iterator var6 = entities.iterator();

        while(var6.hasNext()) {
            LivingEntity entity = (LivingEntity)var6.next();
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 10));
        }

        target.takeKnockback(4.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        return super.postHit(stack, target, attacker);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            BlockPos userPos = user.getBlockPos();
            world.playSound((PlayerEntity)null, userPos, SoundEvents.ENTITY_LLAMA_AMBIENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            summonbackup(world, user);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && selected && entity instanceof LivingEntity livingEntity) {
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, livingEntity.getBoundingBox().expand(5.0), (ex) -> {
                return ex != livingEntity && ex.isAlive() && !(ex instanceof MobEntity);
            });
            Iterator var8 = entities.iterator();

            while(var8.hasNext()) {
                LivingEntity e = (LivingEntity)var8.next();
                e.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 5));
            }

            super.inventoryTick(stack, world, entity, slot, true);
        }

    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Holy Llama Hammer").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Steve the Llama").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Miley has a temper").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Miley stands as a testament to the enduring legacy of the llama").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("guardians, a symbol of hope for generations yet to come.").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}