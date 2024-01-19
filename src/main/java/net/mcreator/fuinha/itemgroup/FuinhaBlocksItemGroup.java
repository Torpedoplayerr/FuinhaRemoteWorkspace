
package net.mcreator.fuinha.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.fuinha.block.RoughConcreteBlock;
import net.mcreator.fuinha.FuinhaModElements;

@FuinhaModElements.ModElement.Tag
public class FuinhaBlocksItemGroup extends FuinhaModElements.ModElement {
	public FuinhaBlocksItemGroup(FuinhaModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabfuinha_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RoughConcreteBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
