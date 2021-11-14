package fr.emotion.emomod.entity;

import java.util.List;

import fr.emotion.emomod.init.EntityTypeRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import fr.emotion.emomod.items.EmoSpellBook;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class OrbSpellEntity extends ThrowableItemProjectile
{
	private EmoSpellBook.SpellList spell;
	private Entity thrower;
	private static final int maxLifeTicks = 20 * 3;
	private int lifeTicks = 0;

	public OrbSpellEntity(EmoSpellBook.SpellList spell, Level level)
	{
		super(EntityTypeRegistry.ORB.get(), level);
		this.spell = spell;
		this.setNoGravity(true);
	}

	@Override
	public void setOwner(Entity entity)
	{
		if (entity != null)
			this.thrower = entity;
	}

	public OrbSpellEntity(FMLPlayMessages.SpawnEntity packet, Level level)
	{
		super(EntityTypeRegistry.ORB.get(), level);
	}

	@Override
	protected Item getDefaultItem()
	{
		return ItemRegistry.SPELL_ORB.get();
	}

	@Override
	public Packet<?> getAddEntityPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void tick()
	{
		super.tick();

		if (this.isAlive())
		{
			if (this.lifeTicks >= maxLifeTicks)
				this.isRemoved();

			this.lifeTicks++;
		}

		if (this.spell != null)
		{
			FluidState fluidState = this.level.getFluidState(this.blockPosition());

			if (this.spell.getName() == "water")
			{
				if (fluidState.is(FluidTags.LAVA))
				{
					this.level.setBlockAndUpdate(this.blockPosition(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(this.level, this.blockPosition(), this.blockPosition(), Blocks.AIR.defaultBlockState()));
					this.level.levelEvent(1501, this.blockPosition(), 0);
					this.findLava(this.blockPosition(), this.blockPosition());
				}
			} else if (this.spell.getName() == "fire")
			{
				if (fluidState.is(FluidTags.WATER))
				{
					this.level.setBlockAndUpdate(this.blockPosition(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(this.level, this.blockPosition(), this.blockPosition(), Blocks.AIR.defaultBlockState()));
					this.level.levelEvent(1501, this.blockPosition(), 0);
				}
			}
		}
	}

	@Override
	protected void onHit(HitResult result)
	{
		if (this.spell == null)
			return;

		Entity entity = result.getType() == HitResult.Type.ENTITY ? ((EntityHitResult) result).getEntity() : null;
		ServerPlayer player = (ServerPlayer) this.thrower;
		BlockState state = result.getType() == HitResult.Type.BLOCK ? player.level.getBlockState(((BlockHitResult) result).getBlockPos()) : null;

		switch (this.spell.getName())
		{
		default:
		case "earth":
			if (entity != null)
			{
				this.earthEffect(entity, player);
			} else if (state != null)
			{
				BlockPos pos = ((BlockHitResult) result).getBlockPos();
				this.earthEffect(state, pos, player);
			}
			break;
		case "water":
			if (entity != null)
			{
				this.waterEffect(entity, player);
			} else if (state != null)
			{
				BlockPos pos = ((BlockHitResult) result).getBlockPos();
				this.waterEffect(state, pos, player);
			}
			break;
		case "wind":
			if (entity != null)
			{
				this.windEffect(entity, player);
			} else if (state != null)
			{
				BlockPos pos = ((BlockHitResult) result).getBlockPos();
				this.windEffect(state, pos, player);
			}
			break;
		case "fire":
			if (entity != null)
			{
				this.fireEffect(entity, player);
			} else if (state != null)
			{
				BlockPos pos = ((BlockHitResult) result).getBlockPos();
				this.fireEffect(state, pos, player);
			}
			break;
		}

		this.remove(RemovalReason.KILLED);
	}

	public void earthEffect(Entity entity, ServerPlayer player)
	{
		List<Player> list = player.getLevel().getEntitiesOfClass(Player.class, new AABB(entity.getX() - 10D, entity.getY() - 10D, entity.getZ() - 10D, entity.getX() + 10D, entity.getY() + 10D, entity.getZ() + 10D));

		for (Player target : list)
		{
			EntityDimensions size = target.getDimensions(Pose.STANDING);
			float x = -Mth.sin(player.getYHeadRot() * ((float) Math.PI / 180F)) * Mth.cos(player.rotA * ((float) Math.PI / 180F));
			float z = Mth.cos(player.getYHeadRot() * ((float) Math.PI / 180F)) * Mth.cos(player.rotA * ((float) Math.PI / 180F));
			Vec3 vec3 = (new Vec3(x, 0, z)).normalize().add(x * (1.5d / (double) size.height), 0.25d / (double) size.width, z * (1.5d / (double) size.height));

			target.lerpMotion(vec3.x(), vec3.y(), vec3.z());
		}
	}

	public void earthEffect(BlockState block, BlockPos pos, ServerPlayer player)
	{
		for (int x = -10; x < 10; x++)
		{
			for (int z = -10; z < 10; z++)
			{
				int y = this.findTopGrowable(pos.offset(x, 0, z), player.getLevel());
				BlockPos target = new BlockPos(pos.getX() + x, y, pos.getZ() + z);
				BlockState state = player.getLevel().getBlockState(target);

				if (y != 666)
				{
					if (state != Blocks.GRASS_BLOCK.defaultBlockState() || player.getLevel().getRandom().nextInt(13) == 0)
						((BonemealableBlock) state.getBlock()).performBonemeal(player.getLevel(), player.getLevel().getRandom(), target, state);
				}
			}
		}
	}

	public void waterEffect(Entity entity, ServerPlayer player)
	{
	}

	public void waterEffect(BlockState block, BlockPos pos, ServerPlayer player)
	{
		player.getLevel().setWeatherParameters(0, 20 * 5, true, false);

	}

	public void windEffect(Entity entity, ServerPlayer player)
	{
		List<Player> list = player.getLevel().getEntitiesOfClass(Player.class, new AABB(entity.getX() - 10D, entity.getY() - 10D, entity.getZ() - 10D, entity.getX() + 10D, entity.getY() + 10D, entity.getZ() + 10D));

		for (Player target : list)
		{
			target.lerpMotion(0d, 2.0d, 0d);
		}
	}

	public void windEffect(BlockState block, BlockPos pos, ServerPlayer player)
	{
	}

	public void fireEffect(Entity entity, ServerPlayer player)
	{
		List<Player> list = player.getLevel().getEntitiesOfClass(Player.class, new AABB(entity.getX() - 10D, entity.getY() - 10D, entity.getZ() - 10D, entity.getX() + 10D, entity.getY() + 10D, entity.getZ() + 10D));

		for (Player target : list)
		{
			target.setSecondsOnFire(5);
		}
	}

	public void fireEffect(BlockState block, BlockPos pos, ServerPlayer player)
	{
	}

	public int findTopGrowable(BlockPos pos, Level level)
	{
		for (int y = -10; y <= 10; y++)
		{
			if (level.getBlockState(pos.offset(0, y, 0)).getBlock() instanceof BonemealableBlock)
			{
				return pos.getY() + y;
			}
		}

		// EL DIABLO AGAIN OMFG
		return 666;
	}

	public int findTop(BlockPos pos, Level level, BlockState... target)
	{
		for (int y = -10; y <= 10; y++)
		{
			for (BlockState state : target)
			{
				if (level.getBlockState(pos.offset(0, y, 0)) == state)
				{
					return pos.getY() + y;
				}
			}
		}

		// SATANIST SPOTTED
		return 666;
	}

	public void findLava(BlockPos pos, BlockPos previous)
	{
		for (Direction dir : Direction.values())
		{
			FluidState fluidState = this.level.getFluidState(pos.relative(dir));

			// HIGH OPTIMISATION SHIT HERE
			if (pos.relative(dir) == previous)
				break;

			if (fluidState.is(FluidTags.LAVA))
			{
				this.level.setBlockAndUpdate(pos.relative(dir), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(this.level, pos.relative(dir), pos.relative(dir), Blocks.AIR.defaultBlockState()));
				this.level.levelEvent(1501, pos.relative(dir), 0);
				this.findLava(pos.relative(dir), pos);
			}
		}
	}
}
