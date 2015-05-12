package extrabiomes.autumn.stuff;

import java.util.List;

import com.google.common.collect.Lists;

import extrabiomes.lib.settings.BlockSettings;

public enum BlockCollection {
	// used for enabling all flower/decorative items
	FLOWER,
	// used for enabling all components of the autumn tree set
	AUTUMN_TREE;
	
	public final BlockSettings settings;
	
	private BlockCollection() {
		settings = new BlockSettings(this.name().toLowerCase());
	}
	
	public static final List<BlockSettings> allSettings = Lists.newArrayList();
	public static void init() {
		if( allSettings.isEmpty() ) {
			for( BlockCollection coll : BlockCollection.values() ) {
				allSettings.add(coll.settings);
			}
		}
	}
}
