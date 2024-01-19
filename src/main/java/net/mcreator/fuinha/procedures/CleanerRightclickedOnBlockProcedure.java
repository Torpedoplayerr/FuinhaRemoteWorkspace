package net.mcreator.fuinha.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fuinha.block.PathwayCobblestoneBlock;
import net.mcreator.fuinha.block.MossyCobblestonePathwayStairsBlock;
import net.mcreator.fuinha.block.MossyCobblestonePathwaySlabBlock;
import net.mcreator.fuinha.block.MossyCobblestonePathwayBlock;
import net.mcreator.fuinha.block.CobblestonePathwayStairsBlock;
import net.mcreator.fuinha.block.CobblestonePathwaySlabBlock;
import net.mcreator.fuinha.FuinhaMod;

import java.util.Random;
import java.util.Map;

public class CleanerRightclickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FuinhaMod.LOGGER.warn("Failed to load dependency world for procedure CleanerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FuinhaMod.LOGGER.warn("Failed to load dependency x for procedure CleanerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FuinhaMod.LOGGER.warn("Failed to load dependency y for procedure CleanerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FuinhaMod.LOGGER.warn("Failed to load dependency z for procedure CleanerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FuinhaMod.LOGGER.warn("Failed to load dependency itemstack for procedure CleanerRightclickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (MossyCobblestonePathwayBlock.block == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = PathwayCobblestoneBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId((world.getBlockState(new BlockPos(x, y, z)))));
			for (int index0 = 0; index0 < (int) (5); index0++) {
				world.addParticle(ParticleTypes.SPLASH, x, (y + 1), z, 0, 1, 0);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5, false);
			}
		} else if (MossyCobblestonePathwaySlabBlock.block == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = CobblestonePathwaySlabBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId((world.getBlockState(new BlockPos(x, y, z)))));
			for (int index1 = 0; index1 < (int) (5); index1++) {
				world.addParticle(ParticleTypes.SPLASH, x, (y + 0.5), z, 0, 1, 0);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5, false);
			}
		} else if (MossyCobblestonePathwayStairsBlock.block == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = CobblestonePathwayStairsBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId((world.getBlockState(new BlockPos(x, y, z)))));
			for (int index2 = 0; index2 < (int) (5); index2++) {
				world.addParticle(ParticleTypes.SPLASH, x, (y + 1), z, 0, 1, 0);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")),
						SoundCategory.BLOCKS, (float) 1, (float) 0.5, false);
			}
		}
	}
}
