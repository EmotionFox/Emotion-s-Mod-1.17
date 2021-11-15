package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.OrchardFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FoliagePlacerTypeRegistry
{
	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, MainRegistry.MOD_ID);

	public static final RegistryObject<FoliagePlacerType<?>> ORCHARD_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("", () ->
	{
		return new FoliagePlacerType<>(OrchardFoliagePlacer.CODEC);
	});
	
	public static void init()
	{
		FOLIAGE_PLACER_TYPES.register(MainRegistry.eventBus);
	}
}
