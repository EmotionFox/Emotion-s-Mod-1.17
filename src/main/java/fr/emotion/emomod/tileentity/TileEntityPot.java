package fr.emotion.emomod.tileentity;

import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.TileEntityTypeRegistry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPot extends TileEntity implements ITickableTileEntity
{
	private String contentsType = "";
	private int contentsLevel = 0;
	private boolean animated = false;
	private int frame = 0;
	private int maxFrame = 0;

	private static final int[] lavaSequence = new int[]
	{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	public TileEntityPot()
	{
		super(TileEntityTypeRegistry.POT);
	}

	public TileEntityPot(String contentsType)
	{
		super(TileEntityTypeRegistry.POT);
		this.setContents(contentsType, 4);
	}

	public void setContents(String contentsType, int contentsLevel)
	{
		this.contentsType = contentsType;

		if (contentsType == "pot_dreamcurrant" || contentsType == "pot_water" || contentsType == "pot_lava")
		{
			this.animated = true;
			this.maxFrame = contentsType == "pot_dreamcurrant" ? 8 : contentsType == "pot_water" ? 32 : lavaSequence.length;
			this.sendUpdates(false);
		}

		this.contentsLevel = contentsLevel;
		this.sendUpdates(false);
	}

	@Override
	public CompoundNBT getUpdateTag()
	{
		CompoundNBT compound = super.getUpdateTag();

		compound.putString("ContentsType", this.contentsType);
		compound.putInt("ContentsLevel", this.contentsLevel);
		compound.putBoolean("Animated", this.animated);
		compound.putInt("Frame", this.frame);

		return compound;
	}

	@Override
	public void handleUpdateTag(CompoundNBT compound)
	{
		this.read(compound);

		this.setContents(compound.getString("ContentsType"), compound.getInt("ContentsLevel"));
		this.animated = compound.getBoolean("Animated");
		this.frame = compound.getInt("Frame");
	}

	private void sendUpdates(boolean notify)
	{
		if (notify)
			world.markAndNotifyBlock(pos, world.getChunkAt(pos), getBlockState(), getBlockState(), 3);
		this.markDirty();
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);

		this.setContents(compound.getString("ContentsType"), compound.getInt("ContentsLevel"));
		this.animated = compound.getBoolean("Animated");
		this.frame = compound.getInt("Frame");
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);

		compound.putString("ContentsType", this.contentsType);
		compound.putInt("ContentsLevel", this.contentsLevel);
		compound.putBoolean("Animated", this.animated);
		compound.putInt("Frame", this.frame);

		return compound;
	}

	public void use()
	{
		this.contentsLevel -= 1;

		if (this.contentsLevel <= 0)
			this.getWorld().setBlockState(this.getPos(), BlockRegistry.POT_GLASS.getDefaultState(), 2);

		this.sendUpdates(true);
	}

	public int getContentsLevel()
	{
		return this.contentsLevel;
	}

	public String getContentsType()
	{
		return this.contentsType;
	}

	public boolean isAnimated()
	{
		return this.animated;
	}

	public String getFrame()
	{
		if (this.contentsType == "pot_lava")
			return Integer.toString(lavaSequence[this.frame]);
		else
			return Integer.toString(this.frame);
	}

	@Override
	public void tick()
	{
		if (this.animated)
		{
			this.frame++;

			if (this.frame >= this.maxFrame)
				this.frame = 0;

			this.sendUpdates(false);
		}
	}
}
