package extrabiomes.autumn.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.lib.ExtraWorldGenerator;
import extrabiomes.lib.ExtrabiomeGenBase;

public class DecorationGenerator extends ExtraWorldGenerator implements IWorldGenerator {
	
	public final int maxDecorations;
	public DecorationGenerator(int max) {
		this.maxDecorations = max;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX <<= 4;
		chunkZ <<= 4;
		final BiomeGenBase biome = world.getBiomeGenForCoords(chunkX, chunkZ);
		
		if( biomeCheck(BiomeCollection.AUTUMN_WOODS.settings, biome) ) {
			final ExtrabiomeGenBase eBiome = (ExtrabiomeGenBase)biome;
			// TODO: handle configurable decoration limits
			for( int k = 0; k < maxDecorations; ++k ) {
				final int idx = random.nextInt( worldGens.size() );
				applyGenerator( (String)worldGens.keySet().toArray()[idx], world, chunkX, chunkZ, random );
			}
		}
	}

}
