package fr.emotion.emomod.blocks.basic;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class BasicFlowingFluidBlock extends LiquidBlock
{
	public BasicFlowingFluidBlock(Supplier<? extends FlowingFluid> supplier, BlockBehaviour.Properties properties)
	{
		super(supplier, properties);
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
	{
		super.stepOn(level, pos, state, entity);

		entity.lerpMotion(entity.getMotionDirection().getStepX() / 3, entity.getMotionDirection().getStepY() / 3, entity.getMotionDirection().getStepZ() / 3);
		entity.lerpTo(0d, 10d, 0d, entity.getRotationVector().x, entity.getRotationVector().y, 0, false);

		if (entity instanceof Mob)
			entity.hurt(DamageSource.MAGIC, 1.0f);
	}
}
