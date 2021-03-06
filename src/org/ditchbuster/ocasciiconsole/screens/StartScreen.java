package org.ditchbuster.ocasciiconsole.screens;

import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.AppMain;
import org.ditchbuster.ocasciiconsole.screens.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public class StartScreen implements Screen {
    private AppMain ap;
    private AsciiPanel screen;

    public StartScreen(AppMain ap){
        this.ap = ap;
        screen = new AsciiPanel(ap.widthInChars,ap.hightInChars);
    }
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Hello World Start Screen", 1, 1);
        terminal.writeCenter("-- Press [enter] to start --", 22);
        terminal.write("-- Press [c] to connect --",terminal.getWidthInCharacters()/2-13,terminal.getHeightInCharacters()/2 );

    }
    @Override
    public void repaint(){
        screen.write("Hello World Start Screen", 1, 1);
        screen.writeCenter("-- Press [enter] to start --", 22);
        screen.write("-- Press [c] to connect --",screen.getWidthInCharacters()/2-13,screen.getHeightInCharacters()/2 );
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_C: return ap.Cscreen;
            //case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_ENTER: return ap.Pscreen;
        }
        return this;
    }
    @Override
    public JPanel getJPanel() {
        return screen;
    }

}

