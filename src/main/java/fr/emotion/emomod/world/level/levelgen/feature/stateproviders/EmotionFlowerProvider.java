package fr.emotion.emomod.world.level.levelgen.feature.stateproviders;

import java.util.Random;

import com.mojang.serialization.Codec;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.init.BiomeRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.BlockStateProviderTypeRegistry;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class EmotionFlowerProvider extends BlockStateProvider
{
	public static final Codec<EmotionFlowerProvider> CODEC;
	public static final EmotionFlowerProvider INSTANCE = new EmotionFlowerProvider();

	private static final BlockState[] ORCHARD_FLOWERS = new BlockState[]
	{ BlockRegistry.FLOWER_GNON.get().defaultBlockState(), BlockRegistry.FLOWER_KITTY.get().defaultBlockState(), BlockRegistry.FLOWER_NARCOTA.get().defaultBlockState(), Blocks.POPPY.defaultBlockState(), Blocks.DANDELION.defaultBlockState() };
	private static final BlockState[] ANCIENT_FLOWERS = new BlockState[]
	{ BlockRegistry.FLOWER_CENTUS.get().defaultBlockState(), BlockRegistry.FLOWER_THORNY.get().defaultBlockState(), BlockRegistry.FLOWER_NOX.get().defaultBlockState() };
	private static final BlockState[] STONY_FLOWERS = new BlockState[]
	{ BlockRegistry.FLOWER_DELY.get().defaultBlockState(), Blocks.WHITE_TULIP.defaultBlockState(), Blocks.RED_TULIP.defaultBlockState() };
	private static final BlockState[] DREAM_FLOWERS = new BlockState[]
	{ BlockRegistry.FLOWER_NARCOTA.get().defaultBlockState(), BlockRegistry.FLOWER_NEBULA.get().defaultBlockState(), BlockRegistry.FLOWER_TALLGRASS.get().defaultBlockState() };

	@Override
	protected BlockStateProviderType<?> type()
	{
		return BlockStateProviderTypeRegistry.EMOTION_FLOWER_PROVIDER.get();
	}

	@Override
	public BlockState getState(Random rand, BlockPos pos)
	{
		Biome biome = MainRegistry.proxy.getClientLevel().getBiome(pos);

		if (biome == BiomeRegistry.BIOME_ORCHARD.get())
			return Util.getRandom(ORCHARD_FLOWERS, rand);
		else if (biome == BiomeRegistry.BIOME_ANCIENT.get())
			return Util.getRandom(ANCIENT_FLOWERS, rand);
		else if (biome == BiomeRegistry.BIOME_STONY.get())
			return Util.getRandom(STONY_FLOWERS, rand);
		else
			return Util.getRandom(DREAM_FLOWERS, rand);
	}

	static
	{
		CODEC = Codec.unit(() ->
		{
			return INSTANCE;
		});
	}
}
