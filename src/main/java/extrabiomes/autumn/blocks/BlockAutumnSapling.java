package extrabiomes.autumn.blocks;

import java.util.Locale;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.autumn.Version;
import extrabiomes.autumn.blocks.BlockExtraFlower.BlockType;
import extrabiomes.autumn.items.SaplingType;
import extrabiomes.lib.blocks.BlockExtraSapling;
import extrabiomes.lib.items.IExtraItemType;

public class BlockAutumnSapling extends BlockExtraSapling {
	public BlockAutumnSapling() {
		super(SaplingType.values());
		setBlockName(Version.LOC_PREFIX + ".sapling");
		for( int k = 0; k < generators.length; ++k ) {
			registerGenerator(k, null);	// TODO: use correct tree generator
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister IIconRegistry) {
		textures[0] = IIconRegistry.registerIcon(Version.TEXTURE_PATH + "saplingbrownautumn");
		textures[1] = IIconRegistry.registerIcon(Version.TEXTURE_PATH + "saplingorangeautumn");
		textures[2] = IIconRegistry.registerIcon(Version.TEXTURE_PATH + "saplingredautumn");
		textures[3] = IIconRegistry.registerIcon(Version.TEXTURE_PATH + "saplingyellowautumn");
	}
}
