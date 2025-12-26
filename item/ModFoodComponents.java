package mxa.modid.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ENCHANTED_POTATO = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                    (StatusEffects.SATURATION, 200,8), 1f).build();

    public static final FoodComponent LASAGNA = new FoodComponent.Builder().snack()
            .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                    (StatusEffects.SATURATION, 200,4), 1f).build();

    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(5)
            .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                    (StatusEffects.SATURATION, 200,2), 1f).build();

    public static final FoodComponent ZOMBIE_CARROT = new FoodComponent.Builder().nutrition(8)
                .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                        (StatusEffects.SATURATION, 200,9), 1f).build();

    public static final FoodComponent LEMON_MINECRAFT = new FoodComponent.Builder().nutrition(6)
                .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                        (StatusEffects.SATURATION, 200,3), 1f).build();

    public static final FoodComponent APPLE_MINECRAFT = new FoodComponent.Builder().nutrition(7)
                .saturationModifier(20.0f).statusEffect(new StatusEffectInstance
                        (StatusEffects.SATURATION, 200,4), 1f).build();

    public static final FoodComponent MC_FRIES = new FoodComponent.Builder().snack()
                .saturationModifier(30.0f).statusEffect(new StatusEffectInstance
                        (StatusEffects.SATURATION, 200,4), 1f).build();

}
