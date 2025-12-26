package mxa.modid.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class EnderglaiveItem extends SwordItem {
    private static final int TELEPORT_COOLDOWN = 100;
    private static final int VOID_SLASH_COOLDOWN = 60;
    private static final int ENDER_SHIELD_DURATION = 200;
    public static final int LEVITATION_DURATION = 100;

    public EnderglaiveItem(ToolMaterials netherite, Settings settings) {
        super(ToolMaterials.NETHERITE, settings);
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
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            if (user.isSneaking()) {
                this.teleport(world, user);
                user.getItemCooldownManager().set(this, 100);
            } else {
                this.activateVoidSlash(world, user);
                user.getItemCooldownManager().set(this, 60);
            }
        }

        return TypedActionResult.success(stack);
    }

    private void teleport(World world, PlayerEntity player) {
        Vec3d lookVec = player.getRotationVec(1.0F);
        Vec3d newPos = player.getPos().add(lookVec.multiply(20.0));
        player.requestTeleport(newPos.x, newPos.y, newPos.z);
        player.fallDistance = 0.0F;
        BlockPos pos = player.getBlockPos();
        world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    private void activateVoidSlash(World world, PlayerEntity user) {
        try {
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, user.getBoundingBox().expand(5.0), (ex) -> {
                return ex != user;
            });
            Iterator var4 = entities.iterator();

            while(var4.hasNext()) {
                LivingEntity entity = (LivingEntity)var4.next();
                double dx = entity.getX() - user.getX();
                double dz = entity.getZ() - user.getZ();
                entity.takeKnockback(4.5, dx, dz);
                entity.addVelocity(dx * 0.0, 1.0, dz * 0.0);
            }
        } catch (Exception var10) {
            Exception e = var10;
            e.printStackTrace();
        }

        BlockPos pos = user.getBlockPos();
        world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.activateEnderShield(attacker);
        return super.postHit(stack, target, attacker);
    }

    private void activateEnderShield(LivingEntity entity) {
        if (entity instanceof ServerPlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 600, true, true, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 600, true, true, true));
        }

    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (selected && player.isSneaking()) {
                this.activateLevitation(player);
            }
        }

    }

    private void activateLevitation(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 0, true, true, true));
        player.playSound(SoundEvents.ENTITY_SHULKER_OPEN, 1.0F, 1.0F);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        tooltip.add(Text.literal("Glaive Herobrine").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.BLUE));
            tooltip.add(Text.literal("Depicts a long pole weapon with a single-edged").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.literal("blade and protrusions on the straight side of the blade.").formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal("").formatted(Formatting.BLUE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}