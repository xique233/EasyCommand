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
}
