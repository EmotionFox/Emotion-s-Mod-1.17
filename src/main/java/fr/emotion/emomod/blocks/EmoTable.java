package fr.emotion.emomod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoTable extends Block
{
	public static final EnumProperty<TableDir> DIR = EnumProperty.<TableDir>create("table", TableDir.class);
	public static final VoxelShape shelf = Block.box(0d, 12d, 0d, 16d, 16d, 16d);
	public static final VoxelShape full = Shapes.or(shelf);

	public static final VoxelShape pillar = Block.box(6d, 3d, 6d, 10d, 12d, 10d);
	public static final VoxelShape foot_ns = Block.box(6d, 0d, 0d, 10d, 2d, 16d);
	public static final VoxelShape foot_ew = Block.box(0d, 0d, 6d, 16d, 2d, 10d);
	public static final VoxelShape foot_shelf = Block.box(3d, 2d, 3d, 13d, 3d, 13d);
	public static final VoxelShape normal = Shapes.or(shelf, pillar, foot_ns, foot_ew, foot_shelf);
	public static final VoxelShape straight_ns = Shapes.or(shelf, foot_ns);
	public static final VoxelShape straight_ew = Shapes.or(shelf, foot_ew);

	public static final VoxelShape s_pillar = Block.box(4d, 2d, 4d, 12d, 10d, 12d);
	public static final VoxelShape s_foot_shelf_t = Block.box(3d, 10d, 3d, 13d, 12d, 13d);
	public static final VoxelShape s_foot_shelf_b = Block.box(3d, 0d, 3d, 13d, 2d, 13d);
	public static final VoxelShape s_normal = Shapes.or(shelf, s_pillar, s_foot_shelf_t, s_foot_shelf_b);

	public boolean isStone = false;

	public EmoTable(Properties properties, boolean isStone)
	{
		this(properties);
		this.isStone = isStone;
	}

	public EmoTable(Properties properties)
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DIR, TableDir.NORMAL));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
	{
		switch ((TableDir) state.getValue(DIR))
		{
		default:
		case NORMAL:
			if (this.isStone)
				return s_normal;
			return normal;
		case STRAIGHT_NS:
			if (this.isStone)
				return full;
			return straight_ns;
		case STRAIGHT_EW:
			if (this.isStone)
				return full;
			return straight_ew;
		case FULL:
			return full;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context)
	{
		return checkAround(context.getLevel(), context.getClickedPos());
	}

	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState facingState, LevelAccessor accessor, BlockPos pos, BlockPos facingPos)
	{
		return checkAround(accessor, pos);
	}

	public BlockState checkAround(LevelAccessor level, BlockPos pos)
	{
		BlockPos north = pos.north();
		BlockPos south = pos.south();
		BlockPos east = pos.east();
		BlockPos west = pos.west();
		BlockState stateNorth = level.getBlockState(north);
		BlockState stateSouth = level.getBlockState(south);
		BlockState stateEast = level.getBlockState(east);
		BlockState stateWest = level.getBlockState(west);

		boolean boolNorth = this.canAttachTo(stateNorth, stateNorth.isFaceSturdy(level, north, Direction.SOUTH));
		boolean boolSouth = this.canAttachTo(stateSouth, stateSouth.isFaceSturdy(level, south, Direction.NORTH));
		boolean boolEast = this.canAttachTo(stateEast, stateEast.isFaceSturdy(level, east, Direction.WEST));
		boolean boolWest = this.canAttachTo(stateWest, stateWest.isFaceSturdy(level, west, Direction.EAST));

		if (boolNorth && boolSouth && boolEast && boolWest)
			return this.defaultBlockState().setValue(DIR, TableDir.FULL);
		else if (boolNorth && boolSouth)
		{
			if (level.getBlockState(north).getValue(DIR) != TableDir.NORMAL || level.getBlockState(south).getValue(DIR) != TableDir.NORMAL)
				return this.defaultBlockState().setValue(DIR, TableDir.FULL);
			else
				return this.defaultBlockState().setValue(DIR, TableDir.STRAIGHT_NS);
		} else if (boolEast && boolWest)
		{
			if (level.getBlockState(east).getValue(DIR) != TableDir.NORMAL || level.getBlockState(west).getValue(DIR) != TableDir.NORMAL)
				return this.defaultBlockState().setValue(DIR, TableDir.FULL);
			else
				return this.defaultBlockState().setValue(DIR, TableDir.STRAIGHT_EW);
		} else
			return this.defaultBlockState().setValue(DIR, TableDir.NORMAL);
	}

	public final boolean canAttachTo(BlockState state, boolean bool)
	{
		return state.getBlock() instanceof EmoTable;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder)
	{
		builder.add(DIR);
	}

	public enum TableDir implements StringRepresentable
	{
		NORMAL("normal"), STRAIGHT_NS("ns"), STRAIGHT_EW("ew"), FULL("full");

		private final String name;

		private TableDir(String name)
		{
			this.name = name;
		}

		@Override
		public String getSerializedName()
		{
			return name;
		}
	}
}
