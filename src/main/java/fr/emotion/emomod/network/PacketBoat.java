package fr.emotion.emomod.network;

import java.util.function.Supplier;

import fr.emotion.emomod.entity.EntityBoat;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketBoat
{
	private boolean left;
	private boolean right;

	public PacketBoat(PacketBuffer buf)
	{
		this.left = buf.readBoolean();
		this.right = buf.readBoolean();
	}

	public PacketBoat(boolean left, boolean right)
	{
		this.left = left;
		this.right = right;
	}

	public void toBytes(PacketBuffer buf)
	{
		buf.writeBoolean(this.left);
		buf.writeBoolean(this.right);
	}

	public void handle(Supplier<NetworkEvent.Context> ctx)
	{
		ctx.get().enqueueWork(() ->
		{
			Entity entity = ctx.get().getSender().getRidingEntity();

			if (entity instanceof EntityBoat)
				((EntityBoat) entity).setPaddleState(this.left, this.right);
		});

		ctx.get().setPacketHandled(true);
	}
}
