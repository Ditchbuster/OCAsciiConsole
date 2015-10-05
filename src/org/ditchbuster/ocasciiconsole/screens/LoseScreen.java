package org.ditchbuster.ocasciiconsole.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.AppMain;

import javax.swing.*;

/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public class LoseScreen implements Screen {
    private AppMain ap;
    private AsciiPanel screen;

    public LoseScreen(AppMain ap) {
        this.ap = ap;
        this.screen = new AsciiPanel(ap.widthInChars,ap.hightInChars);
    }

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }
    @Override
    public void repaint(){
        screen.write("You lost.", 1, 1);
        screen.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? ap.Pscreen : this;
    }
    @Override
    public JPanel getJPanel() {
        return screen;
    }
}