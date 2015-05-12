package extrabiomes.autumn.biomes;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.autumn.stuff.BiomeCollection;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;

public class BiomeAutumnWoods extends ExtrabiomeGenBase {

	public BiomeAutumnWoods() {
		super(BiomeCollection.AUTUMN_WOODS.settings, Type.FOREST);
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
