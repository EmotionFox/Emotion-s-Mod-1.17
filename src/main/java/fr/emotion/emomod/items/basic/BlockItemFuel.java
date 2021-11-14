package fr.emotion.emomod.items.basic;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class BlockItemFuel extends BlockItem
{
	private int burnTime = -1;

	public BlockItemFuel(Block blockIn, Properties builder, int burnTime)
	{
		super(blockIn, builder);
		this.burnTime = burnTime;
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return this.burnTime;
	}
}
