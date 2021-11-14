package fr.emotion.emomod.dispenser;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class IPlaceBehavior implements DispenseItemBehavior
{
	private Block block;
	private Block[] soilList;

	public IPlaceBehavior(Block block, Block... soil)
	{
		this.block = block;

		if (soil.length > 0)
		{
			soilList = new Block[soil.length];

			for (int i = 0; i < soil.length; i++)
			{
				soilList[i] = soil[i];
			}
		}
	}

	@Override
	public ItemStack dispense(BlockSource source, ItemStack stack)
	{
		BlockPos pos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
		BlockState target = source.getLevel().getBlockState(pos);

		boolean isSoil = false;

		for (int i = 0; i < soilList.length; i++)
		{
			if (target.getBlock() == soilList[i])
				isSoil = true;
		}

		if (isSoil && source.getLevel().isEmptyBlock(pos.above()))
		{
			source.getLevel().blockEvent(source.getPos(), source.getBlockState().getBlock(), 1000, 0);
			source.getLevel().setBlockAndUpdate(pos.above(), block.defaultBlockState());
			stack.shrink(1);
		}
		else if (isSoil)
		{
			source.getLevel().blockEvent(source.getPos(), source.getBlockState().getBlock(), 1001, 0);
		}
		else
			return (new DefaultDispenseItemBehavior()).dispense(source, stack);

		return stack;
	}
}
