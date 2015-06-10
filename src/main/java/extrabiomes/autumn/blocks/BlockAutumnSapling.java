package extrabiomes.autumn.blocks;

import java.util.Locale;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.autumn.Version;
import extrabiomes.autumn.blocks.BlockAutumnFlower.BlockType;
import extrabiomes.autumn.items.SaplingType;
import extrabiomes.autumn.worldgen.Generators;
import extrabiomes.lib.blocks.BlockExtraSapling;
import extrabiomes.lib.items.IExtraItemType;

public class BlockAutumnSapling extends BlockExtraSapling {
	public BlockAutumnSapling() {
		super(SaplingType.values());
		setBlockName(Version.LOC_PREFIX + ".sapling");
		
		registerGenerator(SaplingType.UMBER.metadata(), Generators.AUTUMN_TREE_UMBER.treeGen());
		registerGenerator(SaplingType.GOLDENROD.metadata(), Generators.AUTUMN_TREE_GOLDENROD.treeGen());
		registerGenerator(SaplingType.VERMILLION.metadata(), Generators.AUTUMN_TREE_VERMILLION.treeGen());
		registerGenerator(SaplingType.CITRINE.metadata(), Generators.AUTUMN_TREE_CITRINE.treeGen());
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
