package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.AtlasFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.OrchardFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.SmallTreeFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
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
	public static final RegistryObject<FoliagePlacerType<?>> SMALL_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("small_tree_foliage_placer", () ->
	{
		return new FoliagePlacerType<>(SmallTreeFoliagePlacer.CODEC);
	});
	public static final RegistryObject<FoliagePlacerType<?>> PINE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("pine_foliage_placer", () ->
	{
		return new FoliagePlacerType<>(PineFoliagePlacer.CODEC);
	});

	public static void init(IEventBus eventBus)
	{
		FOLIAGE_PLACER_TYPES.register(eventBus);
	}
}
