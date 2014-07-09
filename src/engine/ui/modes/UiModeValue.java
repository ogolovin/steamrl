package engine.ui.modes;

import main.SteampunkRoguelike;

/**
 * Created by ogolovin on 2/23/14.
 */
public enum UiModeValue
{
    MAIN_MENU( new MainMenuMode() ),
    PLAY_GAME( new PlayMode() ),
    LOSE_GAME( new LoseMode() ),
    WIN_GAME( new WinMode() );

    private UiMode mode;
    private UiModeValue(UiMode uiMode)
    {
        mode = uiMode;
        mode.addListener(SteampunkRoguelike.getUI());
    }
    public UiMode get()
    {
        return this.mode;
    }
}
