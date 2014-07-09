package engine.eventSystem;

import game.Game;

import java.awt.*;

/**
 * Created by ogolovin on 2/26/14.
 */
public class GameEventProcessor
{


    /**
     * Draw something, change some setting, change game mode
     * @param e
     * @param output
     */
    public static void digestEventAndShowOutput(GameEvent e, Component output)
    {
        Game currentGame = (Game) e.getSource();
        if( e instanceof CreatureEvent )
        {
            currentGame.getWorld().update();
        }


        output.repaint();
    }
}
