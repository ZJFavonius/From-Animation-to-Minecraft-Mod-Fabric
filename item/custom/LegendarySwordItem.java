package mxa.modid.item.custom;

import mxa.modid.effect.ModEffects;
import mxa.modid.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.DataPackContents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LegendarySwordItem extends SwordItem {
    private static final long MOVEMENT_DURATION = 3600L;
    private static final long COOLDOWN_DURATION = 3600L;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private UUID playerUUID;
    private long movementEndTime;
    private long cooldownEndTime;
    private static final Random random = new Random();

    public LegendarySwordItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return super.canMine(state, world, pos, miner);
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return 10000.0F;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (player.experienceLevel < 30) {
                player.dropItem(this.split(1), true);
                player.sendMessage(Text.literal("Level 30 required to use this item.").formatted(Formatting.RED), true);
                return false;
            }
            if (stack.hasEnchantments()) {
                // Fetch the enchantment registry lookup
                DataPackContents server = null;
                RegistryEntryLookup<Enchantment> enchantmentLookup =
                        server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

                int energyLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.ENERGY), stack);
                int heavyAttackLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.HEAVY_ATTACK), stack);
                int arrowDeflectionLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.ARROW_DEFLECTION), stack);
                int protectionLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.PROTECTION), stack);
                int quickdrawLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.QUICKDRAW), stack);
                int possessionLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.POSSESSION), stack);
                int holyBlessingLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.HOLY_BLESSING), stack);
                int experienceLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.EXPERIENCE_3230), stack);
                int learningLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.LEARNING_547), stack);
                int unknownLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.UNKNOWN), stack);
                int errorLevel = EnchantmentHelper.getLevel(getEnchantment(enchantmentLookup, ModEnchantments.ERROR_785A), stack);

                if (energyLevel > 0) energy(attacker);
                if (heavyAttackLevel > 0) heavyAttack(stack, target);
                if (arrowDeflectionLevel > 0) arrowDeflection(attacker, target);
                if (protectionLevel > 0) protection(attacker);
                if (quickdrawLevel > 0 && attacker instanceof PlayerEntity)
                    quickdraw(stack, (PlayerEntity) attacker, quickdrawLevel);
                if (possessionLevel > 0) possession(attacker, stack);
                if (holyBlessingLevel > 0) holyBlessing(attacker);
                if (experienceLevel > 0) experience(attacker, stack, target);
                if (learningLevel > 0) learning(attacker);
                if (unknownLevel > 0) unknown(target);
                if (errorLevel > 0) error(attacker);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    // Utility method to get RegistryEntry<Enchantment> from RegistryKey<Enchantment>
    private RegistryEntry<Enchantment> getEnchantment(RegistryEntryLookup<Enchantment> lookup, RegistryKey<Enchantment> key) {
        return lookup.getOptional(key).orElseThrow(() -> new IllegalArgumentException("Enchantment not found: " + key.getValue()));
    }


    private ItemStack split(int i) {
        return null;
    }

    public void onCraft(ItemStack stack, World world) {
        super.onCraft(stack, world);

        // Ensure the server is available
        MinecraftServer server = world.getServer();
        if (server == null) return;

        // Fetch the enchantment registry lookup
        RegistryEntryLookup<Enchantment> enchantmentLookup =
                server.getReloadableRegistries().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT);

        // Apply vanilla enchantments
        addEnchantment(stack, enchantmentLookup, Enchantments.SHARPNESS, 10);
        addEnchantment(stack, enchantmentLookup, Enchantments.SMITE, 8);
        addEnchantment(stack, enchantmentLookup, Enchantments.KNOCKBACK, 9);
        addEnchantment(stack, enchantmentLookup, Enchantments.UNBREAKING, 7);
        addEnchantment(stack, enchantmentLookup, Enchantments.MENDING, 5);
        addEnchantment(stack, enchantmentLookup, Enchantments.LOOTING, 10);

        // Apply mod enchantments
        addEnchantment(stack, enchantmentLookup, ModEnchantments.ENERGY, 4);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.HEAVY_ATTACK, 5);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.ARROW_DEFLECTION, 7);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.PROTECTION, 10);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.QUICKDRAW, 10);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.POSSESSION, 10);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.HOLY_BLESSING, 10);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.EXPERIENCE_3230, 9);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.LEARNING_547, 9);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.UNKNOWN, 9);
        addEnchantment(stack, enchantmentLookup, ModEnchantments.ERROR_785A, 9);
    }

    /**
     * Helper method to apply enchantments.
     */
    private void addEnchantment(ItemStack stack, RegistryEntryLookup<Enchantment> lookup, RegistryKey<Enchantment> enchantmentKey, int level) {
        lookup.getOptional(enchantmentKey).ifPresent(entry -> stack.addEnchantment(entry, level));
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack headStack = user.getEquippedStack(EquipmentSlot.HEAD);
        if (headStack.isEmpty()) {
            user.equipStack(EquipmentSlot.HEAD,stack.split(1));
            stack.decrement(1);
            return TypedActionResult.success(user.getEquippedStack(EquipmentSlot.HEAD), world.isClient());
        }
        return TypedActionResult.success(stack, world.isClient());
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Legendary Blade").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Notch").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Steve, Chris, Greg, Blue Demon").formatted(Formatting.DARK_BLUE));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("This sword has been blessed with countless enchantments").formatted(Formatting.BLUE));
            tooltip.add(Text.literal("causing a massive strain on the wielder's body, thus").formatted(Formatting.BLUE));
            tooltip.add(Text.literal("never use the sword unless it was absolutely").formatted(Formatting.BLUE));
            tooltip.add(Text.literal("necessary or if he wished to settle fights quickly.").formatted(Formatting.BLUE));
        } else {
            tooltip.add(Text.literal("Hold §eShift§r for lore.").formatted(Formatting.GRAY));
        }
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("Use this with CAUTION!").formatted(Formatting.DARK_RED));
        tooltip.add(Text.literal(""));
        super.appendTooltip(stack, context, tooltip, type);
    }

    private void energy(LivingEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.ENERGY_EFFECT, 500, 4, true, true, true));
    }

    private void heavyAttack(ItemStack stack, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 500, 5, true, true, true));
    }

    private void arrowDeflection(LivingEntity attacker, Entity target) {
        if (attacker instanceof LivingEntity livingEntity) {
            // Get nearby arrows
            if (target instanceof ArrowEntity arrow) {
                    // Chance to deflect based on enchantment level (Level 7 = 100%)
                    float level = 7;
                    if (random.nextFloat() < (0.5f + (level * 0.0714f))) {
                        deflectArrow(arrow, livingEntity);
                    }
                }
            }
        }

    private void deflectArrow(ArrowEntity arrow, LivingEntity entity) {
        // Get arrow velocity and invert it to reflect back at the shooter
        Vec3d velocity = arrow.getVelocity().multiply(-1);
        arrow.setVelocity(velocity.x, velocity.y, velocity.z);
        arrow.setOwner(entity); // Change ownership to the player
        arrow.setSilent(true); // Prevents arrow hit sounds
    }

    private void protection(LivingEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.PROTECTION_EFFECT, 500, 10, true, true, true));
    }

    private void quickdraw(ItemStack stack, PlayerEntity player, int quickdrawLevel) {
        player.getItemCooldownManager().set(stack.getItem(), 20);
    }

    private void possession(LivingEntity attacker, ItemStack user) {
        if (attacker instanceof PlayerEntity player) {
            if (player.experienceLevel < 30) {
                player.dropItem(user.split(1), true);
                player.sendMessage(Text.of("Level 30 required to use this item."), true);
            } else {
                player.sendMessage(Text.of("Wake Up!"), true);
                player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 5, true, true, true));
            }
        }

    }

    private void holyBlessing(LivingEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLY_BLESSING_EFFECT, 500, 5, true, true, true));
    }

    private void experience(LivingEntity player, ItemStack stack, LivingEntity target) {
        if (!target.isAlive() && player instanceof PlayerEntity) {
            World world = player.getWorld();
            world.spawnEntity(new ExperienceOrbEntity(world, target.getX(), target.getY(), target.getZ(), 3230 * EnchantmentHelper.getLevel((RegistryEntry)ModEnchantments.EXPERIENCE_3230, stack)));
        }

    }

    private void learning(LivingEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.LEARNING_EFFECT, 500, 5, true, true, true));
    }

    private void unknown(LivingEntity target) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.UNKNOWN_EFFECT, 500, 5, true, true, true));
    }

    private void error(LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            ItemStack itemStack = ItemStack.EMPTY;

            for (ItemStack stack : player.getInventory().main) {
                if (stack.getItem() instanceof LegendarySwordItem && EnchantmentHelper.getLevel((RegistryEntry) ModEnchantments.ERROR_785A, stack) > 0) {
                    itemStack = stack;
                    break;
                }
            }

            if (!itemStack.isEmpty()) {
                this.moveItemAroundInventory(player, itemStack);
            }
        }

    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.experienceLevel < 30 && (this.playerUUID == null || !this.playerUUID.equals(player.getUuid()))) {
                this.playerUUID = player.getUuid();
                this.movementEndTime = System.currentTimeMillis() + 3600000L;
                this.cooldownEndTime = this.movementEndTime + 3600000L;
                player.sendMessage(Text.literal("[Level 30] to use this sword. Expect the sword to randomly move in your inventory for an hour.").formatted(Formatting.RED), true);
                this.startItemMovement(player, stack);
            }
        }

    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        this.stopItemMovement();
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    private void startItemMovement(PlayerEntity player, ItemStack itemStack) {
        this.scheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime > this.movementEndTime) {
                this.scheduler.shutdown();
            } else {
                this.moveItemAroundInventory(player, itemStack);
            }
        }, 0L, 5L, TimeUnit.SECONDS);
    }

    private void moveItemAroundInventory(PlayerEntity player, ItemStack itemStack) {
        if (player.getMainHandStack() != itemStack && player.getOffHandStack() != itemStack) {
            int slot = player.getRandom().nextInt(player.getInventory().size());
            ItemStack currentStack = player.getInventory().getStack(slot);
            player.getInventory().setStack(slot, itemStack.copy());
            player.getInventory().setStack(player.getInventory().indexOf(itemStack), currentStack.copy());
        }
    }

    private void stopItemMovement() {
        if (this.scheduler != null && !this.scheduler.isShutdown()) {
            this.scheduler.shutdown();
        }

    }
}