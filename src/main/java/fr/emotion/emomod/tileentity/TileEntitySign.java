package fr.emotion.emomod.tileentity;

import fr.emotion.emomod.init.TileEntityTypeRegistry;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntitySign extends SignTileEntity
{
	// I've kill that. Masterpiece.

	@Override
	public TileEntityType<?> getType()
	{
		return TileEntityTypeRegistry.SIGN;
	}
}
