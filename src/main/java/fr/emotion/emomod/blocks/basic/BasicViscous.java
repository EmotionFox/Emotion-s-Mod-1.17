package fr.emotion.emomod.blocks.basic;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasicViscous extends Block
{
	protected static final VoxelShape MUD = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

	public BasicViscous(BlockBehaviour.Properties properties)
	{
		super(properties);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		return this == BlockRegistry.SHIFTING_SAND.get() ? Shapes.empty() : (this == BlockRegistry.MUD.get() ? MUD : Shapes.block());
	}
}
