package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.levelgen.feature.stateproviders.EmotionFlowerProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockStateProviderTypeRegistry
{
	public static final DeferredRegister<BlockStateProviderType<?>> BLOCK_STATE_PROVIDER_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, MainRegistry.MOD_ID);
	
	public static final RegistryObject<BlockStateProviderType<EmotionFlowerProvider>> EMOTION_FLOWER_PROVIDER = BLOCK_STATE_PROVIDER_TYPES.register("emotion_flower_provider", () -> new BlockStateProviderType<>(EmotionFlowerProvider.CODEC));

	public static void init(IEventBus eventBus)
	{
		BLOCK_STATE_PROVIDER_TYPES.register(eventBus);
	} 
}
