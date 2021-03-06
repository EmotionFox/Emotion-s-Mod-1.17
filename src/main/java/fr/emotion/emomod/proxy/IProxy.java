package fr.emotion.emomod.proxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface IProxy
{
	void init();

	Level getClientLevel();

	Player getClientPlayer();

	MinecraftServer getServerLevel();
}
