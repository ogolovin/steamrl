package game;

import engine.env.CaveBiomeBuilder;
import engine.env.World;

/**
 * Created by ogolovin on 2/23/14.
 * Used for creating new games, restoring games, saving games etc.
 */
public class GameManager
{
    private static Game currentGame = null;
    private static Game createGame()
    {
        Game game = new Game();

        // init character creation

        // init world creation
        World world = CaveBiomeBuilder.build(90, 31);
        game.setWorld( world );

        return game;
    }

    public static Game getCurrentGame()
    {
        return currentGame;
    }

    public static Game restoreGame( CompressedGame compressedGame )
    {
        throw new UnsupportedOperationException();
    }

    public static CompressedGame storeGame( Game game )
    {
        throw new UnsupportedOperationException();
    }
}
