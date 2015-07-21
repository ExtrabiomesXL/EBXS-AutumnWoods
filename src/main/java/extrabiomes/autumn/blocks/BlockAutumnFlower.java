package extrabiomes.autumn.blocks;

import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.autumn.AutumnWoods;
import extrabiomes.autumn.Version;
import extrabiomes.lib.blocks.BlockExtraFlower;
import extrabiomes.lib.blocks.IBlockTypeFlower;
import extrabiomes.lib.blocks.IExtraBlock;

public class BlockAutumnFlower extends BlockExtraFlower {

	public enum BlockType implements IBlockTypeFlower {
		AUTUMN_SHRUB(0, 3, "autumnshrub", 13),
		RED_ROVER(1, 3, "redrover", 1),
		DELPHINIUM_BELLADONNA(2, 3, "belladonna", 4);
		
		public final int	metadata;
		public final int	weight;
		public final int	color;
		
		public final String	texture;
		
		private BlockType(int metadata, int weight, String texture, int color) {
			this.metadata = metadata;
			this.weight = weight;
			this.texture = texture;
			this.color = color;
		}
		
		private IIcon icon;
		public IIcon getIcon() {
			return icon;
		}
		public void setIcon(IIcon icon) {
			this.icon = icon;
		}

		@Override
		public int getMeta() {
			return metadata;
		}

		@Override
		public int getWeight() {
			return weight;
		}

		@Override
		public int getColor() {
			return color;
		}
		
		@Override
		public String getTexture() {
			return texture;
		}
	}
	
	public BlockAutumnFlower() {
		super(AutumnWoods.instance, Version.LOC_PREFIX, BlockType.values());
	}	
}
