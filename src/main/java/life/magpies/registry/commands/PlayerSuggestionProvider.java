package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.concurrent.CompletableFuture;

public class PlayerSuggestionProvider {
    // 创建 SuggestionProvider 类
    public static final SuggestionProvider<ServerCommandSource> suggestPlayers = (ctx, builder) -> suggestPlayers(ctx, builder);

    // 实现 suggestPlayers 方法
    private static CompletableFuture<Suggestions> suggestPlayers(CommandContext<ServerCommandSource> context, SuggestionsBuilder builder) {
        // 从命令上下文中获取服务器命令源
        ServerCommandSource source = context.getSource();
        // 从命令源中获取服务器对象
        PlayerManager playerManager = source.getServer().getPlayerManager();

        // 获取在线玩家列表
        Iterable<ServerPlayerEntity> onlinePlayers = playerManager.getPlayerList();

        // 遍历在线玩家列表，为建议列表添加玩家名称
        for (ServerPlayerEntity player : onlinePlayers) {
            builder.suggest(player.getName().getString());
        }

        // 返回建议列表的 CompletableFuture 对象
        return builder.buildFuture();
    }

}
