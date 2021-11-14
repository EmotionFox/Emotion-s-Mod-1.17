package fr.emotion.emomod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.emotion.emomod.dispenser.IPlaceBehavior;
import fr.emotion.emomod.dispenser.InteractBehavior;
import fr.emotion.emomod.event.EmotionOverlayEvent;
import fr.emotion.emomod.init.BiomeRegistry;
import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.BlockStateProviderTypeRegistry;
import fr.emotion.emomod.init.EntityTypeRegistry;
import fr.emotion.emomod.init.FeatureRegistry;
import fr.emotion.emomod.init.FluidRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import fr.emotion.emomod.init.SurfaceBuilderRegistry;
import fr.emotion.emomod.proxy.ClientProxy;
import fr.emotion.emomod.proxy.IProxy;
import fr.emotion.emomod.proxy.ServerProxy;
import fr.emotion.emomod.world.level.biome.ParcelBiomeSource;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@Mod(MainRegistry.MOD_ID)
public class MainRegistry
{
	public static final String MOD_ID = "emomod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
	public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static MainRegistry instance;

	@ObjectHolder("emomod:parcel_type")
	public static ForgeWorldType PARCEL_TYPE;

	public MainRegistry()
	{
		ItemRegistry.init();
		BlockRegistry.init();
		BiomeRegistry.init();
		BlockStateProviderTypeRegistry.init();
		BlockEntityRegistry.init();
		EntityTypeRegistry.init();
		SurfaceBuilderRegistry.init();
		FeatureRegistry.init();
		FluidRegistry.init();
//		ContainerTypeRegistry.init();

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

		eventBus.addListener(this::setup);
		eventBus.addListener(this::clientSetup);
		eventBus.addListener(this::serverSetup);
		eventBus.addGenericListener(ForgeWorldType.class, this::registerWorldTypes);

		MinecraftForge.EVENT_BUS.register(new EmotionOverlayEvent());
//		MinecraftForge.EVENT_BUS.register(new EmotionLivingEvent());

//		LootItemConditions.(new HarvestLevelCondition.Serializer());

//		EmomodPacketHandler.registerMessages();
	}

	private void setup(final FMLCommonSetupEvent e)
	{
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
//		ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_ATLAS.get().asItem(), 0.3F);
//		ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAPLING_PINE.get().asItem(), 0.3F);
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
//		ComposterBlock.COMPOSTABLES.put(BlockRegistry.MUSHROOM_BLUE.get().asItem(), 0.65F);
//		ComposterBlock.COMPOSTABLES.put(BlockRegistry.MUSHROOM_GREEN.get().asItem(), 0.65F);
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
//		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_ATLAS.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_ATLAS.get());
//		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_PINE.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_PINE.get());
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_COCO.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_COCO.get());
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAPLING_DREAM.get().asItem().getRegistryName(), () -> BlockRegistry.POTTED_SAPLING_DREAM.get());

		proxy.init();
	}

	private void clientSetup(final FMLClientSetupEvent e)
	{
	}

	private void serverSetup(final FMLDedicatedServerSetupEvent e)
	{
	}

	public void registerCommonEvents(IEventBus eventBus)
	{
		eventBus.register(StartupCommon.class);
	}

	private void registerWorldTypes(RegistryEvent.Register<ForgeWorldType> event)
	{
		event.getRegistry().registerAll(new ForgeWorldType(this::createParcelChunkGenerator).setRegistryName("parcel_type"));
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
