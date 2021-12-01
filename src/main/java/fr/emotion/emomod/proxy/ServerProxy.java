package fr.emotion.emomod.proxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;

public class ServerProxy implements IProxy
{
	@Override
	public void init()
	{
	}

	@Override
	public Level getClientLevel()
	{
		throw new IllegalStateException("Only run this on the client!");
	}

	@Override
	public Player getClientPlayer()
	{
		throw new IllegalStateException("Only run this on the client!");
	}

	@Override
	public MinecraftServer getServerLevel()
	{
		return ServerLifecycleHooks.getCurrentServer();
	}
}
