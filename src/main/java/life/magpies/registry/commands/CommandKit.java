package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class CommandKit {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("kit")
                    .executes(context -> execute(context, 5))
                    .then(argument("radius", integer())
                            .executes(ctx -> execute(ctx, getInteger(ctx, "radius")))
                    ));
        });
    }

    private static int execute(CommandContext<ServerCommandSource> context, int radius) {
        if (radius > 30) {
            context.getSource().sendFeedback(() -> Text.literal(("只支持到最大30半径")), false);
            return 0;
        }
        // 获取玩家的对象
        ServerPlayerEntity player = context.getSource().getPlayer();
        // 获取玩家的位置
        assert player != null;
        Vec3d playPos = player.getPos();
        // 获取世界对象
        World world = player.getEntityWorld();
        var ref = new Object() {
            int killEntities = 0;
        };
        // 遍历世界中的实体
        // 检查实体是否不是玩家本身
        // 检查实体是否是生物（如生物实体而不是方块或物品）
        world.getEntitiesByClass(ItemEntity.class, new Box(playPos.getX() - radius,
                        playPos.getY() - radius,
                        playPos.getZ() - radius,
                        playPos.getX() + radius,
                        playPos.getY() + radius,
                        playPos.getZ() + radius),
                (entity) -> true).stream().filter(entity -> !entity.equals(player)).forEach(entity -> {
            entity.kill();
            ref.killEntities++;
        });
        context.getSource().sendFeedback(() -> Text.literal("清理了附近的%s个掉落物".formatted(ref.killEntities)), false);
        return 1;
    }

}
