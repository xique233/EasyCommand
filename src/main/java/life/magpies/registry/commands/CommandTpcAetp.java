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

public class CommandTpcAetp {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("tpcept")
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
        ServerPlayerEntity player = source.getPlayer();
        // 获取uuid
        if (source.isExecutedByPlayer()) {
            UUID SourceUUID = source.getPlayer().getUuid();
            ServerPlayerEntity Target = source.getServer().getPlayerManager().getPlayer(target);
            UUID TargetUUID = Target.getUuid();

            TeleportRequestManager manager = ModManager.manager;
            TeleportRequest request = manager.getRequest(TargetUUID,SourceUUID);

            if (request != null && request.isValid()) {
                source.sendFeedback(() -> Text.literal("您已接授请求").formatted(Formatting.GREEN), false);
                Target.sendMessage(Text.literal("对方已接授请求").formatted(Formatting.GREEN), false);
                manager.remove(request);
                player.teleport(Target.getServerWorld(), Target.getPos().x, Target.getPos().y, Target.getPos().z, Target.getYaw(), Target.getPitch());
            } else {
                source.sendFeedback(() -> Text.literal("传送请求失效了").formatted(Formatting.RED), false);
            }
        }
        return 1;
    }
}
