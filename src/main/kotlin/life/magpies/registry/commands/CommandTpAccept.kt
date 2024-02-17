package life.magpies.registry.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import java.util.concurrent.CompletableFuture

object CommandTpAccept {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("tpaccept")
                    .executes { ctx: CommandContext<ServerCommandSource> ->
                        acceptTpaRequest(
                            ctx
                        )
                    }
            )
        })
    }

    val teleportRequests: MutableMap<String, String> = HashMap()

    private fun acceptTpaRequest(ctx: CommandContext<ServerCommandSource>): Int {
        val source = ctx.source
        val server = source.server
        val player = source.player

        // 检查是否有传送请求
        val sourcePlayerName = teleportRequests.remove(player!!.name.string)
        if (sourcePlayerName != null) {
            val sourcePlayer = server.playerManager.getPlayer(sourcePlayerName)
            if (sourcePlayer != null) {
                // 异步执行传送操作
                val teleportFuture = CompletableFuture.runAsync {
                    // 执行传送操作
                    sourcePlayer.teleport(
                        player.serverWorld,
                        player.pos.x,
                        player.pos.y,
                        player.pos.z,
                        player.yaw,
                        player.pitch
                    )
                }
                // 在异步任务完成时发送传送成功消息
                teleportFuture.thenRun {
                    source.sendFeedback({
                        Text.translatable(
                            "command.tpaccept.success"
                        ).formatted(Formatting.GREEN)
                    }, false)
                }.exceptionally { e: Throwable ->
                    // 发生异常时发送错误消息
                    source.sendFeedback({
                        Text.literal(
                            "传送时出错" + e.message
                        ).formatted(Formatting.RED)
                    }, false)
                    null
                }

                return Command.SINGLE_SUCCESS
            } else {
                source.sendFeedback({
                    Text.translatable(
                        "command.tpaccept.player_not_found"
                    ).formatted(Formatting.RED)
                }, false)
            }
        } else {
            source.sendFeedback({
                Text.translatable(
                    "command.tpaccept.no_request"
                ).formatted(Formatting.RED)
            }, false)
        }
        return 1
    }
}