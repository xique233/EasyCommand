package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
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
        source.sendMessage(Text.literal("/kit -> 清除附近的掉落物 可选填半径最大30"));
        source.sendMessage(Text.literal("/day -> 白天"));
        source.sendMessage(Text.literal("/night -> 黑夜"));
        source.sendMessage(Text.literal("/sun -> 晴天"));
        source.sendMessage(Text.literal("/rain -> 雨天"));
        return 1;
    }
}
