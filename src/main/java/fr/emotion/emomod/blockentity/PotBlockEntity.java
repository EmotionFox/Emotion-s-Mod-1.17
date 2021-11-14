package fr.emotion.emomod.blockentity;

import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PotBlockEntity extends BlockEntity
{
	private String contentsType = "";
	private int contentsLevel = 0;
	private boolean animated = false;
	private int frame = 0;
	private int maxFrame = 0;

	private static final int[] lavaSequence = new int[]
	{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	
	public PotBlockEntity(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.POT.get(), pos, state);
	}
	
	public PotBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
	{
		super(type, pos, state);
	}
	
	public void setContents(String contentsType, int contentsLevel)
	{
		this.contentsType = contentsType;

		if (contentsType == "pot_dreamcurrant" || contentsType == "pot_water" || contentsType == "pot_lava")
		{
			this.animated = true;
			this.maxFrame = contentsType == "pot_dreamcurrant" ? 8 : contentsType == "pot_water" ? 32 : lavaSequence.length;
			this.handleUpdateTag(this.getUpdateTag());
		}

		this.contentsLevel = contentsLevel;
		this.handleUpdateTag(this.getUpdateTag());
	}
	
	public String getFrame()
	{
		if(this.contentsType == "pot_lava")
			return Integer.toString(lavaSequence[this.frame]);
		else
			return Integer.toString(this.frame);
	}
	
	public static void animeTick(Level level, BlockPos pos, BlockState state, PotBlockEntity blockEntity)
	{
		if(blockEntity.animated)
		{
			blockEntity.frame++;
			
			if(blockEntity.frame >= blockEntity.maxFrame)
				blockEntity.frame = 0;
			
			blockEntity.handleUpdateTag(blockEntity.getUpdateTag());
		}
	}
	
	public void use()
	{
		this.contentsLevel -= 1;
		
		if(this.contentsLevel <= 0)
			this.level.setBlock(this.getBlockPos(), BlockRegistry.POT_GLASS.get().defaultBlockState(), 2);
		
		this.handleUpdateTag(this.getUpdateTag());
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
	}
	
	@Override
	public void deserializeNBT(CompoundTag nbt)
	{
		super.deserializeNBT(nbt);
		
		this.setContents(nbt.getString("ContentType"), nbt.getInt("ContentsLevel"));
		this.animated = nbt.getBoolean("Animated");
		this.frame = nbt.getInt("Frame");
	}
	
	@Override
	public CompoundTag serializeNBT()
	{
		CompoundTag ret = new CompoundTag();
		ret.putString("ContentsType", this.contentsType);
		ret.putInt("ContentsLevel", this.contentsLevel);
		ret.putBoolean("Animated", this.animated);
		ret.putInt("Frame", this.frame);
		this.save(ret);
		return ret;
	}
	
	@Override
	public BlockEntityType<?> getType()
	{
		return BlockEntityRegistry.POT.get();
	}
}
