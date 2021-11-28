package fr.emotion.emomod.init;

import java.util.List;
import java.util.function.Supplier;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.entity.EntityBoat;
import fr.emotion.emomod.items.EmoBalloon;
import fr.emotion.emomod.items.EmoButterfly;
import fr.emotion.emomod.items.EmoButterflyNet;
import fr.emotion.emomod.items.EmoFoods;
import fr.emotion.emomod.items.EmoItemTier;
import fr.emotion.emomod.items.EmoRing;
import fr.emotion.emomod.items.basic.BasicBoat;
import fr.emotion.emomod.items.basic.ItemFuel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainRegistry.MOD_ID);

	public static final Tier TIER_FOSSIL = TierSortingRegistry.registerTier(EmoItemTier.FOSSIL, new ResourceLocation(MainRegistry.MOD_ID, "fossil"), List.of(Tiers.STONE), List.of(Tiers.IRON));
	public static final Tier TIER_PURPURA = TierSortingRegistry.registerTier(EmoItemTier.PURPURA, new ResourceLocation(MainRegistry.MOD_ID, "purpura"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

	public static final RegistryObject<Item> PURPURA_SHARD = ITEMS.register("purpura_shard", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> PURPURA_RING = ITEMS.register("purpura_ring", () -> new EmoRing(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
	public static final RegistryObject<Item> PURPURA_RED_BALLOON = ITEMS.register("purpura_red_balloon", () -> new EmoBalloon(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
	public static final RegistryObject<Item> PURPURA_GREEN_BALLOON = ITEMS.register("purpura_green_balloon", () -> new EmoBalloon(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
	public static final RegistryObject<Item> PURPURA_BLUE_BALLOON = ITEMS.register("purpura_blue_balloon", () -> new EmoBalloon(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));

	public static final RegistryObject<Item> PURPURA_AXE = ITEMS.register("purpura_axe", () -> new AxeItem(TIER_PURPURA, 5.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_HOE = ITEMS.register("purpura_hoe", () -> new HoeItem(TIER_PURPURA, -3, 0.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_PICKAXE = ITEMS.register("purpura_pickaxe", () -> new PickaxeItem(TIER_PURPURA, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_SHOVEL = ITEMS.register("purpura_shovel", () -> new ShovelItem(TIER_PURPURA, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_SWORD = ITEMS.register("purpura_sword", () -> new SwordItem(TIER_PURPURA, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	public static final RegistryObject<Item> PURPURA_DIAMOND_SWORD = ITEMS.register("purpura_diamond_sword", () -> new SwordItem(EmoItemTier.PURPURA, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_LUME_SWORD = ITEMS.register("purpura_lume_sword", () -> new SwordItem(EmoItemTier.PURPURA, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> PURPURA_GOLD_SWORD = ITEMS.register("purpura_gold_sword", () -> new SwordItem(EmoItemTier.PURPURA, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

//	public static final RegistryObject<Item> BAG_PURPURA = ITEMS.register("bag_purpura", () -> new EmoBag(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	public static final RegistryObject<Item> FOSSIL_AXE = ITEMS.register("fossil_axe", () -> new AxeItem(TIER_FOSSIL, 5.0F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> FOSSIL_HOE = ITEMS.register("fossil_hoe", () -> new HoeItem(TIER_FOSSIL, -3, 0.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> FOSSIL_PICKAXE = ITEMS.register("fossil_pickaxe", () -> new PickaxeItem(TIER_FOSSIL, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> FOSSIL_SHOVEL = ITEMS.register("fossil_shovel", () -> new ShovelItem(TIER_FOSSIL, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> FOSSIL_SWORD = ITEMS.register("fossil_sword", () -> new SwordItem(TIER_FOSSIL, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	public static final RegistryObject<Item> VIRIDIS_CRISTAL = ITEMS.register("viridis_cristal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

//	public static final RegistryObject<Item> VIRIDIS_HELMET = ITEMS.register("viridis_helmet", () -> new EmoViridisArmor(EmoArmorMaterials.VIRIDIS, EquipmentSlotType.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> VIRIDIS_CHESTPLATE = ITEMS.register("viridis_chestplate", () -> new EmoViridisArmor(EmoArmorMaterials.VIRIDIS, EquipmentSlotType.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> VIRIDIS_LEGGINGS = ITEMS.register("viridis_leggings", () -> new EmoViridisArmor(EmoArmorMaterials.VIRIDIS, EquipmentSlotType.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> VIRIDIS_BOOTS = ITEMS.register("viridis_boots", () -> new EmoViridisArmor(EmoArmorMaterials.VIRIDIS, EquipmentSlotType.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	public static final RegistryObject<Item> LUME_STONE = ITEMS.register("lume_stone", () -> new ItemFuel(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS), 3200));

	public static final RegistryObject<Item> FOSSIL = ITEMS.register("fossil", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

//	public static final RegistryObject<Item> PURPURA_STAFF = ITEMS.register("purpura_staff", () -> new EmoStaff(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
//	public static final RegistryObject<Item> DREAM_STAFF = ITEMS.register("dream_staff", () -> new EmoStaff(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> DREAM_STONE = ITEMS.register("dream_stone", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

//	public static final RegistryObject<Item> SPELL_BOOK_EARTH = ITEMS.register("spell_book_earth", () -> new EmoSpellBook(SpellList.EARTH, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
//	public static final RegistryObject<Item> SPELL_BOOK_WATER = ITEMS.register("spell_book_water", () -> new EmoSpellBook(SpellList.WATER, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
//	public static final RegistryObject<Item> SPELL_BOOK_WIND = ITEMS.register("spell_book_wind", () -> new EmoSpellBook(SpellList.WIND, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
//	public static final RegistryObject<Item> SPELL_BOOK_FIRE = ITEMS.register("spell_book_fire", () -> new EmoSpellBook(SpellList.FIRE, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));

	public static final RegistryObject<Item> SPELL_ORB = ITEMS.register("spell_orb", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> KNIFE = ITEMS.register("knife", () -> new SwordItem(Tiers.WOOD, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> HORN = ITEMS.register("horn", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> BUTTERFLY_NET = ITEMS.register("butterfly_net", () -> new EmoButterflyNet(new Item.Properties().stacksTo(1).durability(10).tab(CreativeModeTab.TAB_TOOLS)));

	public static final RegistryObject<Item> BUTTERFLY_PINK = ITEMS.register("butterfly_pink", () -> new EmoButterfly(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BUTTERFLY_BLUE = ITEMS.register("butterfly_blue", () -> new EmoButterfly(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BUTTERFLY_GREEN = ITEMS.register("butterfly_green", () -> new EmoButterfly(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BUTTERFLY_BRIMSTONE = ITEMS.register("butterfly_brimstone", () -> new EmoButterfly(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> FRUIT_PEAR = ITEMS.register("fruit_pear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PEAR)));
	public static final RegistryObject<Item> FRUIT_CHERRY = ITEMS.register("fruit_cherry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.CHERRY)));
	public static final RegistryObject<Item> FRUIT_ORANGE = ITEMS.register("fruit_orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.ORANGE)));
	public static final RegistryObject<Item> FRUIT_TOMATO = ITEMS.register("fruit_tomato", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.TOMATO)));

	public static final RegistryObject<Item> BERRY_BLUEBERRY = ITEMS.register("berry_blueberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.BLUEBERRY)));
	public static final RegistryObject<Item> BERRY_REDCURRANT = ITEMS.register("berry_redcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.REDCURRANT)));
	public static final RegistryObject<Item> BERRY_BLACKCURRANT = ITEMS.register("berry_blackcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.BLACKCURRANT)));
	public static final RegistryObject<Item> BERRY_STRAWBERRY = ITEMS.register("berry_strawberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.STRAWBERRY)));
	public static final RegistryObject<Item> BERRY_STRAWBERRY_CHOCO = ITEMS.register("berry_strawberry_choco", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.STRAWBERRY_CHOCO)));
	public static final RegistryObject<Item> BERRY_DREAMCURRANT = ITEMS.register("berry_dreamcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.DREAMCURRANT)));

	public static final RegistryObject<Item> SLICE_PEAR = ITEMS.register("slice_pear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_PEAR)));
	public static final RegistryObject<Item> SLICE_CHERRY = ITEMS.register("slice_cherry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_CHERRY)));
	public static final RegistryObject<Item> SLICE_ORANGE = ITEMS.register("slice_orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_ORANGE)));
	public static final RegistryObject<Item> SLICE_APPLE = ITEMS.register("slice_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_APPLE)));
	public static final RegistryObject<Item> SLICE_BLUEBERRY = ITEMS.register("slice_blueberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_BLUEBERRY)));
	public static final RegistryObject<Item> SLICE_REDCURRANT = ITEMS.register("slice_redcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_REDCURRANT)));
	public static final RegistryObject<Item> SLICE_BLACKCURRANT = ITEMS.register("slice_blackcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_BLACKCURRANT)));
	public static final RegistryObject<Item> SLICE_STRAWBERRY = ITEMS.register("slice_strawberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_STRAWBERRY)));
	public static final RegistryObject<Item> SLICE_DREAMCURRANT = ITEMS.register("slice_dreamcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_DREAMCURRANT)));
	public static final RegistryObject<Item> SLICE_CHOCOLATE = ITEMS.register("slice_chocolate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_CHOCOLATE)));
	public static final RegistryObject<Item> SLICE_BREAD = ITEMS.register("slice_bread", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SLICE_BREAD)));

	public static final RegistryObject<Item> BAG_PEAR = ITEMS.register("bag_pear", () -> new Item(new Item.Properties().stacksTo(32).tab(CreativeModeTab.TAB_FOOD)));
	public static final RegistryObject<Item> BAG_CHERRY = ITEMS.register("bag_cherry", () -> new Item(new Item.Properties().stacksTo(32).tab(CreativeModeTab.TAB_FOOD)));
	public static final RegistryObject<Item> BAG_ORANGE = ITEMS.register("bag_orange", () -> new Item(new Item.Properties().stacksTo(32).tab(CreativeModeTab.TAB_FOOD)));
	public static final RegistryObject<Item> BAG_TOMATO = ITEMS.register("bag_tomato", () -> new Item(new Item.Properties().stacksTo(32).tab(CreativeModeTab.TAB_FOOD)));
	public static final RegistryObject<Item> BAG_APPLE = ITEMS.register("bag_apple", () -> new Item(new Item.Properties().stacksTo(32).tab(CreativeModeTab.TAB_FOOD)));

	public static final RegistryObject<Item> SALAD_FRUIT = ITEMS.register("salad_fruit", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SALAD_FRUIT)));
	public static final RegistryObject<Item> SALAD_TOMATO = ITEMS.register("salad_tomato", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SALAD_FRUIT)));
	public static final RegistryObject<Item> SALAD_PUMPKIN = ITEMS.register("salad_pumpkin", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SALAD_FRUIT)));

	public static final RegistryObject<Item> SEED_PEAR = ITEMS.register("seed_pear", () -> new ItemNameBlockItem(BlockRegistry.PEAR_PLANT.get(), (new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))));
	public static final RegistryObject<Item> SEED_CHERRY = ITEMS.register("seed_cherry", () -> new ItemNameBlockItem(BlockRegistry.CHERRY_PLANT.get(), (new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))));
	public static final RegistryObject<Item> SEED_ORANGE = ITEMS.register("seed_orange", () -> new ItemNameBlockItem(BlockRegistry.ORANGE_PLANT.get(), (new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))));
	public static final RegistryObject<Item> SEED_TOMATO = ITEMS.register("seed_tomato", () -> new ItemNameBlockItem(BlockRegistry.TOMATO_PLANT.get(), (new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))));
	public static final RegistryObject<Item> SEED_APPLE = ITEMS.register("seed_apple", () -> new ItemNameBlockItem(BlockRegistry.APPLE_PLANT.get(), (new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))));

	public static final RegistryObject<Item> CAKE_CHOCO = ITEMS.register("cake_choco", () -> new BlockItem(BlockRegistry.CAKE_CHOCO.get(), (new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD))));
	public static final RegistryObject<Item> CAKE_FRUIT = ITEMS.register("cake_fruit", () -> new BlockItem(BlockRegistry.CAKE_FRUIT.get(), (new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD))));
	public static final RegistryObject<Item> CAKE_TOFFEE = ITEMS.register("cake_toffee", () -> new BlockItem(BlockRegistry.CAKE_TOFFEE.get(), (new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD))));
	public static final RegistryObject<Item> CAKE_STRAWBERRY = ITEMS.register("cake_strawberry", () -> new BlockItem(BlockRegistry.CAKE_STRAWBERRY.get(), (new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD))));

	public static final RegistryObject<Item> GLASS_BOWL = ITEMS.register("bowl_glass", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> JUICE_PEAR = ITEMS.register("juice_pear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.JUICE_PEAR)));
	public static final RegistryObject<Item> JUICE_CHERRY = ITEMS.register("juice_cherry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.JUICE_CHERRY)));
	public static final RegistryObject<Item> JUICE_ORANGE = ITEMS.register("juice_orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.JUICE_ORANGE)));
	public static final RegistryObject<Item> JUICE_TOMATO = ITEMS.register("juice_tomato", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.JUICE_TOMATO)));
	public static final RegistryObject<Item> JUICE_APPLE = ITEMS.register("juice_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.JUICE_APPLE)));

	public static final RegistryObject<Item> PIE_PEAR = ITEMS.register("pie_pear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PIE_PEAR)));
	public static final RegistryObject<Item> PIE_CHERRY = ITEMS.register("pie_cherry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PIE_CHERRY)));
	public static final RegistryObject<Item> PIE_ORANGE = ITEMS.register("pie_orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PIE_ORANGE)));
	public static final RegistryObject<Item> PIE_APPLE = ITEMS.register("pie_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PIE_APPLE)));
	public static final RegistryObject<Item> PIE_MELON = ITEMS.register("pie_melon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.PIE_MELON)));

	public static final RegistryObject<Item> MUFFIN_PEAR = ITEMS.register("muffin_pear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_PEAR)));
	public static final RegistryObject<Item> MUFFIN_CHERRY = ITEMS.register("muffin_cherry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_CHERRY)));
	public static final RegistryObject<Item> MUFFIN_ORANGE = ITEMS.register("muffin_orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_ORANGE)));
	public static final RegistryObject<Item> MUFFIN_APPLE = ITEMS.register("muffin_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_APPLE)));
	public static final RegistryObject<Item> MUFFIN_BLUEBERRY = ITEMS.register("muffin_blueberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_BLUEBERRY)));
	public static final RegistryObject<Item> MUFFIN_REDCURRANT = ITEMS.register("muffin_redcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_REDCURRANT)));
	public static final RegistryObject<Item> MUFFIN_BLACKCURRANT = ITEMS.register("muffin_blackcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_BLACKCURRANT)));
	public static final RegistryObject<Item> MUFFIN_STRAWBERRY = ITEMS.register("muffin_strawberry", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_STRAWBERRY)));
	public static final RegistryObject<Item> MUFFIN_DREAMCURRANT = ITEMS.register("muffin_dreamcurrant", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MUFFIN_DREAMCURRANT)));

	public static final RegistryObject<Item> TOFFEE_CUBE = ITEMS.register("toffee_cube", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.TOFFEE_CUBE)));
	public static final RegistryObject<Item> TOFFEE_APPLE = ITEMS.register("toffee_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.TOFFEE_APPLE)));

	public static final RegistryObject<Item> WILDBOAR_RAW = ITEMS.register("wildboar_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.WILDBOAR_RAW)));
	public static final RegistryObject<Item> WILDBOAR_COOKED = ITEMS.register("wildboar_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.WILDBOAR_COOKED)));

	public static final RegistryObject<Item> FISH_TROUT_RAW = ITEMS.register("fish_trout_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.TROUT_RAW)));
	public static final RegistryObject<Item> FISH_BASS_RAW = ITEMS.register("fish_bass_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.BASS_RAW)));
	public static final RegistryObject<Item> FISH_SARDINE_RAW = ITEMS.register("fish_sardine_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SARDINE_RAW)));
	public static final RegistryObject<Item> FISH_MACKEREL_RAW = ITEMS.register("fish_mackerel_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MACKEREL_RAW)));
	public static final RegistryObject<Item> FISH_WHITING_RAW = ITEMS.register("fish_whiting_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.WHITING_RAW)));

	public static final RegistryObject<Item> FISH_TROUT_COOKED = ITEMS.register("fish_trout_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.TROUT_COOKED)));
	public static final RegistryObject<Item> FISH_BASS_COOKED = ITEMS.register("fish_bass_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.BASS_COOKED)));
	public static final RegistryObject<Item> FISH_SARDINE_COOKED = ITEMS.register("fish_sardine_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.SARDINE_COOKED)));
	public static final RegistryObject<Item> FISH_MACKEREL_COOKED = ITEMS.register("fish_mackerel_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.MACKEREL_COOKED)));
	public static final RegistryObject<Item> FISH_WHITING_COOKED = ITEMS.register("fish_whiting_cooked", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(EmoFoods.WHITING_COOKED)));

	public static final RegistryObject<Item> FISH_GOLDEN = ITEMS.register("fish_golden", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> FISH_DIAMOND = ITEMS.register("fish_diamond", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new BasicBoat(EntityBoat.EmoType.CHERRY, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> PEAR_BOAT = ITEMS.register("pear_boat", () -> new BasicBoat(EntityBoat.EmoType.PEAR, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> ORANGE_BOAT = ITEMS.register("orange_boat", () -> new BasicBoat(EntityBoat.EmoType.ORANGE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> ATLAS_BOAT = ITEMS.register("atlas_boat", () -> new BasicBoat(EntityBoat.EmoType.ATLAS, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat", () -> new BasicBoat(EntityBoat.EmoType.PINE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> COCO_BOAT = ITEMS.register("coco_boat", () -> new BasicBoat(EntityBoat.EmoType.COCO, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
	public static final RegistryObject<Item> DREAM_BOAT = ITEMS.register("dream_boat", () -> new BasicBoat(EntityBoat.EmoType.DREAM, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));

	public static final RegistryObject<Item> CHERRY_DOOR = ITEMS.register("cherry_door", () -> new DoubleHighBlockItem(BlockRegistry.CHERRY_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> PEAR_DOOR = ITEMS.register("pear_door", () -> new DoubleHighBlockItem(BlockRegistry.PEAR_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> ORANGE_DOOR = ITEMS.register("orange_door", () -> new DoubleHighBlockItem(BlockRegistry.ORANGE_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> ATLAS_DOOR = ITEMS.register("atlas_door", () -> new DoubleHighBlockItem(BlockRegistry.ATLAS_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> PINE_DOOR = ITEMS.register("pine_door", () -> new DoubleHighBlockItem(BlockRegistry.PINE_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> COCO_DOOR = ITEMS.register("coco_door", () -> new DoubleHighBlockItem(BlockRegistry.COCO_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));
	public static final RegistryObject<Item> DREAM_DOOR = ITEMS.register("dream_door", () -> new DoubleHighBlockItem(BlockRegistry.DREAM_DOOR.get(), (new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE))));

	public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.CHERRY_SIGN.get(), BlockRegistry.CHERRY_WALL_SIGN.get()));
	public static final RegistryObject<Item> PEAR_SIGN = ITEMS.register("pear_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.PEAR_SIGN.get(), BlockRegistry.PEAR_WALL_SIGN.get()));
	public static final RegistryObject<Item> ORANGE_SIGN = ITEMS.register("orange_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.ORANGE_SIGN.get(), BlockRegistry.ORANGE_WALL_SIGN.get()));
	public static final RegistryObject<Item> ATLAS_SIGN = ITEMS.register("atlas_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.ATLAS_SIGN.get(), BlockRegistry.ATLAS_WALL_SIGN.get()));
	public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.PINE_SIGN.get(), BlockRegistry.PINE_WALL_SIGN.get()));
	public static final RegistryObject<Item> COCO_SIGN = ITEMS.register("coco_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.COCO_SIGN.get(), BlockRegistry.COCO_WALL_SIGN.get()));
	public static final RegistryObject<Item> DREAM_SIGN = ITEMS.register("dream_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), BlockRegistry.DREAM_SIGN.get(), BlockRegistry.DREAM_WALL_SIGN.get()));

	public static final RegistryObject<Item> ANCIENT_WATER_BUCKET = ITEMS.register("ancient_water_bucket", () -> new BucketItem(new Supplier<FlowingFluid>()
	{
		public FlowingFluid get()
		{
			return (FlowingFluid) FluidRegistry.FLOWING_ANCIENT_WATER.get();
		};
	}, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> BEETLE_EGG = ITEMS.register("beetle_egg", () -> new ForgeSpawnEggItem(() -> EntityTypeRegistry.BEETLE.get(), 0x1c1c1c, 0x423529, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> LIGHTNING_BUG_EGG = ITEMS.register("lightning_bug_egg", () -> new ForgeSpawnEggItem(() -> EntityTypeRegistry.LIGHTNING_BUG.get(), 0x6c5945, 0x00ff00, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MOUSE_EGG = ITEMS.register("mouse_egg", () -> new ForgeSpawnEggItem(() -> EntityTypeRegistry.MOUSE.get(), 0xcecece, 0xbf9071, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BOAR_EGG = ITEMS.register("boar_egg", () -> new ForgeSpawnEggItem(() -> EntityTypeRegistry.BOAR.get(), 0x141412, 0x665a37, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	public static void init(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
