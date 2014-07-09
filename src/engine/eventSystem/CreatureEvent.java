package engine.eventSystem;

import engine.env.objects.creatures.Creature;
import game.Game;

/**
 * Created by ogolovin on 2/26/14.
 */
public class CreatureEvent extends GameEvent
{
    protected Creature agensCreature; // subject creature - the one which acts

    public CreatureEvent(Creature sourceCreature)
    {
        super();
        agensCreature = sourceCreature;
    }
}
