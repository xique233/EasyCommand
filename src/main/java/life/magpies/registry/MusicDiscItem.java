package life.magpies.registry;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class MusicDiscItem extends Item {
    private final Map<SoundEvent, MusicDiscItem> MUSIC_DISCS = Maps.newHashMap();
    private final SoundEvent sound;
    private final int comparatorOutput;
    private final int lengthInTicks;

    public MusicDiscItem(int comparatorOutput, SoundEvent sound, int lengthInTicks, Settings settings) {
        super(settings);
        this.sound = sound;
        this.comparatorOutput = comparatorOutput;
        this.lengthInTicks = lengthInTicks;
        MUSIC_DISCS.put(this.sound, this);
    }

    public ActionResult useOnBlock(ItemUsageContext ctx) {
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.JUKEBOX) && !(Boolean) blockState.get(JukeboxBlock.HAS_RECORD)) {
            ItemStack itemStack = ctx.getStack();
            if (!world.isClient) {
                PlayerEntity playerEntity = ctx.getPlayer();
                BlockEntity var8 = world.getBlockEntity(blockPos);
                if (var8 instanceof JukeboxBlockEntity) {
                    JukeboxBlockEntity jukeboxBlockEntity = (JukeboxBlockEntity) var8;
                    jukeboxBlockEntity.setStack(itemStack.copy());
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState));
                }
                itemStack.decrement(1);
                if (playerEntity != null) {
                    playerEntity.incrementStat(Stats.PLAY_RECORD);
                }
            }
            return ActionResult.success(world.isClient);
        } else
            return ActionResult.PASS;
    }

    public int getComparatorOutput() {
        return this.comparatorOutput;
    }

    /*public void setStack(ItemStack stack) {
        if (stack.isIn(ItemTags.MUSIC_DISCS) && this.world != null){
            this.recordStack = stack;
            this.updataState((Entity)null,true);
            this.starPlaying();
        }else if(stack.isEmpty()){
            this.decreaseStack(1);
        }
    }*/
}
