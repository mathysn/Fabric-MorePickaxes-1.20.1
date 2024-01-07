package net.sij.morepickaxes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sij.morepickaxes.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_BAD_APPLE)
                .add(ModItems.MUSIC_DISC_COMPTINE)
                .add(ModItems.MUSIC_DISC_HOPPIN_BLOCKS)
                .add(ModItems.MUSIC_DISC_MAD_WORLD);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_BAD_APPLE)
                .add(ModItems.MUSIC_DISC_COMPTINE)
                .add(ModItems.MUSIC_DISC_HOPPIN_BLOCKS)
                .add(ModItems.MUSIC_DISC_MAD_WORLD);
    }
}
