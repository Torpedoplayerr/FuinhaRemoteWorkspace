
package net.mcreator.fuinha.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fuinha.procedures.OrangeSmoothConcreteBlockDestroyedByExplosionProcedure;
import net.mcreator.fuinha.itemgroup.FuinhaBlocksItemGroup;
import net.mcreator.fuinha.FuinhaModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@FuinhaModElements.ModElement.Tag
public class OrangeSmoothConcreteBlock extends FuinhaModElements.ModElement {
	@ObjectHolder("fuinha:orange_smooth_concrete")
	public static final Block block = null;

	public OrangeSmoothConcreteBlock(FuinhaModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(FuinhaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0)
					.slipperiness(0.5f));
			setRegistryName("orange_smooth_concrete");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
			super.onExplosionDestroy(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			OrangeSmoothConcreteBlockDestroyedByExplosionProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
