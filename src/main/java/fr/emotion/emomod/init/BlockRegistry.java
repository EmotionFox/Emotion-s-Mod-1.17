package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.blocks.EmoBush;
import fr.emotion.emomod.blocks.EmoChair;
import fr.emotion.emomod.blocks.EmoCristal;
import fr.emotion.emomod.blocks.EmoLowFlower;
import fr.emotion.emomod.blocks.EmoPot;
import fr.emotion.emomod.blocks.EmoTable;
import fr.emotion.emomod.blocks.basic.BasicCrops;
import fr.emotion.emomod.blocks.basic.BasicFlower;
import fr.emotion.emomod.blocks.basic.BasicFlowingFluidBlock;
import fr.emotion.emomod.blocks.basic.BasicOre;
import fr.emotion.emomod.blocks.basic.BasicStandingSign;
import fr.emotion.emomod.blocks.basic.BasicViscous;
import fr.emotion.emomod.blocks.basic.BasicWallSign;
import fr.emotion.emomod.world.level.block.grower.BasicTreeGrower;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry
{
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainRegistry.MOD_ID);

	// Ore & Ore Block
	public static final RegistryObject<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", () -> new BasicOre(Properties.of(Material.STONE), UniformInt.of(0, 2)));

	public static final RegistryObject<Block> PURPURA_ORE = BLOCKS.register("purpura_ore", () -> new BasicOre(Properties.of(Material.STONE).strength(9.0F, 10F).requiresCorrectToolForDrops().lightLevel((value) ->
	{
		return 5;
	}), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> PURPURA_BLOCK = BLOCKS.register("purpura_block", () -> new Block(Properties.of(Material.STONE).strength(7.0F, 14.0F)));

	public static final RegistryObject<Block> VIRIDIS_ORE = BLOCKS.register("viridis_ore", () -> new BasicOre(Properties.of(Material.STONE).strength(5F, 6F).requiresCorrectToolForDrops().noDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> VIRIDIS_CRISTAL = BLOCKS.register("viridis_cristal", () -> new EmoCristal(Properties.of(Material.ICE).strength(7.0F, 14.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> VIRIDIS_BLOCK = BLOCKS.register("viridis_block", () -> new Block(Properties.of(Material.STONE).strength(7.0F, 14.0F)));

	public static final RegistryObject<Block> LUME_ORE = BLOCKS.register("lume_ore", () -> new BasicOre(Properties.of(Material.STONE).randomTicks().strength(4.0F, 4.0F).requiresCorrectToolForDrops(), UniformInt.of(2, 4)));
	public static final RegistryObject<Block> DREAM_LUME_ORE = BLOCKS.register("dream_lume_ore", () -> new BasicOre(Properties.of(Material.STONE).randomTicks().strength(4.0F, 4.0F).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
	public static final RegistryObject<Block> LUME_BLOCK = BLOCKS.register("lume_block", () -> new Block(Properties.of(Material.STONE).strength(7.0F, 14.0F)));

	// Special
	public static final RegistryObject<Block> GLITCH = BLOCKS.register("glitch", () -> new Block(Properties.of(Material.WEB).strength(4.0F, 4.0F).noDrops()));

	// Plant
	public static final RegistryObject<Block> PEAR_PLANT = BLOCKS.register("plant_pear", () -> new BasicCrops(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP), Items.STICK));
	public static final RegistryObject<Block> CHERRY_PLANT = BLOCKS.register("plant_cherry", () -> new BasicCrops(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP), Items.STICK));
	public static final RegistryObject<Block> ORANGE_PLANT = BLOCKS.register("plant_orange", () -> new BasicCrops(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP), Items.STICK));
	public static final RegistryObject<Block> TOMATO_PLANT = BLOCKS.register("plant_tomato", () -> new BasicCrops(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP), Items.STICK));
	public static final RegistryObject<Block> APPLE_PLANT = BLOCKS.register("plant_apple", () -> new BasicCrops(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP), Items.STICK));

	// Mushroom

	// Pot
	public static final RegistryObject<Block> POT_APPLE = BLOCKS.register("pot_apple", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_APPLE.get()));
	public static final RegistryObject<Block> POT_BLACKCURRANT = BLOCKS.register("pot_blackcurrant", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_BLACKCURRANT.get()));
	public static final RegistryObject<Block> POT_BLUEBERRY = BLOCKS.register("pot_blueberry", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_BLUEBERRY.get()));
	public static final RegistryObject<Block> POT_CHERRY = BLOCKS.register("pot_cherry", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_CHERRY.get()));
	public static final RegistryObject<Block> POT_CHOCOLATE = BLOCKS.register("pot_chocolate", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_CHOCOLATE.get()));
	public static final RegistryObject<Block> POT_ORANGE = BLOCKS.register("pot_orange", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_ORANGE.get()));
	public static final RegistryObject<Block> POT_PEAR = BLOCKS.register("pot_pear", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_PEAR.get()));
	public static final RegistryObject<Block> POT_REDCURRANT = BLOCKS.register("pot_redcurrant", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_REDCURRANT.get()));
	public static final RegistryObject<Block> POT_STRAWBERRY = BLOCKS.register("pot_strawberry", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_STRAWBERRY.get()));
	public static final RegistryObject<Block> POT_DREAMCURRANT = BLOCKS.register("pot_dreamcurrant", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F), ItemRegistry.SLICE_DREAMCURRANT.get()));
	public static final RegistryObject<Block> POT_WATER = BLOCKS.register("pot_watter", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F)));
	public static final RegistryObject<Block> POT_LAVA = BLOCKS.register("pot_lava", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F)));
	public static final RegistryObject<Block> POT_MILK = BLOCKS.register("pot_milk", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F)));
	public static final RegistryObject<Block> POT_GLASS = BLOCKS.register("pot_glass", () -> new EmoPot(Properties.of(Material.GLASS).strength(0.1F, 0.0F)));

	// Cake
	public static final RegistryObject<Block> CAKE_CHOCO = BLOCKS.register("cake_choco", () -> new CakeBlock(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CAKE_FRUIT = BLOCKS.register("cake_fruit", () -> new CakeBlock(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CAKE_TOFFEE = BLOCKS.register("cake_toffee", () -> new CakeBlock(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CAKE_STRAWBERRY = BLOCKS.register("cake_strawberry", () -> new CakeBlock(Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)));

	// Berry
	public static final RegistryObject<Block> BUSH_BLUEBERRY = BLOCKS.register("bush_blueberry", () -> new EmoBush(Properties.of(Material.LEAVES).randomTicks().strength(0.5F).speedFactor(2f).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BUSH_REDCURRANT = BLOCKS.register("buch_redcurrant", () -> new EmoBush(Properties.of(Material.LEAVES).randomTicks().strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BUSH_BLACKCURRANT = BLOCKS.register("bush_blackcurrant", () -> new EmoBush(Properties.of(Material.LEAVES).randomTicks().strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BUSH_STRAWBERRY = BLOCKS.register("bush_strawberry", () -> new EmoBush(Properties.of(Material.LEAVES).randomTicks().strength(0.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BUSH_DREAMCURRANT = BLOCKS.register("bush_dreamcurrant", () -> new EmoBush(Properties.of(Material.LEAVES).randomTicks().strength(0.5F).sound(SoundType.GRASS)));

	// Colored Brick
	public static final RegistryObject<Block> BRICK_GREEN = BLOCKS.register("brick_green", () -> new Block(Properties.of(Material.STONE).strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> BRICK_BLUE = BLOCKS.register("brick_blue", () -> new Block(Properties.of(Material.STONE).strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> BRICK_YELLOW = BLOCKS.register("brick_yellow", () -> new Block(Properties.of(Material.STONE).strength(2.0F, 6.0F)));

	// Flower
	public static final RegistryObject<Block> FLOWER_KITTY = BLOCKS.register("flower_kitty", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_NOX = BLOCKS.register("flower_nox", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_DELY = BLOCKS.register("flower_dely", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_GNON = BLOCKS.register("flower_gnon", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_THORNY = BLOCKS.register("flower_thorny", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_CENTUS = BLOCKS.register("flower_centus", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_TALLGRASS = BLOCKS.register("flower_tallgrass", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_NEBULA = BLOCKS.register("flower_nebula", () -> new BasicFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> FLOWER_NARCOTA = BLOCKS.register("flower_narcota", () -> new EmoLowFlower(Properties.of(Material.PLANT).noCollission().strength(0.0F).sound(SoundType.GRASS)));

	public static final RegistryObject<Block> POTTED_KITTY = BLOCKS.register("potted_kitty",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_KITTY.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_NOX = BLOCKS.register("potted_nox", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_NOX.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_DELY = BLOCKS.register("potted_dely", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_DELY.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_GNON = BLOCKS.register("potted_gnon", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_GNON.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_THORNY = BLOCKS.register("potted_thorny",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_THORNY.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_CENTUS = BLOCKS.register("potted_centus",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_CENTUS.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_NEBULA = BLOCKS.register("potted_nebula",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_NEBULA.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_NARCOTA = BLOCKS.register("potted_narcota",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> FLOWER_NARCOTA.get(), Properties.of(Material.DECORATION).strength(0.0F)));

//	public static final RegistryObject<Block> MUSHROOM_BLUE = BLOCKS.register("mushroom_blue",
//			() -> new MushroomBlock(Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_BLUE).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS).lightValue(1)));
//	public static final RegistryObject<Block> MUSHROOM_GREEN = BLOCKS.register("mushroom_green",
//			() -> new MushroomBlock(Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_GREEN).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS).lightLevel((value) ->
//			{
//				return 1;
//			}).hasPostProcess((state, getter, pos) ->
//			{
//				return (boolean) true;
//			}), () ->
//			{
//				return FeatureRegistry.HUGE_BLUE_MUSHROOM;
//			}));

	// Leaves

	public static final RegistryObject<Block> LEAVES_CHERRY = BLOCKS.register("leaves_cherry", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_PEAR = BLOCKS.register("leaves_pear", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_ORANGE = BLOCKS.register("leaves_orange", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_ATLAS = BLOCKS.register("leaves_atlas", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_PINE = BLOCKS.register("leaves_pine", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_COCO = BLOCKS.register("leaves_coco", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEAVES_DREAM = BLOCKS.register("leaves_dream", () -> new LeavesBlock(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)));

	// Logs

	public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_PEAR_LOG = BLOCKS.register("stripped_pear_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ORANGE_LOG = BLOCKS.register("stripped_orange_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ATLAS_LOG = BLOCKS.register("stripped_atlas_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_PINE_LOG = BLOCKS.register("stripped_pine_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_COCO_LOG = BLOCKS.register("stripped_coco_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_DREAM_LOG = BLOCKS.register("stripped_dream_log", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> LOG_CHERRY = BLOCKS.register("log_cherry", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_RED : MaterialColor.WOOD;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_PEAR = BLOCKS.register("log_pear", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.GOLD : MaterialColor.COLOR_BROWN;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_ORANGE = BLOCKS.register("log_orange", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_ORANGE : MaterialColor.TERRACOTTA_ORANGE;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_ATLAS = BLOCKS.register("log_atlas", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_LIGHT_BLUE : MaterialColor.COLOR_BLUE;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_PINE = BLOCKS.register("log_pine", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_BROWN : MaterialColor.TERRACOTTA_BLACK;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_COCO = BLOCKS.register("log_coco", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_YELLOW : MaterialColor.TERRACOTTA_YELLOW;
	}).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LOG_DREAM = BLOCKS.register("log_dream", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) ->
	{
		return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_LIGHT_GREEN : MaterialColor.COLOR_GREEN;
	}).strength(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_PEAR_WOOD = BLOCKS.register("stripped_pear_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ORANGE_WOOD = BLOCKS.register("stripped_orange_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ATLAS_WOOD = BLOCKS.register("stripped_atlas_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_PINE_WOOD = BLOCKS.register("stripped_pine_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_COCO_WOOD = BLOCKS.register("stripped_coco_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_DREAM_WOOD = BLOCKS.register("stripped_dream_wood", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> WOOD_CHERRY = BLOCKS.register("wood_cherry", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_PEAR = BLOCKS.register("wood_pear", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_ORANGE = BLOCKS.register("wood_orange", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_ATLAS = BLOCKS.register("wood_atlas", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_PINE = BLOCKS.register("wood_pine", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_COCO = BLOCKS.register("wood_coco", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOOD_DREAM = BLOCKS.register("wood_dream", () -> new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F).sound(SoundType.WOOD)));

	// Saplings

	public static final RegistryObject<Block> SAPLING_CHERRY = BLOCKS.register("sapling_cherry",
			() -> new SaplingBlock(new BasicTreeGrower(FeatureRegistry.CF_CHERRY_TREE), Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SAPLING_PEAR = BLOCKS.register("sapling_pear",
			() -> new SaplingBlock(new BasicTreeGrower(FeatureRegistry.CF_PEAR_TREE), Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SAPLING_ORANGE = BLOCKS.register("sapling_orange",
			() -> new SaplingBlock(new BasicTreeGrower(FeatureRegistry.CF_ORANGE_TREE), Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
//	public static final RegistryObject<Block> SAPLING_ATLAS = BLOCKS.register("sapling_atlas", () -> new SaplingBlock(new EmoAtlasTree(false), Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
//	public static final RegistryObject<Block> SAPLING_PINE = BLOCKS.register("sapling_pine", () -> new SaplingBlock(new EmoPineTree(), Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SAPLING_COCO = BLOCKS.register("sapling_coco", () -> new Block(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0f).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SAPLING_DREAM = BLOCKS.register("sapling_dream", () -> new Block(Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0f).sound(SoundType.GRASS)));

	public static final RegistryObject<Block> POTTED_SAPLING_CHERRY = BLOCKS.register("potted_sapling_cherry",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_CHERRY.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_SAPLING_PEAR = BLOCKS.register("potted_sapling_pear",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_PEAR.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_SAPLING_ORANGE = BLOCKS.register("potted_sapling_orange",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_ORANGE.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
//	public static final RegistryObject<Block> POTTED_SAPLING_ATLAS = BLOCKS.register("potted_sapling_atlas",
//			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_ATLAS.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
//	public static final RegistryObject<Block> POTTED_SAPLING_PINE = BLOCKS.register("potted_sapling_pine",
//			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_PINE.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_SAPLING_COCO = BLOCKS.register("potted_sapling_coco",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_COCO.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));
	public static final RegistryObject<Block> POTTED_SAPLING_DREAM = BLOCKS.register("potted_sapling_dream",
			() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> SAPLING_DREAM.get().delegate.get(), Properties.of(Material.DECORATION).strength(0.0F)));

	// Planks

	public static final RegistryObject<Block> PLANKS_CHERRY = BLOCKS.register("planks_cherry", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_PEAR = BLOCKS.register("planks_pear", () -> new Block(Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_ORANGE = BLOCKS.register("planks_orange", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_ATLAS = BLOCKS.register("planks_atlas", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_PINE = BLOCKS.register("planks_pine", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_COCO = BLOCKS.register("planks_coco", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PLANKS_DREAM = BLOCKS.register("planks_dream", () -> new Block(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final WoodType CHERRY_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "cherry").toString());
	public static final WoodType PEAR_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "pear").toString());
	public static final WoodType ORANGE_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "orange").toString());
	public static final WoodType ATLAS_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "atlas").toString());
	public static final WoodType PINE_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "pine").toString());
	public static final WoodType COCO_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "coco").toString());
	public static final WoodType DREAM_WOOD_TYPE = WoodType.create(new ResourceLocation(MainRegistry.MOD_ID, "dream").toString());

	// Signs
	public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).noCollission().strength(1.0F).sound(SoundType.WOOD), CHERRY_WOOD_TYPE));
	public static final RegistryObject<Block> PEAR_SIGN = BLOCKS.register("pear_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.GOLD).noCollission().strength(1.0F).sound(SoundType.WOOD), PEAR_WOOD_TYPE));
	public static final RegistryObject<Block> ORANGE_SIGN = BLOCKS.register("orange_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).noCollission().strength(1.0F).sound(SoundType.WOOD), ORANGE_WOOD_TYPE));
	public static final RegistryObject<Block> ATLAS_SIGN = BLOCKS.register("atlas_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).noCollission().strength(1.0F).sound(SoundType.WOOD), ATLAS_WOOD_TYPE));
	public static final RegistryObject<Block> PINE_SIGN = BLOCKS.register("pine_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).noCollission().strength(1.0F).sound(SoundType.WOOD), PINE_WOOD_TYPE));
	public static final RegistryObject<Block> COCO_SIGN = BLOCKS.register("coco_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).noCollission().strength(1.0F).sound(SoundType.WOOD), COCO_WOOD_TYPE));
	public static final RegistryObject<Block> DREAM_SIGN = BLOCKS.register("dream_sign", () -> new BasicStandingSign(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).noCollission().strength(1.0F).sound(SoundType.WOOD), DREAM_WOOD_TYPE));

	public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(CHERRY_SIGN), CHERRY_WOOD_TYPE));
	public static final RegistryObject<Block> PEAR_WALL_SIGN = BLOCKS.register("pear_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.GOLD).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(PEAR_SIGN), PEAR_WOOD_TYPE));
	public static final RegistryObject<Block> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(ORANGE_SIGN), ORANGE_WOOD_TYPE));
	public static final RegistryObject<Block> ATLAS_WALL_SIGN = BLOCKS.register("atlas_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(ATLAS_SIGN), ATLAS_WOOD_TYPE));
	public static final RegistryObject<Block> PINE_WALL_SIGN = BLOCKS.register("pine_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(PINE_SIGN), PINE_WOOD_TYPE));
	public static final RegistryObject<Block> COCO_WALL_SIGN = BLOCKS.register("coco_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(COCO_SIGN), COCO_WOOD_TYPE));
	public static final RegistryObject<Block> DREAM_WALL_SIGN = BLOCKS.register("dream_wall_sign",
			() -> new BasicWallSign(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(DREAM_SIGN), DREAM_WOOD_TYPE));

	// Buttons
	public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_BUTTON = BLOCKS.register("pear_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_BUTTON = BLOCKS.register("orange_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_BUTTON = BLOCKS.register("atlas_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_BUTTON = BLOCKS.register("pine_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_BUTTON = BLOCKS.register("coco_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_BUTTON = BLOCKS.register("dream_button", () -> new WoodButtonBlock(Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	// Stairs
	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> new StairBlock(() -> PLANKS_CHERRY.get().defaultBlockState(), Properties.copy(PLANKS_CHERRY.get())));
	public static final RegistryObject<Block> PEAR_STAIRS = BLOCKS.register("pear_stairs", () -> new StairBlock(() -> PLANKS_PEAR.get().defaultBlockState(), Properties.copy(PLANKS_PEAR.get())));
	public static final RegistryObject<Block> ORANGE_STAIRS = BLOCKS.register("orange_stairs", () -> new StairBlock(() -> PLANKS_ORANGE.get().defaultBlockState(), Properties.copy(PLANKS_ORANGE.get())));
	public static final RegistryObject<Block> ATLAS_STAIRS = BLOCKS.register("atlas_stairs", () -> new StairBlock(() -> PLANKS_ATLAS.get().defaultBlockState(), Properties.copy(PLANKS_ATLAS.get())));
	public static final RegistryObject<Block> PINE_STAIRS = BLOCKS.register("pine_stairs", () -> new StairBlock(() -> PLANKS_PINE.get().defaultBlockState(), Properties.copy(PLANKS_PINE.get())));
	public static final RegistryObject<Block> COCO_STAIRS = BLOCKS.register("coco_stairs", () -> new StairBlock(() -> PLANKS_COCO.get().defaultBlockState(), Properties.copy(PLANKS_COCO.get())));
	public static final RegistryObject<Block> DREAM_STAIRS = BLOCKS.register("dream_stairs", () -> new StairBlock(() -> PLANKS_DREAM.get().defaultBlockState(), Properties.copy(PLANKS_DREAM.get())));

	public static final RegistryObject<Block> WHITE_TERRACOTTA_STAIRS = BLOCKS.register("white_terracotta_stairs", () -> new StairBlock(() -> Blocks.WHITE_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_STAIRS = BLOCKS.register("orange_terracotta_stairs", () -> new StairBlock(() -> Blocks.ORANGE_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_STAIRS = BLOCKS.register("magenta_terracotta_stairs", () -> new StairBlock(() -> Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.MAGENTA_TERRACOTTA)));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = BLOCKS.register("light_blue_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA)));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_STAIRS = BLOCKS.register("yellow_terracotta_stairs", () -> new StairBlock(() -> Blocks.YELLOW_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.YELLOW_TERRACOTTA)));
	public static final RegistryObject<Block> LIME_TERRACOTTA_STAIRS = BLOCKS.register("lime_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIME_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.LIME_TERRACOTTA)));
	public static final RegistryObject<Block> PINK_TERRACOTTA_STAIRS = BLOCKS.register("pink_terracotta_stairs", () -> new StairBlock(() -> Blocks.PINK_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.PINK_TERRACOTTA)));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_STAIRS = BLOCKS.register("gray_terracotta_stairs", () -> new StairBlock(() -> Blocks.GRAY_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.GRAY_TERRACOTTA)));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = BLOCKS.register("light_gray_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_STAIRS = BLOCKS.register("cyan_terracotta_stairs", () -> new StairBlock(() -> Blocks.CYAN_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.CYAN_TERRACOTTA)));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_STAIRS = BLOCKS.register("purple_terracotta_stairs", () -> new StairBlock(() -> Blocks.PURPLE_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.PURPLE_TERRACOTTA)));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_STAIRS = BLOCKS.register("blue_terracotta_stairs", () -> new StairBlock(() -> Blocks.BLUE_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.BLUE_TERRACOTTA)));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_STAIRS = BLOCKS.register("brown_terracotta_stairs", () -> new StairBlock(() -> Blocks.BROWN_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.BROWN_TERRACOTTA)));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_STAIRS = BLOCKS.register("green_terracotta_stairs", () -> new StairBlock(() -> Blocks.GREEN_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.GREEN_TERRACOTTA)));
	public static final RegistryObject<Block> RED_TERRACOTTA_STAIRS = BLOCKS.register("red_terracotta_stairs", () -> new StairBlock(() -> Blocks.RED_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.RED_TERRACOTTA)));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_STAIRS = BLOCKS.register("black_terracotta_stairs", () -> new StairBlock(() -> Blocks.BLACK_TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.BLACK_TERRACOTTA)));
	public static final RegistryObject<Block> TERRACOTTA_STAIRS = BLOCKS.register("terracotta_stairs", () -> new StairBlock(() -> Blocks.TERRACOTTA.defaultBlockState(), Properties.copy(Blocks.TERRACOTTA)));

	// Fence & Gate
	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_FENCE = BLOCKS.register("pear_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_FENCE = BLOCKS.register("orange_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_FENCE = BLOCKS.register("atlas_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_FENCE = BLOCKS.register("pine_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_FENCE = BLOCKS.register("coco_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_FENCE = BLOCKS.register("dream_fence", () -> new FenceBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_FENCE_GATE = BLOCKS.register("pear_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.GOLD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_FENCE_GATE = BLOCKS.register("orange_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_FENCE_GATE = BLOCKS.register("atlas_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_FENCE_GATE = BLOCKS.register("pine_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_FENCE_GATE = BLOCKS.register("coco_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_FENCE_GATE = BLOCKS.register("dream_fence_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

	// Pressure Plates
	public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_RED).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_PRESSURE_PLATE = BLOCKS.register("pear_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.GOLD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = BLOCKS.register("orange_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_PRESSURE_PLATE = BLOCKS.register("atlas_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_PRESSURE_PLATE = BLOCKS.register("pine_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_PRESSURE_PLATE = BLOCKS.register("coco_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_PRESSURE_PLATE = BLOCKS.register("dream_pressure_plate",
			() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).noCollission().strength(0.5F).sound(SoundType.WOOD)));

	// Slab
	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_SLAB = BLOCKS.register("pear_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_SLAB = BLOCKS.register("orange_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_SLAB = BLOCKS.register("atlas_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_SLAB = BLOCKS.register("pine_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_SLAB = BLOCKS.register("coco_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_SLAB = BLOCKS.register("dream_slab", () -> new SlabBlock(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> WHITE_TERRACOTTA_SLAB = BLOCKS.register("white_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_SLAB = BLOCKS.register("orange_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_SLAB = BLOCKS.register("magenta_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_MAGENTA).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_SLAB = BLOCKS.register("light_blue_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_SLAB = BLOCKS.register("yellow_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIME_TERRACOTTA_SLAB = BLOCKS.register("lime_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> PINK_TERRACOTTA_SLAB = BLOCKS.register("pink_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_SLAB = BLOCKS.register("gray_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_SLAB = BLOCKS.register("light_gray_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_SLAB = BLOCKS.register("cyan_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_SLAB = BLOCKS.register("purple_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_SLAB = BLOCKS.register("blue_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_SLAB = BLOCKS.register("brown_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_SLAB = BLOCKS.register("green_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> RED_TERRACOTTA_SLAB = BLOCKS.register("red_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_SLAB = BLOCKS.register("black_terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> TERRACOTTA_SLAB = BLOCKS.register("terracotta_slab", () -> new SlabBlock(Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(1.25F, 4.2F)));

	// Door & Trapdoor
	public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_DOOR = BLOCKS.register("pear_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PEAR_TRAPDOOR = BLOCKS.register("pear_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_DOOR = BLOCKS.register("orange_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ORANGE_TRAPDOOR = BLOCKS.register("orange_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_DOOR = BLOCKS.register("atlas_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ATLAS_TRAPDOOR = BLOCKS.register("atlas_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> PINE_DOOR = BLOCKS.register("pine_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PINE_TRAPDOOR = BLOCKS.register("pine_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_DOOR = BLOCKS.register("coco_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> COCO_TRAPDOOR = BLOCKS.register("coco_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_DOOR = BLOCKS.register("dream_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DREAM_TRAPDOOR = BLOCKS.register("dream_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD)));

	// Furnitures
	public static final RegistryObject<Block> WOOD_TABLE_CHERRY = BLOCKS.register("wood_table_cherry", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_PEAR = BLOCKS.register("wood_table_pear", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_ORANGE = BLOCKS.register("wood_table_orange", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_ATLAS = BLOCKS.register("wood_table_atlas", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_PINE = BLOCKS.register("wood_table_pine", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_COCO = BLOCKS.register("wood_table_coco", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_DREAM = BLOCKS.register("wood_table_dream", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));

	public static final RegistryObject<Block> WOOD_TABLE_OAK = BLOCKS.register("wood_table_oak", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_SPRUCE = BLOCKS.register("wood_table_spruce", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_BIRCH = BLOCKS.register("wood_table_birch", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_JUNGLE = BLOCKS.register("wood_table_jungle", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_ACACIA = BLOCKS.register("wood_table_acacia", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_TABLE_BIG_OAK = BLOCKS.register("wood_table_big_oak", () -> new EmoTable(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));

//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_CHERRY = BLOCKS.register("wood_nightstand_cherry", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 126, 61, 61 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_PEAR = BLOCKS.register("wood_nightstand_pear", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 165, 134, 80 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_ORANGE = BLOCKS.register("wood_nightstand_orange", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 168, 115, 64 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_ATLAS = BLOCKS.register("wood_nightstand_atlas", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 47, 102, 142 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_PINE = BLOCKS.register("wood_nightstand_pine", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 89, 73, 57 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_COCO = BLOCKS.register("wood_nightstand_coco", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 188, 177, 135 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_DREAM = BLOCKS.register("wood_nightstand_dream", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 73, 172, 116 }));

//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_OAK = BLOCKS.register("wood_nightstand_oak", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 184, 148, 95 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_SPRUCE = BLOCKS.register("wood_nightstand_spruce", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 130, 97, 58 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_BIRCH = BLOCKS.register("wood_nightstand_birch", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 215, 193, 133 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_JUNGLE = BLOCKS.register("wood_nightstand_jungle", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 184, 135, 100 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_ACACIA = BLOCKS.register("wood_nightstand_acacia", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 186, 99, 55 }));
//	public static final RegistryObject<Block> WOOD_NIGHTSTAND_BIG_OAK = BLOCKS.register("wood_nightstand_big_oak", () -> new EmoNightstand(Properties.of(Material.WOOD).strength(2.0F, 5.0F), new float[]
//	{ 79, 50, 24 }));

	public static final RegistryObject<Block> WOOD_CHAIR_CHERRY = BLOCKS.register("wood_chair_cherry", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_PEAR = BLOCKS.register("wood_chair_pear", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_ORANGE = BLOCKS.register("wood_chair_orange", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_ATLAS = BLOCKS.register("wood_chair_atlas", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_PINE = BLOCKS.register("wood_chair_pine", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_COCO = BLOCKS.register("wood_chair_coco", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_DREAM = BLOCKS.register("wood_chair_dream", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));

	public static final RegistryObject<Block> WOOD_CHAIR_OAK = BLOCKS.register("wood_chair_oak", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_SPRUCE = BLOCKS.register("wood_chair_spruce", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_BIRCH = BLOCKS.register("wood_chair_birch", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_JUNGLE = BLOCKS.register("wood_chair_jungle", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_ACACIA = BLOCKS.register("wood_chair_acacia", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));
	public static final RegistryObject<Block> WOOD_CHAIR_BIG_OAK = BLOCKS.register("wood_chair_big_oak", () -> new EmoChair(Properties.of(Material.WOOD).strength(2.0F, 5.0F)));

	public static final RegistryObject<Block> STONE_TABLE_COBBLESTONE = BLOCKS.register("stone_table_cobblestone", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_MOSSY_COBBLESTONE = BLOCKS.register("stone_table_mossy_cobblestone", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_STONE_BRICK = BLOCKS.register("stone_table_stone_brick", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_MOSSY_STONE_BRICK = BLOCKS.register("stone_table_mossy_stone_brick", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_CRACKED_STONE_BRICK = BLOCKS.register("stone_table_cracked_stone_brick", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_CHISELLED_STONE_BRICK = BLOCKS.register("stone_table_chiselled_stone_brick", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));
	public static final RegistryObject<Block> STONE_TABLE_BRICK = BLOCKS.register("stone_table_brick", () -> new EmoTable(Properties.of(Material.STONE).strength(2.0F, 10.0F), true));

	public static final RegistryObject<Block> STONE_CHAIR_COBBLESTONE = BLOCKS.register("stone_chair_cobblestone", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_MOSSY_COBBLESTONE = BLOCKS.register("stone_chair_mossy_cobblestone", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_STONE_BRICK = BLOCKS.register("stone_chair_stone_brick", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_MOSSY_STONE_BRICK = BLOCKS.register("stone_chair_mossy_stone_brick", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_CRACKED_STONE_BRICK = BLOCKS.register("stone_chair_cracked_stone_brick", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_CHISELLED_STONE_BRICK = BLOCKS.register("stone_chair_chiselled_stone_brick", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));
	public static final RegistryObject<Block> STONE_CHAIR_BRICK = BLOCKS.register("stone_chair_brick", () -> new EmoChair(Properties.of(Material.STONE).strength(2.0F, 5.0F), true));

	// Viscous
	public static final RegistryObject<Block> SHIFTING_SAND = BLOCKS.register("shifting_sand", () -> new BasicViscous(Properties.of(Material.SAND).strength(0.7F, 0.0F).speedFactor(0.2f)));
	public static final RegistryObject<Block> MUD = BLOCKS.register("mud", () -> new BasicViscous(Properties.of(Material.DIRT).strength(0.7F, 0.0F).speedFactor(0.4f)));

	public static final RegistryObject<Block> BLUE_MUSHROOM_BLOCK = BLOCKS.register("blue_mushroom_block", () -> new HugeMushroomBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(0.2F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> ANCIENT_WATER = BLOCKS.register("ancient_water",
			() -> new BasicFlowingFluidBlock(() -> FluidRegistry.ANCIENT_WATER.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops()));

//	public static final RegistryObject<Block> CRAFTER = BLOCKS.register("crafter", () -> new EmoCrafter(Properties.of(Material.STONE).strength(0.5f)));

	public static void init()
	{
		BLOCKS.register(MainRegistry.eventBus);
	}
}
