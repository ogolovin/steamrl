package engine.eventSystem;

import engine.env.objects.creatures.Creature;
import engine.env.objects.creatures.CreatureInteractionType;

/**
 * Created by ogolovin on 2/26/14.
 */
public class CreatureAttackEvent extends CreatureInteractionEvent
{
    public CreatureAttackEvent( Creature agensCreature, Creature patiensCreature )
    {
        super(agensCreature, patiensCreature, CreatureInteractionType.ATTACK);
    }
}
