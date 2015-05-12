package extrabiomes.autumn.items;

import java.util.Locale;

import extrabiomes.autumn.blocks.BlockAutumnLeaves;
import extrabiomes.lib.ExtraItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemExtraLeaves extends ExtraItem {

	private static final int	METADATA_BITMASK		= 0x3;
	private static final int	METADATA_USERPLACEDBIT	= 0x4;

	public ItemExtraLeaves(final Block block) {
		super(block);
	}
	
	protected static int unmarkedMetadata(int metadata) {
		return metadata & METADATA_BITMASK;
	}
	private static int setUserPlacedOnMetadata(final int metadata) {
		return metadata | METADATA_USERPLACEDBIT;
	}
	@Override
	public int getMetadata(final int metadata) {
		return setUserPlacedOnMetadata(metadata);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int metadata = unmarkedMetadata(itemstack.getItemDamage());
		if (metadata > METADATA_BITMASK) metadata = METADATA_BITMASK;
		itemstack = itemstack.copy();
		itemstack.setItemDamage(metadata);
		return super.getUnlocalizedName() + "."	
			+ BlockAutumnLeaves.BlockType.values()[metadata].toString().toLowerCase(Locale.ENGLISH);
	}
}
