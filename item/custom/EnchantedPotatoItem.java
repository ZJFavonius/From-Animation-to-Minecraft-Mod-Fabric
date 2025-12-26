    package mxa.modid.item.custom;

    import com.google.common.collect.ImmutableMultimap;
    import com.google.common.collect.Multimap;
    import mxa.modid.entity.custom.EnchantedPotatoProjectileEntity;
    import net.minecraft.entity.Entity;
    import net.minecraft.entity.EquipmentSlot;
    import net.minecraft.entity.LivingEntity;
    import net.minecraft.entity.attribute.EntityAttribute;
    import net.minecraft.entity.attribute.EntityAttributeModifier;
    import net.minecraft.entity.attribute.EntityAttributes;
    import net.minecraft.entity.effect.StatusEffectInstance;
    import net.minecraft.entity.effect.StatusEffects;
    import net.minecraft.entity.player.PlayerEntity;
    import net.minecraft.entity.projectile.PersistentProjectileEntity;
    import net.minecraft.item.Item;
    import net.minecraft.item.ItemStack;
    import net.minecraft.item.SnowballItem;
    import net.minecraft.item.tooltip.TooltipType;
    import net.minecraft.sound.SoundCategory;
    import net.minecraft.sound.SoundEvents;
    import net.minecraft.text.Text;
    import net.minecraft.util.Formatting;
    import net.minecraft.util.Hand;
    import net.minecraft.util.TypedActionResult;
    import net.minecraft.util.UseAction;
    import net.minecraft.util.math.Box;
    import net.minecraft.world.World;

    import java.util.List;

    public class EnchantedPotatoItem extends SnowballItem {
        private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

        public EnchantedPotatoItem(Item.Settings settings) {
            super(settings);
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE.value(), new EntityAttributeModifier(SnowballItem.BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.0, EntityAttributeModifier.Operation.ADD_VALUE));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED.value(), new EntityAttributeModifier(SnowballItem.BASE_ATTACK_SPEED_MODIFIER_ID, 1.0, EntityAttributeModifier.Operation.ADD_VALUE));
            this.attributeModifiers = builder.build();
        }

        public Object getAttributeModifiers(EquipmentSlot slot) {
            return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers();
        }

        public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
            ItemStack stack = player.getStackInHand(hand);
            // If sneaking, start eating
            if (player.isSneaking()) {
                player.setCurrentHand(hand); // Start "using" (eating animation)
                return TypedActionResult.consume(stack);
            }

            // Else, throw immediately
            if (!world.isClient) {
                EnchantedPotatoProjectileEntity projectile = new EnchantedPotatoProjectileEntity(world, player);
                projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(projectile);
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.5F, 1.0F);
                stack.decrement(1);
            }

            return TypedActionResult.success(stack, world.isClient());
        }

        @Override
        public UseAction getUseAction(ItemStack stack) {
            return UseAction.EAT;
        }

        @Override
        public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            if (!world.isClient && user instanceof PlayerEntity player) {
                // Apply effects
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 6000, 0));
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
            return stack;
        }

        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
            if (!world.isClient && entity instanceof PlayerEntity player) {
                if (selected) {
                    Box range = player.getBoundingBox().expand(2.0);
                    world.getOtherEntities(player, range).forEach((target) -> {
                        if (target instanceof LivingEntity livingTarget) {
                            livingTarget.addVelocity(0.0, 2.0, 0.0);
                            livingTarget.velocityModified = true;
                        }

                    });
                }
            }

            super.inventoryTick(stack, world, entity, slot, selected);
        }

        public void onStoppedUsing(ItemStack stack, World world, LivingEntity owner, int remainingUseTicks) {
            if (!world.isClient && owner instanceof PlayerEntity player) {
                EnchantedPotatoProjectileEntity enchantedpotato = new EnchantedPotatoProjectileEntity(world, player);
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                    enchantedpotato.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    ((PlayerEntity)owner).getInventory().removeOne(stack);
                    world.playSound(null, owner.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.5F, 1.0F);
                }
            }

            super.onStoppedUsing(stack, world, owner, remainingUseTicks);
        }

        public boolean hasGlint(ItemStack stack) {
            return true;
        }

        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.literal("").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("Unusual Weapon").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Steve").formatted(Formatting.BOLD));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("The overpowered potato").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("").formatted(Formatting.GOLD));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }