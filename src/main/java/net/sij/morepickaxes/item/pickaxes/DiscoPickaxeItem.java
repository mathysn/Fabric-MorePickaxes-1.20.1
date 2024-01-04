package net.sij.morepickaxes.item.pickaxes;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.WeightedSoundSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.sij.morepickaxes.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class DiscoPickaxeItem extends PickaxeItem {
    private boolean isPlaying = false;


    public DiscoPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity player, int slot, boolean selected) {
        SoundEvent soundEvent = ModSounds.DISCO_PICKAXE_MUSIC;
        SoundInstance sound = new SoundInstance() {
            @Override
            public Identifier getId() {
                return soundEvent.getId();
            }

            @Nullable
            @Override
            public WeightedSoundSet getSoundSet(SoundManager soundManager) {
                return null;
            }

            @Override
            public Sound getSound() {
                return null;
            }

            @Override
            public SoundCategory getCategory() {
                return SoundCategory.PLAYERS;
            }

            @Override
            public boolean isRepeatable() {
                return true;
            }

            @Override
            public boolean isRelative() {
                return false;
            }

            @Override
            public int getRepeatDelay() {
                return 0;
            }

            @Override
            public float getVolume() {
                return 1f;
            }

            @Override
            public float getPitch() {
                return 1f;
            }

            @Override
            public double getX() {
                return 0;
            }

            @Override
            public double getY() {
                return 0;
            }

            @Override
            public double getZ() {
                return 0;
            }

            @Override
            public AttenuationType getAttenuationType() {
                return SoundInstance.AttenuationType.NONE;
            }
        };

        if(selected) {
            if(!isPlaying) {
                player.playSound(ModSounds.DISCO_PICKAXE_MUSIC, 1f, 1f);
                isPlaying = true;
            }
        } else {
            if(isPlaying) {
                MinecraftClient.getInstance().getSoundManager().stop(sound);
                isPlaying = false;
            }
        }

        // FIXME: THIS IS NOT WORKING !!! NEEDS TO BE FIXED !!!
    }
}
