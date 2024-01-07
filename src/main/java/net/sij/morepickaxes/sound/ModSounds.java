package net.sij.morepickaxes.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.sij.morepickaxes.MorePickaxes;

public class ModSounds {
    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");
    public static final SoundEvent MUSIC_DISC_BAD_APPLE = registerSoundEvent("music_disc_bad_apple");
    public static final SoundEvent MUSIC_DISC_COMPTINE = registerSoundEvent("music_disc_comptine");
    public static final SoundEvent MUSIC_DISC_HOPPIN_BLOCKS = registerSoundEvent("music_disc_hoppin_blocks");
    public static final SoundEvent MUSIC_DISC_MAD_WORLD = registerSoundEvent("music_disc_mad_world");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MorePickaxes.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerModSounds() {
        MorePickaxes.LOGGER.info("Registering ModSounds for " + MorePickaxes.MOD_ID);
    }
}
