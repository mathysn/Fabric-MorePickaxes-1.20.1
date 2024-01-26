package net.sij.morepickaxes.item.custom.pickaxes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.explosion.Explosion;

public class TNTPickaxeItem extends PickaxeItem {
    private static final float TNT_RADIUS = 10.0f;
    public TNTPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Explosion explosion = new Explosion(world, miner, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, TNT_RADIUS, false, Explosion.DestructionType.DESTROY);
        explosion.collectBlocksAndDamageEntities();
        explosion.affectWorld(true);
        miner.sendMessage(Text.literal("Boom!"));

        stack.damage(1, miner, (player) -> {
            player.sendToolBreakStatus(player.getActiveHand());
        });

        return super.postMine(stack, world, state, pos, miner);
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        if(!world.isClient){
//            user.getItemCooldownManager().set(this, COOLDOWN);
//            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), TNT_RADIUS, true, true);
//        }
//        return super.use(world, user, hand);
//    }
}
