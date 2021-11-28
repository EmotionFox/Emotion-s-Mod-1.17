package fr.emotion.emomod.init;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.feature.BerryBushFeature;
import fr.emotion.emomod.world.level.levelgen.feature.HugeBlueMushroomFeature;
import fr.emotion.emomod.world.level.levelgen.feature.LayingTreeFeature;
import fr.emotion.emomod.world.level.levelgen.feature.configurations.BerryBushFeatureConfiguration;
import fr.emotion.emomod.world.level.levelgen.feature.configurations.BerryBushFeatureConfiguration.BerryBushType;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.AtlasFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.foliageplacers.OrchardFoliagePlacer;
import fr.emotion.emomod.world.level.levelgen.feature.stateproviders.EmotionFlowerProvider;
import fr.emotion.emomod.world.level.levelgen.feature.trunkplacers.AtlasTrunkPlacer;
import fr.emotion.emomod.world.level.levelgen.feature.trunkplacers.OrchardTrunkPlacer;
import fr.emotion.emomod.world.level.levelgen.placement.OrchardDecorator;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneDecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.ConfiguredDecorator;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags.Blocks;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistry
{
	public static List<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
	public static final RuleTest DIRT = new TagMatchTest(Blocks.DIRT);

	// Feature
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MainRegistry.MOD_ID);

	public static final RegistryObject<Feature<HugeMushroomFeatureConfiguration>> HUGE_BLUE_MUSHROOM_NATURAL = FEATURES.register("huge_blue_mushroom_natural", () -> new HugeBlueMushroomFeature(HugeMushroomFeatureConfiguration.CODEC, true));
	public static final RegistryObject<Feature<HugeMushroomFeatureConfiguration>> HUGE_BLUE_MUSHROOM = FEATURES.register("huge_blue_mushroom", () -> new HugeBlueMushroomFeature(HugeMushroomFeatureConfiguration.CODEC, false));
	public static final RegistryObject<Feature<BlockStateConfiguration>> LAYING_TREE = FEATURES.register("laying_tree", () -> new LayingTreeFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BerryBushFeatureConfiguration>> BERRY_BUSH = FEATURES.register("berry_bush", () -> new BerryBushFeature(BerryBushFeatureConfiguration.CODEC));

	// FeatureDecorator
	public static final DeferredRegister<FeatureDecorator<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, MainRegistry.MOD_ID);

	public static final RegistryObject<FeatureDecorator<?>> ORCHARD_FEATURE = DECORATORS.register("orchard", () -> new OrchardDecorator(NoneDecoratorConfiguration.CODEC));
	@SuppressWarnings("unchecked")
	public static final Lazy<ConfiguredDecorator<?>> ORCHARD_CONFIGURED = Lazy
			.of(() -> Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD.decorated(((FeatureDecorator<NoneDecoratorConfiguration>) ORCHARD_FEATURE.get()).configured(DecoratorConfiguration.NONE)));

	// ConfiguredFeature
	public static final Lazy<ConfiguredFeature<?, ?>> CF_ORE_LUME_NETHER = Lazy
			.of(() -> register("ore_lume_nether", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, BlockRegistry.LUME_ORE.get().defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(16)));
	public static final Lazy<ConfiguredFeature<?, ?>> CF_ORE_PURPURA = Lazy.of(() -> register("ore_purpura",
			Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockRegistry.PURPURA_ORE.get().defaultBlockState(), 4)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(16)).squared()));
	public static final Lazy<ConfiguredFeature<?, ?>> CF_ORE_VIRIDIS = Lazy.of(() -> register("ore_viridis",
			Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockRegistry.VIRIDIS_ORE.get().defaultBlockState(), 4)).rangeUniform(VerticalAnchor.aboveBottom(64), VerticalAnchor.top()).squared()));
	public static final Lazy<ConfiguredFeature<?, ?>> CF_ORE_FOSSIL = Lazy
			.of(() -> register("ore_fossil", Feature.ORE.configured(new OreConfiguration(DIRT, BlockRegistry.FOSSIL_ORE.get().defaultBlockState(), 4)).range(Features.Decorators.FULL_RANGE).squared()));

	public static final Lazy<ConfiguredFeature<?, ?>> CF_HUGE_BLUE_MUSHROOM_NATURAL = Lazy.of(() -> register("huge_blue_mushroom_natural",
			HUGE_BLUE_MUSHROOM_NATURAL.get().configured(new HugeMushroomFeatureConfiguration(new SimpleStateProvider(BlockRegistry.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))),
					new SimpleStateProvider(net.minecraft.world.level.block.Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2))));
	public static final Lazy<ConfiguredFeature<?, ?>> CF_HUGE_BLUE_MUSHROOM = Lazy.of(() -> register("huge_blue_mushroom",
			HUGE_BLUE_MUSHROOM.get().configured(new HugeMushroomFeatureConfiguration(new SimpleStateProvider(BlockRegistry.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))),
					new SimpleStateProvider(net.minecraft.world.level.block.Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2))));

	public static final Lazy<ConfiguredFeature<TreeConfiguration, ?>> CF_CHERRY_TREE = Lazy.of(() -> register("cherry_tree",
			Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(BlockRegistry.LOG_CHERRY.get().defaultBlockState()), new OrchardTrunkPlacer(5, 2, 0),
					new SimpleStateProvider(BlockRegistry.LEAVES_CHERRY.get().defaultBlockState()), new SimpleStateProvider(BlockRegistry.SAPLING_CHERRY.get().defaultBlockState()), new OrchardFoliagePlacer(ConstantInt.of(7), ConstantInt.of(4)),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build())));

	public static final Lazy<ConfiguredFeature<TreeConfiguration, ?>> CF_PEAR_TREE = Lazy.of(() -> register("pear_tree",
			Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(BlockRegistry.LOG_PEAR.get().defaultBlockState()), new OrchardTrunkPlacer(5, 2, 0),
					new SimpleStateProvider(BlockRegistry.LEAVES_PEAR.get().defaultBlockState()), new SimpleStateProvider(BlockRegistry.SAPLING_PEAR.get().defaultBlockState()), new OrchardFoliagePlacer(ConstantInt.of(7), ConstantInt.of(4)),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build())));

	public static final Lazy<ConfiguredFeature<TreeConfiguration, ?>> CF_ORANGE_TREE = Lazy.of(() -> register("orange_tree",
			Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(BlockRegistry.LOG_ORANGE.get().defaultBlockState()), new OrchardTrunkPlacer(5, 2, 0),
					new SimpleStateProvider(BlockRegistry.LEAVES_ORANGE.get().defaultBlockState()), new SimpleStateProvider(BlockRegistry.SAPLING_ORANGE.get().defaultBlockState()), new OrchardFoliagePlacer(ConstantInt.of(7), ConstantInt.of(4)),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build())));

	public static final Lazy<ConfiguredFeature<TreeConfiguration, ?>> CF_ATLAS_TREE = Lazy.of(() -> register("atlas_tree",
			Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(BlockRegistry.LOG_ATLAS.get().defaultBlockState()), new AtlasTrunkPlacer(8, 0, 0),
					new SimpleStateProvider(BlockRegistry.LEAVES_ATLAS.get().defaultBlockState()), new SimpleStateProvider(BlockRegistry.SAPLING_ATLAS.get().defaultBlockState()), new AtlasFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4)),
					new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build())));

	public static final Lazy<ConfiguredFeature<BlockStateConfiguration, ?>> CF_PINE_LAYING_TREE = Lazy
			.of(() -> register("pine_laying_tree", LAYING_TREE.get().configured(new BlockStateConfiguration(BlockRegistry.LOG_PINE.get().defaultBlockState()))));

	public static final Lazy<ConfiguredFeature<?, ?>> CF_EMO_FLOWER = Lazy
			.of(() -> register("emo_flower", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(EmotionFlowerProvider.INSTANCE, SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Decorators.ADD_32)
					.decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(100)));

	public static final Lazy<ConfiguredFeature<BerryBushFeatureConfiguration, ?>> CF_ORCHARD_BERRY_BUSH = Lazy.of(() -> register("orchard_berry_bush", BERRY_BUSH.get().configured(new BerryBushFeatureConfiguration(BerryBushType.ORCHARD.getName()))));

