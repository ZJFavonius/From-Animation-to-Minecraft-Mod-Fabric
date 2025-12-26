package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ScytheItem extends SwordItem {
    private static final String SOULS_COUNT = "HarvestSouls";

    public ScytheItem(ToolMaterials toolMaterials, Settings settings) {
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EnderPearlEntity enderPearl = null;
        if (!world.isClient) {
            enderPearl = new EnderPearlEntity(world, user);
            enderPearl.setPosition(user.getX(), user.getEyeY() - 0.1, user.getZ());
            enderPearl.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            if (user.isSneaking()) {
                enderPearl.setNoGravity(true);
                enderPearl.setCustomName(Text.of("Explosive Pearl"));
                enderPearl.setCustomNameVisible(false);
                if (!world.isClient && world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)world;
                    HitResult hitResult = user.raycast(20.0, 0.0F, false);
                    if (hitResult.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHitResult = (BlockHitResult)hitResult;
                        BlockPos targetPos = blockHitResult.getBlockPos();
                        serverWorld.createExplosion(user, (double)targetPos.getX(), (double)targetPos.getY(), (double)targetPos.getZ(), 2.0F, World.ExplosionSourceType.NONE);
                    }
                }
            }

            world.spawnEntity(enderPearl);
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
        } else {
            DragonFireballEntity dragonFireball = new DragonFireballEntity(EntityType.DRAGON_FIREBALL, world);
            dragonFireball.setPosition(user.getX(), user.getEyeY() - 1.1, user.getZ());
            dragonFireball.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(dragonFireball);
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.VOID_STRIKE_EFFECT, 200, 10, true, true, true));
        if (attacker instanceof PlayerEntity player) {
            if (player instanceof PlayerEntity) {
                Vec3d targetPos = target.getPos();
                player.teleport(targetPos.x, targetPos.y + 1.0, targetPos.z, true);
            }

            if (target.isDead()) {
                this.soulReap(stack, player);
            }

            this.applyCurseOfDecay(target);
            this.applyRealityDistortion(target);
            this.spawnNightmareAura(player);
        }

        return super.postHit(stack, target, attacker);
    }

    public void soulReap(ItemStack stack, PlayerEntity player) {
        NbtCompound nbt = stack.get(null);

        assert nbt != null;

        int souls = nbt.getInt(SOULS_COUNT);
        nbt.putInt(SOULS_COUNT, souls + 1);
        nbt.putFloat("BonusDamage", (float)souls * 0.2F);
        player.sendMessage(Text.of("Soul absorbed! Total souls: " + (souls + 1)), true);
    }

    public void applyCurseOfDecay(LivingEntity target) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 1));
    }

    public void applyRealityDistortion(LivingEntity target) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1));
    }

    public void spawnNightmareAura(PlayerEntity player) {
        World world = player.getWorld();
        if (!world.isClient) {
            AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, player.getX(), player.getY(), player.getZ());
            cloud.addEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
            cloud.addEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1));
            cloud.setDuration(100);
            cloud.setRadius(3.0F);
            world.spawnEntity(cloud);
        }

    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Entity Scythe").formatted(Formatting.WHITE));
        tooltip.add(Text.literal("Entity303's signature scythe").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Entity303").formatted(Formatting.WHITE));
        tooltip.add(Text.literal(""));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From Animation Life by Squared Media").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("The scythe was discovered by Entity 303 in his relentless").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("quest for vengeance against the Minecraft world.").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Its creation is tied to the corruption and manipulation").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("of code. As a symbol of his dominion, the scythe grants").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Entity303 unparalleled control over the forces of darkness,").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("making him a formidable adversary to any who oppose him.").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        NbtCompound nbt = (NbtCompound)stack.get((ComponentType)null);
        int souls = nbt != null ? nbt.getInt("HarvestSouls") : 0;
        tooltip.add(Text.literal("Caught Souls: " + souls).formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}