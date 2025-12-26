package mxa.modid.entities;

import mxa.modid.goals.AttackTargetGoal;
import mxa.modid.goals.FollowPlayerGoal;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class CustomPandaEntity extends PandaEntity {
    private static PlayerEntity owner;

    public CustomPandaEntity(EntityType<? extends PandaEntity> entityType, World world) {
        super(entityType, world);
    }

    public static CustomPandaEntity create(ServerWorld world, PlayerEntity player) {
        CustomPandaEntity panda = new CustomPandaEntity(EntityType.PANDA, world);
        String[] names = new String[]{"Panda", "Yin Yang", "Peace", "Whitlack", "Blawhit"};
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        panda.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), 0.0F);
        panda.initialize(world, world.getLocalDifficulty(panda.getBlockPos()), SpawnReason.MOB_SUMMONED, (EntityData)null);
        panda.setCustomName(Text.of(randomName));
        panda.setCustomNameVisible(true);
        panda.setTame(true);
        ((EntityAttributeInstance)Objects.requireNonNull(panda.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH))).setBaseValue(60.0);
        panda.goalSelector.add(0, new FollowPlayerGoal(panda, player));
        panda.targetSelector.add(0, new AttackTargetGoal(panda, player));
        setOwner(owner);
        return panda;
    }

    private void setTame(boolean b) {

    }

    public static void setOwner(PlayerEntity owner) {
        CustomPandaEntity.owner = owner;
    }
}
