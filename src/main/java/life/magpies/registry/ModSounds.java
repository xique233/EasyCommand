package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent COLOR = registerSoundEvent("color");
    public static final SoundEvent LOVE = registerSoundEvent("the_world_is_falling_in_love");
    public static final SoundEvent CONGRATULATIONS = registerSoundEvent("congratulations_and_prosperity");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(SimplerTemplateMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        System.out.println("Registering ModSounds for " + SimplerTemplateMod.MOD_ID);
    }
}
