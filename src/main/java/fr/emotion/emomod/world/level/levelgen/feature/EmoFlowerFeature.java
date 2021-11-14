package fr.emotion.emomod.world.level.levelgen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import fr.emotion.emomod.init.BiomeRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DefaultFlowerFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class EmoFlowerFeature extends DefaultFlowerFeature
{
	private Biome biome = null;

	public EmoFlowerFeature(Codec<RandomPatchConfiguration> config)
	{
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context)
	{
		this.biome = context.level().getBiome(context.origin());
		return super.place(context);
	}

	@Override
	public BlockState getRandomFlower(Random rand, BlockPos pos, RandomPatchConfiguration config)
	{
		int i;

		if (biome != null)
		{
			if (biome == BiomeRegistry.BIOME_ORCHARD.get())
			{
				i = rand.nextInt(4);

				switch (i)
				{
				default:
				case 0:
					return BlockRegistry.FLOWER_GNON.get().defaultBlockState();
				case 1:
					return BlockRegistry.FLOWER_KITTY.get().defaultBlockState();
				case 2:
					return BlockRegistry.FLOWER_NARCOTA.get().defaultBlockState();
				case 3:
					return Blocks.POPPY.defaultBlockState();
				case 4:
					return Blocks.DANDELION.defaultBlockState();
				}
			} else if (biome == BiomeRegistry.BIOME_ANCIENT.get())
			{
				i = rand.nextInt(2);

				switch (i)
				{
				default:
				case 0:
					return BlockRegistry.FLOWER_CENTUS.get().defaultBlockState();
				case 1:
					return BlockRegistry.FLOWER_THORNY.get().defaultBlockState();
				case 2:
					return BlockRegistry.FLOWER_NOX.get().defaultBlockState();
				}
			} else if (biome == BiomeRegistry.BIOME_STONY.get())
			{
				i = rand.nextInt(2);

				switch (i)
				{
				default:
				case 0:
					return BlockRegistry.FLOWER_DELY.get().defaultBlockState();
				case 1:
					return Blocks.WHITE_TULIP.defaultBlockState();
				case 2:
					return Blocks.RED_TULIP.defaultBlockState();
				}
			} else if (biome == BiomeRegistry.BIOME_DREAM.get())
			{
				i = rand.nextInt(2);

				switch (i)
				{
				default:
				case 0:
					return BlockRegistry.FLOWER_NARCOTA.get().defaultBlockState();
				case 1:
					return BlockRegistry.FLOWER_NEBULA.get().defaultBlockState();
				case 2:
					return BlockRegistry.FLOWER_TALLGRASS.get().defaultBlockState();
				}
			}
		}

		return Blocks.POPPY.defaultBlockState();
	}
}
