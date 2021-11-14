package fr.emotion.emomod.world.gen.feature;

import java.util.Random;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoAtlasTree extends Tree
{
	private boolean natural;

	public EmoAtlasTree(boolean natural)
	{
		this.natural = natural;
	}

	@Override
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random)
	{
		return (AbstractTreeFeature<NoFeatureConfig>) (new EmoAtlasFeature(NoFeatureConfig::deserialize, true, natural));
	}
}
