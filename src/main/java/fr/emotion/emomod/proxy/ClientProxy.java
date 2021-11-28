package fr.emotion.emomod.proxy;

import fr.emotion.emomod.event.EmotionGUIEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy
{
	@Override
	@OnlyIn(Dist.CLIENT)
	public void init()
	{
		BiomeColors.FOLIAGE_COLOR_RESOLVER = (biome, x, z) ->
		{
			return biome.getFoliageColor();
		};

		MinecraftForge.EVENT_BUS.register(new EmotionGUIEvent());

//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySign.class, new TileEntitySignRenderer());
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrafter.class, new TileEntityCrafterRenderer());
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPot.class, new TileEntityPotRenderer());

//		MenuScreens.register(null, null);

//		ScreenManager.<CrafterContainer, CrafterScreen>registerFactory(ContainerTypeRegistry.CRAFTER, (container, playerInventory, title) ->
//		{
//			return new CrafterScreen(container, playerInventory, title);
//		});
//
//		ScreenManager.<BagContainer, BagScreen>registerFactory(ContainerTypeRegistry.BAG, (container, playerInventory, title) ->
//		{
//			return new BagScreen(container, playerInventory, title);
//		});
//
//		ScreenManager.<NightstandContainer, NightstandScreen>registerFactory(ContainerTypeRegistry.NIGHTSTAND, (container, playerInventory, title) ->
//		{
//			return new NightstandScreen(container, playerInventory, title, container.getTileEntity().getColor());
//		});
	}

	@SuppressWarnings("resource")
	@Override
	public Level getClientLevel()
	{
		return Minecraft.getInstance().level;
	}

	@SuppressWarnings("resource")
	@Override
	public Player getClientPlayer()
	{
		return Minecraft.getInstance().player;
	}
}
