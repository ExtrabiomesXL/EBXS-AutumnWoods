package extrabiomes.autumn.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeAutumnWoods extends BiomeGenBase {

	public BiomeAutumnWoods(int biomeId, boolean register) {
		super(biomeId, register);
		setColor(0xF29C11);
		setBiomeName("Autumn Woods");
		
		this.temperature = BiomeGenBase.forest.temperature;
		this.rainfall = BiomeGenBase.forest.rainfall;
		
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return ColorizerFoliage.getFoliageColor(1.0F, 0.1F);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return ColorizerGrass.getGrassColor(1.0F, 0.1F);
    }

}
