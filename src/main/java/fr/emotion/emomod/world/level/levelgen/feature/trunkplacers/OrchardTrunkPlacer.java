package fr.emotion.emomod.world.level.levelgen.feature.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class OrchardTrunkPlacer extends TrunkPlacer
{
	public static final Codec<OrchardTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70261_) ->
	{
		return trunkPlacerParts(p_70261_).apply(p_70261_, OrchardTrunkPlacer::new);
	});

	public OrchardTrunkPlacer(int height, int bonusHeightA, int bonusHeightB)
	{
		super(height, bonusHeightA, bonusHeightB);
	}

	@Override
	protected TrunkPlacerType<?> type()
	{
		return null;
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader p_161868_, BiConsumer<BlockPos, BlockState> p_161869_, Random p_161870_, int p_161871_, BlockPos p_161872_, TreeConfiguration p_161873_)
	{
		return null;
	}

}
