package fr.emotion.emomod.event;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class EmotionGUIEvent
{
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void OnGuiOpen(GuiOpenEvent e)
	{
		if (e.getGui() instanceof TitleScreen)
		{
			ObfuscationReflectionHelper.setPrivateValue(TitleScreen.class, (TitleScreen) e.getGui(), new PanoramaRenderer(new CubeMap(new ResourceLocation(MainRegistry.MOD_ID, "textures/gui/title/background/panorama"))), "field_209101_K");
		}
	}
}
