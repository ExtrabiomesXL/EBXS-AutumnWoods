package extrabiomes.autumn.handlers;

import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.autumn.worldgen.DecorationGenerator;
import extrabiomes.lib.ExtraItem;
import extrabiomes.lib.WorldGenDecoration;
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
		
		// max of 5 attempts per chunk << TODO: make configurable
		final DecorationGenerator gen = new DecorationGenerator(5);
        GameRegistry.registerWorldGenerator(gen, 50);
		
		final BlockExtraFlower block = new BlockExtraFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "flower");
		
		for( BlockExtraFlower.BlockType type : BlockExtraFlower.BlockType.values() ) {
			BiomeCollection.AUTUMN_WOODS.settings.getBiome().get().addFlower(block, type.metadata, type.weight);
			gen.registerGenerator(type.name(), new WorldGenDecoration(block, type.metadata));
		}
		
		// TODO: register with forestry
	}

}
