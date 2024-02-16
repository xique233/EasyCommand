package life.magpies.registry.commands;

import life.magpies.SimplerTemplateMod;

public class ModCommands {
    public static void registerCommands(){
        CommandKit.register();
        CommandDay.register();
        CommandWeather.register();
        CommandList.register();
        CommandTpa.register();
        CommandTpa.register();
        CommandTpAccept.register();
        CommandTpc.register();
        CommandTpcAetp.register();
    }
    public static void registerModCommand() {
        SimplerTemplateMod.LOGGER.debug("Registering mod command for" + SimplerTemplateMod.MOD_ID);
    }
}
