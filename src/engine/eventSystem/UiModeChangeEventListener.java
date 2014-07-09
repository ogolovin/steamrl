package engine.eventSystem;

import java.util.EventListener;

/**
 * Created by ogolovin on 7/3/14.
 */
public interface UiModeChangeEventListener extends EventListener
{
    void uiModeChanged(UiModeChangeEvent e);
}
