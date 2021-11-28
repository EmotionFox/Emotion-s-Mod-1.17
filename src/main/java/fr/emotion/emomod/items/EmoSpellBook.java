package fr.emotion.emomod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class EmoSpellBook extends Item
{
	private SpellList spell;

	public EmoSpellBook(SpellList spell, Properties properties)
	{
		super(properties);
		this.spell = spell;
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return 100;
	}

	public SpellList getSpell()
	{
		return this.spell;
	}

	public enum SpellList
	{
		EARTH("earth"), WATER("water"), WIND("wind"), FIRE("fire");

		private String name;

		private SpellList(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}
	}
}
