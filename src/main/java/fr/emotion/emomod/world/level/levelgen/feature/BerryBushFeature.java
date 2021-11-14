package fr.emotion.emomod.world.level.levelgen.feature;

import com.mojang.serialization.Codec;

import fr.emotion.emomod.world.level.levelgen.feature.configurations.BerryBushFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;

public class BerryBushFeature extends Feature<BerryBushFeatureConfiguration>
{
	public BerryBushFeature(Codec<BerryBushFeatureConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BerryBushFeatureConfiguration> configuration)
	{
		BlockState state = configuration.config().type.getList()[configuration.random().nextInt(configuration.config().type.getList().length)].defaultBlockState();

		if (validBushPos(configuration.level(), configuration.origin()) && configuration.level().getBlockState(configuration.origin().below()).getBlock() == Blocks.GRASS_BLOCK)
		{
			configuration.level().setBlock(configuration.origin(), state, 0);
			return true;
		} else
			return false;
	}

	public static boolean isAirOrLeaves(LevelSimulatedReader reader, BlockPos pos)
	{
		return reader.isStateAtPosition(pos, (p_67266_) ->
		{
			return p_67266_.isAir() || p_67266_.is(BlockTags.LEAVES);
		});
	}

	private static boolean isReplaceablePlant(LevelSimulatedReader reader, BlockPos pos)
	{
		return reader.isStateAtPosition(pos, (p_160551_) ->
		{
			Material material = p_160551_.getMaterial();
			return material == Material.REPLACEABLE_PLANT;
		});
	}

	public static boolean validBushPos(LevelSimulatedReader reader, BlockPos pos)
	{
		return isAirOrLeaves(reader, pos) || isReplaceablePlant(reader, pos);
	}
}
