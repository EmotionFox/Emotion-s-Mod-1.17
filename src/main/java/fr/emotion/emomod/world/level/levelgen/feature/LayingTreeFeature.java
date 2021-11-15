package fr.emotion.emomod.world.level.levelgen.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.predicate.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.material.Material;

public class LayingTreeFeature extends Feature<BlockStateConfiguration>
{
	BlockPredicate IS_GRASS = new BlockPredicate(Blocks.GRASS_BLOCK);

	public LayingTreeFeature(Codec<BlockStateConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> config)
	{
		MutableBlockPos pos = new MutableBlockPos();
		WorldGenLevel wgl = config.level();
		pos.set(config.origin());

		int lenght = 2 + (config.random().nextInt(1) * 2);
		Axis dir = config.random().nextInt(2) == 0 ? Direction.Axis.X : Direction.Axis.Z;

		// Check For Soil
		for (int i = -(lenght / 2); i <= lenght / 2; i++)
		{
			pos.offset(dir == Direction.Axis.X ? i : 0, 0, dir == Direction.Axis.Z ? i : 0);
			boolean flag = IS_GRASS.test(wgl.getBlockState(pos.below())) && validPos(wgl, pos);

			// Bottom Or Top Can Float
			if (i == -(lenght - 1) || i == lenght - 1)
				flag = validPos(wgl, pos);

			if (!flag)
				return false;
		}

		// Trunk
		for (int i = -(lenght / 2); i <= lenght / 2; i++)
		{
			pos.offset(dir == Direction.Axis.X ? i : 0, 0, dir == Direction.Axis.Z ? i : 0);
			wgl.setBlock(pos, config.config().state, 2);
		}

		return true;
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
}
