package net.mcreator.fuinha.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.fuinha.block.RoughConcreteBlock;
import net.mcreator.fuinha.FuinhaMod;

import java.util.Map;

public class BlackSmoothConcreteBlockDestroyedByExplosionProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FuinhaMod.LOGGER.warn("Failed to load dependency world for procedure BlackSmoothConcreteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FuinhaMod.LOGGER.warn("Failed to load dependency x for procedure BlackSmoothConcreteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FuinhaMod.LOGGER.warn("Failed to load dependency y for procedure BlackSmoothConcreteBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FuinhaMod.LOGGER.warn("Failed to load dependency z for procedure BlackSmoothConcreteBlockDestroyedByExplosion!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		world.setBlockState(new BlockPos(x, y, z), RoughConcreteBlock.block.getDefaultState(), 3);
	}
}
