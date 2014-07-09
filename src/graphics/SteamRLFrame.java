package graphics;

import graphics.ascii.AsciiPanel;
import main.SteampunkRoguelike;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author ogolovin
 */
public class SteamRLFrame extends JFrame
{
    private AsciiPanel terminal;

    public SteamRLFrame()
    {
        super();
        terminal = new AsciiPanel();
        terminal.write("rl tutorial blabla", 1, 1);
        add(terminal);
        pack();

        this.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent keyEvent)
            {
                // digest input
                SteampunkRoguelike.getUI().getUiMode().takeInput(keyEvent);

                // run AI,logics,change game objects status etc..

                // show result to user

            }

            @Override
            public void keyReleased(KeyEvent keyEvent){}
            @Override
            public void keyTyped(KeyEvent keyEvent){}
        });
    }

    @Override
    public void repaint()
    {
        terminal.clear();

        VisualInterface vi = SteampunkRoguelike.getUI().getUiMode();
        vi.giveOutput(terminal);
        super.repaint();
//        RepaintManager.currentManager(this).paintDirtyRegions();
    }
}
