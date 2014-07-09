package engine.env;

import engine.env.map.BiomeBuilder;
import engine.env.map.Cartogram;
import engine.env.map.Population;
import engine.env.map.Tile;
import engine.env.map.biome.Biome;
import engine.env.objects.creatures.Creature;
import engine.env.objects.creatures.CreatureFactory;
import engine.env.objects.creatures.CreatureType;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ogolovin on 7/4/14.
 */
public class CaveBiomeBuilder implements BiomeBuilder
{
    @Override
    public Cartogram createMap(Rectangle dimensions, Biome biome)
    {
        Cartogram result = new Cartogram(dimensions);

        makeCaves(result);

        return result;
    }

    @Override
    public Population createCreatures(int quantity, Biome biome)
    {
        Population result = new Population();

        // get CreatureFactory
        CreatureFactory factory = CreatureFactory.getInstance();

        // use allowed creature types
        for( int i=0; i<quantity; i++ )
        {
            Creature creature = factory.create(CreatureType.FUNGUS);
            result.add( creature );
        }

        return result;
    }


    private Cartogram makeCaves(Cartogram map)
    {
        randomizeTiles(map);
        smooth(map, 8);

        return map;
    }

    // cellular automata methods
    private void randomizeTiles(Cartogram map)
    {
        for (int x = 0; x < map.getWidth(); x++)
            for (int y = 0; y < map.getHeight(); y++)
            {
                Tile tileType = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
                map.setTile(x,y,tileType);
            }
    }

    private void smooth(Cartogram map,int times)
    {
        int width = map.getWidth();
        int height = map.getHeight();

        Tile[][] tiles2 = new Tile[width][height];
        for (int time = 0; time < times; time++)
        {
            for (int x = 0; x < width; x++)
            {
                for (int y = 0; y < height; y++)
                {
                    int floors = 0;
                    int rocks = 0;

                    for (int ox = -1; ox < 2; ox++)
                    {
                        for (int oy = -1; oy < 2; oy++)
                        {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0
                                    || y + oy >= height)
                                continue;

                            if (map.getTile( x+ox, y+oy ) == Tile.FLOOR)
                                floors++;
                            else
                                rocks++;
                        }
                    }
                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            map.setTiles(tiles2);
        }
    }
}
