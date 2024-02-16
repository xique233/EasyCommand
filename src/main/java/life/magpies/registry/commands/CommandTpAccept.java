package life.magpies.registry.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandTpAccept {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("tpaccept")
                    .executes(ctx -> {
                        return acceptTpaRequest(ctx);
                    })
            );
        });
    }

    public static final Map<String, String> teleportRequests = new HashMap<>();

    private static int acceptTpaRequest(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        MinecraftServer server = source.getServer();
        ServerPlayerEntity player = source.getPlayer();

        // 检查是否有传送请求
        String sourcePlayerName = teleportRequests.remove(player.getName().getString());
        if (sourcePlayerName != null) {
            ServerPlayerEntity sourcePlayer = server.getPlayerManager().getPlayer(sourcePlayerName);
            if (sourcePlayer != null) {
                // 异步执行传送操作
                CompletableFuture<Void> teleportFuture = CompletableFuture.runAsync(() -> {
                    // 执行传送操作
                    sourcePlayer.teleport(player.getServerWorld(), player.getPos().x, player.getPos().y, player.getPos().z, player.getYaw(), player.getPitch());
                });
                // 在异步任务完成时发送传送成功消息
                teleportFuture.thenRun(() -> {
                    source.sendFeedback(() -> Text.translatable("command.tpaccept.success").formatted(Formatting.GREEN), false);
                }).exceptionally(e -> {
                    // 发生异常时发送错误消息
                    source.sendFeedback(() -> Text.literal("传送时出错" + e.getMessage()).formatted(Formatting.RED), false);
                    return null;
                });

                return Command.SINGLE_SUCCESS;
            } else {
                source.sendFeedback(() -> Text.translatable("command.tpaccept.player_not_found").formatted(Formatting.RED), false);
            }
        } else {
            source.sendFeedback(() -> Text.translatable("command.tpaccept.no_request").formatted(Formatting.RED), false);
        }
        return 1;
    }

}
