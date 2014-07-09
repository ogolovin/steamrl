package engine.ui.modes;

import engine.eventSystem.GameEvent;
import engine.eventSystem.UiModeChangeEvent;
import graphics.ascii.AsciiPanel;
import java.awt.event.KeyEvent;

import static engine.ui.modes.UiModeValue.PLAY_GAME;

/**
 *
 * @author ogolovin
 */
public class LoseMode extends UiMode
{
    @Override
    public void takeInput(KeyEvent key)
    {
        switch( key.getKeyCode() )
        {
            case KeyEvent.VK_ENTER:
                fireGameModeChangeEvent( PLAY_GAME );
            default:
                return;
        }
    }

    @Override
    public void giveOutput(AsciiPanel terminal)
    {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }
}
