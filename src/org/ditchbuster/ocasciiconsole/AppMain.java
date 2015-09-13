package org.ditchbuster.ocasciiconsole;

import javax.swing.*;
import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.screens.Screen;
import org.ditchbuster.ocasciiconsole.screens.StartScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public class AppMain extends JFrame implements KeyListener{
    private static final long serialVersionUID= 2342981234120L;
    private AsciiPanel terminal;
    private Screen screen;


    public AppMain(){
        super();
        terminal = new AsciiPanel();
        terminal.write("Hello World",1,1);
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent key){
        screen = screen.respondToUserInput(key);
        repaint();
    }

    public void keyReleased(KeyEvent key){

    }

    public void keyTyped(KeyEvent key){

    }

    public static void main(String[] args){
        AppMain app = new AppMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
