package extrabiomes.autumn.stuff;

import com.google.common.base.Optional;

import extrabiomes.autumn.blocks.BlockAutumnLeaves;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public enum Element {
	LEAVES_AUTUMN_UMBER,
	LEAVES_AUTUMN_GOLENROD,
	LEAVES_AUTUMN_VERMILLION,
	LEAVES_AUTUMN_CITRINE,
	SAPLING_AUTUMN_UMBER,
	SAPLING_AUTUMN_GOLDENROD,
	SAPLING_AUTUMN_VERMILLION,
	SAPLING_AUTUMN_CITRINE,
	LOG_AUTUMN, PLANK_AUTUMN;
	
	private Optional<ItemStack> itemStack = Optional.absent();
	
	public ItemStack get() {
		return itemStack.get();
	}
	public boolean isPresent() {
		return itemStack.isPresent();
	}
	
	public void set(ItemStack stack) {
		this.itemStack = Optional.of(stack);
	}
	public void set(Block block, int metadata) {
		this.set(new ItemStack(block, 1, metadata));
	}
	public void set(Block block) {
		this.set(new ItemStack(block, 1));
	}
}
