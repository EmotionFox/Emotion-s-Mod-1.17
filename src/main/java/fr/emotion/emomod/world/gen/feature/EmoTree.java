package fr.emotion.emomod.world.gen.feature;

import java.util.Random;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class EmoTree extends AbstractTreeGrower
{
	private BlockState logBlock;
	private BlockState leavesBlock;

	public EmoTree(BlockState logBlock, BlockState leavesBlock)
	{
		this.logBlock = logBlock;
		this.leavesBlock = leavesBlock;
	}

	public EmoTree()
	{}

	@Override
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random p_60014_, boolean p_60015_)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random)
//	{
//		if (logBlock == null || leavesBlock == null)
//			return (AbstractTreeFeature<NoFeatureConfig>) (new EmoTreeFeature(NoFeatureConfig::deserialize, true));
//		return (AbstractTreeFeature<NoFeatureConfig>) (new EmoTreeFeature(NoFeatureConfig::deserialize, true, logBlock, leavesBlock));
//	}
}
