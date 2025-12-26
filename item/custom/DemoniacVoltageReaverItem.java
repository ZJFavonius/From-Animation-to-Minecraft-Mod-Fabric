package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import mxa.modid.entity.ModEntities;
import mxa.modid.entity.custom.SwordsmanHerobrineEntity;
import mxa.modid.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class DemoniacVoltageReaverItem extends SwordItem {
    public DemoniacVoltageReaverItem(ToolMaterials toolMaterials, Settings settings) {
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
        ItemStack itemStack = user.getStackInHand(hand);

        try {
            if (!world.isClient) {
                if (itemStack.isOf(ModItems.DEMONIAC_VOLTAGE_REAVER)) {
                    user.setStackInHand(hand, new ItemStack(ModItems.DEMONIAC_VOLTAGE_REAVER1));

                    BlockPos pos = user.getBlockPos();
                    world.playSound(null, pos, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.SWORDSMAN_HEROBRINE_EFFECT, 600, 9, true, true, true));
                    BlockPos spawnPos = pos.add(world.random.nextInt(3) - 1, 1, world.random.nextInt(3) - 1);
                    SwordsmanHerobrineEntity herobrine = new SwordsmanHerobrineEntity(ModEntities.SWORDSMAN_HEROBRINE, world);
                    herobrine.refreshPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), user.getYaw(), 0.0F);
                    world.spawnEntity(herobrine);
                    BlockPos userPos = user.getBlockPos();
                    world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double)userPos.getX() + 0.5, (double)userPos.getY() + 0.5, (double)userPos.getZ() + 0.5, 0.0, 0.0, 0.0);
                    this.whipEffect(world, user);
                    }
                }
        } catch (Exception var9) {
            var9.printStackTrace();
            return TypedActionResult.fail(itemStack);
        }

        return TypedActionResult.success(itemStack);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient && entity != null && !(entity instanceof PlayerEntity)) {
            World world = user.getEntityWorld();
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, entity.getSoundCategory(), 1.0F, 1.0F);
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.refreshPositionAfterTeleport(entity.getX(), entity.getY(), entity.getZ());
            world.spawnEntity(lightning);
            if (user instanceof ServerPlayerEntity) {
                lightning.setChanneler((ServerPlayerEntity)user);
            }

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 900, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 900, 6));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 900, 6));
        return super.postHit(stack, target, attacker);
    }

    private void whipEffect(World world, PlayerEntity user) {
        try {
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, user.getBoundingBox().expand(5.0), (ex) -> ex != user);

            for (LivingEntity entity : entities) {
                double dx = entity.getX() - user.getX();
                double dz = entity.getZ() - user.getZ();
                entity.takeKnockback(4.5, dx, dz);
                entity.addVelocity(dx * 0.0, 2.0, dz * 0.0);
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("2nd Form").copy().formatted(Formatting.RED));
        tooltip.add(Text.literal("Swordsman Herobrine").copy().formatted(Formatting.BOLD));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").copy().formatted(Formatting.GREEN));
        tooltip.add(Text.literal(" "));
        tooltip.add(Text.literal("Depicts a large sword with short blade and a long, ").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("single-edged blade. It has two known forms: ").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("the first form is the basic state when not used in combat. ").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("On second form, the sword will extend with a ").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("bizarrely long length, able to be bent at will.").copy().formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal(" "));
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Can summon The Swordsman Herobrine when right-clicked").copy().formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("Use wisely. Remember he is not your ally!").copy().formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.literal("[WARNING!!! MUST READ FIRST BEFORE USING! Press Shift]").formatted(Formatting.RED));
            super.appendTooltip(stack, context, tooltip, type);
        }

    }
}