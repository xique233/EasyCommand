package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandList {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("list")
                    .requires(source -> source.hasPermissionLevel(1))
                    .executes(CommandList::execute));

        });
    }

    public static int execute(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        source.sendMessage(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".explain_kit"));
        source.sendMessage(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".explain_day"));
        source.sendMessage(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".explain_night"));
        source.sendMessage(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".explain_sun"));
        source.sendMessage(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".explain_rain"));
        return 1;
    }
}
