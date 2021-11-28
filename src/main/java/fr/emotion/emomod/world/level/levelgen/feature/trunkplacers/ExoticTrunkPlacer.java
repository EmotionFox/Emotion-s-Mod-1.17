package fr.emotion.emomod.world.level.levelgen.feature.trunkplacers;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

public abstract class ExoticTrunkPlacer extends TrunkPlacer
{
	public ExoticTrunkPlacer(int height, int heightRandA, int heightRandB)
	{
		super(height, heightRandA, heightRandB);
	}

	protected static boolean placeLogOnAxis(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> biconsumer, Random rand, BlockPos pos, TreeConfiguration config, Direction.Axis axis)
	{
		return placeLogOnAxis(reader, biconsumer, rand, pos, config, axis, Function.identity());
	}

	protected static boolean placeLogOnAxis(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> biconsumer, Random rand, BlockPos pos, TreeConfiguration config, Direction.Axis axis, Function<BlockState, BlockState> function)
	{
		if (TreeFeature.validTreePos(reader, pos))
		{
			biconsumer.accept(pos, function.apply(config.trunkProvider.getState(rand, pos).setValue(RotatedPillarBlock.AXIS, axis)));
			return true;
		} else
			return false;
	}
}
