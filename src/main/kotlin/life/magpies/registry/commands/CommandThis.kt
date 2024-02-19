package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import life.magpies.registry.commands.CommandUtils.formattingPosition
import life.magpies.registry.commands.CommandUtils.onPlayerJoinWorld
import life.magpies.registry.config.ModConfig
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object CommandThis {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(CommandManager.literal("this")
                .requires { source: ServerCommandSource ->
                    source.hasPermissionLevel(ModConfig.hear)
                }
                .executes { ctx -> execute(ctx) }
            )
        })
    }

    /**
     * 执行命令，如果满足特定条件，则为玩家应用发光效果。
     *
     * @param ctx 命令上下文
     * @return 整型数值
     */
    private fun execute(ctx: CommandContext<ServerCommandSource>): Int {
        // 获取命令源
        val source = ctx.source
        // 获取发起玩家
        val player = CommandUtils.getPlayer(ctx) ?: return 0
        // 格式化玩家的位置信息
        val formattedPosition = formattingPosition(player.pos)
        val world = onPlayerJoinWorld(player)
        // 为玩家添加发光效果
        source.player!!.addStatusEffect(StatusEffectInstance(StatusEffects.GLOWING, 600, 10))
        // 向玩家发送反馈消息
        CommandUtils.serverMessage(
            source,
            Text.literal(player.name.string + " " + world + " " + formattedPosition).formatted(Formatting.YELLOW)
        )
        // 返回整型数值
        return 1
    }


}