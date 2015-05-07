package extrabiomes.autumn.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockExtraFlower extends BlockFlower {

	public enum BlockType {
		FLOWER_ONE(0, 3),
		FLOWER_TWO(1, 6);
		
		public final int	metadata;
		public final int	weight;		
		
		private BlockType(int metadata, int weight) {
			this.metadata = metadata;
			this.weight = weight;
		}
	}
	
	// NB: may need to switch to a generic block manually implementing IPlantable
	public BlockExtraFlower() {
		super(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List itemList) {
		for( final BlockType type : BlockType.values() ) {
			itemList.add(new ItemStack(this, 1, type.metadata));
		}
	}

	// TODO: addInformation
	// TODO: getUnlocalizedName
	
}
