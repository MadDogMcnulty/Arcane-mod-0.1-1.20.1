package net.Jackson.arcanemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;



public class ModFoods {

    public static final FoodProperties SHIMMER_SYRINGE = new FoodProperties.Builder().nutrition(10)
            .saturationMod(3f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 500), 0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900), 0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900), 0.9f)
            .build();

    public static final FoodProperties TAINTED_ROTTEN_FLESH = new FoodProperties.Builder().nutrition(5)
            .saturationMod(1.3f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 1200), 0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 1200), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800), 0.9f)
            .build();
}
