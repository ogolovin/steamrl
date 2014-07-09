package engine.eventSystem;

import engine.ui.modes.UiModeValue;

/**
 * Created by ogolovin on 2/26/14.
 */
public class UiModeChangeEvent extends UiEvent
{
    private UiModeValue oldUiMode;
    private UiModeValue newUiMode;

    public UiModeChangeEvent(UiModeValue changeToUiMode)
    {
        super();

        oldUiMode = this.targetUi.getUiModeValue();
        newUiMode = changeToUiMode;
    }


    public UiModeValue getOldUiMode()
    {
        return oldUiMode;
    }
    public UiModeValue getNewUiMode()
    {
        return newUiMode;
    }
}
