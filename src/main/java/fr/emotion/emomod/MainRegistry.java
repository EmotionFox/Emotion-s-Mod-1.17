package fr.emotion.emomod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.client.renderer.entity.RendererBoat;
import fr.emotion.emomod.dispenser.IPlaceBehavior;
import fr.emotion.emomod.dispenser.InteractBehavior;
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
import fr.emotion.emomod.event.EmotionOverlayEvent;
import fr.emotion.emomod.init.BiomeRegistry;
import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.BlockStateProviderTypeRegistry;
import fr.emotion.emomod.init.EntityTypeRegistry;
import fr.emotion.emomod.init.FeatureRegistry;
import fr.emotion.emomod.init.FluidRegistry;
import fr.emotion.emomod.init.FoliagePlacerTypeRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import fr.emotion.emomod.init.SurfaceBuilderRegistry;
import fr.emotion.emomod.init.TrunkPlacerTypeRegistry;
import fr.emotion.emomod.proxy.ClientProxy;
import fr.emotion.emomod.proxy.IProxy;
import fr.emotion.emomod.proxy.ServerProxy;
import fr.emotion.emomod.world.level.biome.ParcelBiomeSource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@Mod(MainRegistry.MOD_ID)
public class MainRegistry
{
	public static final String MOD_ID = "emomod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static MainRegistry instance;

	@ObjectHolder("emomod:parcel_type")
	public static ForgeWorldType PARCEL_TYPE;

	public MainRegistry()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemRegistry.init(eventBus);
		BlockRegistry.init(eventBus);
		BlockEntityRegistry.init(eventBus);
		EntityTypeRegistry.init(eventBus);
		FluidRegistry.init(eventBus);
		SurfaceBuilderRegistry.init(eventBus);
		BlockStateProviderTypeRegistry.init(eventBus);
		FoliagePlacerTypeRegistry.init(eventBus);
		FeatureRegistry.init(eventBus);
		BiomeRegistry.init(eventBus);
//		ContainerTypeRegistry.init();

		eventBus.addListener(this::setup);
		eventBus.addListener(this::clientSetup);
		eventBus.addListener(this::onRegisterLayerDefinitions);
		eventBus.addListener(this::onRegisterRenderers);
		eventBus.addListener(this::onItemColor);
		eventBus.addListener(this::onBlockColor);
		eventBus.addListener(EventPriority.HIGH, this::onBiomeLoading);
		eventBus.addGenericListener(ForgeWorldType.class, this::registerWorldTypes);

		MinecraftForge.EVENT_BUS.register(new EmotionOverlayEvent());
//		MinecraftForge.EVENT_BUS.register(new EmotionLivingEvent());

//		LootItemConditions.(new HarvestLevelCondition.Serializer());

//		EmomodPacketHandler.registerMessages();

		proxy.init();
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() ->
		{
			TrunkPlacerTypeRegistry.ORCHARD_TRUNK_PLACER.get();
			TrunkPlacerTypeRegistry.ATALS_TRUNK_PLACER.get();

			SurfaceBuilderRegistry.CSB_ORCHARD.get();
			SurfaceBuilderRegistry.CSB_DREAM.get();
			SurfaceBuilderRegistry.CSB_STONY.get();

			FeatureRegistry.CF_ORE_LUME_NETHER.get();
			FeatureRegistry.CF_ORE_PURPURA.get();
			FeatureRegistry.CF_ORE_VIRIDIS.get();
			FeatureRegistry.CF_ORE_FOSSIL.get();

			FeatureRegistry.CF_HUGE_BLUE_MUSHROOM_NATURAL.get();
			FeatureRegistry.CF_HUGE_BLUE_MUSHROOM.get();

			FeatureRegistry.CF_CHERRY_TREE.get();
			FeatureRegistry.CF_PEAR_TREE.get();
			FeatureRegistry.CF_ORANGE_TREE.get();
			FeatureRegistry.CF_ATLAS_TREE.get();

			FeatureRegistry.CF_PINE_LAYING_TREE.get();

			FeatureRegistry.CF_EMO_FLOWER.get();

			FeatureRegistry.CF_ORCHARD_BERRY_BUSH.get();

			DispenserBlock.registerBehavior(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER).getItem(), new InteractBehavior());

