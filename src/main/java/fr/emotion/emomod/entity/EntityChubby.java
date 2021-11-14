package fr.emotion.emomod.entity;

import java.util.EnumSet;

import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityChubby extends Monster
{
	public EntityChubby(EntityType<? extends Monster> type, Level worldIn)
	{
		super(type, worldIn);
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new JumpGoal(this));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.25D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_213811_1_) ->
		{
			return Math.abs(p_213811_1_.position().x - this.position().y) <= 4.0D;
		}));
	}

	static class JumpGoal extends Goal
	{
		private final EntityChubby chubby;

		public JumpGoal(EntityChubby chubby)
		{
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
			this.chubby = chubby;
		}

		@Override
		public void start()
		{
			chubby.setJumping(true);
			chubby.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3));
		}

		@Override
		public void stop()
		{
			chubby.removeEffect(MobEffects.INVISIBILITY);
		}

		@Override
		public boolean canUse()
		{
			if (!chubby.isInWater() && !chubby.isInLava() && chubby.onGround && chubby.random.nextInt(30) == 0)
				return true;
			else
				return false;
		}

		@Override
		public boolean canContinueToUse()
		{
			return chubby.getMotionDirection() == Direction.UP ? true : false;
		}
	}
}
