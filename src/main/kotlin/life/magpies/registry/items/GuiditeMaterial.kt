package life.magpies.registry.items

import life.magpies.registry.ModItems
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient


object CitrineMaterial:ToolMaterial {
    override fun getDurability(): Int {
        return 2200
    }

    override fun getMiningSpeedMultiplier(): Float {
        return 5.0f
    }

    override fun getAttackDamage(): Float {
        return 3.5f
    }

    override fun getMiningLevel(): Int {
        return 1
    }

    override fun getEnchantability(): Int {
        return 18
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(ModItems.CITRINE)
    }

    val INSTANCE: CitrineMaterial = CitrineMaterial

}