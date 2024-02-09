package life.magpies.registry.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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
}
