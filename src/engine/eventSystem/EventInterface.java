package engine.eventSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ogolovin on 2/26/14.
 */
public interface EventInterface
{
    /**
     * Digest input keyEvent. Implementation should fire GameEvents
     * @param key
     */
    public void takeInput(KeyEvent key);
}
