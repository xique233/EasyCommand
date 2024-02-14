package life.magpies.registry.items;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
public static final FoodComponent FRUIT_PUDDING = new FoodComponent
        .Builder()
        .hunger(6)
        .saturationModifier(0.8f)
        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 2), 1.0f)
        .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 2), 1.0f)
        .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 1), 1.0f)
        .build();
}
