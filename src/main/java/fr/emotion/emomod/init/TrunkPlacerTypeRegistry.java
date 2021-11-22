package fr.emotion.emomod.init;

import com.mojang.serialization.Codec;

import fr.emotion.emomod.world.level.levelgen.feature.trunkplacers.AtlasTrunkPlacer;
import fr.emotion.emomod.world.level.levelgen.feature.trunkplacers.OrchardTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.common.util.Lazy;

public class TrunkPlacerTypeRegistry<P extends TrunkPlacer>
{
	public static final Lazy<TrunkPlacerType<OrchardTrunkPlacer>> ORCHARD_TRUNK_PLACER = Lazy.of(() -> register("orchard_trunk_placer", OrchardTrunkPlacer.CODEC));
	public static final Lazy<TrunkPlacerType<AtlasTrunkPlacer>> ATALS_TRUNK_PLACER = Lazy.of(() -> register("atlas_trunk_placer", AtlasTrunkPlacer.CODEC));
	private final Codec<P> codec;

	public static <P extends TrunkPlacer> TrunkPlacerType<P> register(String name, Codec<P> codec)
	{
		return Registry.register(Registry.TRUNK_PLACER_TYPES, name, new TrunkPlacerType<>(codec));
	}

	public TrunkPlacerTypeRegistry(Codec<P> codec)
	{
		this.codec = codec;
	}

	public Codec<P> codec()
	{
		return this.codec;
	}
}
