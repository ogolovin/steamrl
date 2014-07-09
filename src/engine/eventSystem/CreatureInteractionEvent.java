package engine.eventSystem;

import engine.env.objects.creatures.Creature;
import engine.env.objects.creatures.CreatureInteractionType;

/**
 * Created by ogolovin on 2/26/14.
 */
public class CreatureInteractionEvent extends CreatureEvent
{
    protected Creature patiensCreature; // object creature, on whom action is performed
    protected CreatureInteractionType action;

    public CreatureInteractionEvent(Creature sourceCreature, Creature targetCreature, CreatureInteractionType action)
    {
        super(sourceCreature);
        this.patiensCreature = targetCreature;
        this.action = action;
    }
}
