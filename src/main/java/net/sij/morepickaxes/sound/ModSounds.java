package net.sij.morepickaxes.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.sij.morepickaxes.MorePickaxes;

public class ModSounds {
    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");
    public static final SoundEvent DISCO_PICKAXE_MUSIC = registerSoundEvent("disco_pickaxe_music");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MorePickaxes.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerModSounds() {
        MorePickaxes.LOGGER.info("Registering ModSounds for " + MorePickaxes.MOD_ID);
    }
}
