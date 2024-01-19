
package net.mcreator.fuinha.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fuinha.itemgroup.FuinhaItemGroup;
import net.mcreator.fuinha.FuinhaModElements;

@FuinhaModElements.ModElement.Tag
public class ConcreteCompoundItem extends FuinhaModElements.ModElement {
	@ObjectHolder("fuinha:concrete_compound")
	public static final Item block = null;

	public ConcreteCompoundItem(FuinhaModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(FuinhaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("concrete_compound");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
