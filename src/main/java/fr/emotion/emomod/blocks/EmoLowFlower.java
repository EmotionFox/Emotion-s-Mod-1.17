package fr.emotion.emomod.blocks;

import fr.emotion.emomod.blocks.basic.BasicFlower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoLowFlower extends BasicFlower
{
	private static final VoxelShape NARCOTA_SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F);

	public EmoLowFlower(Properties properties)
	{
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
	{
		Vec3 vec3 = state.getOffset(getter, pos);
		return NARCOTA_SHAPE.move(vec3.x, vec3.y, vec3.z);
	}
}
