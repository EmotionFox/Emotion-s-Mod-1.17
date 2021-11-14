package fr.emotion.emomod.blocks;

import javax.annotation.Nullable;

import fr.emotion.emomod.blockentity.BushBlockEntity;
import fr.emotion.emomod.init.BlockEntityRegistry;
import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoBush extends BushBlock implements EntityBlock, DispenserInteract
{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_2;

	public EmoBush(Properties properties)
	{
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(this.getStageProperty(), Integer.valueOf(1)));
	}

	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
	{
		return Shapes.empty();
	}

	@Override
	public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_)
	{
		return Shapes.block();
	}

	public IntegerProperty getStageProperty()
	{
		return AGE;
	}

	public int getStage(BlockState state)
	{
		return state.getValue(this.getStageProperty());
	}

	public BlockState withStage(int stage)
	{
		return this.defaultBlockState().setValue(this.getStageProperty(), Integer.valueOf(stage));
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
	{
		InteractionResult interaction = InteractionResult.FAIL;

		double d0 = (double) pos.getX();
		double d1 = (double) pos.getY();
		double d2 = (double) pos.getZ();

		if (level.getBlockEntity(pos) instanceof BushBlockEntity)
			((BushBlockEntity) level.getBlockEntity(pos)).interact(player.getItemInHand(hand).getItem() == Items.WATER_BUCKET ? true : false, this.getStage(state) == 2 ? true : false);

		if (this.getStage(state) > 0 && player.getItemInHand(hand).getItem() == Items.BONE_MEAL)
		{
			level.addParticle(ParticleTypes.HAPPY_VILLAGER, d0 + (double) level.random.nextFloat(), d1 + 1D, d2 + (double) level.random.nextFloat(), 0.0D, 0.0D, 0.0D);

			if (level.random.nextInt(7) == 0)
				popResource(level, pos, new ItemStack(this.asItem(), 1));

			if (!player.isCreative())
				player.getItemInHand(hand).shrink(1);

			interaction = InteractionResult.SUCCESS;
		} else if (player.getItemInHand(hand).getItem() == Items.WATER_BUCKET)
		{
			level.addParticle(ParticleTypes.HAPPY_VILLAGER, d0 + (double) level.random.nextFloat(), d1 + 1D, d2 + (double) level.random.nextFloat(), 0.0D, 0.0D, 0.0D);
			player.playSound(SoundEvents.BUCKET_EMPTY, 1.0F, 1.0F);
			level.setBlock(pos, this.withStage(1), 2);

			if (!player.isCreative())
				player.setItemInHand(hand, new ItemStack(Items.BUCKET));

			interaction = InteractionResult.SUCCESS;
		}

		if (this.getStage(state) == 2)
		{
			dropBerry(level, pos, state);
			interaction = InteractionResult.SUCCESS;
		}

		return interaction;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player)
	{
		if (!player.isCreative())
			this.dropBerry(player.level, pos, state);

		return super.canHarvestBlock(state, world, pos, player);
	}

	protected void dropBerry(Level level, BlockPos pos, BlockState state)
	{
		if (this.getStage(state) == 2)
		{
			if (this == BlockRegistry.BUSH_BLUEBERRY.get())
				popResource(level, pos, new ItemStack(ItemRegistry.BERRY_BLUEBERRY.get(), 1 + level.random.nextInt(3)));
			else if (this == BlockRegistry.BUSH_REDCURRANT.get())
				popResource(level, pos, new ItemStack(ItemRegistry.BERRY_REDCURRANT.get(), 1 + level.random.nextInt(3)));
			else if (this == BlockRegistry.BUSH_BLACKCURRANT.get())
				popResource(level, pos, new ItemStack(ItemRegistry.BERRY_BLACKCURRANT.get(), 1 + level.random.nextInt(3)));
			else if (this == BlockRegistry.BUSH_STRAWBERRY.get())
				popResource(level, pos, new ItemStack(ItemRegistry.BERRY_STRAWBERRY.get(), 1 + level.random.nextInt(3)));
			else if (this == BlockRegistry.BUSH_DREAMCURRANT.get())
				popResource(level, pos, new ItemStack(ItemRegistry.BERRY_DREAMCURRANT.get(), 1 + level.random.nextInt(1)));

			level.setBlock(pos, this.withStage(1), 2);
		}
	}

//	@Override
//	protected void fillStateContainer(Builder<Block, BlockState> builder)
//	{
//		builder.add(AGE);
//	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BushBlockEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity)
	{
		return level.isClientSide ? null : createTickerHelper(blockEntity, BlockEntityRegistry.BUSH.get(), BushBlockEntity::growTick);
	}
	
	public RenderShape getRenderShape(BlockState p_49232_)
	{
		return RenderShape.INVISIBLE;
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

	public ItemStack react(Level level, BlockSource source, ItemStack stackIn)
	{
		if (!level.isClientSide())
		{
			if (stackIn.getItem() == PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER).getItem())
			{
				if (level.getBlockEntity(source.getPos()) instanceof BushBlockEntity)
					((BushBlockEntity) level.getBlockEntity(source.getPos())).interact(true, false);

				level.setBlock(source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING)), this.withStage(1), 2);

				return new ItemStack(Items.GLASS_BOTTLE, 1);
			}
		}

		return stackIn;
	}
}
