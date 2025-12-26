package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import java.util.Objects;
import java.util.Random;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CustomLlamaEntity extends LlamaEntity {
    private static PlayerEntity owner;

    public CustomLlamaEntity(EntityType<? extends LlamaEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomLlamaEntity create(ServerWorld world, PlayerEntity player) {
        CustomLlamaEntity llama = new CustomLlamaEntity(EntityType.LLAMA, world);
        String[] names = new String[]{"Luna", "Sunny", "Spirit", "Fuzzy", "Blaze", "Spitter"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        llama.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        llama.initialize(world, world.getLocalDifficulty(llama.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        llama.setCustomName(Text.of(randomName));
        llama.setCustomNameVisible(true);
        llama.setTame(true);
        ((EntityAttributeInstance)Objects.requireNonNull(llama.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH))).setBaseValue(60.0);
        llama.goalSelector.add(0, new FollowPlayerGoal(llama, player));
        llama.targetSelector.add(0, new AttackTargetGoal(llama, player));
        setOwner(owner);
        return llama;
    }

    public static void setOwner(PlayerEntity owner) {
        CustomLlamaEntity.owner = owner;
    }
}
