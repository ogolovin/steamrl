package engine.env.objects.creatures;

import engine.env.World;
import graphics.ascii.AsciiPanel;
import java.util.List;

/**
 *
 * @author ogolovin
 */
public class CreatureFactory 
{
    private CreatureFactory(){}
    private static CreatureFactory instance = null;
    public static CreatureFactory getInstance()
    {
        if(instance == null)
            instance = new CreatureFactory();
        return instance;
    }

    public Creature newPlayer()
    {
        return create(CreatureType.PLAYER);
    }
    
    public Creature newFungus()
    {
        return create(CreatureType.FUNGUS);
    }

    public Creature create( CreatureType t )
    {
        CreatureAi ai = null;
        try {
            ai = t.ai.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Creature c = new Creature( t.glyph, t.color, t.maxHp, t.attack, t.defense );
        c.setCreatureAi(ai);

        return c;
    }
}
