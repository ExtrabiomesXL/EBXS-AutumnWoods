package extrabiomes.autumn.handlers;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockAutumnLeaves;
import extrabiomes.autumn.blocks.BlockAutumnLog;
import extrabiomes.autumn.blocks.BlockAutumnSapling;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.items.ItemExtraLeaves;
import extrabiomes.autumn.items.SaplingType;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.autumn.stuff.Element;
import extrabiomes.autumn.worldgen.Generators;
import extrabiomes.lib.blocks.BlockExtraSapling;
import extrabiomes.lib.items.ExtraItem;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;
import extrabiomes.lib.worldgen.ExtraWorldGenerator;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;
import extrabiomes.lib.worldgen.WorldGenDecoration;
import extrabiomes.lib.worldgen.WorldGenExtraTree;

public abstract class BlockHandler {

	public static void init() {
		createAutumnLeaves();
		createAutumnLogs();
		createSaplings();
		
		createFlowers();
		/// createCrops();
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
		
		Generators.AUTUMN_TREE_UMBER.treeGen().setLeaves(Element.LEAVES_AUTUMN_UMBER.get());
		Generators.AUTUMN_TREE_UMBER.treeGenChunk().setLeaves(Element.LEAVES_AUTUMN_UMBER.get());
		Generators.AUTUMN_TREE_GOLDENROD.treeGen().setLeaves(Element.LEAVES_AUTUMN_GOLENROD.get());
		Generators.AUTUMN_TREE_GOLDENROD.treeGenChunk().setLeaves(Element.LEAVES_AUTUMN_GOLENROD.get());
		Generators.AUTUMN_TREE_VERMILLION.treeGen().setLeaves(Element.LEAVES_AUTUMN_VERMILLION.get());
		Generators.AUTUMN_TREE_VERMILLION.treeGenChunk().setLeaves(Element.LEAVES_AUTUMN_VERMILLION.get());
		Generators.AUTUMN_TREE_CITRINE.treeGen().setLeaves(Element.LEAVES_AUTUMN_CITRINE.get());
		Generators.AUTUMN_TREE_CITRINE.treeGenChunk().setLeaves(Element.LEAVES_AUTUMN_CITRINE.get());
		
		ExtrabiomeGenBase biome = BiomeCollection.AUTUMN_WOODS.settings.getBiome().get();
		for( Generators gen : Generators.values() ) {
			biome.registerTreeGenerator(gen.treeGenChunk());
		}
		
		// TODO: register with Forestry
	}
	
	public static void createAutumnLogs() {
		final BlockSettings settings = BlockCollection.AUTUMN_TREE.settings;
		if( !settings.isEnabled() ) return;
		
		final BlockAutumnLog block = new BlockAutumnLog(settings);
		GameRegistry.registerBlock(block, ExtraItem.class, "log");
		OreDictionary.registerOre("logWood", block);
		
		// less flamable than leaves
		Blocks.fire.setFireInfo(block, 5, 5);
		
		Element.LOG_AUTUMN.set(block);
		
		Generators.AUTUMN_TREE_UMBER.treeGen().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_UMBER.treeGenChunk().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_GOLDENROD.treeGen().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_GOLDENROD.treeGenChunk().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_VERMILLION.treeGen().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_VERMILLION.treeGenChunk().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_CITRINE.treeGen().setTrunkBlock(block, 0);
		Generators.AUTUMN_TREE_CITRINE.treeGenChunk().setTrunkBlock(block, 0);
		
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
		
		GameRegistry.registerFuelHandler(block.new FuelHandler(block));
		MinecraftForge.EVENT_BUS.register(block.new BonemealEventHandler(block));
		
		// TODO: register with Forestry
	}


}
