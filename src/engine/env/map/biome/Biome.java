package engine.env.map.biome;

import engine.env.CaveBiomeBuilder;
import engine.env.WorldBuilder;
import engine.env.map.BiomeBuilder;
import engine.env.objects.creatures.CreatureType;

import java.util.Set;

/**
 * Defines which objects and creatures and map style to use.
 * Created by ogolovin on 7/4/14.
 */
public enum Biome
{
    CAVE(new CaveBiomeBuilder());

    private BiomeBuilder worldBuilder;
    private Biome(BiomeBuilder wb)
    {
        this.worldBuilder = wb;
    }

    public Set<CreatureType> getAllowedCreatureTypes()
    {
        throw new UnsupportedOperationException();
    }

    public BiomeBuilder getBuilder()
    {
        return worldBuilder;
    }
}
