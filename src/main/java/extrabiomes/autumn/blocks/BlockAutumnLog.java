package extrabiomes.autumn.blocks;

import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
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
import extrabiomes.autumn.blocks.BlockExtraFlower.BlockType;
import extrabiomes.lib.blocks.IExtraBlock;
import extrabiomes.lib.settings.BlockSettings;

public class BlockAutumnLog extends BlockLog implements IExtraBlock {
    private BlockSettings settings;
    private IIcon[] textures = { null, null };
    
    public BlockAutumnLog(BlockSettings settings)
    {
        super();
        this.settings = settings;
        this.setBlockName(Version.LOC_PREFIX+".log");
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(2.0F);
        this.setResistance(Blocks.log.getExplosionResistance(null) * 5.0F);
        this.setHarvestLevel("axe", 0);
        // TODO: custom tab
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        textures[0] = iconRegister.registerIcon(Version.TEXTURE_PATH + "logautumnside");
        textures[1] = iconRegister.registerIcon(Version.TEXTURE_PATH + "logautumntop");
    }
    
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        final int orientation = metadata & 12;
        int type = metadata & 3;
        if (type > 3)
            type = 0;
        if (orientation == 0 && (side == 1 || side == 0) || orientation == 4 && (side == 5 || side == 4) || orientation == 8 && (side == 2 || side == 3))
        {
            //return texturesMap.get(index + 16 + type);
            return textures[(type * 2) + 1];
        }
        
        return textures[type * 2];
        //return texturesMap.get(index + type);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List list)
    {
        list.add(new ItemStack(item, 1));
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
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
