package main;

import engine.ui.UiManager;
import graphics.SteamRLFrame;

import javax.swing.*;

/**
 * Created by ogolovin on 2/23/14.
 */
public class SteampunkRoguelike
{
    private static UiManager ui;
    public static UiManager getUI()
    {
        return ui;
    }

    public static void main(String[] args)
    {
        // init graphic ui
        {
            SteamRLFrame rlFrame = new SteamRLFrame();
            rlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rlFrame.setVisible(true);

            ui = new UiManager(rlFrame);
        }

        ui.showMainMenu();
    }
}
