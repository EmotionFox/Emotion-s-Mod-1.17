package fr.emotion.emomod.blockentity;

import java.util.Random;

import fr.emotion.emomod.blocks.EmoBush;
import fr.emotion.emomod.init.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BushBlockEntity extends BlockEntity
{
	private static final Random rand = new Random();
	private long lastHarvest;
	private static final int minFruitageDelay = 12000;
	private static final int maxFruitageDelay = 20000;
	private long lastWatering;
	private static final int dayLenght = 24000;

	public BushBlockEntity(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.BUSH.get(), pos, state);
	}

	public static void growTick(Level level, BlockPos pos, BlockState state, BushBlockEntity blockEntity)
	{
		if (level.isRaining())
			blockEntity.interact(true, false);

		if (state.getBlock() instanceof EmoBush)
		{
			EmoBush bush = (EmoBush) state.getBlock();

			if (blockEntity.lastHarvest == 0 || blockEntity.lastHarvest > level.getDayTime())
				blockEntity.lastHarvest = level.getDayTime();
			if (blockEntity.lastWatering == 0 || blockEntity.lastWatering > level.getDayTime())
				blockEntity.lastWatering = level.getDayTime();

			long fruitageDelay = level.getDayTime() - blockEntity.lastHarvest;
			long waterDelay = level.getDayTime() - blockEntity.lastWatering;

			blockEntity.handleUpdateTag(blockEntity.getUpdateTag());

			if (bush.getStage(state) == 1)
			{
				if (fruitageDelay > minFruitageDelay)
				{
					int chance = (int) (fruitageDelay - maxFruitageDelay);

					if (fruitageDelay >= maxFruitageDelay)
					{
						level.setBlock(pos, bush.withStage(2), 2);
						blockEntity.lastHarvest = level.getDayTime() - 1;
						blockEntity.handleUpdateTag(blockEntity.getUpdateTag());
					} else if (chance <= 0 || rand.nextInt(chance) == 0)
					{
						level.setBlock(pos, bush.withStage(2), 2);
						blockEntity.lastHarvest = level.getDayTime() - 1;
						blockEntity.handleUpdateTag(blockEntity.getUpdateTag());
					}
				}
			}

			if (bush.getStage(state) >= 1)
			{
				if (waterDelay >= (dayLenght * 1.50))
				{
					level.setBlock(pos, bush.withStage(0), 2);
					blockEntity.lastHarvest = level.getDayTime() - 1;
					blockEntity.handleUpdateTag(blockEntity.getUpdateTag());
				}
			} else if (bush.getStage(state) == 0)
			{
				if (waterDelay >= (dayLenght * 2.25))
				{
					level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
					blockEntity.handleUpdateTag(blockEntity.getUpdateTag());
				}
			}
		}
	}

	public void interact(boolean water, boolean stage)
	{
		if (water)
		{
			this.lastWatering = this.level.getDayTime();
			this.handleUpdateTag(this.getUpdateTag());
		}
		if (stage)
		{
			this.lastHarvest = this.level.getDayTime();
			this.handleUpdateTag(this.getUpdateTag());
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket()
	{
		return new ClientboundBlockEntityDataPacket(this.getBlockPos(), 3, this.getUpdateTag());
	}

	@Override
	public CompoundTag getUpdateTag()
	{
		return this.save(new CompoundTag());
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt)
	{
		super.onDataPacket(net, pkt);
		handleUpdateTag(pkt.getTag());
	}

	@Override
	public void handleUpdateTag(CompoundTag tag)
	{
		this.level.markAndNotifyBlock(this.getBlockPos(), level.getChunkAt(this.getBlockPos()), this.getBlockState(), this.getBlockState(), 3, 0);
		this.setChanged();
	}

	@Override
	public void deserializeNBT(CompoundTag nbt)
	{
		super.deserializeNBT(nbt);
		
		this.lastWatering = nbt.getLong("LastWatering");
		this.lastHarvest = nbt.getLong("LastHarvest");
	}

	@Override
	public CompoundTag serializeNBT()
	{
		CompoundTag ret = new CompoundTag();
		ret.putLong("LastWatering", this.lastWatering);
		ret.putLong("LastHarvest", this.lastHarvest);
		this.save(ret);
		return ret;
	}

	@Override
	public BlockEntityType<?> getType()
	{
		return BlockEntityRegistry.BUSH.get();
	}
}
