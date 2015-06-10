package extrabiomes.autumn.blocks;

import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.autumn.Version;
import extrabiomes.autumn.blocks.BlockAutumnFlower.BlockType;
import extrabiomes.lib.blocks.IExtraBlock;
import extrabiomes.lib.settings.BlockSettings;

public class BlockAutumnWood extends BlockWood implements IExtraBlock {
    private BlockSettings settings;
    private IIcon[] textures = { null };
    
    public BlockAutumnWood(BlockSettings settings)
    {
        super();
        this.settings = settings;
        this.setBlockName(Version.LOC_PREFIX+".planks");
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("axe", 0);
        // TODO: custom tab
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        textures[0] = iconRegister.registerIcon(Version.TEXTURE_PATH + "planksautumn");
    }
    
    @Override
    public IIcon getIcon(int side, int metadata)
    {
    	if( metadata < 0 || metadata >= textures.length )
    		metadata = 0;
        return textures[metadata];
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List list)
    {
    	for( int meta = 0; meta < textures.length; ++meta ) {
    		list.add(new ItemStack(item, 1, meta));
    	}
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
	public String getUnlocalizedName(int metadata) {
		return this.getUnlocalizedName() + ".autumn";
	}
}
