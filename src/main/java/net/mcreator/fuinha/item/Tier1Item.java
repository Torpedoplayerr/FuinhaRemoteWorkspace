
package net.mcreator.fuinha.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fuinha.itemgroup.FuinhaItemGroup;
import net.mcreator.fuinha.FuinhaModElements;

@FuinhaModElements.ModElement.Tag
public class Tier1Item extends FuinhaModElements.ModElement {
	@ObjectHolder("fuinha:tier_1")
	public static final Item block = null;

	public Tier1Item(FuinhaModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(FuinhaItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON));
			setRegistryName("tier_1");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
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
