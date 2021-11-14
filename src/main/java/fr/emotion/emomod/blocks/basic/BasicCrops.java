package fr.emotion.emomod.blocks.basic;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BasicCrops extends CropBlock
{
	private Item seed;

	public BasicCrops(BlockBehaviour.Properties properties, Item seed)
	{
		super(properties);
		this.seed = seed;
	}

	@Override
	protected ItemLike getBaseSeedId()
	{
		return seed;
	}
}
