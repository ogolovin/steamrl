package engine.eventSystem;

import engine.env.objects.creatures.Creature;

/**
 * Created by ogolovin on 2/26/14.
 */
public class CreatureMovementEvent extends CreatureEvent
{
    private int dx;
    private int dy;

    public CreatureMovementEvent(Creature creature, int mx, int my)
    {
        super(creature);
        this.dx = mx;
        this.dy = my;
    }
}
