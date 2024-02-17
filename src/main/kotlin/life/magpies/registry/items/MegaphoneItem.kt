package life.magpies.registry.items

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class MegaphoneItem(settings: Settings?) : Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        saySomething(user)
        user.itemCooldownManager[this] = 10
        return super.use(world, user, hand)
    }

    private fun saySomething(user: PlayerEntity) {
        user.sendMessage(Text.literal("Hello World"), false)
    }

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip.add(Text.translatable("好像是能喊出来的大喇叭 其实只是测试用的").formatted(Formatting.DARK_PURPLE))
    }
}