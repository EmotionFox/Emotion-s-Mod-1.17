package fr.emotion.emomod.blocks.basic;

import fr.emotion.emomod.blockentity.BasicSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BasicStandingSign extends StandingSignBlock
{
	public BasicStandingSign(BlockBehaviour.Properties properties, WoodType woodType)
	{
		super(properties, woodType);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BasicSignBlockEntity(pos, state);
	}
}
