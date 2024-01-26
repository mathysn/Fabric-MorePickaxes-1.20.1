package net.sij.morepickaxes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sij.morepickaxes.MorePickaxes;
import net.sij.morepickaxes.item.custom.MetalDetectorItem;
import net.sij.morepickaxes.item.custom.pickaxes.TNTPickaxeItem;
import net.sij.morepickaxes.sound.ModSounds;

public class ModItems {
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    // MUSIC DISCS
    public static final Item MUSIC_DISC_BAD_APPLE = registerItem("music_disc_bad_apple",
            new MusicDiscItem(12, ModSounds.MUSIC_DISC_BAD_APPLE, new FabricItemSettings().maxCount(1), 172));
    public static final Item MUSIC_DISC_COMPTINE = registerItem("music_disc_comptine",
            new MusicDiscItem(13, ModSounds.MUSIC_DISC_COMPTINE, new FabricItemSettings().maxCount(1), 86));
    public static final Item MUSIC_DISC_HOPPIN_BLOCKS = registerItem("music_disc_hoppin_blocks",
            new MusicDiscItem(14, ModSounds.MUSIC_DISC_HOPPIN_BLOCKS, new FabricItemSettings().maxCount(1), 175));
    public static final Item MUSIC_DISC_MAD_WORLD = registerItem("music_disc_mad_world",
            new MusicDiscItem(15, ModSounds.MUSIC_DISC_MAD_WORLD, new FabricItemSettings().maxCount(1), 154));

    // PICKAXES
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new PickaxeItem(ModToolMaterial.OBSIDIAN, 3, 2f, new FabricItemSettings()));
    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe",
            new PickaxeItem(ModToolMaterial.EMERALD, 2, 2f, new FabricItemSettings()));
    public static final Item TNT_PICKAXE = registerItem("tnt_pickaxe",
            new TNTPickaxeItem(ToolMaterials.DIAMOND, 2, 2f, new FabricItemSettings().maxCount(1).maxDamage(1300)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MorePickaxes.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MorePickaxes.LOGGER.info("Registering ModItems for " + MorePickaxes.MOD_ID);
    }
}
