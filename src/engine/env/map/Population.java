package engine.env.map;

import engine.env.objects.creatures.Creature;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ogolovin on 7/9/14.
 */
public class Population extends HashSet<Creature>
{
    private Set<Creature> population;

    public Creature creature(int x, int y)
    {
        for (Creature c : population)
        {
            if (c.x == x && c.y == y)
                return c;
        }
        return null;
    }

}
