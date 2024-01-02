package net.sij.morepickaxes.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sij.morepickaxes.block.ModBlocks;
import net.sij.morepickaxes.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("No valuable blocks found"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(), (player) -> {
            player.sendToolBreakStatus(player.getActiveHand());
        });

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.getName().getString() + " at " + down.getX() + ", " + down.getY() + ", " + down.getZ()), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }
}
