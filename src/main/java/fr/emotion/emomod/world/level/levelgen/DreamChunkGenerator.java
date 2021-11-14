package fr.emotion.emomod.world.level.levelgen;

import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;

public final class DreamChunkGenerator extends NoiseBasedChuckGenerator
{
	public DreamChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, EndGenerationSettings settingsIn)
	{
		super(worldIn, biomeProviderIn, 16, 8, 256, settingsIn, true);
	}
	
	@Override
	protected double[] func_222549_a(int noiseX, int noiseZ)
	{
		return new double[]
		{ (double) this.biomeProvider.func_222365_c(noiseX, noiseZ), 0.0D };
	}

	@Override
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_)
	{
		return 8.0D - p_222545_1_;
	}
	
	@Override
	protected void func_222548_a(double[] noiseColumn, int noiseX, int noiseZ)
	{
		this.func_222546_a(noiseColumn, noiseX, noiseZ, 1368.824D, 684.412D, 17.110300000000002D, 4.277575000000001D, 500, -3000);
	}

	protected double func_222551_g()
	{
		return (double) ((int) super.func_222551_g() / 2);
	}

	protected double func_222553_h()
	{
		return 8.0D;
	}

	@Override
	public int getGroundHeight()
	{
		return 200;
	}

	@Override
	public int getSeaLevel()
	{
		return 0;
	}
}
