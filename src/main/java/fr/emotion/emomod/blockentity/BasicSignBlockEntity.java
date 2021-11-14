package fr.emotion.emomod.blockentity;

import fr.emotion.emomod.init.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BasicSignBlockEntity extends SignBlockEntity
{
	public BasicSignBlockEntity(BlockPos pos, BlockState state)
	{
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType()
	{
		return BlockEntityRegistry.SIGN.get();
	}
}
