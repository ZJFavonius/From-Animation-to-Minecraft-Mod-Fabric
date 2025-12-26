package mxa.modid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;

public interface onapp {
    void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier);

    void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier);
}
