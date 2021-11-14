package fr.emotion.emomod.dimension;

import fr.emotion.emomod.init.BiomeRegistry;
import fr.emotion.emomod.world.level.levelgen.DreamChunkGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.EndGenerationSettings;
import net.minecraft.world.level.levelgen.carver.NetherWorldCarver;
import net.minecraft.world.level.levelgen.feature.EndCityFeature;
import net.minecraftforge.client.IRenderHandler;

public class DreamDimension extends Dimension
{
	public DreamDimension(World worldIn, DimensionType typeIn)
	{
		super(worldIn, typeIn);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator()
	{
		EndGenerationSettings endgenerationsettings = ChunkGeneratorType.FLOATING_ISLANDS.createSettings();
		endgenerationsettings.setDefaultBlock(Blocks.STONE.getDefaultState());
		endgenerationsettings.setDefaultFluid(Blocks.AIR.getDefaultState());
		return new DreamChunkGenerator(world, new SingleBiomeProvider(new SingleBiomeProviderSettings().setBiome(BiomeRegistry.BIOME_DREAM)), endgenerationsettings);
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
		return 300;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos)
	{
		return SleepResult.ALLOW;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
	{
		return 0;
	}

	@Override
	public int getMoonPhase(long worldTime)
	{
		return 1;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks)
	{
		return new Vec3d(255.0D, 255.0D, 255.0D);
	}

	@Override
	public boolean canRespawnHere()
	{
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z)
	{
		return false;
	}

	@Override
	public double getVoidFogYFactor()
	{
		return 0.01D;
	}

	@Override
	public Vec3d getSkyColor(BlockPos cameraPos, float partialTicks)
	{
		return new Vec3d(255.0D, 255.0D, 255.0D);
	}

	@Override
	public IRenderHandler getSkyRenderer()
	{
		return new DreamSkyRenderer();
	}
}
