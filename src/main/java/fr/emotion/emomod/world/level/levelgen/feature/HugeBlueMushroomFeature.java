package fr.emotion.emomod.world.level.levelgen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

public class HugeBlueMushroomFeature extends AbstractHugeMushroomFeature
{
	public boolean natural;

	public HugeBlueMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec, boolean natural)
	{
		super(codec);
		this.natural = natural;
	}

	@Override
	protected void makeCap(LevelAccessor accessor, Random rand, BlockPos pos, int height, MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config)
	{
		BlockState block = config.capProvider.getState(rand, pos);

		mutablePos.setWithOffset(pos, 0, this.getTreeHeight(rand), 0);

		for (int y = 0; y <= 2; y++)
		{
			mutablePos.offset(0, y, 0);

			this.placeBlock(accessor, mutablePos.offset(2, -4, 2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
			this.placeBlock(accessor, mutablePos.offset(2, -4, -2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
			this.placeBlock(accessor, mutablePos.offset(-2, -4, 2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
			this.placeBlock(accessor, mutablePos.offset(-2, -4, -2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
		}

		for (int x = -1; x <= 1; x++)
		{
			for (int y = 0; y <= 1; y++)
			{
				mutablePos.offset(0, y, 0);

				this.placeBlock(accessor, mutablePos.offset(x, -4, 3), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, -4, -3), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(3, -4, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(-3, -4, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(2, -1, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(-2, -1, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, -1, 2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, -1, -2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false)));
			}

			if (x == -1 || x == 1)
			{
				this.placeBlock(accessor, mutablePos.offset(x, -2, 2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, -2, -2), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(2, -2, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(-2, -2, x), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));

				this.placeBlock(accessor, mutablePos.offset(x, 0, 1), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, 0, -1), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false))
						.setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
			}
		}

		this.placeBlock(accessor, mutablePos.offset(0, -2, -3), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(false)));
		this.placeBlock(accessor, mutablePos.offset(-3, -2, 0), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(false)));
		this.placeBlock(accessor, mutablePos.offset(0, -2, 3), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(false)));
		this.placeBlock(accessor, mutablePos.offset(3, -2, 0), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.WEST, Boolean.valueOf(false)));

		this.placeBlock(accessor, mutablePos.offset(0, -1, 3), block);
		this.placeBlock(accessor, mutablePos.offset(3, -1, 0), block);
		this.placeBlock(accessor, mutablePos.offset(0, -1, -3), block);
		this.placeBlock(accessor, mutablePos.offset(-3, -1, 0), block);

		for (int x = -2; x <= 2; x++)
		{
			for (int z = -2; z <= 2; z++)
			{
				this.placeBlock(accessor, mutablePos.offset(x, -4, z), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(x, -4, z), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(-x, -4, z), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)));
				this.placeBlock(accessor, mutablePos.offset(-x, -4, z), block.setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false)).setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)));
			}
		}

		if (this.natural && rand.nextInt(7) == 0)
		{
			setBlock(accessor, mutablePos.offset(0, -3, 0), Blocks.CHEST.defaultBlockState());

			BlockEntity blockEntity = accessor.getBlockEntity(mutablePos.offset(0, -3, 0));

			if (blockEntity != null && blockEntity instanceof ChestBlockEntity)
				((ChestBlockEntity) blockEntity).setLootTable(BuiltInLootTables.SIMPLE_DUNGEON, rand.nextLong());
		}
	}

	@Override
	protected int getTreeRadiusForHeight(int p_65094_, int p_65095_, int p_65096_, int p_65097_)
	{
		return p_65097_ <= 3 ? 0 : p_65096_;
	}

	@Override
	protected int getTreeHeight(Random rand)
	{
		return 8 + rand.nextInt(2);
	}

	public void placeBlock(LevelAccessor accessor, BlockPos pos, BlockState state)
	{
		if (!accessor.getBlockState(pos).isSolidRender(accessor, pos))
			this.setBlock(accessor, pos, state);
	}
}
