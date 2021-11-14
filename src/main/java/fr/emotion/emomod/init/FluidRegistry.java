package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.fluid.AncientWaterFluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidRegistry
{
	private static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, MainRegistry.MOD_ID);

	public static final RegistryObject<FlowingFluid> FLOWING_ANCIENT_WATER = FLUID.register("flowing_ancient_water", () ->
	{
		return new AncientWaterFluid.Flowing();
	});
	public static final RegistryObject<FlowingFluid> ANCIENT_WATER = FLUID.register("ancient_water", () ->
	{
		return new AncientWaterFluid.Source();
	});

	public static void init()
	{
		FLUID.register(MainRegistry.eventBus);
	}
}
