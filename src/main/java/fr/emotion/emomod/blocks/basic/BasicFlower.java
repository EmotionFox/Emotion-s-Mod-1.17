package fr.emotion.emomod.blocks.basic;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BasicFlower extends FlowerBlock
{
	public BasicFlower(Properties properties)
	{
		super(MobEffects.SATURATION, 7, properties);
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
	{
		if (this == BlockRegistry.FLOWER_THORNY.get())
			entity.hurt(DamageSource.GENERIC, 1.0F);
	}
}
