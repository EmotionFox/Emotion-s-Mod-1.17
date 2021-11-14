package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerTypeRegistry
{
	private static final List<ContainerType<?>> containerTypeList = new ArrayList<ContainerType<?>>();

	private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MainRegistry.MOD_ID);

	public static final ContainerType<CrafterContainer> CRAFTER = IForgeContainerType.create((windowId, inv, data) ->
	{
		BlockPos pos = data.readBlockPos();
		return new CrafterContainer(windowId, MainRegistry.proxy.getClientWorld(), pos, MainRegistry.proxy.getClientPlayer());
	});

	public static final ContainerType<BagContainer> BAG = IForgeContainerType.create((windowId, inv, data) ->
	{
		return new BagContainer(windowId, inv);
	});

	public static final ContainerType<NightstandContainer> NIGHTSTAND = IForgeContainerType.create((windowId, inv, data) ->
	{
		BlockPos pos = data.readBlockPos();
		return new NightstandContainer(windowId, inv.player.getEntityWorld(), pos, inv);
	});

	public static void init()
	{
		addContainerType(CRAFTER, "crafter");
		addContainerType(BAG, "bag");
		addContainerType(NIGHTSTAND, "nightstand");
	}

	public static void addContainerType(ContainerType<?> tet, String name)
	{
		containerTypeList.add(tet.setRegistryName(name));
	}

//	@SubscribeEvent
	public static void registerContainerType(final RegistryEvent.Register<ContainerType<?>> e)
	{
		for (ContainerType<?> tet : containerTypeList)
		{
			e.getRegistry().register(tet);
		}
	}
}
