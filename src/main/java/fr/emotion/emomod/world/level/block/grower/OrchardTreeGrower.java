package fr.emotion.emomod.world.level.block.grower;

import java.util.Random;

import fr.emotion.emomod.init.FeatureRegistry;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class OrchardTreeGrower extends AbstractTreeGrower
{
	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random rand, boolean bee)
	{
		int choice = rand.nextInt(3);

		switch (choice)
		{
		case 0:
			return FeatureRegistry.CF_CHERRY_TREE;
		case 1:
			return FeatureRegistry.CF_ORANGE_TREE;
		default:
			return FeatureRegistry.CF_PEAR_TREE;
		}
	}
}
