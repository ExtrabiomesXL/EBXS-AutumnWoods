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
import extrabiomes.lib.IExtraBlock;

public class BlockExtraFlower extends BlockFlower implements IExtraBlock {

	public enum BlockType {
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
		
		@SideOnly(Side.CLIENT)
		public IIcon registerIcon(IIconRegister iconRegister) {
			icon = iconRegister.registerIcon(Version.TEXTURE_PATH + this.texture);
			return icon;
		}
		
		public static BlockType getBlockType(int metadata) {
			if( metadata < 0 || metadata > BlockType.values().length )
				return null;
			return BlockType.values()[metadata];
		}
	}
	
	// NB: may need to switch to a generic block manually implementing IPlantable
	public BlockExtraFlower() {
		super(0);
		setBlockName(Version.LOC_PREFIX+".flower");
		setTickRandomly(true);
		setHardness(0.0f);
		setStepSound(Block.soundTypeGrass);
		// TODO: add our own tab again
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List itemList) {
		for( final BlockType type : BlockType.values() ) {
			itemList.add(new ItemStack(this, 1, type.metadata));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		AutumnWoods.LOGGER.debug(this.getClass().getSimpleName() + ": registerIcons");
		for( BlockType type : BlockType.values() ) {
			final IIcon icon = type.registerIcon(iconRegister);
			if( icon == null ) {
				AutumnWoods.LOGGER.warn("No icon found for %s (%d)", type, type.metadata);
			} else {
				AutumnWoods.LOGGER.debug("%s: %s = %s", this.getClass().getSimpleName(), type, icon);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		final BlockType type = BlockType.getBlockType(metadata);
		if( type != null ) {
			return type.getIcon();
		} else {
			return null;
		}
	}

	public String getUnlocalizedName(int metadata) {
		if( metadata < 0 || metadata > BlockType.values().length )
			return null;
		final BlockType type = BlockType.values()[metadata];
		if( type != null ) {
			return this.getUnlocalizedName() + "." + type.name().toLowerCase(Locale.ENGLISH);
		} else {
			return "";
		}
	}
	
}
