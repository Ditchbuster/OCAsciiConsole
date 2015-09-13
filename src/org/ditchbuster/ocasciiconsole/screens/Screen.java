package org.ditchbuster.ocasciiconsole.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public interface Screen{
    public void displayOutput(AsciiPanel terminal);
    public Screen respondToUserInput(KeyEvent key);

}