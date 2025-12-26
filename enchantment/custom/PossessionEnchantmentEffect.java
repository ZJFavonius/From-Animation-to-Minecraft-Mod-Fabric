package mxa.modid.enchantment.custom;

import com.mojang.serialization.MapCodec;
import mxa.modid.effect.ModEffects;
import mxa.modid.item.ModItems;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public record PossessionEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<PossessionEnchantmentEffect> CODEC = MapCodec.unit(PossessionEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 0, true, true, true));
                }
            }
        }

        if (level == 2) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 1, true, true, true));
                }
            }

        }

        if (level == 3) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 2, true, true, true));
                }
            }

        }

        if (level == 4) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 3, true, true, true));
                }
            }

        }

        if (level == 5) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 4, true, true, true));
                }
            }

        }

        if (level == 6) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 5, true, true, true));
                }
            }

        }

        if (level == 7) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 6, true, true, true));
                }
            }

        }

        if (level == 8) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 7, true, true, true));
                }
            }

        }

        if (level == 9) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 8, true, true, true));
                }
            }

        }

        if (level == 10) {
            if (user instanceof PlayerEntity player) {
                if (player.experienceLevel < 30) {
                    player.dropItem(ModItems.LEGENDARY_SWORD.getDefaultStack(), true);
                    player.sendMessage(Text.of("Level 30 required to use this item."), true);
                } else {
                    player.sendMessage(Text.of("Wake Up!"), true);
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.POSSESSION_EFFECT, 500, 9, true, true, true));
                }
            }

        }
        }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
