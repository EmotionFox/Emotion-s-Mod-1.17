package fr.emotion.emomod.event;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.init.DimensionRegistry;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EmotionDimensionEvent
{
	@SubscribeEvent
	public static void registerDimensions(RegisterDimensionsEvent e)
	{
		if (DimensionType.byName(DimensionRegistry.DREAM_TYPE) == null)
			DimensionManager.registerDimension(DimensionRegistry.DREAM_TYPE, DimensionRegistry.DREAM_HEAVEN, null, true);
		if (DimensionType.byName(DimensionRegistry.NIGHTMARE_HELL_TYPE) == null)
			DimensionManager.registerDimension(DimensionRegistry.NIGHTMARE_HELL_TYPE, DimensionRegistry.NIGHTMARE_HELL, null, true);
	}
}
