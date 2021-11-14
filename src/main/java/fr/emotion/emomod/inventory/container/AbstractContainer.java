package fr.emotion.emomod.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;

public class AbstractContainer extends Container
{
	public AbstractContainer()
	{
		// El Diablo
		super(null, 666);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return false;
	}
}
