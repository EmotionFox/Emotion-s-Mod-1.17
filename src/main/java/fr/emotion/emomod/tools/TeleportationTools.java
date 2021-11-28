package fr.emotion.emomod.tools;

import java.util.function.Function;

import javax.annotation.Nullable;

import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.LevelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.ITeleporter;

public class TeleportationTools
{
	public static void teleport(ServerPlayer entity, ServerLevel destination, BlockPos pos)
	{
		entity.changeDimension(destination, new ITeleporter()
		{
			@Override
			public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
			{
				BlockPos blockPos = pos.above(256 - pos.getY());

				if (destination.dimension() == LevelRegistry.DREAM)
				{
					blockPos = findSpawn(destWorld, entity.blockPosition());

					if (blockPos == null)
					{
						blockPos = new BlockPos((double) entity.blockPosition().getX(), 256.0D / 2.0D, (double) entity.blockPosition().getZ());

						createIsland(destWorld, blockPos);
					}
				} else if (destination.dimension() == LevelRegistry.NIGHTMARE)
				{

				}

				entity = repositionEntity.apply(false);
				entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
				return entity;
			}
		});
	}

	@Nullable
	public static BlockPos findSpawn(ServerLevel serverLevel, BlockPos pos)
	{
		for (int x = -10; x <= 10; x++)
		{
			for (int z = -10; z <= 10; z++)
			{
				for (int y = 255; y >= 0; y--)
				{
					if (serverLevel.getBlockState(new BlockPos(pos.getX() + x, y, pos.getZ() + z)).getBlock() != Blocks.AIR)
					{
						return new BlockPos((double) (pos.getX() + x) + 0.5D, (double) y + 3.0D, (double) (pos.getZ() + z) + 0.5D);
					}
				}
			}
		}
		return null;
	}

	public static void createIsland(ServerLevel serverLevel, BlockPos pos)
	{
		for (int x = -2; x <= 2; x++)
		{
			for (int z = -2; z <= 2; z++)
			{
				serverLevel.setBlockAndUpdate(pos.offset((double) x, -2.0D, (double) z), BlockRegistry.PLANKS_DREAM.get().defaultBlockState());
			}
		}
	}
}
