package fr.emotion.emomod.world.level.levelgen.feature.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.FoliagePlacerTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class OrchardFoliagePlacer extends FoliagePlacer
{
	public static final Codec<OrchardFoliagePlacer> CODEC = RecordCodecBuilder.create((builder) ->
	{
		return foliagePlacerParts(builder).and(IntProvider.codec(0, 16).fieldOf("trunk_height").forGetter((getter) ->
		{
			return getter.trunkHeight;
		})).apply(builder, OrchardFoliagePlacer::new);
	});
	
	private final IntProvider trunkHeight;

	public OrchardFoliagePlacer(IntProvider p_161411_, IntProvider p_161412_, IntProvider trunkHeight)
	{
		super(p_161411_, p_161412_);
		this.trunkHeight = trunkHeight;
	}

	@Override
	protected FoliagePlacerType<?> type()
	{
		return FoliagePlacerTypeRegistry.ORCHARD_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader p_161422_, BiConsumer<BlockPos, BlockState> p_161423_, Random p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int p_161428_, int p_161429_, int p_161430_)
	{
	}

	@Override
	public int foliageHeight(Random p_68568_, int p_68569_, TreeConfiguration p_68570_)
	{
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(Random p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_)
	{
		return false;
	}
}
