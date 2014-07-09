/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.ui.modes;

import graphics.ascii.AsciiPanel;
import java.awt.event.KeyEvent;

import static engine.ui.modes.UiModeValue.*;

/**
 *
 * @author ogolovin
 */
public class MainMenuMode extends UiMode
{
    @Override
    public synchronized void takeInput(KeyEvent key)
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
        terminal.write("rl tutorial", 1, 1);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }
}
