package mxa.modid.item.custom;

import mxa.modid.entities.CustomEndermanEntity;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class ObsidianSledgehammerItem extends AxeItem {
    public ObsidianSledgehammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, settings);
    }

    public ObsidianSledgehammerItem(ToolMaterials toolMaterials, Settings settings) {
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

    public void activateShadowStep(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 400, 6));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 3));
        player.sendMessage(Text.of("Surprise Attack"), true);
        this.shadowStep(player);
    }

    public void activateSpectralSummoning(World world, PlayerEntity player) {
        if (!world.isClient) {
            player.sendMessage(Text.of("You've Got a Friend in Me"), true);
            this.spectralSummoning(player.getWorld(), player);
        }

    }

    public void activateEclipseFury(PlayerEntity player) {
        if (player.getWorld().isNight()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 6));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 6));
            player.sendMessage(Text.of("Feel the Fury"), true);
            this.eclipseFury(player);
        }

    }

    private void applyShadowStrike(LivingEntity target) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 5));
    }

    private void shatterReality(World world, LivingEntity user) {
        try {
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, user.getBoundingBox().expand(5.0), (ex) -> {
                return ex != user && ex instanceof MobEntity && ((MobEntity)ex).getTarget() == user;
            });
            Iterator var4 = entities.iterator();

            while(var4.hasNext()) {
                LivingEntity entity = (LivingEntity)var4.next();
                double dx = entity.getX() - user.getX();
                double dz = entity.getZ() - user.getZ();
                entity.takeKnockback(8.5, dx, dz);
                entity.addVelocity(dx * 2.1, 2.1, dz * 2.1);
            }
        } catch (Exception var10) {
            Exception e = var10;
            e.printStackTrace();
        }

    }

    private void soulDevourer(LivingEntity user) {
        user.heal(10.0F);
    }

    private void darkenedShield(LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 9000, 4));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 9000, 4));
    }

    private void nightmareAura(LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 5));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 5));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 5));
    }

    private void eclipseFury(LivingEntity user) {
        boolean isEclipse = true;
        if (isEclipse) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 6));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 6));
        }

    }

    private void shadowStep(PlayerEntity player) {
        double maxDistance = 100.0;
        Vec3d startVec = player.getCameraPosVec(1.0F);
        Vec3d lookVec = player.getRotationVec(1.0F);
        Vec3d endVec = startVec.add(lookVec.multiply(maxDistance));
        HitResult hitResult = player.getWorld().raycast(new RaycastContext(startVec, endVec, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos hitPos = ((BlockHitResult)hitResult).getBlockPos();
            this.teleportPlayerTo(player, (double)hitPos.getX(), (double)hitPos.getY(), (double)hitPos.getZ());
        } else if (hitResult.getType() == HitResult.Type.MISS) {
            Vec3d hitVec = hitResult.getPos();
            this.teleportPlayerTo(player, hitVec.x, hitVec.y, hitVec.z);
        } else {
            player.sendMessage(Text.of("No valid teleport destination found"), true);
        }

    }

    private void teleportPlayerTo(PlayerEntity player, double x, double y, double z) {
        double safeY = this.findSafeYPosition(player.getWorld(), x, y, z);
        player.requestTeleport(x, safeY, z);
    }

    private double findSafeYPosition(World world, double x, double y, double z) {
        BlockPos pos;
        for(pos = new BlockPos((int)x, (int)y, (int)z); !world.isAir(pos) && pos.getY() < world.getTopY(); pos = pos.up()) {
        }

        while(!world.isAir(pos) && pos.getY() > world.getBottomY()) {
            pos = pos.down();
        }

        return (double)pos.getY();
    }

    private void spectralSummoning(World world, PlayerEntity player) {
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld)world;
            CustomEndermanEntity ally = CustomEndermanEntity.create(serverWorld, player);
            serverWorld.spawnEntity(ally);
        }

    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            BlockPos userPos;
            if (user.isSneaking()) {
                userPos = user.getBlockPos();
                world.playSound((PlayerEntity)null, userPos, SoundEvents.ENTITY_ENDERMAN_AMBIENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                world.addParticle(ParticleTypes.SONIC_BOOM, (double)userPos.getX() + 0.5, (double)userPos.getY() + 0.5, (double)userPos.getZ() + 0.5, 0.0, 0.0, 0.0);
                this.shatterReality(world, user);
                this.darkenedShield(user);
                this.activateSpectralSummoning(world, user);
            } else {
                userPos = user.getBlockPos();
                world.playSound((PlayerEntity)null, userPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                world.addParticle(ParticleTypes.ELECTRIC_SPARK, (double)userPos.getX() + 0.5, (double)userPos.getY() + 0.5, (double)userPos.getZ() + 0.5, 0.0, 0.0, 0.0);
                this.activateShadowStep(user);
            }
        }

        return new TypedActionResult(ActionResult.SUCCESS, stack);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            this.activateEclipseFury(player);
            this.applyShadowStrike(target);
            this.nightmareAura(target);
            this.soulDevourer(player);
        }

        return super.postHit(stack, target, attacker);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Sledgehammer Herobrine").copy().formatted(Formatting.BOLD));
        tooltip.add(Text.literal(" "));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").copy().formatted(Formatting.GREEN));
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.literal("Depicts a large hammer entirely composed of").copy().formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("crying obsidian. It can deal massive").copy().formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("knockback upon impact with the opponent.").copy().formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(" "));
        super.appendTooltip(stack, context, tooltip, type);
    }
}