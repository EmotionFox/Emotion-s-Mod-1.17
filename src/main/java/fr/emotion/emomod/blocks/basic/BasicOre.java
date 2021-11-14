package fr.emotion.emomod.blocks.basic;

import java.util.Random;

import fr.emotion.emomod.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasicOre extends OreBlock
{
	public BasicOre(BlockBehaviour.Properties properties, UniformInt exp)
	{
		super(properties, exp);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
	{
		if (this == BlockRegistry.LUME_ORE.get())
			return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
		else
			return Shapes.block();
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player)
	{
		if (this == BlockRegistry.VIRIDIS_ORE.get())
			player.level.setBlock(pos, BlockRegistry.VIRIDIS_CRISTAL.get().defaultBlockState(), 2);
		return super.canHarvestBlock(state, world, pos, player);
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
	{
		if (entity instanceof Player && this == BlockRegistry.LUME_ORE.get())
		{
			Player player = (Player) entity;

			if (!player.isOnFire())
				player.setSecondsOnFire(5);
		}
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, Random rand)
	{
		double d0 = (double) pos.getX();
		double d1 = (double) pos.getY();
		double d2 = (double) pos.getZ();

		if (this == BlockRegistry.LUME_ORE.get() || this == BlockRegistry.DREAM_LUME_ORE.get())
		{
			level.addParticle(ParticleTypes.SMOKE, d0 + rand.nextDouble(), d1 + 1.0D, d2 + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
			level.addParticle(ParticleTypes.FLAME, d0 + rand.nextDouble(), d1 + 1.0D, d2 + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}
}
