package engine.eventSystem;

import engine.ui.UiManager;
import graphics.SteamRLFrame;
import main.SteampunkRoguelike;

import java.util.EventObject;

/**
 * Created by ogolovin on 7/4/14.
 */
public class UiEvent extends EventObject
{
    protected UiManager targetUi = SteampunkRoguelike.getUI();

    public UiEvent()
    {
        super(SteampunkRoguelike.getUI());
    }
}
