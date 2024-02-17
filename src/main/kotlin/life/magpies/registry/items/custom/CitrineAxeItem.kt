package life.magpies.registry.items.custom

import net.minecraft.item.AxeItem
import net.minecraft.item.ToolMaterial


class CitrineAxeItem(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) :
    AxeItem(material, attackDamage.toFloat(), attackSpeed, settings)