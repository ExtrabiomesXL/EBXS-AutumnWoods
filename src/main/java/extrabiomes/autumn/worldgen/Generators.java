package extrabiomes.autumn.worldgen;

import extrabiomes.lib.worldgen.WorldGenExtraTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public enum Generators {
	AUTUMN_TREE_UMBER		(new WorldGenExtraTree(true), new WorldGenExtraTree(false)),
	AUTUMN_TREE_GOLDENROD	(new WorldGenExtraTree(true), new WorldGenExtraTree(false)),
	AUTUMN_TREE_VERMILLION	(new WorldGenExtraTree(true), new WorldGenExtraTree(false)),
	AUTUMN_TREE_CITRINE		(new WorldGenExtraTree(true), new WorldGenExtraTree(false));
	
	// this generator runs during normal situations
	public final WorldGenerator generator;
	// this generator runs in the background (during chunk generation)
	public final WorldGenerator generatorChunk;
	
	private Generators(WorldGenerator generator) {
		this.generatorChunk = this.generator = generator;
	}
	private Generators(WorldGenerator generator, WorldGenerator generatorActive) {
		this.generator = generator;
		this.generatorChunk = generator;
	}
	
	public WorldGenExtraTree treeGen() {
		return (WorldGenExtraTree)generator;
	}
	public WorldGenExtraTree treeGenChunk() {
		return (WorldGenExtraTree)generatorChunk;
	}

}
