package fr.emotion.emomod.network;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class EmomodPacketHandler
{
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MainRegistry.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	private static int id = 0;

	public static int nextId()
	{
		return id++;
	}

	public static void registerMessages()
	{
		INSTANCE.registerMessage(nextId(), PacketCrafter.class, PacketCrafter::toBytes, PacketCrafter::new, PacketCrafter::handle);
		INSTANCE.registerMessage(nextId(), PacketBoat.class, PacketBoat::toBytes, PacketBoat::new, PacketBoat::handle);
	}
}
