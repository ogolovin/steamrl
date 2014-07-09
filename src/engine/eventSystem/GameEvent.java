package engine.eventSystem;

import game.Game;
import game.GameManager;

import java.util.EventObject;

/**
 * Created by ogolovin on 2/23/14.
 */
public class GameEvent extends EventObject
{
    public GameEvent()
    {
        super( GameManager.getCurrentGame() );
    }

}
