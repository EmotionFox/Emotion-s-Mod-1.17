package fr.emotion.emomod.tileentity;

import java.util.Random;

import javax.annotation.Nullable;

import fr.emotion.emomod.blocks.EmoBush;
import fr.emotion.emomod.init.TileEntityTypeRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBush extends TileEntity implements ITickableTileEntity
{
	private static final Random rand = new Random();
	private long lastHarvest;
	private static final int minFruitageDelay = 12000;
	private static final int maxFruitageDelay = 20000;
	private long lastWatering;
	private static final int dayLenght = 24000;

	public TileEntityBush()
	{
		super(TileEntityTypeRegistry.BUSH);
	}

	@Override
	public void tick()
	{
		if (this.getWorld().isRaining())
			this.interact(true, false);

		if (this.getBlockState().getBlock() instanceof EmoBush)
		{
			EmoBush bush = (EmoBush) this.getBlockState().getBlock();

			if (this.lastHarvest == 0 || this.lastHarvest > this.world.getDayTime())
				this.lastHarvest = this.world.getDayTime();
			if (this.lastWatering == 0 || this.lastWatering > this.world.getDayTime())
				this.lastWatering = this.world.getDayTime();

			long fruitageDelay = this.world.getDayTime() - this.lastHarvest;
			long waterDelay = this.world.getDayTime() - this.lastWatering;

			this.sendUpdates();

			if (bush.getStage(this.getBlockState()) == 1)
			{
				if (fruitageDelay > minFruitageDelay)
				{
					int chance = (int) (fruitageDelay - maxFruitageDelay);

					if (fruitageDelay >= maxFruitageDelay)
					{
						this.world.setBlockState(this.pos, bush.withStage(2), 2);
						this.lastHarvest = this.world.getDayTime() - 1;
						this.sendUpdates();
					} else if (chance <= 0 || rand.nextInt(chance) == 0)
					{
						this.world.setBlockState(this.pos, bush.withStage(2), 2);
						this.lastHarvest = this.world.getDayTime() - 1;
						this.sendUpdates();
					}
				}
			}

			if (bush.getStage(this.getBlockState()) >= 1)
			{
				if (waterDelay >= (dayLenght * 1.50))
				{
					this.world.setBlockState(this.pos, bush.withStage(0), 2);
					this.lastHarvest = this.world.getDayTime() - 1;
					this.sendUpdates();
				}
			} else if (bush.getStage(this.getBlockState()) == 0)
			{
				if (waterDelay >= (dayLenght * 2.25))
				{
					this.world.setBlockState(this.pos, Blocks.AIR.getDefaultState(), 2);
					this.sendUpdates();
				}
			}
		}
	}

	public void interact(boolean water, boolean stage)
	{
		if (water)
		{
			this.lastWatering = this.world.getDayTime();
			this.sendUpdates();
		}
		if (stage)
		{
			this.lastHarvest = this.world.getDayTime();
			this.sendUpdates();
		}
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket()
	{
		return new SUpdateTileEntityPacket(this.pos, 3, this.getUpdateTag());
	}

	@Override
	public CompoundNBT getUpdateTag()
	{
		return this.write(new CompoundNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt)
	{
		super.onDataPacket(net, pkt);
		handleUpdateTag(pkt.getNbtCompound());
	}

	private void sendUpdates()
	{
		world.markAndNotifyBlock(pos, world.getChunkAt(pos), getBlockState(), getBlockState(), 3);
		markDirty();
	}

	@Override
	public void read(CompoundNBT compound)
	{
		this.lastWatering = compound.getLong("LastWatering");
		this.lastHarvest = compound.getLong("LastHarvest");
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		compound.putLong("LastWatering", this.lastWatering);
		compound.putLong("LastHarvest", this.lastHarvest);
		return compound;
	}
}
