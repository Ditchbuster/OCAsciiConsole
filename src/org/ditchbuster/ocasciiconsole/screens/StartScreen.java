package org.ditchbuster.ocasciiconsole.screens;

import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.screens.Screen;

import java.awt.event.KeyEvent;

/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public class StartScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Hello World Start Screen",1,1);
        terminal.writeCenter("-- Press [enter] to start --",22);

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
