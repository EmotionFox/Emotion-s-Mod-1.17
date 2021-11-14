package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.DreamSurfaceBuilder;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.OrchardSurfaceBuilder;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.StonySurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderRegistry
{
	private static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MainRegistry.MOD_ID);

	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> ORCHARD = SURFACE_BUILDERS.register("orchard", () -> new OrchardSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> DREAM = SURFACE_BUILDERS.register("dream", () -> new DreamSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> STONY = SURFACE_BUILDERS.register("stony", () -> new StonySurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));

	public static void init()
	{
		SURFACE_BUILDERS.register(MainRegistry.eventBus);
	}
}
