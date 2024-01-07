package net.sij.morepickaxes.item.pickaxes;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.sij.morepickaxes.sound.ModSounds;
import net.sij.morepickaxes.sound.instance.DiscoPickaxeSoundInstance;

public class DiscoPickaxeItem extends PickaxeItem {
    private boolean isToggled = false;


    public DiscoPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient()) {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }

        DiscoPickaxeSoundInstance sound = new DiscoPickaxeSoundInstance(player, isToggled);

        if(!isToggled) {
            player.sendMessage(Text.literal("Disco mode enabled!"));
            MinecraftClient.getInstance().getSoundManager().play(sound);
            isToggled = true;
        } else {
            player.sendMessage(Text.literal("Disco mode disabled!"));
            isToggled = false;
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity player, int slot, boolean selected) {
//        DiscoPickaxeSoundInstance sound = new DiscoPickaxeSoundInstance(player, canPlaySoundInstance);
//        MinecraftClient client = MinecraftClient.getInstance();
//
//
//        if (selected && canPlaySoundInstance) {
//            client.getSoundManager().play(sound);
//        } else {
//            client.getSoundManager().stop(sound);
//        }
//        canPlaySoundInstance = !selected;
//    }
}
