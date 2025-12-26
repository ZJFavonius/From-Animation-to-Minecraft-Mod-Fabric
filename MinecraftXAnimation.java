package mxa.modid;

import mxa.modid.block.ModBlocks;
import mxa.modid.effect.ModEffects;
import mxa.modid.enchantment.ModEnchantmentEffects;
import mxa.modid.entity.ModEntities;
import mxa.modid.entity.custom.GarfieldEntity;
import mxa.modid.entity.custom.GolemTotemEntity;
import mxa.modid.entity.custom.SwordsmanHerobrineEntity;
import mxa.modid.event.ModEvents;
import mxa.modid.item.ModItemGroups;
import mxa.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftXAnimation implements ModInitializer {
	public static final String MOD_ID = "minecraft_x_animation";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Initializing " + MOD_ID);

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModEnchantmentEffects.registerEnchantmentEffects();
		ModEffects.registerEffects();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.SWORDSMAN_HEROBRINE,
				SwordsmanHerobrineEntity.createSwordsmanHerobrineAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.GOLEM_TOTEM,
				GolemTotemEntity.createGolemTotemAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.GARFIELD,
				GarfieldEntity.createCatAttributes());

		ModEvents.register();

		CompostingChanceRegistry.INSTANCE.add(ModItems.TOMATO, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.TOMATO_SEEDS, 0.25f);

	}
}