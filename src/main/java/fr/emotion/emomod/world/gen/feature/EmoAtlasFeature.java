package fr.emotion.emomod.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoAtlasFeature extends AbstractTreeFeature<NoFeatureConfig>
{
	private static final int height = 8;
	private static final BlockState log = BlockRegistry.LOG_ATLAS.getDefaultState();
	private static final BlockState leaves = BlockRegistry.LEAVES_ATLAS.getDefaultState();
	private boolean natural;
	private IChunk previous = null;

	public EmoAtlasFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, boolean natural)
	{
		super(config, doBlockNofityOnPlace);
		this.natural = natural;
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		for (int x = -2; x <= 2; x++)
		{
			for (int z = -2; z <= 2; z++)
			{
				if (!isSoil(worldIn, pos.down().add(x, 0, z), getSapling()))
					return false;
			}
		}

		if (previous != null && worldIn instanceof IWorld)
		{
			if (previous.getPos() == ((IWorld) worldIn).getChunk(pos).getPos())
				return false;
			else
				previous = ((IWorld) worldIn).getChunk(pos);
		}
		else if (worldIn instanceof IWorld)
		{
			previous = ((IWorld) worldIn).getChunk(pos);
		}

		if (isSoil(worldIn, pos.down(), getSapling()) && isAir(worldIn, pos.up()) && pos.getY() + height + 1 <= worldIn.getMaxHeight())
		{
			for (int i = -2; i <= 2; i++)
			{
				if ((!isAir(worldIn, pos.add(i, 0, 0)) && !func_214587_a(worldIn, pos.add(i, 0, 0))) || (!isAir(worldIn, pos.add(0, 0, i)) && !func_214587_a(worldIn, pos.add(0, 0, i))))
					return false;
			}

			for (int x = -3; x <= 3; x++)
			{
				for (int z = -1; z <= 1; z++)
				{
					setLogState(changedBlocks, worldIn, pos.add(x, height - 3, z), leaves, boundsIn);
					setLogState(changedBlocks, worldIn, pos.add(z, height - 3, x), leaves, boundsIn);

					if (x != -3 && x != 3)
					{
						setLogState(changedBlocks, worldIn, pos.add(x, height - 3, x), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(+x, height - 3, -x), leaves, boundsIn);
					}

					setLogState(changedBlocks, worldIn, pos.add(x, height - 2, 0), leaves, boundsIn);
					setLogState(changedBlocks, worldIn, pos.add(x, height - 1, 0), leaves, boundsIn);
					setLogState(changedBlocks, worldIn, pos.add(0, height - 2, x), leaves, boundsIn);
					setLogState(changedBlocks, worldIn, pos.add(0, height - 1, x), leaves, boundsIn);
				}
			}

			for (int x = -2; x <= 2; x++)
			{
				for (int y = 0; y <= 2; y++)
				{
					for (int z = -1; z <= 1; z++)
					{
						setLogState(changedBlocks, worldIn, pos.add(x, (height - 2) + y, z), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(z, (height - 2) + y, x), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(z, height + 1, z), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(-z, height + 1, +z), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(0, height + 1, z), leaves, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(z, height + 1, 0), leaves, boundsIn);
					}
				}
			}

			for (int i = -2; i <= 2; i++)
			{
				for (int y = 0; y <= 2; y++)
				{
					if ((i == -2 || i == 2) && y != 2)
					{
						setLogState(changedBlocks, worldIn, pos.add(i, y, 0), log, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(0, y, i), log, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(i, 6, 0), log, boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(0, 6, i), log, boundsIn);
					}
					else if (i != -2 && i != 2)
					{
						setLogState(changedBlocks, worldIn, pos.add(i, 2, 0), log.with(RotatedPillarBlock.AXIS, Direction.Axis.X), boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(0, 2, i), log.with(RotatedPillarBlock.AXIS, Direction.Axis.Z), boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(i, 5, 0), log.with(RotatedPillarBlock.AXIS, Direction.Axis.X), boundsIn);
						setLogState(changedBlocks, worldIn, pos.add(0, 5, i), log.with(RotatedPillarBlock.AXIS, Direction.Axis.Z), boundsIn);
					}
				}
			}

			for (int y = 2; y <= height; y++)
			{
				setLogState(changedBlocks, worldIn, pos.add(0, y, 0), log, boundsIn);
			}

			if (natural && rand.nextInt(5) == 0)
				setLogState(changedBlocks, worldIn, pos, BlockRegistry.MUSHROOM_BLUE.getDefaultState(), boundsIn);

			return true;
		}

		return false;
	}

}
