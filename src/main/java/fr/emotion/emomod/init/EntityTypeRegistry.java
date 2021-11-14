package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.blockentity.BasicSignBlockEntity;
import fr.emotion.emomod.entity.EntityBeetle;
import fr.emotion.emomod.entity.EntityBoar;
import fr.emotion.emomod.entity.EntityBoat;
import fr.emotion.emomod.entity.EntityButterfly;
import fr.emotion.emomod.entity.EntityChubby;
import fr.emotion.emomod.entity.EntityLightningBug;
import fr.emotion.emomod.entity.EntityMouse;
import fr.emotion.emomod.entity.EntityMushroom;
import fr.emotion.emomod.entity.EntityOrchardSpider;
import fr.emotion.emomod.entity.EntitySittable;
import fr.emotion.emomod.entity.OrbSpellEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistry
{
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MainRegistry.MOD_ID);
	private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MainRegistry.MOD_ID);

	public static final RegistryObject<EntityType<EntitySittable>> SITTABLE = ENTITIES.register("sittable", () -> EntityType.Builder.<EntitySittable>of(EntitySittable::new, MobCategory.MISC).sized(0f, 0f).clientTrackingRange(2).build("sittable"));
	public static final RegistryObject<EntityType<OrbSpellEntity>> ORB = ENTITIES.register("orb",
			() -> EntityType.Builder.<OrbSpellEntity>createNothing(MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(10).setCustomClientFactory(OrbSpellEntity::new).build("orb"));
	public static final RegistryObject<EntityType<EntityButterfly>> BUTTERFLY = ENTITIES.register("butterfly",
			() -> EntityType.Builder.<EntityButterfly>of(EntityButterfly::new, MobCategory.AMBIENT).sized(0.4f, 0.4f).clientTrackingRange(6).build("butterfly"));
	public static final RegistryObject<EntityType<EntityBoat>> BOAT = ENTITIES.register("boat",
			() -> EntityType.Builder.<EntityBoat>createNothing(MobCategory.MISC).setCustomClientFactory(EntityBoat::new).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
	public static final RegistryObject<EntityType<EntityBeetle>> BEETLE = ENTITIES.register("beetle", () -> EntityType.Builder.<EntityBeetle>of(EntityBeetle::new, MobCategory.AMBIENT).sized(0.2f, 0.1f).build("beetle"));
	public static final RegistryObject<EntityType<EntityLightningBug>> LIGHTNING_BUG = ENTITIES.register("lightning_bug",
			() -> EntityType.Builder.<EntityLightningBug>of(EntityLightningBug::new, MobCategory.AMBIENT).sized(0.1f, 0.1f).build("lightning_bug"));
	public static final RegistryObject<EntityType<EntityChubby>> CHUBBY = ENTITIES.register("chubby", () -> EntityType.Builder.<EntityChubby>of(EntityChubby::new, MobCategory.MONSTER).sized(0.5f, 0.6f).build("chubby"));
	public static final RegistryObject<EntityType<EntityMouse>> MOUSE = ENTITIES.register("mouse", () -> EntityType.Builder.<EntityMouse>of(EntityMouse::new, MobCategory.AMBIENT).sized(0.3f, 0.2f).build("mouse"));
	public static final RegistryObject<EntityType<EntityOrchardSpider>> ORCHARD_SPIDER = ENTITIES.register("orchard_spider",
			() -> EntityType.Builder.<EntityOrchardSpider>of(EntityOrchardSpider::new, MobCategory.MONSTER).sized(0.6f, 0.4f).build("orchard_spider"));
	public static final RegistryObject<EntityType<EntityBoar>> BOAR = ENTITIES.register("boar", () -> EntityType.Builder.<EntityBoar>of(EntityBoar::new, MobCategory.CREATURE).sized(1.2f, 1.0f).build(null));
	public static final RegistryObject<EntityType<EntityMushroom>> MUSHROOM = ENTITIES.register("mushroom", () -> EntityType.Builder.<EntityMushroom>of(EntityMushroom::new, MobCategory.CREATURE).sized(1.2f, 1.0f).build(null));

	public static final RegistryObject<BlockEntityType<BasicSignBlockEntity>> BASIC_SIGN = BLOCK_ENTITIES.register("basic_sign",
			() -> BlockEntityType.Builder.of(BasicSignBlockEntity::new, BlockRegistry.CHERRY_WALL_SIGN.get(), BlockRegistry.PEAR_WALL_SIGN.get(), BlockRegistry.ORANGE_WALL_SIGN.get(), BlockRegistry.ATLAS_WALL_SIGN.get(),
					BlockRegistry.PINE_WALL_SIGN.get(), BlockRegistry.COCO_WALL_SIGN.get(), BlockRegistry.DREAM_WALL_SIGN.get(), BlockRegistry.CHERRY_SIGN.get(), BlockRegistry.PEAR_SIGN.get(), BlockRegistry.ORANGE_SIGN.get(),
					BlockRegistry.ATLAS_SIGN.get(), BlockRegistry.PINE_SIGN.get(), BlockRegistry.COCO_SIGN.get(), BlockRegistry.DREAM_SIGN.get()).build(null));

	public static void init()
	{
		ENTITIES.register(MainRegistry.eventBus);
		BLOCK_ENTITIES.register(MainRegistry.eventBus);
	}
}
