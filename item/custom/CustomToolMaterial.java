package mxa.modid.item.custom;

import net.minecraft.block.Block;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class CustomToolMaterial implements ToolMaterial {
    public static final CustomToolMaterial DEMONIAC_VOLTAGE_REAVER = new CustomToolMaterial();
    public static final ToolMaterial LIGHTNING = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 99999;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 10;
        }

        @Override
        public float getAttackDamage() {
            return 12;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return null;
        }

        @Override
        public int getEnchantability() {
            return 22;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        @Override
        public ToolComponent createComponent(TagKey<Block> tag) {
            return ToolMaterial.super.createComponent(tag);
        }
    } ;

    @Override
    public int getDurability() {
        return 99999;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0f;
    }

    @Override
    public float getAttackDamage() {
        return 14;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }
    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
}