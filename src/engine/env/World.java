package engine.env;


import engine.env.map.Cartogram;
import engine.env.map.Population;
import engine.env.objects.creatures.Creature;
import engine.eventSystem.CreatureEvent;
import engine.eventSystem.CreatureEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * World is a map(1) with creatures(2)
 * @author ogolovin
 */
public class World implements CreatureEventListener
{
    private Cartogram map;
    private Population population;

    public Set<Creature> getPopulation()
    {
        return population;
    }
    public void setPopulation(Population population)
    {
        this.population = population;
    }
    public Cartogram getMap()
    {
        return map;
    }
    public void setMap(Cartogram map)
    {
        this.map = map;
    }

    /**
 * Creature handling.
 */
    public void update()
    {
        List<Creature> toUpdate = new ArrayList<Creature>(population);
        for (Creature creature : toUpdate)
            creature.update();
    }


    @Override
    public void creatureMoved(CreatureEvent e)
    {
        throw new UnsupportedOperationException();
    }
}
