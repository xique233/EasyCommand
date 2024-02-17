package life.magpies.registry.commands

import com.mojang.brigadier.context.CommandContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.Vec3d

object CommandUtils {
    /**
     * 获取当前执行命令的玩家实体
     *
     * @param ctx 命令上下文
     * @return 当前执行命令的玩家实体，如果命令不是由玩家执行或者玩家为空，则返回null
     */
    fun getPlayer(ctx: CommandContext<ServerCommandSource>): ServerPlayerEntity? {
        val source = ctx.source
        if (source.isExecutedByPlayer && source.player != null) {
            return source.player
        }
        return null
    }


    /**
     * 服务器向所有玩家发送消息
     *
     * @param source 发送消息的服务器命令源
     * @param text   要发送的消息文本
     */
    fun serverMessage(source: ServerCommandSource, text: Text) {
        return source.server.playerManager.broadcast(text, false)
    }


    /**
     * 检查玩家是否是服务器玩家实体，因为只有服务器玩家实体才有世界属性
     * @param player 玩家实体
     */
    fun onPlayerJoinWorld(player: PlayerEntity?): String {
        // 如果玩家是服务器玩家实体
        if (player is ServerPlayerEntity) {
            // 将玩家实体转换为服务器玩家实体
            // 获取玩家所在的世界
            val world = player.getWorld()
            // 检查世界是否是服务器世界，因为服务器世界有额外的方法和属性
            if (world is ServerWorld) {
                // 返回服务器世界的注册键值
                return world.getRegistryKey().value.toString()
            }
        }
        // 如果玩家不是服务器玩家实体或者世界不是服务器世界，则返回空字符串
        return ""
    }

    /**
     * 格式化位置坐标为字符串
     *
     * @param position 位置坐标
     * @return 格式化后的字符串
     */
    fun formattingPosition(position: Vec3d): String {
        // 获取位置的X、Y、Z坐标
        val x = position.getX()
        val y = position.getY()
        val z = position.getZ()
        // 格式化位置坐标为字符串
        return String.format("(X: %.2f, Y: %.2f, Z: %.2f)", x, y, z)
    }


}