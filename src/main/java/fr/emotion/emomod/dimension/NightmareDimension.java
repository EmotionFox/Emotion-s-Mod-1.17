package fr.emotion.emomod.dimension;

import fr.emotion.emomod.init.BiomeRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.NetherGenSettings;

public class NightmareDimension extends Dimension
{
	public NightmareDimension(World worldIn, DimensionType typeIn)
	{
		super(worldIn, typeIn);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator()
	{
		NetherGenSettings netherSettings = ChunkGeneratorType.CAVES.createSettings();
		netherSettings.setDefaultBlock(Blocks.STONE.getDefaultState());
		netherSettings.setDefaultFluid(Blocks.WATER.getDefaultState());
		SingleBiomeProviderSettings singleSettings = BiomeProviderType.FIXED.createSettings().setBiome(BiomeRegistry.BIOME_NIGHTMARE);
		BiomeProvider biomeProvider = BiomeProviderType.FIXED.create(singleSettings);
		return ChunkGeneratorType.CAVES.create(this.world, biomeProvider, netherSettings);
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid)
	{
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid)
	{
		return null;
	}

	@Override
	public int getActualHeight()
	{
		return 256;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos)
	{
		return SleepResult.DENY;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
	{
		return 0;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks)
	{
		return new Vec3d(0.0d, 0.0d, 0.0d);
	}

	@Override
	public double getVoidFogYFactor()
	{
		return 1.0d;
	}

	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z)
	{
		return true;
	}

}
