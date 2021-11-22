package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.AtlasFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.OrchardFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoliagePlacerTypeRegistry
{
	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, MainRegistry.MOD_ID);

	public static final RegistryObject<FoliagePlacerType<?>> ORCHARD_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("orchard_foliage_placer", () ->
	{
		return new FoliagePlacerType<>(OrchardFoliagePlacer.CODEC);
	});
	public static final RegistryObject<FoliagePlacerType<?>> ATLAS_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("atlas_foliage_placer", () ->
	{
		return new FoliagePlacerType<>(AtlasFoliagePlacer.CODEC);
	});

	public static void init()
	{
		FOLIAGE_PLACER_TYPES.register(MainRegistry.eventBus);
	}
}
