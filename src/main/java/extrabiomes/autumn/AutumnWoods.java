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

import java.io.File;

@Mod(modid = Version.MOD_ID, name = Version.MOD_NAME, version = Version.VERSION, 
	dependencies = "required-after:"+extrabiomes.core.Version.MOD_ID)
public class AutumnWoods implements IEBXSMod
{
    static final Minecraft MC = Minecraft.getMinecraft();
    
    @Instance(Version.MOD_ID)
    public static AutumnWoods instance;
    
    @SidedProxy(clientSide = Version.CLIENT_PROXY, serverSide = Version.SERVER_PROXY)
    public static CommonProxy proxy;

    static final Logger  LOGGER  = LogManager.getFormatterLogger(Version.MOD_ID);
    static final Boolean DEV     = Boolean.parseBoolean( System.getProperty("development", "false") );

    static File          BaseDir;
    static Configuration Config;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BaseDir = new File(event.getModConfigurationDirectory(), Const.PREFIX_LONG);
        if ( !BaseDir.exists() )
            BaseDir.mkdir();

        Config  = new Configuration( new File(BaseDir, getClass().getSimpleName().toLowerCase() + ".cfg") );
        
        BiomeUtils.register(this, Const.API_VERSION);
    }
    
    public void ebxsPreInit() {
    	
    }
    
    public void ebxsInit() {
    	LOGGER.info("Loaded version %s, API version %s", Version.VERSION, Const.API_VERSION);
    }
    
    public void ebxsPostInit() {
    	
    }
}
