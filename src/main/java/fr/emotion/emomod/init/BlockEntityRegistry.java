package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.blockentity.BasicSignBlockEntity;
import fr.emotion.emomod.blockentity.BushBlockEntity;
import fr.emotion.emomod.blockentity.PotBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityRegistry
{
	private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MainRegistry.MOD_ID);

	public static final RegistryObject<BlockEntityType<BushBlockEntity>> BUSH = BLOCK_ENTITIES.register("bush", () -> BlockEntityType.Builder
			.of(BushBlockEntity::new, BlockRegistry.BUSH_BLUEBERRY.get(), BlockRegistry.BUSH_REDCURRANT.get(), BlockRegistry.BUSH_BLACKCURRANT.get(), BlockRegistry.BUSH_STRAWBERRY.get(), BlockRegistry.BUSH_DREAMCURRANT.get()).build(null));

	public static final RegistryObject<BlockEntityType<BasicSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign",
			() -> BlockEntityType.Builder.of(BasicSignBlockEntity::new, BlockRegistry.CHERRY_WALL_SIGN.get(), BlockRegistry.CHERRY_SIGN.get(), BlockRegistry.ORANGE_WALL_SIGN.get(), BlockRegistry.ORANGE_SIGN.get(), BlockRegistry.PEAR_WALL_SIGN.get(),
					BlockRegistry.PEAR_SIGN.get(), BlockRegistry.ATLAS_WALL_SIGN.get(), BlockRegistry.ATLAS_SIGN.get(), BlockRegistry.PINE_WALL_SIGN.get(), BlockRegistry.PINE_SIGN.get(), BlockRegistry.COCO_WALL_SIGN.get(),
					BlockRegistry.COCO_SIGN.get(), BlockRegistry.DREAM_WALL_SIGN.get(), BlockRegistry.DREAM_SIGN.get()).build(null));

	public static final RegistryObject<BlockEntityType<PotBlockEntity>> POT = BLOCK_ENTITIES.register("pot",
			() -> BlockEntityType.Builder.of(PotBlockEntity::new, BlockRegistry.POT_APPLE.get(), BlockRegistry.POT_BLACKCURRANT.get(), BlockRegistry.POT_BLUEBERRY.get(), BlockRegistry.POT_CHERRY.get(), BlockRegistry.POT_CHOCOLATE.get(),
					BlockRegistry.POT_ORANGE.get(), BlockRegistry.POT_PEAR.get(), BlockRegistry.POT_REDCURRANT.get(), BlockRegistry.POT_STRAWBERRY.get(), BlockRegistry.POT_DREAMCURRANT.get(), BlockRegistry.POT_WATER.get(),
					BlockRegistry.POT_LAVA.get(), BlockRegistry.POT_MILK.get(), BlockRegistry.POT_GLASS.get()).build(null));

	public static void init()
	{
		BLOCK_ENTITIES.register(MainRegistry.eventBus);
	}
}
