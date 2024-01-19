package net.mcreator.fuinha.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.Minecraft;

import net.mcreator.fuinha.FuinhaMod;

import java.util.Map;
import java.util.HashMap;

public class AimSystemProcedure {
	@Mod.EventBusSubscriber(value = {Dist.CLIENT})
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void computeFOV(EntityViewRenderEvent.FOVModifier event) {
			try {
				ClientWorld clientWorld = Minecraft.getInstance().world;
				Entity entity = event.getInfo().getRenderViewEntity();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("dimension", clientWorld.getDimensionKey());
				dependencies.put("entity", entity);
				dependencies.put("fov", event.getFOV());
				dependencies.put("x", entity.getPosX());
				dependencies.put("y", entity.getPosY());
				dependencies.put("z", entity.getPosZ());
				dependencies.put("viewport", event);
				dependencies.put("world", clientWorld);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			} catch (Exception e) {
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FuinhaMod.LOGGER.warn("Failed to load dependency world for procedure AimSystem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FuinhaMod.LOGGER.warn("Failed to load dependency entity for procedure AimSystem!");
			return;
		}
		if (dependencies.get("viewport") == null) {
			if (!dependencies.containsKey("viewport"))
				FuinhaMod.LOGGER.warn("Failed to load dependency viewport for procedure AimSystem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		EntityViewRenderEvent viewport = (EntityViewRenderEvent) dependencies.get("viewport");
		double fov = 0;
		fov = ((EntityViewRenderEvent.FOVModifier) viewport).getFOV();
		if (Screen.hasAltDown() && (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:firearm"))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
				|| ItemTags.getCollection().getTagByID(new ResourceLocation("forge:firearm"))
						.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()))) {
			if (viewport instanceof EntityViewRenderEvent.FOVModifier) {
				((EntityViewRenderEvent.FOVModifier) viewport).setFOV(30);
			}
			if (world.isRemote()) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fuinha:textures/items/icons.png"));
				Minecraft.getInstance().getTextureManager().loadTexture(new ResourceLocation("minecraft:textures/gui/icons.png"),
						Minecraft.getInstance().getTextureManager().getTexture(new ResourceLocation("fuinha:textures/items/icons.png")));
			}
		} else {
			if (viewport instanceof EntityViewRenderEvent.FOVModifier) {
				((EntityViewRenderEvent.FOVModifier) viewport).setFOV(fov);
			}
			if (world.isRemote()) {
				Minecraft.getInstance().getTextureManager().deleteTexture(new ResourceLocation("minecraft:textures/gui/icons.png"));
			}
		}
	}
}
