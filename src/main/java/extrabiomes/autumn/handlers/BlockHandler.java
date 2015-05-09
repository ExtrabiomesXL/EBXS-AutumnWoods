package extrabiomes.autumn.handlers;

import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.lib.ExtraItem;
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
		
		final BlockExtraFlower block = new BlockExtraFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "flower");
		
		for( BlockExtraFlower.BlockType type : BlockExtraFlower.BlockType.values() ) {
			BiomeCollection.AUTUMN_WOODS.settings.getBiome().get().addFlower(block, type.metadata, type.weight);
		}
		
		// TODO: register with forestry
	}

}
