package fr.emotion.emomod.tools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeInput
{
	private char key;
	private ItemStack ingredient;
	private String tagName = "";

	public RecipeInput(Block ingredient)
	{
		this(new ItemStack(ingredient));
	}

	public RecipeInput(Item ingredient)
	{
		this(new ItemStack(ingredient));
	}

	public RecipeInput(ItemStack ingredient)
	{
		this(' ', ingredient);
	}

	public RecipeInput(char key, Block ingredient)
	{
		this(key, new ItemStack(ingredient));
	}

	public RecipeInput(char key, Item ingredient)
	{
		this(key, new ItemStack(ingredient));
	}

	public RecipeInput(char key, ItemStack ingredient)
	{
		this.key = key;
		this.ingredient = ingredient;
	}

	public RecipeInput(char key, String tagName)
	{
		this.key = key;
		this.tagName = tagName;
	}

	public char getKey()
	{
		return this.key;
	}

	public String getName()
	{
		return this.tagName.isEmpty() ? this.ingredient.getItem().getRegistryName().toString() : this.tagName;
	}

	public String getTag()
	{
		return this.tagName.isEmpty() ? "item" : "tag";
	}
}
