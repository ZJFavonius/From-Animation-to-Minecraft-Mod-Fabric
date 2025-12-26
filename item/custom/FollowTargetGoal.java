package mxa.modid.item.custom;

import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;

public abstract class FollowTargetGoal<T> {
    protected Object minDistance;

    public FollowTargetGoal(IronGolemEntity golem, Class<PlayerEntity> playerEntityClass, boolean b) {
    }

    public abstract boolean canStart();
}
