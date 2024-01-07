package net.sij.morepickaxes.sound.instance;

import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.sij.morepickaxes.sound.ModSounds;


public class DiscoPickaxeSoundInstance extends MovingSoundInstance {
    private final PlayerEntity player;
    private final boolean isToggled;
    public DiscoPickaxeSoundInstance(PlayerEntity player, boolean canPlaySoundInstance) {
        super(ModSounds.DISCO_PICKAXE_MUSIC, SoundCategory.RECORDS, SoundInstance.createRandom());
        this.player = player;
        this.repeat = true;
        this.repeatDelay = 0;
        this.isToggled = canPlaySoundInstance;

        this.x = (float) player.getX();
        this.y = (float) player.getY();
        this.z = (float) player.getZ();
    }

    @Override
    public void tick() {
        if(!isToggled) {
            this.setDone();
            return;
        }
        setPos();
    }

    private void setPos() {
        this.x = (float) player.getX();
        this.y = (float) player.getY();
        this.z = (float) player.getZ();
    }
}
