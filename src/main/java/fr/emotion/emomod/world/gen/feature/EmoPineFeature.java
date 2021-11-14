package fr.emotion.emomod.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoPineFeature extends AbstractTreeFeature<NoFeatureConfig>
{
	private static final int minHeight = 6;
	private static final BlockState log = BlockRegistry.LOG_PINE.getDefaultState();
	private static final BlockState leaves = BlockRegistry.LEAVES_PINE.getDefaultState();

	public EmoPineFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace)
	{
		super(config, doBlockNofityOnPlace);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		float heightPourcentage = ((pos.getY() - 65) * 100) / (worldIn.getMaxHeight() - 65);
		float smallChancePourcentage = 25.0F + ((float) rand.nextInt(25));
		int height = minHeight;
		int smallHeight = 3 + rand.nextInt(1);

		if (heightPourcentage <= 10.0F)
		{
			height += 6 + rand.nextInt(3);
		} else if (heightPourcentage <= 20.0F)
		{
			height += 3 + rand.nextInt(3);
		} else if (heightPourcentage <= 30.0F)
		{
			height += 3;
			smallChancePourcentage += 25.0F + ((float) rand.nextInt(25));
		} else
		{
			smallChancePourcentage += 50.0F + ((float) rand.nextInt(25));
		}

		boolean isSmall = false;

		if (rand.nextInt(100) <= ((int) Math.ceil(smallChancePourcentage)))
			isSmall = true;

		if (worldIn.hasBlockState(pos.down(), (state) ->
		{
			return state.getBlock() != Blocks.GRASS_BLOCK;
		}))
			return false;

		if (isSoil(worldIn, pos.down(), getSapling()) && pos.getY() + (isSmall ? smallHeight : height) + 1 <= worldIn.getMaxHeight())
		{
			for (int y = 0; y <= (isSmall ? smallHeight : height); y++)
			{
				if (!isAirOrLeaves(worldIn, pos.add(0, y, 0)) && func_214587_a(worldIn, pos.add(0, y, 0)))
					return false;
			}
		}

		spawnTree(isSmall, isSmall ? smallHeight : height, changedBlocks, worldIn, rand, pos, boundsIn);

		return true;
	}

	public void spawnTree(boolean isSmall, int height, Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		if (isSmall)
		{
			// Trunk
			for (int y = 0; y < height; y++)
			{
				setLogState(changedBlocks, worldIn, pos.add(0, y, 0), log, boundsIn);
			}

			// Leaves
			for (int x = -1; x <= 1; x++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if (isAir(worldIn, pos.add(x, height - 2, z)))
						setLogState(changedBlocks, worldIn, pos.add(x, height - 2, z), leaves, boundsIn);
				}
			}

			for (int i = -1; i <= 1; i++)
			{
				if (isAir(worldIn, pos.add(i, height - 1, 0)))
					setLogState(changedBlocks, worldIn, pos.add(i, height - 1, 0), leaves, boundsIn);
				if (isAir(worldIn, pos.add(0, height - 1, i)))
					setLogState(changedBlocks, worldIn, pos.add(0, height - 1, i), leaves, boundsIn);
			}

			for (int y = 0; y <= 1; y++)
			{
				if (isAir(worldIn, pos.add(0, height + y, 0)))
					setLogState(changedBlocks, worldIn, pos.add(0, height + y, 0), leaves, boundsIn);
			}
		} else // Is Big
		{
			int heightLayer = ((int) Math.ceil(height / 4)) - 1;

			// Trunk
			for (int y = 0; y < height; y++)
			{
				setLogState(changedBlocks, worldIn, pos.add(0, y, 0), log, boundsIn);
			}

			// Leaves
			if (isAir(worldIn, pos.add(0, height + 1, 0)))
				setLogState(changedBlocks, worldIn, pos.add(0, height + 1, 0), leaves, boundsIn);

			for (int y = 0; y <= 2; y++)
			{
				for (int i = -1; i <= 1; i++)
				{
					if (isAir(worldIn, pos.add(i, y + height - 1, 0)))
						setLogState(changedBlocks, worldIn, pos.add(i, y + height - 2, 0), leaves, boundsIn);
					if (isAir(worldIn, pos.add(0, y + height - 1, i)))
						setLogState(changedBlocks, worldIn, pos.add(0, y + height - 2, i), leaves, boundsIn);
				}
			}

			for (int a = 0; a <= heightLayer; a++)
			{
				int heightPoint = height - 3;
				heightPoint -= 3 * a;

				if (a > 0)
				{
					for (int i = -a; i <= a; i++)
					{
						if (isAir(worldIn, pos.add(i, heightPoint, 0)))
							setLogState(changedBlocks, worldIn, pos.add(i, heightPoint, 0), log.with(RotatedPillarBlock.AXIS, Direction.Axis.X), boundsIn);
						if (isAir(worldIn, pos.add(0, heightPoint, i)))
							setLogState(changedBlocks, worldIn, pos.add(0, heightPoint, i), log.with(RotatedPillarBlock.AXIS, Direction.Axis.Z), boundsIn);
					}
				}

				for (int y = 0; y <= 2; y++)
				{
					for (int i = -2 - a; i <= 2 + a; i++)
					{
						if (isAir(worldIn, pos.add(i, y + heightPoint, 0)))
							setLogState(changedBlocks, worldIn, pos.add(i, y + heightPoint, 0), leaves, boundsIn);
						if (isAir(worldIn, pos.add(0, y + heightPoint, i)))
							setLogState(changedBlocks, worldIn, pos.add(0, y + heightPoint, i), leaves, boundsIn);
					}
				}

				for (int y = 0; y <= 3; y++)
				{
					for (int x = -1 - a; x <= 1 + a; x++)
					{
						for (int z = -1 - a; z <= 1 + a; z++)
						{
							if ((x == -1 - a || x == 1 + a) && (z == -1 - a || z == 1 + a))
							{

							} else
							{
								if (isAir(worldIn, pos.add(x, y + heightPoint, z)))
									setLogState(changedBlocks, worldIn, pos.add(x, y + heightPoint, z), leaves, boundsIn);
							}
						}
					}
				}
			}
		}
	}
}
