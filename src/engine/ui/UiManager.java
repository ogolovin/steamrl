package engine.ui;

import engine.eventSystem.UiModeChangeEvent;
import engine.eventSystem.UiModeChangeEventListener;
import engine.ui.modes.UiMode;
import engine.ui.modes.UiModeValue;
import graphics.SteamRLFrame;

import static engine.ui.modes.UiModeValue.*;

/**
 * User Interface class.
 * Contains both input interface (key input) and output interface (output to graphic terminal)
 * Created by ogolovin on 7/3/14.
 */
public class UiManager implements UiModeChangeEventListener
{
    private SteamRLFrame outputTerminal;
    private UiMode uiMode;
    private UiModeValue uiModeValue;

    public UiManager(SteamRLFrame outputFrame)
    {
        this.outputTerminal = outputFrame;
    }

    public UiMode getUiMode()
    {
        return uiMode;
    }

    private void setUiMode(UiModeValue newMode)
    {
        this.uiMode = newMode.get();
        this.uiModeValue = newMode;
    }

    public UiModeValue getUiModeValue()
    {
        return uiModeValue;
    }

    public void showMainMenu()
    {
        this.setUiMode( MAIN_MENU );
        repaintTerminal();
    }

    private void repaintTerminal()
    {
        outputTerminal.repaint();
    }

    public void uiModeChanged(UiModeChangeEvent e)
    {
        // set game mode
        this.setUiMode(e.getNewUiMode());

        // send a message to GUI for repaint
        // get from mode, what area of GUI should be repainted
        // either create an event, or simply call .repaint()
        repaintTerminal();
    }
}
