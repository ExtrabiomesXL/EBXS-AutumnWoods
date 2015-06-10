package extrabiomes.autumn;

import java.util.Locale;

public abstract class Version {
	public static final String MOD_ID		= "ExtrabiomesAutumnWoods";
	public static final String MOD_NAME		= "Extrabiomes Autumn Woods";
	public static final String VERSION		= "@VERSION@";
	public static final String API_VERSION	= "0.1.3";

	public static final String LOC_PREFIX   = "extrabiomes.autumn";
	
	public static final String CHANNEL		= MOD_ID;
	public static final String TEXTURE_PATH = MOD_ID.toLowerCase(Locale.ENGLISH) + ":";
	
	public static final String CLIENT_PROXY	= "extrabiomes.autumn.proxy.ClientProxy";
	public static final String SERVER_PROXY	= "extrabiomes.autumn.proxy.CommonProxy";
}
