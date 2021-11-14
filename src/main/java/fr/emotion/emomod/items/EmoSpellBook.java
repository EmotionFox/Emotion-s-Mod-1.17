package fr.emotion.emomod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class EmoSpellBook extends Item
{
	private SpellList spell;

	public EmoSpellBook(SpellList spell, Properties properties)
	{
		super(properties);
		this.spell = spell;
	}

	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return 100;
	}
	
	public SpellList getSpell()
	{
		return this.spell;
	}

	public enum SpellList implements IStringSerializable
	{
		EARTH("earth"), WATER("water"), WIND("wind"), FIRE("fire");

		private String name;

		private SpellList(String name)
		{
			this.name = name;
		}

		@Override
		public String getName()
		{
			return name;
		}
	}
}
