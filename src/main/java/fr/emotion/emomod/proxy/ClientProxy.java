package fr.emotion.emomod.proxy;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.client.renderer.entity.RendererBoat;
import fr.emotion.emomod.client.renderer.tileentity.TileEntityPotRenderer;
import fr.emotion.emomod.entity.EntityBoar;
import fr.emotion.emomod.entity.EntityChubby;
import fr.emotion.emomod.entity.EntityLightningBug;
import fr.emotion.emomod.entity.EntityMushroom;
import fr.emotion.emomod.entity.model.ModelBeetle;
import fr.emotion.emomod.entity.model.ModelBoar;
import fr.emotion.emomod.entity.model.ModelButterfly;
import fr.emotion.emomod.entity.model.ModelChubby;
import fr.emotion.emomod.entity.model.ModelLightningBug;
import fr.emotion.emomod.entity.model.ModelMouse;
import fr.emotion.emomod.entity.model.ModelMushroom;
import fr.emotion.emomod.entity.renderer.RendererBasic;
import fr.emotion.emomod.entity.renderer.RendererBeetle;
import fr.emotion.emomod.entity.renderer.RendererButterfly;
import fr.emotion.emomod.entity.renderer.RendererMouse;
import fr.emotion.emomod.entity.renderer.RendererOrchardSpider;
import fr.emotion.emomod.event.EmotionGUIEvent;
import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.EntityTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
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

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
		BlockEntityRenderers.register(BlockEntityRegistry.SIGN.get(), SignRenderer::new);
		BlockEntityRenderers.register(BlockEntityRegistry.POT.get(), TileEntityPotRenderer::new);

		event.enqueueWork(() ->
		{
			Sheets.addWoodType(BlockRegistry.CHERRY_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.PEAR_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.ORANGE_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.ATLAS_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.PINE_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.COCO_WOOD_TYPE);
			Sheets.addWoodType(BlockRegistry.DREAM_WOOD_TYPE);
		});
	}

	@SubscribeEvent
	public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(EmoModelLayers.BETTLE, ModelBeetle::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.BOAR, ModelBoar::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.BUTTERFLY, ModelButterfly::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.CHUBBY, ModelChubby::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.LIGHTNING_BUG, ModelLightningBug::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.MOUSE, ModelMouse::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.MUSHROOM, ModelMushroom::createBodyLayer);
	}

	@SubscribeEvent
	public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event)
	{
		event.registerEntityRenderer(EntityTypeRegistry.ORB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EntityTypeRegistry.BUTTERFLY.get(), RendererButterfly::new);
		event.registerEntityRenderer(EntityTypeRegistry.BEETLE.get(), RendererBeetle::new);
		event.registerEntityRenderer(EntityTypeRegistry.LIGHTNING_BUG.get(), render -> new RendererBasic<EntityLightningBug, ModelLightningBug<EntityLightningBug>>(render,
				new ModelLightningBug<EntityLightningBug>(render.bakeLayer(EmoModelLayers.LIGHTNING_BUG)), 0.0f, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/lightning_bug.png")));
		event.registerEntityRenderer(EntityTypeRegistry.BOAT.get(), RendererBoat::new);
		event.registerEntityRenderer(EntityTypeRegistry.CHUBBY.get(),
				render -> new RendererBasic<EntityChubby, ModelChubby<EntityChubby>>(render, new ModelChubby<EntityChubby>(render.bakeLayer(EmoModelLayers.CHUBBY)), .2f, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/chubby.png")));
		event.registerEntityRenderer(EntityTypeRegistry.MOUSE.get(), RendererMouse::new);
		event.registerEntityRenderer(EntityTypeRegistry.ORCHARD_SPIDER.get(), RendererOrchardSpider::new);
		event.registerEntityRenderer(EntityTypeRegistry.BOAR.get(),
				render -> new RendererBasic<EntityBoar, ModelBoar<EntityBoar>>(render, new ModelBoar<EntityBoar>(render.bakeLayer(EmoModelLayers.BOAR)), .5f, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/boar.png")));
		event.registerEntityRenderer(EntityTypeRegistry.MUSHROOM.get(), render -> new RendererBasic<EntityMushroom, ModelMushroom<EntityMushroom>>(render, new ModelMushroom<EntityMushroom>(render.bakeLayer(EmoModelLayers.MUSHROOM)), .2f,
				new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mushroom.png")));
	}

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void onItemColor(ColorHandlerEvent.Item event)
	{
//		event.getItemColors().register((stack, tintIndex) ->
//		{
//			if (tintIndex == 1)
//			{
//				Item offhand = Minecraft.getInstance().player.getOffhandItem().getItem();
//
//				if (offhand == ItemRegistry.SPELL_BOOK_EARTH.get())
//					return 0x7b6f5d;
//				else if (offhand == ItemRegistry.SPELL_BOOK_WATER.get())
//					return 0x4c91c8;
//				else if (offhand == ItemRegistry.SPELL_BOOK_WIND.get())
//					return 0xdfdfde;
//				else if (offhand == ItemRegistry.SPELL_BOOK_FIRE.get())
//					return 0xc79755;
//				else
//					return 0xFFFFFF;
//			} else
//				return 0xFFFFFF;
//		}, ItemRegistry.PURPURA_STAFF.get(), ItemRegistry.SPELL_ORB.get());

		event.getItemColors().register((item, tintIndex) ->
		{
			return GrassColor.get(0.5D, 1.0D);
		}, BlockRegistry.FLOWER_TALLGRASS.get());

		event.getItemColors().register((item, tintIndex) ->
		{
			BlockState blockstate = ((BlockItem) item.getItem()).getBlock().defaultBlockState();
			return Minecraft.getInstance().getBlockColors().getColor(blockstate, (BlockAndTintGetter) null, (BlockPos) null, tintIndex);
		}, BlockRegistry.LEAVES_CHERRY.get(), BlockRegistry.LEAVES_PEAR.get(), BlockRegistry.LEAVES_ORANGE.get(), BlockRegistry.LEAVES_ATLAS.get(), BlockRegistry.LEAVES_PINE.get(), BlockRegistry.LEAVES_COCO.get(), BlockRegistry.LEAVES_DREAM.get());
	}

	@SubscribeEvent
	public static void onItemColor(ColorHandlerEvent.Block event)
	{
		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return reader != null && pos != null ? BiomeColors.getAverageGrassColor(reader, pos) : GrassColor.get(0.5D, 1.0D);
		}, BlockRegistry.FLOWER_TALLGRASS.get());

		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor();
		}, BlockRegistry.LEAVES_PINE.get(), BlockRegistry.LEAVES_COCO.get(), BlockRegistry.LEAVES_DREAM.get());

		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return 0xac73af;
		}, BlockRegistry.LEAVES_CHERRY.get());

		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return 0x487748;
		}, BlockRegistry.LEAVES_PEAR.get());

		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return 0x45a14a;
		}, BlockRegistry.LEAVES_ORANGE.get());

		event.getBlockColors().register((state, reader, pos, color) ->
		{
			return 0x4496c4;
		}, BlockRegistry.LEAVES_ATLAS.get());
	}
}
