package graphics;

import graphics.ascii.AsciiPanel;

/**
 * Determines how display output is formatted and delivered to the terminal
 * Created by ogolovin on 2/26/14.
 */
public interface VisualInterface
{
    public void giveOutput(AsciiPanel terminal);
}
