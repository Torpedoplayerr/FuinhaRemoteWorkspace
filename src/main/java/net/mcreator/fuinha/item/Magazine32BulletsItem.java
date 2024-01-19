
package net.mcreator.fuinha.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fuinha.FuinhaModElements;

@FuinhaModElements.ModElement.Tag
public class Magazine32BulletsItem extends FuinhaModElements.ModElement {
	@ObjectHolder("fuinha:magazine_32_bullets")
	public static final Item block = null;

	public Magazine32BulletsItem(FuinhaModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(4).rarity(Rarity.COMMON));
			setRegistryName("magazine_32_bullets");
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
