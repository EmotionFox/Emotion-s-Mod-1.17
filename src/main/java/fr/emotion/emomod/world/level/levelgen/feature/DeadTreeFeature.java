package fr.emotion.emomod.world.level.levelgen.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

public class DeadTreeFeature extends Feature<NoneFeatureConfiguration>
{
	private static final BlockStatePredicate IS_SAND = BlockStatePredicate.forBlock(Blocks.SAND);

	public DeadTreeFeature(Codec<NoneFeatureConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> config)
	{
		MutableBlockPos pos = new MutableBlockPos();
		WorldGenLevel wgl = config.level();
		pos.set(config.origin());

		if (!IS_SAND.test(wgl.getBlockState(pos.below())))
			return false;
		else
		{
			BlockState state = Blocks.DARK_OAK_LOG.defaultBlockState();
			int height = 6 + config.random().nextInt(2);

			// Trunk
			for (int y = 0; y < height; y++)
			{
				pos.offset(0, y, 0);
				boolean flag = validPos(wgl, pos);

				if (flag)
					wgl.setBlock(pos, state, 2);
			}

			wgl.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
			pos.setWithOffset(pos, 0, height - 4, 0);

			int chance = 0;
			int[] placeX = new int[]
			{ 1, -1, 0, 0 };
			int[] placeZ = new int[]
			{ 0, 0, -1, 1 };

			Axis dir = Direction.Axis.X;

			// Random Branches
			for (int y = 0; y < 4; y++)
			{
				if (y > 2)
					dir = Direction.Axis.Z;

				if (config.random().nextInt(4 - chance) == 0)
				{
					pos.offset(placeX[y], y + 1, placeZ[y]);
					boolean flag = validPos(wgl, pos);

					if (flag)
						wgl.setBlock(pos, state.setValue(RotatedPillarBlock.AXIS, dir), 2);
				} else
					chance++;
			}

			// Soil
			for (int x = -2; x <= 2; x++)
			{
				for (int z = -2; z <= 2; z++)
				{
					if ((x == -2 || x == 2) && (z == -2 || z == 2))
					{
					} else
					{
						pos.offset(x, 0, z);
						int y = getTop(wgl, pos);
						pos.offset(0, y, 0);

						if (y != 666)
						{
							wgl.setBlock(pos, Blocks.PODZOL.defaultBlockState(), 2);

							if (config.random().nextInt(10) == 0)
								wgl.setBlock(pos.above(), Blocks.DEAD_BUSH.defaultBlockState(), 2);
						}
					}
				}
			}

			return true;
		}
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader reader, BlockPos pos)
	{
		return reader.isStateAtPosition(pos, (predicate) ->
		{
			return predicate.isAir() || predicate.is(BlockTags.LEAVES);
		});
	}

	public static boolean isReplaceablePlant(LevelSimulatedReader reader, BlockPos pos)
	{
		return reader.isStateAtPosition(pos, (predicate) ->
		{
			Material mat = predicate.getMaterial();
			return mat == Material.REPLACEABLE_PLANT;
		});
	}

	public static boolean validPos(LevelSimulatedReader reader, BlockPos pos)
	{
		return isAirOrLeaves(reader, pos) || isReplaceablePlant(reader, pos);
	}

	public int getTop(LevelSimulatedReader reader, BlockPos pos)
	{
		for (int y = -4; y < 4; y++)
		{
			pos.offset(0, y, 0);

			boolean flag1 = reader.isStateAtPosition(pos.below(), (predicate) ->
			{
				return predicate.is(Blocks.SAND);
			});

			if (flag1 && isAirOrLeaves(reader, pos))
				return y - 1;
		}

		// EL DIABLO
		return 666;
	}
}
