package extrabiomes.autumn.stuff;

import java.util.List;

import com.google.common.collect.Lists;

import extrabiomes.autumn.biomes.BiomeAutumnWoods;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;

public enum BiomeCollection {
	AUTUMN_WOODS(61, BiomeAutumnWoods.class);
	
	public final BiomeSettings settings;
	
	private BiomeCollection(int defaultID, Class<? extends ExtrabiomeGenBase> biomeClass) {
		settings = new BiomeSettings(this.name().toLowerCase(), defaultID, biomeClass);
	}
	
	public static final List<BiomeSettings> allSettings = Lists.newArrayList();
	public static void init() {
		if( allSettings.isEmpty() ) {
			for( BiomeCollection coll : BiomeCollection.values() ) {
				allSettings.add(coll.settings);
			}
		}
	}
}
