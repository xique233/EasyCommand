package life.magpies.registry.items

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent


object ModFoodComponents {
    val FRUIT_PUDDING: FoodComponent = FoodComponent.Builder()
        .hunger(6)
        .saturationModifier(0.8f)
        .statusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 300, 2), 1.0f)
        .statusEffect(StatusEffectInstance(StatusEffects.RESISTANCE, 100, 2), 1.0f)
        .statusEffect(StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 1), 1.0f)
        .build()
}