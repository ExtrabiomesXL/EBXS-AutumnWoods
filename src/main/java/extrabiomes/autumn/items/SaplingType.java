package extrabiomes.autumn.items;

import extrabiomes.lib.items.IExtraItemType;

public enum SaplingType implements IExtraItemType {
	UMBER(0, new String[] {"1x1"}),
	GOLDENROD(1, new String[] {"1x1"}),
	VERMILLION(2, new String[] {"1x1"}),
	CITRINE(3, new String[] {"1x1"});

	private final int metadata;
	private final String[] tooltip;
	
	SaplingType(int metadata, String[] tooltip) {
		this.metadata = metadata;
		this.tooltip = tooltip;
	}
	
	@Override
	public int metadata() {
		return metadata;
	}

	@Override
	public String[] toolTipData() {
		return tooltip;
	}
}
