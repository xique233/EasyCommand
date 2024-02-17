package life.magpies.registry.commands

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.SuggestionProvider
import com.mojang.brigadier.suggestion.Suggestions
import com.mojang.brigadier.suggestion.SuggestionsBuilder
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.network.ServerPlayerEntity
import java.util.concurrent.CompletableFuture

object PlayerSuggestionProvider {
    // 创建 SuggestionProvider 类
    val suggestPlayers: SuggestionProvider<ServerCommandSource> =
        SuggestionProvider { ctx: CommandContext<ServerCommandSource>, builder: SuggestionsBuilder ->
            suggestPlayers(
                ctx,
                builder
            )
        }

    // 实现 suggestPlayers 方法
    private fun suggestPlayers(
        context: CommandContext<ServerCommandSource>,
        builder: SuggestionsBuilder
    ): CompletableFuture<Suggestions?> {
        // 从命令上下文中获取服务器命令源
        val source = context.source
        // 从命令源中获取服务器对象
        val playerManager = source.server.playerManager

        // 获取在线玩家列表
        val onlinePlayers: Iterable<ServerPlayerEntity> = playerManager.playerList

        // 遍历在线玩家列表，为建议列表添加玩家名称
        for (player in onlinePlayers) {
            builder.suggest(player.name.string)
        }

        // 返回建议列表的 CompletableFuture 对象
        return builder.buildFuture()
    }
}