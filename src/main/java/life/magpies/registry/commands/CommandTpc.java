package life.magpies.registry.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import life.magpies.registry.util.ModManager;
import life.magpies.registry.util.TeleportRequest;
import life.magpies.registry.util.TeleportRequestManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.UUID;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandTpc {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("tpc")
                    .requires(source -> source.hasPermissionLevel(0))
                    .then(CommandManager.argument("player", StringArgumentType.word())
                            .suggests(PlayerSuggestionProvider.suggestPlayers)
                            .executes(ctx -> {
                                String targetPlayer = StringArgumentType.getString(ctx, "player");
                                return execute(ctx, targetPlayer);
                            })
                    ));
        });
    }

    public static int execute(CommandContext<ServerCommandSource> ctx, String target) {
        //获取命令源
        ServerCommandSource source = ctx.getSource();
        // 获取uuid
        if (source.isExecutedByPlayer()) {
            if (source.getName() != null) {
                UUID SourceUUID = source.getPlayer().getUuid();
                ServerPlayerEntity Target = source.getServer().getPlayerManager().getPlayer(target);

                UUID TargetUUID = Target.getUuid();
                TeleportRequestManager manager = ModManager.manager;
                TeleportRequest request = manager.getRequest(SourceUUID, TargetUUID);

                if (request == null || !request.isValid()) {
                    source.sendFeedback(() -> Text.literal("传送请求已发送给 " + target).formatted(Formatting.GOLD), false);
                    Target.sendMessage(Text.literal(source.getName() + " 请求传送到您此处").formatted(Formatting.GOLD), false);
                    manager.add(new TeleportRequest(SourceUUID, TargetUUID));
                } else {
                    source.sendFeedback(() -> Text.literal("你已经向 " + Target + " 请求了请等待回复").formatted(Formatting.RED), false);
                }
            }
        }
        return 1;
    }
}
