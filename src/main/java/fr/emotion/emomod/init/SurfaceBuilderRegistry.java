package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.DreamSurfaceBuilder;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.OrchardSurfaceBuilder;
import fr.emotion.emomod.world.level.levelgen.surfacebuilders.StonySurfaceBuilder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderRegistry
{
	private static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MainRegistry.MOD_ID);

	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> ORCHARD = SURFACE_BUILDERS.register("orchard", () -> new OrchardSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> DREAM = SURFACE_BUILDERS.register("dream", () -> new DreamSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> STONY = SURFACE_BUILDERS.register("stony", () -> new StonySurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));

	public static final Lazy<ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration>> CSB_ORCHARD = Lazy.of(() -> register("orchard", ORCHARD.get().configured(SurfaceBuilder.CONFIG_GRASS)));
	public static final Lazy<ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration>> CSB_DREAM = Lazy.of(() -> register("dream", DREAM.get().configured(SurfaceBuilder.CONFIG_GRASS)));
	public static final Lazy<ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration>> CSB_STONY = Lazy.of(() -> register("stony", STONY.get().configured(SurfaceBuilder.CONFIG_GRASS)));

	public static void init(IEventBus eventBus)
	{
		SURFACE_BUILDERS.register(eventBus);
	}

	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> csb)
	{
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(MainRegistry.MOD_ID, name), csb);
	}
}
