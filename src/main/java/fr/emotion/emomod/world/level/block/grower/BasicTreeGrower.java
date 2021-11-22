package fr.emotion.emomod.world.level.block.grower;

import java.util.Random;

import fr.emotion.emomod.init.FeatureRegistry;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class BasicTreeGrower extends AbstractTreeGrower
{
	protected ConfiguredFeature<TreeConfiguration, ?> feature;

	public BasicTreeGrower(ConfiguredFeature<TreeConfiguration, ?> feature)
	{
		this.feature = feature;
	}

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random rand, boolean bee)
	{
		if (feature == null)
			return FeatureRegistry.CF_CHERRY_TREE; // Why Not
		else
			return this.feature;
	}
}
