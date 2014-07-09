package engine.ui.modes;

import engine.eventSystem.CreatureEventListener;
import engine.eventSystem.CreatureMovementEvent;
import engine.env.World;
import engine.env.WorldBuilder;
import engine.env.objects.creatures.Creature;
import engine.env.objects.creatures.CreatureFactory;
import graphics.ascii.AsciiPanel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;

import static engine.ui.modes.UiModeValue.LOSE_GAME;
import static engine.ui.modes.UiModeValue.WIN_GAME;

/**
 *
 * @author ogolovin
 */
public class PlayMode extends UiMode
{
    @Override
    public void takeInput(KeyEvent key)
    {
        switch (key.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE: fireGameModeChangeEvent( LOSE_GAME ); break;
            case KeyEvent.VK_ENTER: fireGameModeChangeEvent( WIN_GAME ); break;

            // movement
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H: fireCreatureMovementEvent(player, -1, 0); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L: fireCreatureMovementEvent(player, 1, 0); break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K: fireCreatureMovementEvent(player, 0, -1); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J: fireCreatureMovementEvent(player, 0, 1); break;

            case KeyEvent.VK_Y: fireCreatureMovementEvent(player, -1, -1); break;
            case KeyEvent.VK_U: fireCreatureMovementEvent(player, 1, -1); break;
            case KeyEvent.VK_B: fireCreatureMovementEvent(player, -1, 1); break;
            case KeyEvent.VK_N: fireCreatureMovementEvent(player, 1, 1); break;
        }
    }

    private synchronized void fireCreatureMovementEvent(Creature player, int dx, int dy)
    {
        // listener should be "World"
        CreatureMovementEvent e = new CreatureMovementEvent(player, dx, dy);
        Iterator it = listeners.iterator();

        while (it.hasNext())
        {
            EventListener el = (EventListener) it.next();
            if (el instanceof CreatureEventListener)
                ((CreatureEventListener) el).creatureMoved(e);
        }
    }

    @Override
    public void giveOutput(AsciiPanel terminal)
    {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);

        // show player's health
        String stats = String.format(" %3d/%3d hp", player.hp(), player.maxHp());
        terminal.write(stats, 1, 23);

        displayMessages(terminal, messages);
    }





    private World world;

 
    private Creature player;
    private List<String> messages;
    
    
    public PlayMode()
    {
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
        
        messages = new ArrayList<String>();
        
        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory);
    }
    
    private void createWorld()
    {
        world = new WorldBuilder(90, 31).makeCaves().build();
    }
    
    public int getScrollX() 
    {
        return Math.max(0, Math.min(player.x - screenWidth / 2, world.getWidth() - screenWidth));
    }
    public int getScrollY() 
    {
        return Math.max(0, Math.min(player.y - screenHeight / 2, world.getHeight() - screenHeight));
    }

    
    private void displayTiles(AsciiPanel terminal, int left, int top) 
    {
        for (int x = 0; x < screenWidth; x++)
        {
            for (int y = 0; y < screenHeight; y++)
            {
                int wx = x + left;
                int wy = y + top;

                Creature creature = world.creature(wx, wy);
                if (creature != null)
                    terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
                else
    //                terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
                    terminal.write(world.glyph(wx, wy), x, y);
            }
        }

    }
    
    private void displayMessages(AsciiPanel terminal, List<String> messages)
    {
        int top = screenHeight - messages.size();
        for (int i = 0; i < messages.size(); i++){
            terminal.writeCenter(messages.get(i), top + i);
        }
        messages.clear();
    }
}
