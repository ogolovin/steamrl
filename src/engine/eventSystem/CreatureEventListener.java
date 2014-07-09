package engine.eventSystem;

import java.util.EventListener;

/**
 * Created by ogolovin on 7/4/14.
 */
public interface CreatureEventListener extends EventListener
{
    void creatureMoved(CreatureEvent e);
}