//	public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE = FEATURES.register("cherry_tree", () -> EMO_TREE.get().configured(FeatureConfiguration.NONE).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(3)));
//	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LUME_NETHER = FEATURES.register("ore_lume_nether", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, BlockRegistry.LUME_ORE.get().defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(16));
//	public static final Feature<BigMushroomFeatureConfig> HUGE_BLUE_MUSHROOM = new BigBlueMushroomFeature(BigMushroomFeatureConfig::deserialize);
//	public static final FlowersFeature EMO_FLOWER = new EmoFlowersFeature(NoneFeatureConfiguration::deserialize);
//	public static final Feature<BerryBushFeatureConfig> BERRY_BUSH = new BerryBushFeature(BerryBushFeatureConfig::deserialize);
//	public static final Feature<NoFeatureConfig> ORCHARD_TREE = new EmoTreeFeature(NoFeatureConfig::deserialize, false);
//	public static final Feature<NoFeatureConfig> ANCIENT_TREE = new EmoAtlasFeature(NoFeatureConfig::deserialize, false, true);
//	public static final Feature<NoFeatureConfig> PINE_TREE = new EmoPineFeature(NoFeatureConfig::deserialize, false);
//	public static final Feature<NoFeatureConfig> DEAD_TREE = new EmoDeadTreeFeature(NoFeatureConfig::deserialize, false);
//	public static final Feature<NoFeatureConfig> LAYING_TREE = new EmoLayingTreeFeature(NoFeatureConfig::deserialize, false);
//	public static final OreFeatureConfig.FillerBlockType DIRT = OreFeatureConfig.FillerBlockType.create("DIRT", MainRegistry.MOD_ID + ":dirt", new BlockMatcher(Blocks.DIRT));

	public static void init(IEventBus eventBus)
	{
		FEATURES.register(eventBus);
		DECORATORS.register(eventBus);

		overworldOres.add(CF_ORE_PURPURA.get());
		overworldOres.add(CF_ORE_VIRIDIS.get());
		overworldOres.add(CF_ORE_FOSSIL.get());
	}

	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature)
	{
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MainRegistry.MOD_ID, name), configuredFeature);
	}
}
