package fr.emotion.emomod.network;

import java.util.function.Supplier;

import fr.emotion.emomod.inventory.container.CrafterContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketCrafter
{
	private final int page;
	private final String[] tags;

	public PacketCrafter(PacketBuffer buf)
	{
		this.page = buf.readInt();
		int size = buf.readInt();
		this.tags = new String[size];

		for (int i = 0; i < size; i++)
		{
			this.tags[i] = buf.readString();
		}
	}

	public PacketCrafter(int page, String... tags)
	{
		this.page = page;
		this.tags = new String[tags.length];

		for (int i = 0; i < tags.length; i++)
		{
			this.tags[i] = tags[i];
		}
	}

	public void toBytes(PacketBuffer buf)
	{
		buf.writeInt(page);
		buf.writeInt(this.tags.length);

		for (int i = 0; i < this.tags.length; i++)
		{
			buf.writeString(this.tags[i]);
		}
	}

	public void handle(Supplier<NetworkEvent.Context> ctx)
	{
		ctx.get().enqueueWork(() ->
		{
			Container container = ctx.get().getSender().openContainer;

			if (container != null && container instanceof CrafterContainer)
			{
				((CrafterContainer) container).setInventory(this.page, this.tags);
			}
		});

		ctx.get().setPacketHandled(true);
	}
}
