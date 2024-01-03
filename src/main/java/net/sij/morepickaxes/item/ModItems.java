package net.sij.morepickaxes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sij.morepickaxes.MorePickaxes;
import net.sij.morepickaxes.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new PickaxeItem(ModToolMaterial.OBSIDIAN, 3, 2f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MorePickaxes.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MorePickaxes.LOGGER.info("Registering ModItems for " + MorePickaxes.MOD_ID);
    }
}
