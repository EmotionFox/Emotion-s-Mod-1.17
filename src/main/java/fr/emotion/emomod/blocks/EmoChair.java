package fr.emotion.emomod.blocks;

import java.util.List;

import fr.emotion.emomod.entity.EntitySittable;
import fr.emotion.emomod.init.EntityTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoChair extends Block
{
	private static final VoxelShape CHAIR_SHAPE = Block.box(3.0F, 0.0F, 3.0F, 13.0F, 12.0F, 13.0F);
	private static final VoxelShape shelf = Block.box(3d, 9d, 3d, 13d, 12d, 13d);

	private static final VoxelShape w_foot_1 = Block.box(3d, 0d, 3d, 5d, 9d, 5d);
	private static final VoxelShape w_foot_2 = Block.box(11d, 0d, 3d, 13d, 9d, 5d);
	private static final VoxelShape w_foot_3 = Block.box(3d, 0d, 11d, 5d, 9d, 13d);
	private static final VoxelShape w_foot_4 = Block.box(11d, 0d, 11d, 13d, 9d, 13d);
	private static final VoxelShape w_shelf = Block.box(4d, 5d, 4d, 12d, 7d, 12d);

	private static final VoxelShape wood = Shapes.or(shelf, w_foot_1, w_foot_2, w_foot_3, w_foot_4, w_shelf);

	private static final VoxelShape s_pillar = Block.box(4d, 2d, 4d, 12d, 9d, 12d);
	private static final VoxelShape s_shelf = Block.box(3d, 0d, 3d, 13d, 2d, 13d);

	private static final VoxelShape stone = Shapes.or(shelf, s_pillar, s_shelf);

	private boolean isStone = false;

	public EmoChair(Properties properties, boolean isStone)
	{
		this(properties);
		this.isStone = isStone;
	}

	public EmoChair(Properties properties)
	{
		super(properties);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
	{
		return CHAIR_SHAPE;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
	{
		if (isStone)
			return stone;
		else
			return wood;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
	{
		return sitPlayer(level, pos, player, hand);
	}

	private static InteractionResult sitPlayer(Level level, BlockPos pos, Player player, InteractionHand hand)
	{
		if (!level.isClientSide() && !level.getBlockState(pos.above()).hasLargeCollisionShape())
		{
			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();

			List<EntitySittable> listEMB = level.getEntitiesOfClass(EntitySittable.class, new AABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expandTowards(1.0D, 1.0D, 1.0D));

			for (EntitySittable entitytocheck : listEMB)
			{
				if ((entitytocheck.blockPosX == x) && (entitytocheck.blockPosY == y) && (entitytocheck.blockPosZ == z))
				{
					entitytocheck.interact(player, hand);
					return InteractionResult.SUCCESS;
				}
			}

			EntitySittable entity = new EntitySittable(EntityTypeRegistry.SITTABLE.get(), level, player, x, y, z);
			level.addFreshEntity(entity);
			return entity.interact(player, hand);
		}

		return InteractionResult.FAIL;
	}
}
