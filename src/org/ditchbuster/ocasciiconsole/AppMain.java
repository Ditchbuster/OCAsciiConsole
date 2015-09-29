package org.ditchbuster.ocasciiconsole;

import javax.swing.*;
import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.screens.ConnectScreen;
import org.ditchbuster.ocasciiconsole.screens.PlayScreen;
import org.ditchbuster.ocasciiconsole.screens.Screen;
import org.ditchbuster.ocasciiconsole.screens.StartScreen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */
public class AppMain extends JFrame implements KeyListener{
    private static final long serialVersionUID= 2342981234120L;
    private AsciiPanel terminal;
    private JPanel contentPanel;
    private AsciiPanel options;
    private Screen screen;
    public PlayScreen Pscreen;
    public ConnectScreen Cscreen;
    public StartScreen Sscreen;
    public int hightInChars;
    public int widthInChars;

    public AppMain(){
        super();
        hightInChars = 48;
        widthInChars = 160;
        terminal = new AsciiPanel(widthInChars,hightInChars);
        terminal.write("Hello World", 1, 1);
        //options = new AsciiPanel(20,48);
        //add(terminal);
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(terminal, BorderLayout.WEST);
        //contentPanel.add(options, BorderLayout.EAST);
        add(contentPanel);
        pack();

        Sscreen = new StartScreen(this);
        Pscreen = new PlayScreen();
        Cscreen = new ConnectScreen(this);
        screen = Sscreen;
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
