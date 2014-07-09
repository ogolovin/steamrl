package engine.env.objects.creatures;

import engine.env.map.Tile;

/**
 * Creates action queue for the creature
 * @author ogolovin
 */
public class CreatureAi 
{
    protected Creature creature;
 
    public CreatureAi(Creature creature)
    {
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }
 
    public void onEnter(int x, int y, Tile tile) {}
    
    void onUpdate(){}
    
    void onNotify(String format) {}
}
