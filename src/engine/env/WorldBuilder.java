package engine.env;

import engine.env.map.BiomeBuilder;
import engine.env.map.Cartogram;
import engine.env.map.Population;
import engine.env.map.biome.Biome;
import engine.env.objects.creatures.Creature;
import engine.env.objects.creatures.CreatureFactory;

import java.awt.*;

/**
 *
 * @author ogolovin
 */
public final class WorldBuilder
{
    /**
     * creates {@link World} object with several different {@link Biome}
     * @param width
     * @param height
     * @return
     */
    public World build(int width, int height)
    {
        World result = new World();

        Rectangle biomeShape = new Rectangle(0, 0, width, height);
        int density = 300;  // TODO move density outta here
        int biomePop = calculatePopulation(biomeShape, density);

        addBiome(result,
                biomeShape,
                biomePop,
                Biome.CAVE);

        // add player
        Creature player = CreatureFactory.getInstance().newPlayer();
        result.getPopulation().add( player );

        return result;
    }

    private void addBiome(World recipientWorld, Rectangle biomeShape, int biomePopulationCount, Biome biome)
    {
        BiomeBuilder bb = biome.getBuilder();
        // create tile map
        Cartogram map = bb.createMap(biomeShape, biome);

        // create population
        Population population = bb.createCreatures(biomePopulationCount, biome);     // init creature set
        syncWithMap(population, map);                                           // distribute creatures around the tile map

        recipientWorld.setMap(map);
        recipientWorld.setPopulation(population);
    }

    private void syncWithMap(Population population, Cartogram map)
    {
        int width = map.getWidth();
        int height = map.getHeight();

        for( Creature c : population )
        {
            // addAtEmptyLocation(c, map);
            int x,y;

            do {
                x = (int)(Math.random() * width);
                y = (int)(Math.random() * height);
            }
            while (!map.getTile(x, y).isGround() || population.creature(x, y) != null);

            c.x = x;
            c.y = y;
        }
    };


    /**
     * calculates how many creatures should be created for given cartogram area size
     * @param shape
     * @param density one creature per "density" tiles
     * @return
     */
    private int calculatePopulation( Rectangle shape, int density )
    {
        Dimension shapeSize = shape.getSize();
        int w = (int)shapeSize.getWidth();
        int h = (int)shapeSize.getHeight();

        return w*h / density;
    };
}
