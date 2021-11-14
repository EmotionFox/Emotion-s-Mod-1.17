package fr.emotion.emomod.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoLittleTreeFeature extends AbstractTreeFeature<NoFeatureConfig>
{
	private static final BlockState logBlock = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState leavesBlock = Blocks.OAK_LEAVES.getDefaultState();

	public EmoLittleTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace)
	{
		super(config, doBlockNofityOnPlace);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		if (isSoil(worldIn, pos.down(), getSapling()) && pos.getY() < 245 && isAir(worldIn, pos))
		{
			for (int l = -1; l <= 1; l++)
			{
				if (isAir(worldIn, pos.add(l, 0, 0)) || func_214587_a(worldIn, pos.add(1, 0, 0)))
					setBlockState(worldIn, pos.add(l, 0, 0), leavesBlock);
				if (isAir(worldIn, pos.add(0, 0, l)) || func_214587_a(worldIn, pos.add(0, 0, 1)))
					setBlockState(worldIn, pos.add(0, 0, l), leavesBlock);
			}

			setBlockState(worldIn, pos, logBlock);
			setBlockState(worldIn, pos.up(), leavesBlock);

			return true;
		}
		return false;
	}
}
