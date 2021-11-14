package fr.emotion.emomod.world.level.levelgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class BerryBushFeatureConfiguration implements FeatureConfiguration
{
	public static final Codec<BerryBushFeatureConfiguration> CODEC = RecordCodecBuilder.create((builder) ->
	{
		return builder.group(Codec.STRING.fieldOf("type").forGetter((getter) ->
		{
			return getter.type.getName();
		})).apply(builder, BerryBushFeatureConfiguration::new);
	});

	public final BerryBushType type;

	public BerryBushFeatureConfiguration(String type)
	{
		this.type = BerryBushType.valueOf(type);
	}

	public enum BerryBushType
	{
		ORCHARD("orchard", new Block[]
		{ BlockRegistry.BUSH_REDCURRANT.get(), BlockRegistry.BUSH_STRAWBERRY.get() }), STONY("stony", new Block[]
		{ BlockRegistry.BUSH_BLACKCURRANT.get() }), ANCIENT("ancient", new Block[]
		{ BlockRegistry.BUSH_BLUEBERRY.get() }), DREAM("dream", new Block[]
		{ BlockRegistry.BUSH_DREAMCURRANT.get() });

		private String name;
		private Block[] list;

		BerryBushType(String name, Block[] list)
		{
			this.name = name;
			this.list = list;
		}

		public Block[] getList()
		{
			return this.list;
		}

		public String getName()
		{
			return this.name;
		}
	}
}
