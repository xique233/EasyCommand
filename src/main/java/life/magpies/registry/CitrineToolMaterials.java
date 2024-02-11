package life.magpies.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CitrineToolMaterials implements ToolMaterial {
    public static final CitrineToolMaterials SLIVER = new CitrineToolMaterials();

    @Override
    public int getDurability() {
        return 2200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.5F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.CITRINE);
    }

}
