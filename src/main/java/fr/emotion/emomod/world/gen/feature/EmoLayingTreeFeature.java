package fr.emotion.emomod.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoLayingTreeFeature extends AbstractTreeFeature<NoFeatureConfig>
{

	public EmoLayingTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace)
	{
		super(config, doBlockNofityOnPlace);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		if (!isSoil(worldIn, pos.down(), getSapling()))
			return false;

		boolean onX = true;
		boolean onZ = true;

		for (int i = -1; i <= 1; i++)
		{
			if (!func_214576_j(worldIn, pos.add(i, 0, 0)) && !isAir(worldIn, pos.add(i, 0, 0)))
			{
				onX = false;
			}

			if (!func_214576_j(worldIn, pos.add(0, 0, i)) && !isAir(worldIn, pos.add(0, 0, i)))
			{
				onZ = false;
			}
		}

		Axis dir = Direction.Axis.X;

		if (!onZ && !onX)
			return false;
		else if (!onZ && onX)
		{
		} else if (onZ && !onX)
		{
			dir = Direction.Axis.Z;
		} else if (onZ && onX)
		{
			if (rand.nextInt(2) == 0)
				dir = Direction.Axis.Z;
		}

		switch (dir)
		{
		case X:
			for (int x = -2; x <= 2; x++)
			{
				setLogState(changedBlocks, worldIn, pos.add(x, 0, 0), BlockRegistry.LOG_PINE.getDefaultState().with(RotatedPillarBlock.AXIS, dir), boundsIn);
			}
			break;
		case Z:
			for (int z = -2; z <= 2; z++)
			{
				setLogState(changedBlocks, worldIn, pos.add(0, 0, z), BlockRegistry.LOG_PINE.getDefaultState().with(RotatedPillarBlock.AXIS, dir), boundsIn);
			}
			break;
		default:
			break;
		}

		return true;
	}
}
