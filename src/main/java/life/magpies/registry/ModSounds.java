package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModSounds {
    // 创建存储歌曲标识符和声音事件的映射
    private static final Map<Identifier, SoundEvent> MUSIC_MAP = new HashMap<>();

    // 添加歌曲的方法
    public static void addMusic(String name) {
        Identifier musicId = new Identifier(SimplerTemplateMod.MOD_ID, name);
        SoundEvent musicSound = SoundEvent.of(musicId);
        MUSIC_MAP.put(musicId, musicSound);
    }

    // 注册所有歌曲的方法
    public static void registerSounds() {
        for (Map.Entry<Identifier, SoundEvent> entry : MUSIC_MAP.entrySet()) {
            Registry.register(Registries.SOUND_EVENT, entry.getKey(), entry.getValue());
        }
    }

    // 示例：在这里添加所有歌曲
    public static void setupMusic() {
        addMusic("color");
        addMusic("the_world_is_falling_in_love");
        addMusic("congratulations_and_prosperity");
        // 添加更多歌曲...
    }

    // 公共静态字段，用于访问 CLICK_SOUND
    public static final SoundEvent CLICK_SOUND = SoundEvent.of(new Identifier(SimplerTemplateMod.MOD_ID, "color"));
}
