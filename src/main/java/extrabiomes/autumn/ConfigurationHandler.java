package extrabiomes.autumn;

import extrabiomes.lib.BiomeSettings;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	// Load all of our config settings
	public static void init(Configuration config) {
		
		for( final BiomeSettings settings : BiomeCollection.allSettings ) {
			settings.load(config);
		}
		
		config.save();
	}

}