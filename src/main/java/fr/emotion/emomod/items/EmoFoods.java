package fr.emotion.emomod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class EmoFoods
{
	public static final FoodProperties PEAR = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties CHERRY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties ORANGE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).build();
	public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();

	public static final FoodProperties BLUEBERRY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.POISON, 250, 0);
	}, 0.1F).build();
	public static final FoodProperties REDCURRANT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.POISON, 250, 0);
	}, 0.1F).build();
	public static final FoodProperties BLACKCURRANT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.POISON, 250, 0);
	}, 0.1F).build();
	public static final FoodProperties STRAWBERRY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.POISON, 250, 0);
	}, 0.1F).build();
	public static final FoodProperties DREAMCURRANT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.POISON, 250, 0);
	}, 0.1F).build();

	public static final FoodProperties STRAWBERRY_CHOCO = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).build();

	public static final FoodProperties SLICE_PEAR = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_CHERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_ORANGE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_BLUEBERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_REDCURRANT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_BLACKCURRANT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_STRAWBERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_DREAMCURRANT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).fast().build();
	public static final FoodProperties SLICE_CHOCOLATE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).fast().build();
	public static final FoodProperties SLICE_BREAD = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast().build();

	public static final FoodProperties SALAD_FRUIT = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0);
	}, 1.0F).build();
	public static final FoodProperties SALAD_TOMATO = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).effect(() ->
	{
		return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0);
	}, 1.0F).build();
	public static final FoodProperties SALAD_PUMKIN = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.6F).build();

	public static final FoodProperties JUICE_PEAR = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties JUICE_CHERRY = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
	public static final FoodProperties JUICE_ORANGE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).build();
	public static final FoodProperties JUICE_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties JUICE_TOMATO = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();

	public static final FoodProperties PIE_PEAR = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();
	public static final FoodProperties PIE_CHERRY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final FoodProperties PIE_ORANGE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
	public static final FoodProperties PIE_APPLE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();
	public static final FoodProperties PIE_MELON = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();

	public static final FoodProperties MUFFIN_PEAR = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_CHERRY = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_ORANGE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_APPLE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_BLUEBERRY = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_REDCURRANT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_BLACKCURRANT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_STRAWBERRY = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties MUFFIN_DREAMCURRANT = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).build();

	public static final FoodProperties TOFFEE_CUBE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties TOFFEE_APPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();

	public static final FoodProperties WILDBOAR_RAW = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).meat().build();
	public static final FoodProperties WILDBOAR_COOKED = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).meat().build();

	public static final FoodProperties TROUT_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties BASS_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties SARDINE_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties MACKEREL_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties WHITING_RAW = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();

	public static final FoodProperties TROUT_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties BASS_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties SARDINE_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties MACKEREL_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties WHITING_COOKED = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
}
