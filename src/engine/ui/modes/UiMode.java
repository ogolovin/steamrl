package engine.ui.modes;

import engine.eventSystem.EventInterface;
import engine.eventSystem.UiModeChangeEvent;
import engine.eventSystem.UiModeChangeEventListener;
import game.GameManager;
import graphics.VisualInterface;

import java.util.EventListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  Defines interface "mode". Mode defines which actions are available to user and how output screen looks.
 * @author ogolovin
 */
public abstract class UiMode implements EventInterface, VisualInterface
{
    protected int screenWidth;
    protected int screenHeight;

    protected List<EventListener> listeners = new LinkedList<>();
    public synchronized void addListener(UiModeChangeEventListener eventLsnr) {
        listeners.add(eventLsnr);
    }

    public synchronized void removeListener(UiModeChangeEventListener eventLsnr) {
        listeners.remove(eventLsnr);
    }

    public synchronized void fireGameModeChangeEvent(UiModeValue newUiMode)
    {
        UiModeChangeEvent e = new UiModeChangeEvent(newUiMode);
        Iterator it = listeners.iterator();

        while (it.hasNext())
        {
            EventListener el = (EventListener) it.next();
            if (el instanceof UiModeChangeEventListener)
                ((UiModeChangeEventListener) el).uiModeChanged(e);
        }
    }

}
