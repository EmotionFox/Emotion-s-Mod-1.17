package fr.emotion.emomod.world.level.levelgen.feature;

import com.mojang.serialization.Codec;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

public class EmoTreeFeature extends Feature<NoneFeatureConfiguration>
{
	private static final Block[] logBlocks = new Block[]
	{ BlockRegistry.LOG_CHERRY.get(), BlockRegistry.LOG_ORANGE.get(), BlockRegistry.LOG_PEAR.get() };
	private static final Block[] leavesBlocks = new Block[]
	{ BlockRegistry.LEAVES_CHERRY.get(), BlockRegistry.LEAVES_ORANGE.get(), BlockRegistry.LEAVES_PEAR.get() };
	private BlockState logBlock;
	private BlockState leavesBlock;
	private boolean planted = false;

	public EmoTreeFeature(Codec<NoneFeatureConfiguration> config, BlockState log, BlockState leaves)
	{
		this(config);
		this.logBlock = log;
		this.leavesBlock = leaves;
		planted = true;
	}

	public EmoTreeFeature(Codec<NoneFeatureConfiguration> config)
	{
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
	{
		int height = 5 + context.random().nextInt(2);
		BlockPos newPos = context.origin();

		if (!planted)
		{
			int type = context.random().nextInt(logBlocks.length);
			logBlock = logBlocks[type].defaultBlockState();
			leavesBlock = leavesBlocks[type].defaultBlockState();

			for (int x = 0; x <= 16; x++)
			{
				for (int z = 0; z <= 16; z++)
				{
					BlockPos testPos = context.origin().offset(x, 0, z);
					testPos = context.level().getHeightmapPos(Heightmap.Types.WORLD_SURFACE, testPos);

					if ((testPos.getX() % 8 == 0 && testPos.getZ() % 8 == 0) && context.random().nextInt(5) == 0)
						newPos = testPos;
				}
			}

			if (newPos == null)
				return false;
		}

		if (validTreePos(context.level(), newPos.below()) && newPos.getY() + height + 1 <= context.level().getMaxBuildHeight())
		{
			for (int x = 1; x <= 3; x++)
			{
				for (int z = 0; z <= 2; z++)
				{
					for (int y = -3; y <= -1; y++)
					{
						if (isAir(context.level(), newPos.offset(x, y + height, z)))
							setBlock(context.level(), newPos.offset(x, y + height, z), leavesBlock);
						if (isAir(context.level(), newPos.offset(-x, y + height, -z)))
							setBlock(context.level(), newPos.offset(-x, y + height, -z), leavesBlock);
						if (isAir(context.level(), newPos.offset(-z, y + height, x)))
							setBlock(context.level(), newPos.offset(-z, y + height, x), leavesBlock);
						if (isAir(context.level(), newPos.offset(z, y + height, -x)))
							setBlock(context.level(), newPos.offset(z, y + height, -x), leavesBlock);
					}
				}
			}

			BlockPos lPos1 = newPos.offset(1, height - 2, 3);
			BlockPos lPos2 = newPos.offset(-1, height - 2, -3);
			BlockPos lPos3 = newPos.offset(3, height - 2, -1);
			BlockPos lPos4 = newPos.offset(-3, height - 2, 1);

			if (isAir(context.level(), lPos1))
				setBlock(context.level(), lPos1, leavesBlock);
			if (isAir(context.level(), lPos1.east()))
				setBlock(context.level(), lPos1.east(), leavesBlock);
			if (isAir(context.level(), lPos1.above()))
				setBlock(context.level(), lPos1.above(), leavesBlock);

			if (isAir(context.level(), lPos2))
				setBlock(context.level(), lPos2, leavesBlock);
			if (isAir(context.level(), lPos2.west()))
				setBlock(context.level(), lPos2.west(), leavesBlock);
			if (isAir(context.level(), lPos2.above()))
				setBlock(context.level(), lPos2.above(), leavesBlock);

			if (isAir(context.level(), lPos3))
				setBlock(context.level(), lPos3, leavesBlock);
			if (isAir(context.level(), lPos3.north()))
				setBlock(context.level(), lPos3.north(), leavesBlock);
			if (isAir(context.level(), lPos3.above()))
				setBlock(context.level(), lPos3.above(), leavesBlock);

			if (isAir(context.level(), lPos4))
				setBlock(context.level(), lPos4, leavesBlock);
			if (isAir(context.level(), lPos4.south()))
				setBlock(context.level(), lPos4.south(), leavesBlock);
			if (isAir(context.level(), lPos4.above()))
				setBlock(context.level(), lPos4.above(), leavesBlock);

			for (int x = -2; x <= 2; x++)
			{
				for (int y = 0; y <= 1; y++)
				{
					for (int z = -1; z <= 1; z++)
					{
						if (isAirOrLeaves(context.level(), newPos.offset(x, height + y, z)))
							setBlock(context.level(), newPos.offset(x, height + y, z), leavesBlock);
						if (isAirOrLeaves(context.level(), newPos.offset(z, height + y, x)))
							setBlock(context.level(), newPos.offset(z, height + y, x), leavesBlock);
					}
				}
			}

			for (int x = -1; x <= 1; x++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if (isAirOrLeaves(context.level(), newPos.offset(x, height - 3, z)))
						setBlock(context.level(), newPos.offset(x, height - 3, z), Blocks.AIR.defaultBlockState());
				}
			}

			for (int i = -3; i <= 3; i++)
			{
				if (isAirOrLeaves(context.level(), newPos.offset(i, height, 0)))
					setBlock(context.level(), newPos.offset(i, height, 0), leavesBlock);
				if (isAirOrLeaves(context.level(), newPos.offset(0, height, i)))
					setBlock(context.level(), newPos.offset(0, height, i), leavesBlock);

				if (i != -3 && i != 3)
				{
					if (isAirOrLeaves(context.level(), newPos.offset(i, height - 2, 0)))
						setBlock(context.level(), newPos.offset(i, height - 2, 0), logBlock.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
					if (isAirOrLeaves(context.level(), newPos.offset(0, height - 2, i)))
						setBlock(context.level(), newPos.offset(0, height - 2, i), logBlock.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
				}
			}

			for (int y = 0; y <= height; y++)
			{
				if (isAirOrLeaves(context.level(), newPos.offset(0, y, 0)) || isReplaceablePlant(context.level(), newPos.offset(0, y, 0)))
					setBlock(context.level(), newPos.offset(0, y, 0), logBlock);
			}

			return true;
		}

		return false;
	}

	private static boolean isBlockWater(LevelSimulatedReader p_67283_, BlockPos p_67284_)
	{
		return p_67283_.isStateAtPosition(p_67284_, (p_67271_) ->
		{
			return p_67271_.is(Blocks.WATER);
		});
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader p_67268_, BlockPos p_67269_)
	{
		return p_67268_.isStateAtPosition(p_67269_, (p_67266_) ->
		{
			return p_67266_.isAir() || p_67266_.is(BlockTags.LEAVES);
		});
	}

	private static boolean isReplaceablePlant(LevelSimulatedReader p_67289_, BlockPos p_67290_)
	{
		return p_67289_.isStateAtPosition(p_67290_, (p_160551_) ->
		{
			Material material = p_160551_.getMaterial();
			return material == Material.REPLACEABLE_PLANT;
		});
	}

	public static boolean validTreePos(LevelSimulatedReader p_67273_, BlockPos p_67274_)
	{
		return isAirOrLeaves(p_67273_, p_67274_) || isReplaceablePlant(p_67273_, p_67274_) || isBlockWater(p_67273_, p_67274_);
	}
}
