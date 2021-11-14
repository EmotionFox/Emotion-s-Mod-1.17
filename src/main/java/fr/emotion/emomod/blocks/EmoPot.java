package fr.emotion.emomod.blocks;

import javax.annotation.Nullable;

import fr.emotion.emomod.blockentity.PotBlockEntity;
import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoPot extends Block implements EntityBlock
{
	private static final VoxelShape jar = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
	private static final VoxelShape cork = Block.box(5.0D, 9.0D, 5.0D, 11.0D, 11.0D, 11.0D);

	private static final VoxelShape pot = Shapes.or(jar, cork);

	private Item drop;

	public EmoPot(Properties properties)
	{
		this(properties, null);
	}

	public EmoPot(Properties properties, Item drop)
	{
		super(properties);
		this.drop = drop;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		return pot;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
	{
		return pot;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
	{
		Item heldItem = player.getItemInHand(handIn).getItem();
		ItemStack newStack = null;
		boolean isLava = false;
		boolean isFish = false;

		if (level.getBlockEntity(pos) instanceof PotBlockEntity)
		{
			PotBlockEntity tileEntityPot = (PotBlockEntity) level.getBlockEntity(pos);

			if (this == BlockRegistry.POT_GLASS.get())
			{
				if (heldItem == Items.WATER_BUCKET)
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_WATER.get().defaultBlockState());
					newStack = new ItemStack(Items.BUCKET);
				} else if (heldItem == Items.LAVA_BUCKET)
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_LAVA.get().defaultBlockState());
					newStack = new ItemStack(Items.BUCKET);
					isLava = true;
				} else if (heldItem == Items.MILK_BUCKET)
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_MILK.get().defaultBlockState());
					newStack = new ItemStack(Items.BUCKET);
				}

				if (newStack != null)
				{
					if (isLava)
						player.playSound(SoundEvents.BUCKET_EMPTY_LAVA, 1.0F, 1.0F);
					else
						player.playSound(SoundEvents.BUCKET_EMPTY, 1.0F, 1.0F);
				}
			} else if (this.drop != null && heldItem == ItemRegistry.SLICE_BREAD.get())
			{
				tileEntityPot.use();

				if (!player.isCreative())
				{
					player.getItemInHand(handIn).shrink(1);

					if (!player.addItem(new ItemStack(drop)))
					{
						Entity entity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(drop));
						level.addFreshEntity(entity);
					}
				}
			} else if (heldItem == Items.BUCKET)
			{
				if (this == BlockRegistry.POT_WATER.get())
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_GLASS.get().defaultBlockState());

					if (level.random.nextInt(100) == 0)
					{
						newStack = new ItemStack(Items.COD_BUCKET);
						isFish = true;
					} else
					{
						newStack = new ItemStack(Items.WATER_BUCKET);
					}
				} else if (this == BlockRegistry.POT_LAVA.get())
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_GLASS.get().defaultBlockState());
					newStack = new ItemStack(Items.LAVA_BUCKET);
					isLava = true;
				}

				if (this == BlockRegistry.POT_MILK.get())
				{
					level.setBlockAndUpdate(pos, BlockRegistry.POT_GLASS.get().defaultBlockState());
					newStack = new ItemStack(Items.MILK_BUCKET);
				}

				if (newStack != null)
				{
					if (isLava)
						player.playSound(SoundEvents.BUCKET_FILL_LAVA, 1.0F, 1.0F);
					else if (isFish)
						player.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
					else
						player.playSound(SoundEvents.BUCKET_FILL, 1.0F, 1.0F);
				}
			}

			if (newStack != null)
			{
				if (!player.isCreative())
					player.setItemInHand(handIn, newStack);

				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.FAIL;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new PotBlockEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity)
	{
		return level.isClientSide ? null : createTickerHelper(blockEntity, BlockEntityRegistry.POT.get(), PotBlockEntity::animeTick);
	}

	@Override
	public RenderShape getRenderShape(BlockState p_60550_)
	{
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@SuppressWarnings("deprecation")
	public boolean triggerEvent(BlockState p_49226_, Level p_49227_, BlockPos p_49228_, int p_49229_, int p_49230_)
	{
		super.triggerEvent(p_49226_, p_49227_, p_49228_, p_49229_, p_49230_);
		BlockEntity blockentity = p_49227_.getBlockEntity(p_49228_);
		return blockentity == null ? false : blockentity.triggerEvent(p_49229_, p_49230_);
	}

	@Nullable
	public MenuProvider getMenuProvider(BlockState p_49234_, Level p_49235_, BlockPos p_49236_)
	{
		BlockEntity blockentity = p_49235_.getBlockEntity(p_49236_);
		return blockentity instanceof MenuProvider ? (MenuProvider) blockentity : null;
	}

	@SuppressWarnings("unchecked")
	@Nullable
	protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_)
	{
		return p_152134_ == p_152133_ ? (BlockEntityTicker<A>) p_152135_ : null;
	}
}
