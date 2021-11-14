package fr.emotion.emomod.init;

public class RecipeRegistry
{
	public static void init()
	{
		// RecipeCreator.shapeless(null, BlockRegistry.PURPURA_BLOCK, new
		// ItemStack(ItemRegistry.PURPURA_SHARD, 9), 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { " X ", "Y Y", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_RING, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XY", " Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_AXE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", " Y", " Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_HOE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", " Y ", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_PICKAXE,
		// 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X", "Y", "Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_SHOVEL,
		// 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X", "X", "Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT) }, ItemRegistry.PURPURA_SWORD, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XZ", "XZ", "Y " }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT), new RecipeInput('Z',
		// Items.DIAMOND) }, new ItemStack(ItemRegistry.PURPURA_BLUE_SWORD), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.PURPURA_SWORD, Items.DIAMOND, Items.DIAMOND },
		// ItemRegistry.PURPURA_BLUE_SWORD, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XZ", "XZ", "Y " }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.PURPURA_SHARD), new
		// RecipeInput('Y', Items.IRON_INGOT), new RecipeInput('Z',
		// Items.REDSTONE) }, new ItemStack(ItemRegistry.PURPURA_RED_SWORD), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.PURPURA_SWORD, Items.REDSTONE, Items.REDSTONE },
		// ItemRegistry.PURPURA_RED_SWORD, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { " X ", "XYX", " X " }, new RecipeInput[]
		// { new RecipeInput('X', Items.LEATHER), new RecipeInput('Y',
		// ItemRegistry.PURPURA_SHARD) }, ItemRegistry.BAG_PURPURA, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XY", " Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FOSSIL), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.FOSSIL_AXE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", " Y", " Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FOSSIL), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.FOSSIL_HOE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", " Y ", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FOSSIL), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.FOSSIL_PICKAXE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X", "Y", "Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FOSSIL), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.FOSSIL_SHOVEL, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X", "X", "Y" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FOSSIL), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.FOSSIL_SWORD, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XYX", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Items.IRON_INGOT), new RecipeInput('Y',
		// ItemRegistry.VIRIDIS_CRISTAL) }, ItemRegistry.VIRIDIS_HELMET, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "YYY", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', Items.IRON_INGOT), new RecipeInput('Y',
		// ItemRegistry.VIRIDIS_CRISTAL) }, ItemRegistry.VIRIDIS_CHESTPLATE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "YXY", "Y Y", "X X" }, new RecipeInput[]
		// { new RecipeInput('X', Items.IRON_INGOT), new RecipeInput('Y',
		// ItemRegistry.VIRIDIS_CRISTAL) }, ItemRegistry.VIRIDIS_LEGGINGS, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "Y Y", "X X" }, new RecipeInput[]
		// { new RecipeInput('X', Items.IRON_INGOT), new RecipeInput('Y',
		// ItemRegistry.VIRIDIS_CRISTAL) }, ItemRegistry.VIRIDIS_BOOTS, 0);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LUME_BLOCK, new
		// ItemStack(ItemRegistry.LUME_STONE, 9), 0);
		//
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.STICK, ItemRegistry.HORN }, ItemRegistry.KNIFE, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XYX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', Items.STRING), new RecipeInput('Y',
		// Items.STICK) }, ItemRegistry.BUTTERFLY_NET, 0);
		//
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_PEAR, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new ItemStack(ItemRegistry.SLICE_PEAR,
		// 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_CHERRY, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new ItemStack(ItemRegistry.SLICE_CHERRY,
		// 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_ORANGE, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new ItemStack(ItemRegistry.SLICE_ORANGE,
		// 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_APPLE, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new ItemStack(ItemRegistry.SLICE_APPLE,
		// 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_BLUEBERRY, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_BLUEBERRY, 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_REDCURRANT, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_REDCURRANT, 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_BLACKCURRANT, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_BLACKCURRANT, 4),
		// 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_STRAWBERRY, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_STRAWBERRY, 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_DREAMCURRANT, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_DREAMCURRANT, 4),
		// 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_CHOCOLATE, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD, ItemRegistry.SLICE_BREAD,
		// ItemRegistry.SLICE_BREAD }, new
		// ItemStack(ItemRegistry.SLICE_CHOCOLATE, 4), 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.BREAD }, new ItemStack(ItemRegistry.SLICE_BREAD, 4), 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FRUIT_PEAR) },
		// ItemRegistry.BAG_PEAR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FRUIT_CHERRY) },
		// ItemRegistry.BAG_CHERRY, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FRUIT_ORANGE) },
		// ItemRegistry.BAG_ORANGE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.FRUIT_TOMATO) },
		// ItemRegistry.BAG_TOMATO, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', Items.APPLE) }, ItemRegistry.BAG_APPLE, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XYX", "ZWZ", "SSS" }, new RecipeInput[]
		// { new RecipeInput('X', Items.COCOA_BEANS), new RecipeInput('Y',
		// Items.MILK_BUCKET), new RecipeInput('W', Items.EGG), new
		// RecipeInput('Z', Items.SUGAR), new RecipeInput('S', Items.WHEAT) },
		// ItemRegistry.CAKE_CHOCO, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "WYU", "VZX", "TTT" }, new RecipeInput[]
		// { new RecipeInput('W', ItemRegistry.FRUIT_PEAR), new RecipeInput('Y',
		// Items.SUGAR), new RecipeInput('U', ItemRegistry.FRUIT_ORANGE), new
		// RecipeInput('V', ItemRegistry.FRUIT_CHERRY),
		// new RecipeInput('Z', Items.EGG), new RecipeInput('X', Items.APPLE),
		// new RecipeInput('T', Items.WHEAT) }, ItemRegistry.CAKE_FRUIT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "WYW", "XZX", "VVV" }, new RecipeInput[]
		// { new RecipeInput('W', ItemRegistry.TOFFEE_CUBE), new
		// RecipeInput('Y', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Z', Items.EGG),
		// new RecipeInput('V', Items.WHEAT) }, ItemRegistry.CAKE_TOFFEE, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "WYW", "XZX", "VVV" }, new RecipeInput[]
		// { new RecipeInput('W', ItemRegistry.BERRY_STRAWBERRY), new
		// RecipeInput('Y', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Z', Items.EGG),
		// new RecipeInput('V', Items.WHEAT) }, ItemRegistry.CAKE_STRAWBERRY,
		// 0);
		// RecipeCreator.shaped(null, new String[]
		// { "Y Y", "YYY" }, new RecipeInput[]
		// { new RecipeInput('Y', Blocks.GLASS) }, new
		// ItemStack(ItemRegistry.GLASS_BOWL, 4), 0);
		//
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.GLASS_BOWL, ItemRegistry.FRUIT_PEAR,
		// ItemRegistry.FRUIT_PEAR, Items.SUGAR }, ItemRegistry.JUICE_PEAR, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.GLASS_BOWL, ItemRegistry.FRUIT_CHERRY,
		// ItemRegistry.FRUIT_CHERRY, Items.SUGAR }, ItemRegistry.JUICE_CHERRY,
		// 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.GLASS_BOWL, ItemRegistry.FRUIT_ORANGE,
		// ItemRegistry.FRUIT_ORANGE, Items.SUGAR }, ItemRegistry.JUICE_ORANGE,
		// 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.GLASS_BOWL, ItemRegistry.FRUIT_TOMATO,
		// ItemRegistry.FRUIT_TOMATO }, ItemRegistry.JUICE_TOMATO, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { ItemRegistry.GLASS_BOWL, Items.APPLE, Items.APPLE, Items.SUGAR },
		// ItemRegistry.JUICE_APPLE, 0);
		//
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.EGG, Items.SUGAR, ItemRegistry.FRUIT_PEAR },
		// ItemRegistry.PIE_PEAR, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.EGG, Items.SUGAR, ItemRegistry.FRUIT_CHERRY },
		// ItemRegistry.PIE_CHERRY, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.EGG, Items.SUGAR, ItemRegistry.FRUIT_ORANGE },
		// ItemRegistry.PIE_ORANGE, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.EGG, Items.SUGAR, Items.APPLE }, ItemRegistry.PIE_APPLE, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { Items.EGG, Items.SUGAR, Items.MELON_SLICE },
		// ItemRegistry.PIE_MELON, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.FRUIT_PEAR), new RecipeInput('W',
		// Items.MILK_BUCKET), new RecipeInput('X', Items.SUGAR), new
		// RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_PEAR, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.FRUIT_CHERRY), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_CHERRY, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.FRUIT_ORANGE), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_ORANGE, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', Items.APPLE), new RecipeInput('W',
		// Items.MILK_BUCKET), new RecipeInput('X', Items.SUGAR), new
		// RecipeInput('Y', Items.EGG), new RecipeInput('Z', Items.WHEAT) },
		// new ItemStack(ItemRegistry.MUFFIN_APPLE, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.BERRY_BLUEBERRY), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_BLUEBERRY, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.BERRY_BLACKCURRANT), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_BLACKCURRANT, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.BERRY_REDCURRANT), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_REDCURRANT, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.BERRY_STRAWBERRY), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_STRAWBERRY, 2), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "VWV", "XYX", "ZZZ" }, new RecipeInput[]
		// { new RecipeInput('V', ItemRegistry.BERRY_DREAMCURRANT), new
		// RecipeInput('W', Items.MILK_BUCKET), new RecipeInput('X',
		// Items.SUGAR), new RecipeInput('Y', Items.EGG),
		// new RecipeInput('Z', Items.WHEAT) }, new
		// ItemStack(ItemRegistry.MUFFIN_DREAMCURRANT, 2), 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "X", "Y", "Z" }, new RecipeInput[]
		// { new RecipeInput('X', ItemRegistry.TOFFEE_CUBE), new
		// RecipeInput('Y', Items.APPLE), new RecipeInput('Z', Items.STICK) },
		// ItemRegistry.TOFFEE_APPLE, 0);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_KITTY,
		// Items.ORANGE_DYE, 0);
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_NOX,
		// Items.CYAN_DYE, 0);
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_DELY,
		// Items.PURPLE_DYE, 0);
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_GNON,
		// Items.ORANGE_DYE, 0);
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_CENTUS,
		// Items.BLUE_DYE, 0);
		// RecipeCreator.shapeless(null, BlockRegistry.FLOWER_THORNY, new
		// ItemStack(Items.STICK, 2), 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_CHERRY),
		// ItemRegistry.CHERRY_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PEAR),
		// ItemRegistry.PEAR_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ORANGE),
		// ItemRegistry.ORANGE_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ATLAS),
		// ItemRegistry.ATLAS_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PINE),
		// ItemRegistry.PINE_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_COCO),
		// ItemRegistry.COCO_BOAT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "X X", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_DREAM),
		// ItemRegistry.DREAM_BOAT, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_CHERRY), ItemRegistry.CHERRY_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_PEAR), ItemRegistry.PEAR_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_ORANGE), ItemRegistry.ORANGE_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_ATLAS), ItemRegistry.ATLAS_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_PINE), ItemRegistry.PINE_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_COCO), ItemRegistry.COCO_DOOR, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XX", "XX", "XX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_DREAM), ItemRegistry.DREAM_DOOR, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.CHERRY_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.PEAR_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.ORANGE_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.ATLAS_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.PINE_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.COCO_SIGN, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", " Y " }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, ItemRegistry.DREAM_SIGN, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput('X',
		// ItemRegistry.PURPURA_SHARD), BlockRegistry.PURPURA_BLOCK, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput('X',
		// ItemRegistry.VIRIDIS_CRISTAL), BlockRegistry.VIRIDIS_BLOCK, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XXX", "XXX" }, new RecipeInput('X',
		// ItemRegistry.LUME_STONE), BlockRegistry.LUME_BLOCK, 0);
		//
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, Items.APPLE, Items.APPLE, Items.APPLE,
		// Items.SUGAR }, BlockRegistry.POT_APPLE, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.BERRY_BLACKCURRANT,
		// ItemRegistry.BERRY_BLACKCURRANT, ItemRegistry.BERRY_BLACKCURRANT,
		// Items.SUGAR }, BlockRegistry.POT_BLACKCURRANT, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.BERRY_BLUEBERRY,
		// ItemRegistry.BERRY_BLUEBERRY, ItemRegistry.BERRY_BLUEBERRY,
		// Items.SUGAR }, BlockRegistry.POT_BLUEBERRY, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.FRUIT_CHERRY,
		// ItemRegistry.FRUIT_CHERRY, ItemRegistry.FRUIT_CHERRY, Items.SUGAR },
		// BlockRegistry.POT_CHERRY, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, Items.COCOA_BEANS, Items.COCOA_BEANS,
		// Items.COCOA_BEANS, Items.SUGAR }, BlockRegistry.POT_CHOCOLATE, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.FRUIT_ORANGE,
		// ItemRegistry.FRUIT_ORANGE, ItemRegistry.FRUIT_ORANGE, Items.SUGAR },
		// BlockRegistry.POT_ORANGE, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.FRUIT_PEAR,
		// ItemRegistry.FRUIT_PEAR, ItemRegistry.FRUIT_PEAR, Items.SUGAR },
		// BlockRegistry.POT_PEAR, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.BERRY_REDCURRANT,
		// ItemRegistry.BERRY_REDCURRANT, ItemRegistry.BERRY_REDCURRANT,
		// Items.SUGAR }, BlockRegistry.POT_REDCURRANT, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.BERRY_STRAWBERRY,
		// ItemRegistry.BERRY_STRAWBERRY, ItemRegistry.BERRY_STRAWBERRY,
		// Items.SUGAR }, BlockRegistry.POT_STRAWBERRY, 0);
		// RecipeCreator.shapeless(null, new IItemProvider[]
		// { BlockRegistry.POT_GLASS, ItemRegistry.BERRY_DREAMCURRANT,
		// ItemRegistry.BERRY_DREAMCURRANT, ItemRegistry.BERRY_DREAMCURRANT,
		// Items.SUGAR }, BlockRegistry.POT_DREAMCURRANT, 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XYX", "X X", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.GLASS), new RecipeInput('Y',
		// "minecraft:planks") }, BlockRegistry.POT_GLASS, 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XYX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BRICKS), new RecipeInput('Y',
		// Items.GREEN_DYE) }, new ItemStack(BlockRegistry.BRICK_GREEN, 8), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XYX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BRICKS), new RecipeInput('Y',
		// Items.BLUE_DYE) }, new ItemStack(BlockRegistry.BRICK_BLUE, 8), 0);
		// RecipeCreator.shaped(null, new String[]
		// { "XXX", "XYX", "XXX" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BRICKS), new RecipeInput('Y',
		// Items.YELLOW_DYE) }, new ItemStack(BlockRegistry.BRICK_YELLOW, 8),
		// 0);
		//
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_CHERRY), new
		// ItemStack(BlockRegistry.WOOD_CHERRY, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_PEAR), new
		// ItemStack(BlockRegistry.WOOD_PEAR, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_ORANGE), new
		// ItemStack(BlockRegistry.WOOD_ORANGE, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_ATLAS), new
		// ItemStack(BlockRegistry.WOOD_ATLAS, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_PINE), new
		// ItemStack(BlockRegistry.WOOD_PINE, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_COCO), new
		// ItemStack(BlockRegistry.WOOD_COCO, 3), 0);
		// RecipeCreator.shaped("bark", new String[]
		// { "XX", "XX" }, new RecipeInput('X', BlockRegistry.LOG_DREAM), new
		// ItemStack(BlockRegistry.WOOD_DREAM, 3), 0);
		//
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_CHERRY,
		// BlockRegistry.CHERRY_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_PEAR,
		// BlockRegistry.PEAR_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_ORANGE,
		// BlockRegistry.ORANGE_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_ATLAS,
		// BlockRegistry.ATLAS_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_PINE,
		// BlockRegistry.PINE_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_COCO,
		// BlockRegistry.COCO_BUTTON, 0);
		// RecipeCreator.shapeless("wooden_button", BlockRegistry.PLANKS_DREAM,
		// BlockRegistry.DREAM_BUTTON, 0);
		//
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_CHERRY), new
		// ItemStack(BlockRegistry.CHERRY_STAIRS, 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_PEAR), new ItemStack(BlockRegistry.PEAR_STAIRS,
		// 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_ORANGE), new
		// ItemStack(BlockRegistry.ORANGE_STAIRS, 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_ATLAS), new
		// ItemStack(BlockRegistry.ATLAS_STAIRS, 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_PINE), new ItemStack(BlockRegistry.PINE_STAIRS,
		// 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_COCO), new ItemStack(BlockRegistry.COCO_STAIRS,
		// 4), 0);
		// RecipeCreator.shaped("wooden_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// BlockRegistry.PLANKS_DREAM), new
		// ItemStack(BlockRegistry.DREAM_STAIRS, 4), 0);
		//
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.WHITE_TERRACOTTA), new
		// ItemStack(BlockRegistry.WHITE_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.WHITE_TERRACOTTA, new
		// ItemStack(BlockRegistry.WHITE_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.ORANGE_TERRACOTTA), new
		// ItemStack(BlockRegistry.ORANGE_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.ORANGE_TERRACOTTA, new
		// ItemStack(BlockRegistry.ORANGE_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.MAGENTA_TERRACOTTA), new
		// ItemStack(BlockRegistry.MAGENTA_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.MAGENTA_TERRACOTTA, new
		// ItemStack(BlockRegistry.MAGENTA_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.LIGHT_BLUE_TERRACOTTA), new
		// ItemStack(BlockRegistry.LIGHT_BLUE_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.LIGHT_BLUE_TERRACOTTA, new
		// ItemStack(BlockRegistry.LIGHT_BLUE_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.YELLOW_TERRACOTTA), new
		// ItemStack(BlockRegistry.YELLOW_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.YELLOW_TERRACOTTA, new
		// ItemStack(BlockRegistry.YELLOW_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.LIME_TERRACOTTA),
		// new ItemStack(BlockRegistry.LIME_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.LIME_TERRACOTTA, new
		// ItemStack(BlockRegistry.LIME_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.PINK_TERRACOTTA),
		// new ItemStack(BlockRegistry.PINK_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.PINK_TERRACOTTA, new
		// ItemStack(BlockRegistry.PINK_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.GRAY_TERRACOTTA),
		// new ItemStack(BlockRegistry.GRAY_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.GRAY_TERRACOTTA, new
		// ItemStack(BlockRegistry.GRAY_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.LIGHT_GRAY_TERRACOTTA), new
		// ItemStack(BlockRegistry.LIGHT_GRAY_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.LIGHT_GRAY_TERRACOTTA, new
		// ItemStack(BlockRegistry.LIGHT_GRAY_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.CYAN_TERRACOTTA),
		// new ItemStack(BlockRegistry.CYAN_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.CYAN_TERRACOTTA, new
		// ItemStack(BlockRegistry.CYAN_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.PURPLE_TERRACOTTA), new
		// ItemStack(BlockRegistry.PURPLE_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.PURPLE_TERRACOTTA, new
		// ItemStack(BlockRegistry.PURPLE_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.BLUE_TERRACOTTA),
		// new ItemStack(BlockRegistry.BLUE_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.BLUE_TERRACOTTA, new
		// ItemStack(BlockRegistry.BLUE_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.BROWN_TERRACOTTA), new
		// ItemStack(BlockRegistry.BROWN_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.BROWN_TERRACOTTA, new
		// ItemStack(BlockRegistry.BROWN_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.GREEN_TERRACOTTA), new
		// ItemStack(BlockRegistry.GREEN_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.GREEN_TERRACOTTA, new
		// ItemStack(BlockRegistry.GREEN_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.RED_TERRACOTTA),
		// new ItemStack(BlockRegistry.RED_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.RED_TERRACOTTA, new
		// ItemStack(BlockRegistry.RED_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X',
		// Blocks.BLACK_TERRACOTTA), new
		// ItemStack(BlockRegistry.BLACK_TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs",
		// Blocks.BLACK_TERRACOTTA, new
		// ItemStack(BlockRegistry.BLACK_TERRACOTTA_STAIRS), 0);
		// RecipeCreator.shaped("terracotta_stairs", new String[]
		// { "X ", "XX ", "XXX" }, new RecipeInput('X', Blocks.TERRACOTTA), new
		// ItemStack(BlockRegistry.TERRACOTTA_STAIRS, 4), 0);
		// RecipeCreator.stonecutting("terracotta_stairs", Blocks.TERRACOTTA,
		// new ItemStack(BlockRegistry.TERRACOTTA_STAIRS), 0);
		//
		// // Kyle XY Area
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.CHERRY_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.PEAR_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.ORANGE_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.ATLAS_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.PINE_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.COCO_FENCE, 3), 0);
		// RecipeCreator.shaped("wooden_fence", new String[]
		// { "XYX", "XYX" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, new
		// ItemStack(BlockRegistry.DREAM_FENCE, 3), 0);
		//
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.CHERRY_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.PEAR_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.ORANGE_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.ATLAS_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.PINE_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.COCO_FENCE_GATE, 0);
		// RecipeCreator.shaped("wooden_fence_gate", new String[]
		// { "YXY", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.DREAM_FENCE_GATE, 0);
		//
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_CHERRY),
		// BlockRegistry.CHERRY_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_PEAR),
		// BlockRegistry.PEAR_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_ORANGE),
		// BlockRegistry.ORANGE_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_ATLAS),
		// BlockRegistry.ATLAS_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_PINE),
		// BlockRegistry.PINE_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_COCO),
		// BlockRegistry.COCO_PRESSURE_PLATE, 0);
		// RecipeCreator.shaped("wooden_pressure_plate", new String[]
		// { "XX" }, new RecipeInput('X', BlockRegistry.PLANKS_DREAM),
		// BlockRegistry.DREAM_PRESSURE_PLATE, 0);
		//
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// ItemStack(BlockRegistry.CHERRY_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// ItemStack(BlockRegistry.PEAR_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// ItemStack(BlockRegistry.ORANGE_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// ItemStack(BlockRegistry.ATLAS_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// ItemStack(BlockRegistry.PINE_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// ItemStack(BlockRegistry.COCO_SLAB, 6), 0);
		// RecipeCreator.shaped("wooden_slab", new String[]
		// { "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// ItemStack(BlockRegistry.DREAM_SLAB, 6), 0);
		//
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.WHITE_TERRACOTTA), new
		// ItemStack(BlockRegistry.WHITE_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.WHITE_TERRACOTTA, new
		// ItemStack(BlockRegistry.WHITE_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.ORANGE_TERRACOTTA), new
		// ItemStack(BlockRegistry.ORANGE_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.ORANGE_TERRACOTTA, new
		// ItemStack(BlockRegistry.ORANGE_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.MAGENTA_TERRACOTTA), new
		// ItemStack(BlockRegistry.MAGENTA_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.MAGENTA_TERRACOTTA, new
		// ItemStack(BlockRegistry.MAGENTA_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.LIGHT_BLUE_TERRACOTTA), new
		// ItemStack(BlockRegistry.LIGHT_BLUE_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.LIGHT_BLUE_TERRACOTTA, new
		// ItemStack(BlockRegistry.LIGHT_BLUE_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.YELLOW_TERRACOTTA), new
		// ItemStack(BlockRegistry.YELLOW_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.YELLOW_TERRACOTTA, new
		// ItemStack(BlockRegistry.YELLOW_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.LIME_TERRACOTTA), new
		// ItemStack(BlockRegistry.LIME_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.LIME_TERRACOTTA,
		// new ItemStack(BlockRegistry.LIME_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.PINK_TERRACOTTA), new
		// ItemStack(BlockRegistry.PINK_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.PINK_TERRACOTTA,
		// new ItemStack(BlockRegistry.PINK_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.GRAY_TERRACOTTA), new
		// ItemStack(BlockRegistry.GRAY_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.GRAY_TERRACOTTA,
		// new ItemStack(BlockRegistry.GRAY_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.LIGHT_GRAY_TERRACOTTA), new
		// ItemStack(BlockRegistry.LIGHT_GRAY_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.LIGHT_GRAY_TERRACOTTA, new
		// ItemStack(BlockRegistry.LIGHT_GRAY_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.CYAN_TERRACOTTA), new
		// ItemStack(BlockRegistry.CYAN_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.CYAN_TERRACOTTA,
		// new ItemStack(BlockRegistry.CYAN_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.PURPLE_TERRACOTTA), new
		// ItemStack(BlockRegistry.PURPLE_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.PURPLE_TERRACOTTA, new
		// ItemStack(BlockRegistry.PURPLE_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.BLUE_TERRACOTTA), new
		// ItemStack(BlockRegistry.BLUE_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.BLUE_TERRACOTTA,
		// new ItemStack(BlockRegistry.BLUE_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.BROWN_TERRACOTTA), new
		// ItemStack(BlockRegistry.BROWN_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.BROWN_TERRACOTTA, new
		// ItemStack(BlockRegistry.BROWN_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.GREEN_TERRACOTTA), new
		// ItemStack(BlockRegistry.GREEN_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.GREEN_TERRACOTTA, new
		// ItemStack(BlockRegistry.GREEN_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.RED_TERRACOTTA), new
		// ItemStack(BlockRegistry.RED_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.RED_TERRACOTTA,
		// new ItemStack(BlockRegistry.RED_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.BLACK_TERRACOTTA), new
		// ItemStack(BlockRegistry.BLACK_TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab",
		// Blocks.BLACK_TERRACOTTA, new
		// ItemStack(BlockRegistry.BLACK_TERRACOTTA_SLAB, 2), 0);
		// RecipeCreator.shaped("terracotta_slab", new String[]
		// { "XXX" }, new RecipeInput('X', Blocks.TERRACOTTA), new
		// ItemStack(BlockRegistry.TERRACOTTA_SLAB, 6), 0);
		// RecipeCreator.stonecutting("terracotta_slab", Blocks.TERRACOTTA, new
		// ItemStack(BlockRegistry.TERRACOTTA_SLAB, 2), 0);
		//
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_CHERRY),
		// new ItemStack(BlockRegistry.CHERRY_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PEAR),
		// new ItemStack(BlockRegistry.PEAR_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ORANGE),
		// new ItemStack(BlockRegistry.ORANGE_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_ATLAS),
		// new ItemStack(BlockRegistry.ATLAS_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_PINE),
		// new ItemStack(BlockRegistry.PINE_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_COCO),
		// new ItemStack(BlockRegistry.COCO_TRAPDOOR, 2), 0);
		// RecipeCreator.shaped("wooden_trapdoor", new String[]
		// { "XXX", "XXX" }, new RecipeInput('X', BlockRegistry.PLANKS_DREAM),
		// new ItemStack(BlockRegistry.DREAM_TRAPDOOR, 2), 0);
		//
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_CHERRY, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_PEAR, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_ORANGE, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_ATLAS, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_PINE, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_COCO, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_TABLE_DREAM, 0);
		//
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_OAK, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.SPRUCE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_SPRUCE, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BIRCH_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_BIRCH, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.JUNGLE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_JUNGLE, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.ACACIA_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_ACACIA, 0);
		// RecipeCreator.shaped("wooden_table", new String[]
		// { "XXX", " X ", "YXY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.DARK_OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_TABLE_BIG_OAK, 0);
		//
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) },
		// BlockRegistry.WOOD_NIGHTSTAND_CHERRY, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_PEAR,
		// 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) },
		// BlockRegistry.WOOD_NIGHTSTAND_ORANGE, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_ATLAS,
		// 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_PINE,
		// 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_COCO,
		// 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_DREAM,
		// 0);
		//
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_OAK, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.SPRUCE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_SPRUCE, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BIRCH_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_BIRCH, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.JUNGLE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_JUNGLE, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.ACACIA_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_ACACIA, 0);
		// RecipeCreator.shaped("wooden_nightstand", new String[]
		// { "XXX", "YXY", "Y Y" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.DARK_OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_NIGHTSTAND_BIG_OAK, 0);
		//
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_CHERRY), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_CHERRY, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PEAR), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_PEAR, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ORANGE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_ORANGE, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_ATLAS), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_ATLAS, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_PINE), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_PINE, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_COCO), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_COCO, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', BlockRegistry.PLANKS_DREAM), new
		// RecipeInput('Y', Items.STICK) }, BlockRegistry.WOOD_CHAIR_DREAM, 0);
		//
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_OAK, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.SPRUCE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_SPRUCE, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.BIRCH_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_BIRCH, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.JUNGLE_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_JUNGLE, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.ACACIA_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_ACACIA, 0);
		// RecipeCreator.shaped("wooden_chair", new String[]
		// { "XX", "YY" }, new RecipeInput[]
		// { new RecipeInput('X', Blocks.DARK_OAK_PLANKS), new RecipeInput('Y',
		// Items.STICK) }, BlockRegistry.WOOD_CHAIR_BIG_OAK, 0);
		//
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X', Blocks.COBBLESTONE),
		// BlockRegistry.STONE_TABLE_COBBLESTONE, 0);
		// RecipeCreator.stonecutting("stone_table", Blocks.COBBLESTONE, new
		// ItemStack(BlockRegistry.STONE_TABLE_COBBLESTONE, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X',
		// Blocks.MOSSY_COBBLESTONE),
		// BlockRegistry.STONE_TABLE_MOSSY_COBBLESTONE, 0);
		// RecipeCreator.stonecutting("stone_table", Blocks.MOSSY_COBBLESTONE,
		// new ItemStack(BlockRegistry.STONE_TABLE_MOSSY_COBBLESTONE, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X', Blocks.STONE_BRICKS),
		// BlockRegistry.STONE_TABLE_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_table", Blocks.STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_TABLE_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X',
		// Blocks.MOSSY_STONE_BRICKS),
		// BlockRegistry.STONE_TABLE_MOSSY_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_table", Blocks.MOSSY_STONE_BRICKS,
		// new ItemStack(BlockRegistry.STONE_TABLE_MOSSY_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X',
		// Blocks.CRACKED_STONE_BRICKS),
		// BlockRegistry.STONE_TABLE_CRACKED_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_table",
		// Blocks.CRACKED_STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_TABLE_CRACKED_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X',
		// Blocks.CHISELED_STONE_BRICKS),
		// BlockRegistry.STONE_TABLE_CHISELLED_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_table",
		// Blocks.CHISELED_STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_TABLE_CHISELLED_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_table", new String[]
		// { "XXX", " X ", "XXX" }, new RecipeInput('X', Blocks.BRICKS),
		// BlockRegistry.STONE_TABLE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_table", Blocks.BRICKS, new
		// ItemStack(BlockRegistry.STONE_TABLE_BRICK, 2), 0);
		//
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.COBBLESTONE),
		// BlockRegistry.STONE_CHAIR_COBBLESTONE, 0);
		// RecipeCreator.stonecutting("stone_chair", Blocks.COBBLESTONE, new
		// ItemStack(BlockRegistry.STONE_CHAIR_COBBLESTONE, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.MOSSY_COBBLESTONE),
		// BlockRegistry.STONE_CHAIR_MOSSY_COBBLESTONE, 0);
		// RecipeCreator.stonecutting("stone_chair", Blocks.MOSSY_COBBLESTONE,
		// new ItemStack(BlockRegistry.STONE_CHAIR_MOSSY_COBBLESTONE, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.STONE_BRICKS),
		// BlockRegistry.STONE_CHAIR_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_chair", Blocks.STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_CHAIR_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.MOSSY_STONE_BRICKS),
		// BlockRegistry.STONE_CHAIR_MOSSY_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_chair", Blocks.MOSSY_STONE_BRICKS,
		// new ItemStack(BlockRegistry.STONE_CHAIR_MOSSY_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.CRACKED_STONE_BRICKS),
		// BlockRegistry.STONE_CHAIR_CRACKED_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_chair",
		// Blocks.CRACKED_STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_CHAIR_CRACKED_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.CHISELED_STONE_BRICKS),
		// BlockRegistry.STONE_CHAIR_CHISELLED_STONE_BRICK, 0);
		// RecipeCreator.stonecutting("stone_chair",
		// Blocks.CHISELED_STONE_BRICKS, new
		// ItemStack(BlockRegistry.STONE_CHAIR_CHISELLED_STONE_BRICK, 2), 0);
		// RecipeCreator.shaped("stone_chair", new String[]
		// { "XX", "XX" }, new RecipeInput('X', Blocks.BRICKS),
		// BlockRegistry.STONE_CHAIR_BRICK, 0);
		// RecipeCreator.stonecutting("stone_chair", Blocks.BRICKS, new
		// ItemStack(BlockRegistry.STONE_CHAIR_BRICK, 2), 0);
		//
		// RecipeCreator.shaped(null, new String[]
		// { "XYX", "YZY", "XSX" }, new RecipeInput[]
		// { new RecipeInput('X', Items.IRON_INGOT), new RecipeInput('Y',
		// "minecraft:planks"), new RecipeInput('Z', Blocks.CRAFTING_TABLE), new
		// RecipeInput('S', Items.REDSTONE) }, BlockRegistry.CRAFTER,
		// 0);

		// RecipeCreator.blasting(null, BlockRegistry.PURPURA_ORE,
		// ItemRegistry.PURPURA_SHARD, 0, 1.0f);
		// RecipeCreator.blasting(null, BlockRegistry.VIRIDIS_ORE,
		// ItemRegistry.VIRIDIS_CRISTAL, 0, 1.0f);
		// RecipeCreator.blasting(null, ItemRegistry.FISH_DIAMOND,
		// Items.DIAMOND, 0, 1.0f);
		// RecipeCreator.blasting(null, ItemRegistry.FISH_GOLDEN,
		// Items.GOLD_INGOT, 0, 1.0f);
		//
		// RecipeCreator.campfire(null, Items.SUGAR, ItemRegistry.TOFFEE_CUBE,
		// 0, 0.35f);
		// RecipeCreator.campfire(null, ItemRegistry.WILDBOAR_RAW,
		// ItemRegistry.WILDBOAR_COOKED, 0, 0.60f, 900);
		// RecipeCreator.campfire(null, ItemRegistry.FISH_TROUT_RAW,
		// ItemRegistry.FISH_TROUT_COOKED, 0, 0.35f);
		// RecipeCreator.campfire(null, ItemRegistry.FISH_BASS_RAW,
		// ItemRegistry.FISH_BASS_COOKED, 0, 0.35f);
		// RecipeCreator.campfire(null, ItemRegistry.FISH_SARDINE_RAW,
		// ItemRegistry.FISH_SARDINE_COOKED, 0, 0.35f);
		// RecipeCreator.campfire(null, ItemRegistry.FISH_MACKEREL_RAW,
		// ItemRegistry.FISH_MACKEREL_COOKED, 0, 0.35f);
		// RecipeCreator.campfire(null, ItemRegistry.FISH_WHITING_RAW,
		// ItemRegistry.FISH_WHITING_COOKED, 0, 0.35f);
		//
		// RecipeCreator.smelting(null, Items.SUGAR, ItemRegistry.TOFFEE_CUBE,
		// 0, 0.35f);
		// RecipeCreator.smelting(null, ItemRegistry.WILDBOAR_RAW,
		// ItemRegistry.WILDBOAR_COOKED, 0, 0.60f);
		// RecipeCreator.smelting(null, ItemRegistry.FISH_TROUT_RAW,
		// ItemRegistry.FISH_TROUT_COOKED, 0, 0.35f);
		// RecipeCreator.smelting(null, ItemRegistry.FISH_BASS_RAW,
		// ItemRegistry.FISH_BASS_COOKED, 0, 0.35f);
		// RecipeCreator.smelting(null, ItemRegistry.FISH_SARDINE_RAW,
		// ItemRegistry.FISH_SARDINE_COOKED, 0, 0.35f);
		// RecipeCreator.smelting(null, ItemRegistry.FISH_MACKEREL_RAW,
		// ItemRegistry.FISH_MACKEREL_COOKED, 0, 0.35f);
		// RecipeCreator.smelting(null, ItemRegistry.FISH_WHITING_RAW,
		// ItemRegistry.FISH_WHITING_COOKED, 0, 0.35f);
		//
		// RecipeCreator.smoking(null, Items.SUGAR, ItemRegistry.TOFFEE_CUBE, 0,
		// 0.35f);
		// RecipeCreator.smoking(null, ItemRegistry.WILDBOAR_RAW,
		// ItemRegistry.WILDBOAR_COOKED, 0, 0.60f);
		// RecipeCreator.smoking(null, ItemRegistry.FISH_TROUT_RAW,
		// ItemRegistry.FISH_TROUT_COOKED, 0, 0.35f);
		// RecipeCreator.smoking(null, ItemRegistry.FISH_BASS_RAW,
		// ItemRegistry.FISH_BASS_COOKED, 0, 0.35f);
		// RecipeCreator.smoking(null, ItemRegistry.FISH_SARDINE_RAW,
		// ItemRegistry.FISH_SARDINE_COOKED, 0, 0.35f);
		// RecipeCreator.smoking(null, ItemRegistry.FISH_MACKEREL_RAW,
		// ItemRegistry.FISH_MACKEREL_COOKED, 0, 0.35f);
		// RecipeCreator.smoking(null, ItemRegistry.FISH_WHITING_RAW,
		// ItemRegistry.FISH_WHITING_COOKED, 0, 0.35f);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_CHERRY, new
		// ItemStack(BlockRegistry.PLANKS_CHERRY, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_CHERRY_LOG, new
		// ItemStack(BlockRegistry.PLANKS_CHERRY, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_CHERRY, new
		// ItemStack(BlockRegistry.PLANKS_CHERRY, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_CHERRY_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_CHERRY, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_PEAR, new
		// ItemStack(BlockRegistry.PLANKS_PEAR, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_PEAR_LOG, new
		// ItemStack(BlockRegistry.PLANKS_PEAR, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_PEAR, new
		// ItemStack(BlockRegistry.PLANKS_PEAR, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_PEAR_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_PEAR, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_ORANGE, new
		// ItemStack(BlockRegistry.PLANKS_ORANGE, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_ORANGE_LOG, new
		// ItemStack(BlockRegistry.PLANKS_ORANGE, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_ORANGE, new
		// ItemStack(BlockRegistry.PLANKS_ORANGE, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_ORANGE_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_ORANGE, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_ATLAS, new
		// ItemStack(BlockRegistry.PLANKS_ATLAS, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_ATLAS_LOG, new
		// ItemStack(BlockRegistry.PLANKS_ATLAS, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_ATLAS, new
		// ItemStack(BlockRegistry.PLANKS_ATLAS, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_ATLAS_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_ATLAS, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_PINE, new
		// ItemStack(BlockRegistry.PLANKS_PINE, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_PINE_LOG, new
		// ItemStack(BlockRegistry.PLANKS_PINE, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_PINE, new
		// ItemStack(BlockRegistry.PLANKS_PINE, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_PINE_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_PINE, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_COCO, new
		// ItemStack(BlockRegistry.PLANKS_COCO, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_COCO_LOG, new
		// ItemStack(BlockRegistry.PLANKS_COCO, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_COCO, new
		// ItemStack(BlockRegistry.PLANKS_COCO, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_COCO_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_COCO, 4), 3);
		//
		// RecipeCreator.shapeless(null, BlockRegistry.LOG_DREAM, new
		// ItemStack(BlockRegistry.PLANKS_DREAM, 4), 0);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_DREAM_LOG, new
		// ItemStack(BlockRegistry.PLANKS_DREAM, 4), 1);
		// RecipeCreator.shapeless(null, BlockRegistry.WOOD_DREAM, new
		// ItemStack(BlockRegistry.PLANKS_DREAM, 4), 2);
		// RecipeCreator.shapeless(null, BlockRegistry.STRIPPED_DREAM_WOOD, new
		// ItemStack(BlockRegistry.PLANKS_DREAM, 4), 3);
	}
}
