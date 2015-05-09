package extrabiomes.autumn.handlers;

import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.autumn.blocks.BlockExtraFlower;
import extrabiomes.autumn.stuff.BlockCollection;
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
		GameRegistry.registerBlock(block, ItemBlock.class, "flower");
		
		// TODO: register with forestry
	}

}
