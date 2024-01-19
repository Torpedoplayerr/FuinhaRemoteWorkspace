package net.mcreator.fuinha.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fuinha.FuinhaMod;

import java.util.Random;
import java.util.Map;

public class ARightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FuinhaMod.LOGGER.warn("Failed to load dependency entity for procedure ARightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.rotationYaw = (float) ((entity.rotationYaw + MathHelper.nextDouble(new Random(), -3, 3)));
		entity.setRenderYawOffset(entity.rotationYaw);
		entity.prevRotationYaw = entity.rotationYaw;
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
			((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
			((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
		}
		entity.rotationPitch = (float) ((entity.rotationPitch - MathHelper.nextDouble(new Random(), 2, 5)));
	}
}
