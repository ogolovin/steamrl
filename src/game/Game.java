package game;

import engine.EntityStatus;
import engine.TimeStatus;
import engine.env.World;

/**
 * Created by ogolovin on 2/23/14.
 */
public class Game
{
    private World world;    // all that describes world status - position of entities(mobs and otherwise)
    private TimeStatus timeStatus;      // describes current time, elapsed time from beginning of the game, number of turns etc.
    private EntityStatus[] entitiesStatus;  // describes action queue of entities and their general status;
    private EntityStatus playerStatus;                // all that describe player character

    public World getWorld()
    {
        return world;
    }
    public void setWorld(World world)
    {
        this.world = world;
    }


    private static Game dummyGame = new Game();
    public static Game getDummyGame()
    {
        return dummyGame;
    }
}
