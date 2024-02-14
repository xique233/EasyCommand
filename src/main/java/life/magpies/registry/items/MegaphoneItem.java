package life.magpies.registry.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MegaphoneItem extends Item {
    public MegaphoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        saySomething(user);
        user.getItemCooldownManager().set(this, 10);
        return super.use(world, user, hand);
    }

    private void saySomething(PlayerEntity user) {
        user.sendMessage(Text.literal("Hello World"), false);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("好像是能喊出来的大喇叭 其实只是测试用的").formatted(Formatting.DARK_PURPLE) );
    }
}
