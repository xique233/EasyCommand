package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.context.CommandContext
import life.magpies.utils.ModManager
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object CommandTpcAetp {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("tpcept")
                    .requires { source: ServerCommandSource ->
                        source.hasPermissionLevel(
                            0
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

    private fun execute(ctx: CommandContext<ServerCommandSource>, targetPlayer: String?): Int {
        //获取命令源
        val source = ctx.source
        val player = CommandUtils.getPlayer(ctx) ?: return 0
        // 获取uuid
        if (source.isExecutedByPlayer) {
            val sourceUUID = player.uuid
            val target = source.server.playerManager.getPlayer(targetPlayer)
            val targetUUID = target!!.uuid

            val manager = ModManager.manager
            val request = manager.getRequest(targetUUID, sourceUUID)

            if (request != null && request.isValid) {
                source.sendFeedback({
                    Text.literal(
                        "您已接授请求"
                    ).formatted(Formatting.GREEN)
                }, false)
                target.sendMessage(Text.literal("对方已接授请求").formatted(Formatting.GREEN), false)
                manager.remove(request)
                player.teleport(
                    target.serverWorld,
                    target.pos.x,
                    target.pos.y,
                    target.pos.z,
                    target.yaw,
                    target.pitch
                )
            } else {
                source.sendFeedback({
                    Text.literal(
                        "传送请求失效 获者您未有请求"
                    ).formatted(Formatting.RED)
                }, false)
            }
        }
        return 1
    }
}