package net.sij.morepickaxes;

import net.fabricmc.api.ModInitializer;

import net.sij.morepickaxes.block.ModBlocks;
import net.sij.morepickaxes.item.ModItemGroups;
import net.sij.morepickaxes.item.ModItems;
import net.sij.morepickaxes.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MorePickaxes implements ModInitializer {
	public static final String MOD_ID = "morepickaxes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerModSounds();
	}
}