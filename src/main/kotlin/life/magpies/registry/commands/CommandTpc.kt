package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.context.CommandContext
import life.magpies.utils.ModManager
import life.magpies.utils.TeleportRequest
import life.magpies.utils.TeleportRequestManager
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object CommandTpc {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("tpc")
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

    private fun execute(ctx: CommandContext<ServerCommandSource>, targetPlayer: String): Int {
        //获取命令源
        val source = ctx.source
        // 获取uuid
        val player = CommandUtils.getPlayer(ctx) ?: return 0
        val sourceUUID = player.uuid
        val target = source.server.playerManager.getPlayer(targetPlayer)
        val targetUUID = target!!.uuid
        val manager: TeleportRequestManager = ModManager.manager
        val request: TeleportRequest? = manager.getRequest(sourceUUID, targetUUID)

        if (request == null || !request.isValid) {
            source.sendFeedback({
                Text.literal(
                    "传送请求已发送给 $targetPlayer"
                ).formatted(Formatting.GOLD)
            }, false)
            target.sendMessage(
                Text.literal(source.name + " 请求传送到您此处").formatted(Formatting.GOLD),
                false
            )
            manager.add(TeleportRequest(sourceUUID, targetUUID))
        } else {
            source.sendFeedback({
                Text.literal(
                    "你已经向 $target 请求了请等待回复"
                ).formatted(Formatting.RED)
            }, false)
        }
        return 1
    }
}