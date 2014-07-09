/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.env.objects.creatures;

import engine.env.map.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ogolovin
 */
public class PlayerAi extends CreatureAi 
{
    private List<String> messages;
    
    public PlayerAi(Creature creature, List<String> messages) 
    {
        super(creature);
        this.messages = messages;
    }
    
    @Override
    public void onEnter(int x, int y, Tile tile)
    {
        if (tile.isGround())
        {
            creature.x = x;
            creature.y = y;
        }
        else if (tile.isDiggable())
        {
            creature.dig(x, y);
        }
    }
    
    public void onNotify(String message)
    {
        messages.add(message);
    }
}