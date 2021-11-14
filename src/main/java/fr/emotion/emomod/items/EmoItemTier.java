package fr.emotion.emomod.items;

import java.util.function.Supplier;

import fr.emotion.emomod.init.ItemRegistry;
import fr.emotion.emomod.tags.EmoTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum EmoItemTier implements Tier
{
	PURPURA(4, 1750, 10.0F, 3.5F, 8, () ->
	{
		return Ingredient.of(ItemRegistry.PURPURA_SHARD.get());
	}), FOSSIL(3, 150, 5.0F, 1.5F, 16, () ->
	{
		return Ingredient.of(ItemRegistry.FOSSIL.get());
	});

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private EmoItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient)
	{
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	public int getUses()
	{
		return this.uses;
	}

	public float getSpeed()
	{
		return this.speed;
	}

	public float getAttackDamageBonus()
	{
		return this.damage;
	}

	public int getLevel()
	{
		return this.level;
	}

	public int getEnchantmentValue()
	{
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient()
	{
		return this.repairIngredient.get();
	}

	@javax.annotation.Nullable
	public net.minecraft.tags.Tag<net.minecraft.world.level.block.Block> getTag()
	{
		return switch (this)
		{
		case PURPURA -> EmoTags.NEEDS_PURPURA_TOOL;
		case FOSSIL -> BlockTags.NEEDS_IRON_TOOL;
		};
	}
}
