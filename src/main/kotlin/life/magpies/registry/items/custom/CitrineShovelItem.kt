package life.magpies.registry.items.custom

import net.minecraft.item.ShovelItem
import net.minecraft.item.ToolMaterial

class CitrineShovelItem(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) :
    ShovelItem(material, attackDamage.toFloat(), attackSpeed, settings)