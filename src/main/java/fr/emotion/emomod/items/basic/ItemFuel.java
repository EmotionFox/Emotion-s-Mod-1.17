package fr.emotion.emomod.items.basic;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class ItemFuel extends Item
{
	private int burnTime = -1;

	public ItemFuel(Properties properties, int burnTime)
	{
		super(properties);
		this.burnTime = burnTime;
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return this.burnTime;
	}
}
