package engine.env.map;

import engine.env.map.biome.Biome;
import engine.env.objects.creatures.Creature;

import java.awt.*;
import java.util.Set;

/**
 * Created by ogolovin on 7/9/14.
 */
public interface BiomeBuilder
{
    public Cartogram createMap(Rectangle dimensions, Biome biome);
    public Population createCreatures(int quantity, Biome biome);
}
