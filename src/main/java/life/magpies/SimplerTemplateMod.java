package life.magpies;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import life.magpies.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.ItemEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class SimplerTemplateMod implements ModInitializer {
    public static final String MOD_ID = "simplertemplatemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        KillItemCommand();
        LOGGER.info("Hello Fabric world!");
        ModItems.registerItem();
    }


    private static void KillItemCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("kit")
                    .executes(context -> executeWithRadius(context, 5))
                    .then(argument("radius", IntegerArgumentType.integer())
                            .executes(context -> {
                                return executeWithRadius(context, IntegerArgumentType.getInteger(context, "radius"));
                            })));
        });
    }

    private static int executeWithRadius(CommandContext<ServerCommandSource> context, int radius) {

        if (radius > 30) {
            context.getSource().sendFeedback(() -> Text.literal(("只支持到最大30半径")), false);
            return 0;
        }
        // 获取玩家的位置
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
        context.getSource().sendFeedback(() -> Text.literal("data:r = %s playPos = %s world = %s kill = %s ".formatted(radius, playPos, world, ref.killEntities)), false);
        return radius;
    }
}

