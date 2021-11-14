package fr.emotion.emomod.fluid;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.FluidRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class AncientWaterFluid extends FlowingFluid
{
	public Fluid getFlowing()
	{
		return FluidRegistry.FLOWING_ANCIENT_WATER.get();
	}

	public Fluid getSource()
	{
		return FluidRegistry.ANCIENT_WATER.get();
	}

	public Item getBucket()
	{
		return ItemRegistry.ANCIENT_WATER_BUCKET.get();
	}

	public void animateTick(Level level, BlockPos pos, FluidState state, Random rand)
	{
		if (!state.isSource() && !state.getValue(FALLING))
		{
			if (rand.nextInt(64) == 0)
			{
				level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() + 0.5F, false);
			}
		} else if (rand.nextInt(10) == 0)
		{
			level.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + rand.nextDouble(), (double) pos.getY() + rand.nextDouble(), (double) pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}

	@Nullable
	public ParticleOptions getDripParticle()
	{
		return ParticleTypes.DRIPPING_WATER;
	}

	protected boolean canConvertToSource()
	{
		return true;
	}

	protected void beforeDestroyingBlock(LevelAccessor p_76450_, BlockPos p_76451_, BlockState p_76452_)
	{
		BlockEntity blockentity = p_76452_.hasBlockEntity() ? p_76450_.getBlockEntity(p_76451_) : null;
		Block.dropResources(p_76452_, p_76450_, p_76451_, blockentity);
	}

	public int getSlopeFindDistance(LevelReader p_76464_)
	{
		return 4;
	}

	public BlockState createLegacyBlock(FluidState p_76466_)
	{
		return BlockRegistry.ANCIENT_WATER.get().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_76466_)));
	}

	public boolean isSame(Fluid fluidIn)
	{
		return fluidIn == FluidRegistry.ANCIENT_WATER.get() || fluidIn == FluidRegistry.FLOWING_ANCIENT_WATER.get();
	}

	public int getDropOff(LevelReader reader)
	{
		return 1;
	}

	public int getTickDelay(LevelReader reader)
	{
		return 5;
	}

	public boolean canBeReplacedWith(FluidState p_76458_, BlockGetter p_76459_, BlockPos p_76460_, Fluid p_76461_, Direction p_76462_)
	{
		return p_76462_ == Direction.DOWN && !p_76461_.is(FluidTags.WATER);
	}

	protected float getExplosionResistance()
	{
		return 50.0F;
	}

	public Optional<SoundEvent> getPickupSound()
	{
		return Optional.of(SoundEvents.BUCKET_FILL);
	}

	public static class Flowing extends AncientWaterFluid
	{
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> stateDefinition)
		{
			super.createFluidStateDefinition(stateDefinition);
			stateDefinition.add(LEVEL);
		}

		public int getAmount(FluidState state)
		{
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state)
		{
			return false;
		}
	}

	public static class Source extends AncientWaterFluid
	{
		public int getAmount(FluidState p_76485_)
		{
			return 8;
		}

		public boolean isSource(FluidState p_76483_)
		{
			return true;
		}
	}
}
