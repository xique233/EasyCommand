package life.magpies.registry.items.custom

import life.magpies.registry.ModItems
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class CitrineToolMaterials : ToolMaterial {
    override fun getDurability(): Int {
        return 2200
    }

    override fun getMiningSpeedMultiplier(): Float {
        return 9.0f
    }

    override fun getAttackDamage(): Float {
        return 3.5f
    }

    override fun getMiningLevel(): Int {
        return 4
    }

    override fun getEnchantability(): Int {
        return 22
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(ModItems.CITRINE)
    }

    companion object {
        val SLIVER: CitrineToolMaterials = CitrineToolMaterials()
    }
}