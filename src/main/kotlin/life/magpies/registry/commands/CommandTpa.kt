package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.context.CommandContext
import life.magpies.registry.commands.CommandTpAccept.teleportRequests
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object CommandTpa {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("tpa")
                    .requires { source: ServerCommandSource ->
                        source.hasPermissionLevel(
                            1
                        )
                    }
                    .then(
                        CommandManager.argument("player", StringArgumentType.word())
                            .suggests(PlayerSuggestionProvider.suggestPlayers)
                            .executes { ctx: CommandContext<ServerCommandSource> ->
                                val targetPlayer = StringArgumentType.getString(ctx, "player")
                                execute(ctx, targetPlayer)
                            }
                    )
            )
        })
    }


    private fun execute(ctx: CommandContext<ServerCommandSource>, targetPlayer: String): Int {
        val source = ctx.source
        val playerNames = source.playerNames
        val targetPlayerEntity = source.server.playerManager.getPlayer(targetPlayer)
        // 从服务器玩家列表中筛选目标玩家名称
        if (playerNames.contains(targetPlayer) && source.name != targetPlayer) {
            // 向目标玩家发送传送消息
            targetPlayerEntity!!.sendMessage(
                Text.literal(source.name + " 向您发起了传送请求").formatted(Formatting.GOLD), false
            )
            teleportRequests[targetPlayer] = source.name
            targetPlayerEntity.sendMessage(
                Text.literal("接受传送请使用/tpaccept").formatted(Formatting.GOLD),
                false
            )
            source.sendFeedback({
                Text.literal(
                    "传送请求已发送给 $targetPlayer"
                ).formatted(Formatting.GOLD)
            }, false)

            // 如果目标玩家不存在或者是自己，则发送相应消息
        } else if (!playerNames.contains(targetPlayer)) {
            source.sendFeedback({
                Text.literal(
                    "玩家 $targetPlayer 不在服务器上"
                ).formatted(Formatting.RED)
            }, false)
        } else {
            source.sendError(
                Text.translatable(
                    "command.tpa.error_n1"
                )
            )
        }
        return 1
    }
}