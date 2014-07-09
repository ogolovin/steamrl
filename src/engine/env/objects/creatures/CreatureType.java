package engine.env.objects.creatures;

import graphics.ascii.AsciiPanel;

import java.awt.*;

/**
 * basic blank for creating creatures. Includes basic characteristics and used AI
 * Created by ogolovin on 7/8/14.
 */
public enum CreatureType
{
    FUNGUS(FungusAi.class, 'f', AsciiPanel.brightWhite, 10, 0, 0),
    PLAYER(PlayerAi.class, '@', AsciiPanel.brightWhite, 100, 20, 5);

    protected char glyph;
    protected Color color;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected Class<CreatureAi> ai;

    private CreatureType(Class ai, char glyph, Color color, int maxHp, int attack, int defense)
    {
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.ai = ai;
    }
}
