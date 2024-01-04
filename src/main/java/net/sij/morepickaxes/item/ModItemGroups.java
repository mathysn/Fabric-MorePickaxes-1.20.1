package net.sij.morepickaxes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sij.morepickaxes.MorePickaxes;
import net.sij.morepickaxes.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MORE_PICKAXES = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(MorePickaxes.MOD_ID,"more_pickaxes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.more_pickaxes"))
                    .icon(() -> new ItemStack(Items.DIAMOND_PICKAXE)).entries((displayContext, entries) -> {
                        // Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.OBSIDIAN_PICKAXE);
                        entries.add(ModItems.DISCO_PICKAXE);

                        // Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                    }).build());
    public static void registerItemGroups() {
        MorePickaxes.LOGGER.info("Registering ModItemGroups for " + MorePickaxes.MOD_ID);
    }
}
