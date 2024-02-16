package life.magpies.registry.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Collection;

import static life.magpies.registry.commands.CommandTpAccept.teleportRequests;
import static net.minecraft.server.command.CommandManager.literal;

public class CommandTpa {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("tpa")
                    .requires(source -> source.hasPermissionLevel(1))
                    .then(CommandManager.argument("player", StringArgumentType.word())
                            .suggests(PlayerSuggestionProvider.suggestPlayers)
                            .executes(ctx -> {
                                String targetPlayer = StringArgumentType.getString(ctx, "player");
                                return execute(ctx, targetPlayer);
                            })
                    ));
        });
    }


    public static int execute(CommandContext<ServerCommandSource> ctx, String targetPlayer) {
        ServerCommandSource source = ctx.getSource();
        if (source.isExecutedByPlayer()) {
            Collection<String> playerNames = source.getPlayerNames();
            ServerPlayerEntity targetPlayerEntity = source.getServer().getPlayerManager().getPlayer(targetPlayer);
            // 从服务器玩家列表中筛选目标玩家名称
            if (playerNames.contains(targetPlayer) && !source.getName().equals(targetPlayer)) {
                assert targetPlayerEntity != null;
                // 向目标玩家发送传送消息
                targetPlayerEntity.sendMessage(Text.literal(source.getName() + " 向您发起了传送请求").formatted(Formatting.GOLD), false);
                teleportRequests.put(targetPlayer, source.getName());
                targetPlayerEntity.sendMessage(Text.literal("接受传送请使用/tpaccept").formatted(Formatting.GOLD), false);
                source.sendFeedback(() -> Text.literal("传送请求已发送给 " + targetPlayer).formatted(Formatting.GOLD), false);

                // 如果目标玩家不存在或者是自己，则发送相应消息
            } else if (!playerNames.contains(targetPlayer)) {
                source.sendFeedback(() -> Text.literal("玩家 " + targetPlayer + " 不在服务器上").formatted(Formatting.RED), false);
            } else {
                source.sendFeedback(() -> Text.translatable("command.tpa.error_n1").formatted(Formatting.RED), false);
            }
        }
        return 1;
    }
}
