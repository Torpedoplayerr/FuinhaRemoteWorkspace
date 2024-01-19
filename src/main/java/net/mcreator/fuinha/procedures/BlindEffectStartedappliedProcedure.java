package net.mcreator.fuinha.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fuinha.FuinhaMod;

import java.util.Map;

public class BlindEffectStartedappliedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FuinhaMod.LOGGER.warn("Failed to load dependency entity for procedure BlindEffectStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("blind", (true));
	}
}
