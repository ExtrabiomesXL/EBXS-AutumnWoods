package extrabiomes.autumn.worldgen;

import extrabiomes.lib.worldgen.WorldGenExtraTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public enum Generators {
	AUTUMN_TREE_UMBER(new WorldGenExtraTree(true)),
	AUTUMN_TREE_GOLDENROD(new WorldGenExtraTree(true)),
	AUTUMN_TREE_VERMILLION(new WorldGenExtraTree(true)),
	AUTUMN_TREE_CITRINE(new WorldGenExtraTree(true));
	
	public final WorldGenerator generator;
	
	private Generators(WorldGenerator generator) {
		this.generator = generator;
	}
	
	public WorldGenExtraTree treeGen() {
		return (WorldGenExtraTree)generator;
	}
}
