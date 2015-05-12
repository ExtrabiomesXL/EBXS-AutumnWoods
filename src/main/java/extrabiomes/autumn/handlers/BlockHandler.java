package extrabiomes.autumn.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockAutumnLeaves;
import extrabiomes.autumn.blocks.BlockAutumnSapling;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.items.ItemExtraLeaves;
import extrabiomes.autumn.items.SaplingType;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.autumn.stuff.Element;
import extrabiomes.lib.items.ExtraItem;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;
import extrabiomes.lib.worldgen.ExtraWorldGenerator;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;
import extrabiomes.lib.worldgen.WorldGenDecoration;

public abstract class BlockHandler {

	public static void init() {
		createAutumnLeaves();
		createFlowers();
		createSaplings();
		/// createLogs();
	}

	public static void createAutumnLeaves() {
		final BlockSettings settings = BlockCollection.AUTUMN_TREE.settings;
		if( !settings.isEnabled() ) return;
		
		final BlockAutumnLeaves block = new BlockAutumnLeaves();
		GameRegistry.registerBlock(block, ItemExtraLeaves.class, "leaves");
		OreDictionary.registerOre("treeLeaves", new ItemStack(block, 1, Short.MAX_VALUE));
		
		// have to register before making block flammable
        Blocks.fire.setFireInfo(block, 30, 60);
		
		Element.LEAVES_AUTUMN_UMBER.set(block, BlockAutumnLeaves.BlockType.UMBER.metadata());
		Element.LEAVES_AUTUMN_GOLENROD.set(block, BlockAutumnLeaves.BlockType.GOLDENROD.metadata());
		Element.LEAVES_AUTUMN_VERMILLION.set(block, BlockAutumnLeaves.BlockType.VERMILLION.metadata());
		Element.LEAVES_AUTUMN_CITRINE.set(block, BlockAutumnLeaves.BlockType.CITRINE.metadata());
		
		// TODO: register with Forestry
	}

	private static void createFlowers() {
		final BlockSettings settings = BlockCollection.FLOWER.settings;
		if( !settings.isEnabled() ) return;
		
		final BiomeSettings autumnSettings = BiomeCollection.AUTUMN_WOODS.settings;
		final ExtrabiomeGenBase autumnBiome = autumnSettings.getBiome().get();
		
		// max of 5 attempts per chunk << TODO: make configurable
		final ExtraWorldGenerator gen = new ExtraWorldGenerator(5);
		gen.registerBiome(autumnSettings);
        GameRegistry.registerWorldGenerator(gen, 50);
		
		final BlockExtraFlower block = new BlockExtraFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "flower");
		
		for( BlockExtraFlower.BlockType type : BlockExtraFlower.BlockType.values() ) {
			autumnBiome.addFlower(block, type.metadata, type.weight);
			gen.registerGenerator(type.name(), new WorldGenDecoration(block, type.metadata));
		}
		
		// TODO: register with Forestry
	}
	
	
	private static void createSaplings() {
		final BlockSettings settings = BlockCollection.AUTUMN_TREE.settings;
		if( !settings.isEnabled() ) return;
		
		final BlockAutumnSapling block = new BlockAutumnSapling();
		GameRegistry.registerBlock(block, ExtraItem.class, "sapling");	// TODO: custom sapling item?		
		OreDictionary.registerOre("treeSapling", new ItemStack(block, 1, Short.MAX_VALUE));
		
		Element.SAPLING_AUTUMN_UMBER.set(block, SaplingType.UMBER.metadata());
		Element.SAPLING_AUTUMN_GOLDENROD.set(block, SaplingType.GOLDENROD.metadata());
		Element.SAPLING_AUTUMN_VERMILLION.set(block, SaplingType.VERMILLION.metadata());
		Element.SAPLING_AUTUMN_CITRINE.set(block, SaplingType.CITRINE.metadata());
		
		// TODO: register as burnable
		// TODO: register as bonemealable
		// TODO: register with Forestry
	}


}
