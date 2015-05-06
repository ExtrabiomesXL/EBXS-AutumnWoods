package extrabiomes.autumn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import extrabiomes.autumn.proxy.CommonProxy;
import extrabiomes.lib.BiomeUtils;
import extrabiomes.lib.Const;
import extrabiomes.lib.IEBXSMod;
import extrabiomes.lib.ModBase;

import java.io.File;

@Mod(modid = Version.MOD_ID, name = Version.MOD_NAME, version = Version.VERSION, 
	dependencies = "required-after:"+extrabiomes.core.Version.MOD_ID)
public class AutumnWoods extends ModBase implements IEBXSMod
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
        BiomeUtils.register(this, Const.API_VERSION);
    }
    
    public void ebxsPreInit() {
    	/// BlockHandler.init();
    	/// ItemHandler.init();
    	/// CropHandler.init();
    }
    
    public void ebxsInit() {
    	LOGGER.info("Loaded version %s, API version %s", Version.VERSION, Const.API_VERSION);
    	proxy.registerRenderInformation();
    }
    
    public void ebxsPostInit() {
    	/// RecipeHandler.init();
    }
}