			DispenserBlock.registerBehavior(Items.WHEAT_SEEDS, new IPlaceBehavior(Blocks.WHEAT, Blocks.FARMLAND));
			DispenserBlock.registerBehavior(Items.PUMPKIN_SEEDS, new IPlaceBehavior(Blocks.PUMPKIN_STEM, Blocks.FARMLAND));
			DispenserBlock.registerBehavior(Items.MELON_SEEDS, new IPlaceBehavior(Blocks.MELON_STEM, Blocks.FARMLAND));
			DispenserBlock.registerBehavior(Items.BEETROOT_SEEDS, new IPlaceBehavior(Blocks.BEETROOTS, Blocks.FARMLAND));
			DispenserBlock.registerBehavior(Items.CARROT, new IPlaceBehavior(Blocks.CARROTS, Blocks.FARMLAND));
			DispenserBlock.registerBehavior(Items.POTATO, new IPlaceBehavior(Blocks.POTATOES, Blocks.FARMLAND));

			DispenserBlock.registerBehavior(Items.OAK_SAPLING, new IPlaceBehavior(Blocks.OAK_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.ACACIA_SAPLING, new IPlaceBehavior(Blocks.ACACIA_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.BIRCH_SAPLING, new IPlaceBehavior(Blocks.BIRCH_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.DARK_OAK_SAPLING, new IPlaceBehavior(Blocks.DARK_OAK_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.JUNGLE_SAPLING, new IPlaceBehavior(Blocks.JUNGLE_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.SPRUCE_SAPLING, new IPlaceBehavior(Blocks.SPRUCE_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));
			DispenserBlock.registerBehavior(Items.BAMBOO, new IPlaceBehavior(Blocks.BAMBOO_SAPLING, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));

			DispenserBlock.registerBehavior(Items.NETHER_WART, new IPlaceBehavior(Blocks.NETHER_WART, Blocks.SOUL_SAND, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL));

			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_CHERRY.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_PEAR.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_ORANGE.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_ATLAS.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_PINE.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_COCO.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.LEAVES_DREAM.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_CHERRY.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_PEAR.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_ORANGE.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_ATLAS.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_PINE.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_COCO.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_DREAM.get().asItem(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_BLUEBERRY.get(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_REDCURRANT.get(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_BLACKCURRANT.get(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_STRAWBERRY.get(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_STRAWBERRY_CHOCO.get(), 0.3F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.BERRY_DREAMCURRANT.get(), 0.3F);

			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_KITTY.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_NOX.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_DELY.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_GNON.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_THORNY.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_CENTUS.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_TALLGRASS.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_NEBULA.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.FLOWER_NARCOTA.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.MUSHROOM_BLUE.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.MUSHROOM_GREEN.get().asItem(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.FRUIT_PEAR.get(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.FRUIT_CHERRY.get(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.FRUIT_ORANGE.get(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.FRUIT_TOMATO.get(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.TOFFEE_CUBE.get(), 0.65F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.TOFFEE_APPLE.get(), 0.65F);

			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_PEAR.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_CHERRY.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_ORANGE.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_APPLE.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_BLUEBERRY.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_REDCURRANT.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_BLACKCURRANT.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_STRAWBERRY.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_DREAMCURRANT.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_CHOCOLATE.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.SLICE_BREAD.get(), 0.85F);
			ComposterBlock.COMPOSTABLES.put(BlockRegistry.BLUE_MUSHROOM_BLOCK.get().asItem(), 0.85F);

			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_PEAR.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_CHERRY.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_ORANGE.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_APPLE.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_BLUEBERRY.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_REDCURRANT.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_BLACKCURRANT.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_STRAWBERRY.get(), 0.9F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.MUFFIN_DREAMCURRANT.get(), 0.9F);

			ComposterBlock.COMPOSTABLES.put(ItemRegistry.PIE_PEAR.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.PIE_CHERRY.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.PIE_ORANGE.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.PIE_APPLE.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.PIE_MELON.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.CAKE_CHOCO.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.CAKE_FRUIT.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.CAKE_TOFFEE.get(), 1.0F);
			ComposterBlock.COMPOSTABLES.put(ItemRegistry.CAKE_STRAWBERRY.get(), 1.0F);

			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_KITTY.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_KITTY.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_NOX.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_NOX.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_DELY.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_DELY.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_GNON.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_GNON.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_THORNY.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_THORNY.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_CENTUS.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_CENTUS.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_NEBULA.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_NEBULA.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FLOWER_NARCOTA.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_NARCOTA.get());

			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_CHERRY.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_CHERRY.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_PEAR.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_PEAR.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_ORANGE.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_ORANGE.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_ATLAS.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_ATLAS.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_PINE.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_PINE.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_COCO.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_COCO.get());
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_DREAM.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_DREAM.get());
		});
	}

	public void registerWorldTypes(final RegistryEvent.Register<ForgeWorldType> event)
	{
		event.getRegistry().registerAll(new ForgeWorldType(this::createParcelChunkGenerator).setRegistryName("parcel_type"));
	}

	public void onBiomeLoading(final BiomeLoadingEvent event)
	{
		BiomeGenerationSettingsBuilder builder = event.getGeneration();

		if (event.getName() != null)
		{
			if (event.getCategory().equals(Biome.BiomeCategory.NETHER))
			{
				builder.getFeatures(Decoration.UNDERGROUND_ORES).add(() ->
				{
					return FeatureRegistry.CF_ORE_LUME_NETHER.get();
				});
			} else if (!event.getCategory().equals(Biome.BiomeCategory.THEEND))
			{
				for (ConfiguredFeature<?, ?> ore : FeatureRegistry.overworldOres)
				{
					builder.getFeatures(Decoration.UNDERGROUND_ORES).add(() ->
					{
						return ore;
					});
				}

				if (event.getName() == BiomeRegistry.BIOME_ANCIENT.get().getRegistryName())
				{
					builder.getFeatures(Decoration.VEGETAL_DECORATION).add(() ->
					{
						return FeatureRegistry.CF_HUGE_BLUE_MUSHROOM.get();
					});
				}
			}
		}
	}

	public void clientSetup(final FMLClientSetupEvent event)
	{
		BlockEntityRenderers.register(BlockEntityRegistry.SIGN.get(), SignRenderer::new);

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

	public void onRegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(EmoModelLayers.BETTLE, ModelBeetle::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.BOAR, ModelBoar::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.BUTTERFLY, ModelButterfly::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.CHUBBY, ModelChubby::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.LIGHTNING_BUG, ModelLightningBug::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.MOUSE, ModelMouse::createBodyLayer);
		event.registerLayerDefinition(EmoModelLayers.MUSHROOM, ModelMushroom::createBodyLayer);
	}

	public void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event)
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

	public void onItemColor(final ColorHandlerEvent.Item event)
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

	public void onBlockColor(final ColorHandlerEvent.Block event)
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

	public ChunkGenerator createParcelChunkGenerator(Registry<Biome> biomeRegistry, Registry<NoiseGeneratorSettings> dimensionSettingsRegistry, long seed, String generatorSettings)
	{
		ParcelBiomeSource biomeSource = new ParcelBiomeSource(biomeRegistry, seed);

		return new NoiseBasedChunkGenerator(biomeSource, seed, () ->
		{
			return dimensionSettingsRegistry.getOrThrow(NoiseGeneratorSettings.OVERWORLD);
		});
	}
}
