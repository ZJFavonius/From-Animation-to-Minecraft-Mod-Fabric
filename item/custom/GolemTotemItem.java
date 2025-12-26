package mxa.modid.item.custom;

import mxa.modid.entities.CustomGolemTotemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
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

public class GolemTotemItem extends SwordItem {
    public GolemTotemItem(ToolMaterials toolMaterials, Settings settings) {
        super(toolMaterials, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld)world;
            CustomGolemTotemEntity golem = CustomGolemTotemEntity.create(serverWorld, player);
            serverWorld.spawnEntity(golem);
            BlockPos userPos = player.getBlockPos();
            world.playSound((PlayerEntity)null, userPos, SoundEvents.ENTITY_IRON_GOLEM_REPAIR, SoundCategory.PLAYERS, 1.0F, 1.0F);
            world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, (double)userPos.getX() + 0.5, (double)userPos.getY() + 0.5, (double)userPos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }

        return new TypedActionResult(ActionResult.SUCCESS, itemStack);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Golem Statue").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("Unreconstructed Golem").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Mustard").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("Villagers Settlers").formatted(Formatting.BOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("From the Annoying Villagers by MrFudgeMonkeyz Studios").formatted(Formatting.GREEN));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("This is a reoccurring weapon.").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Can summon the Golem Totem when right-clicked").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}