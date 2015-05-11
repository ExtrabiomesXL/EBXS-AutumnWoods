package extrabiomes.autumn.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.lib.ExtraItem;
import extrabiomes.lib.ExtraWorldGenerator;
import extrabiomes.lib.ExtrabiomeGenBase;
import extrabiomes.lib.WorldGenDecoration;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;

public abstract class BlockHandler {

	public static void init() {
		/// createAutumnLeaves();
		createFlowers();
		/// createLogs();
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
		
		// TODO: register with forestry
	}

}
