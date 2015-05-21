package extrabiomes.autumn;

import java.util.List;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import extrabiomes.autumn.handlers.BlockHandler;
import extrabiomes.autumn.handlers.ConfigurationHandler;
import extrabiomes.autumn.handlers.ItemHandler;
import extrabiomes.autumn.handlers.RecipeHandler;
import extrabiomes.autumn.proxy.CommonProxy;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.autumn.stuff.BlockCollection;
import extrabiomes.autumn.worldgen.Generators;
import extrabiomes.lib.BiomeUtils;
import extrabiomes.lib.Const;
import extrabiomes.lib.IEBXSSubMod;
import extrabiomes.lib.ModBase;
import extrabiomes.lib.settings.BiomeSettings;

@Mod(modid = Version.MOD_ID, name = Version.MOD_NAME, version = Version.VERSION, 
	dependencies = "required-after:"+Const.API_MOD_ID)
public class AutumnWoods extends ModBase implements IEBXSSubMod
{
    public AutumnWoods() {
		super(Version.MOD_ID);
	}
    
	@Instance(Version.MOD_ID)
    public static AutumnWoods instance;
    
    @SidedProxy(clientSide = Version.CLIENT_PROXY, serverSide = Version.SERVER_PROXY)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        basePreInit(event);
        
        BiomeCollection.init();
        BlockCollection.init();
        ConfigurationHandler.init(Config);
        
        BiomeUtils.register(this, Const.API_VERSION);
    }
    
    public void ebxsPreInit() {
    	super.ebxsPreInit();
    	BlockHandler.init();
    	ItemHandler.init();
    	/// CropHandler.init();
    }
    
    public void ebxsInit() {
    	super.ebxsInit();
    	LOGGER.info("Loaded version %s, API version %s", Version.VERSION, Const.API_VERSION);
    	proxy.registerRenderInformation();
    }
    
    public void ebxsPostInit() {
    	super.ebxsPostInit();
    	RecipeHandler.init();
    }

	public List<BiomeSettings> getBiomeSettings() {
		return BiomeCollection.allSettings;
	}

    private List<Class<? extends IWorldGenerator>> worldGens = ImmutableList.of();
	public List<Class<? extends IWorldGenerator>> getWorldGenerators() {
		return worldGens;
	}
}
