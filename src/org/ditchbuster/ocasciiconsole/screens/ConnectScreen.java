package org.ditchbuster.ocasciiconsole.screens;

import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.AppMain;
import org.ditchbuster.ocasciiconsole.CommThread;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by CPearson on 9/13/2015.
 */
public class ConnectScreen implements Screen {
    private AppMain ap;
    private CommThread ct;
    private ArrayList<String> mesg;


    public ConnectScreen(AppMain ap){
        this.ap = ap;
        mesg = new ArrayList<>();
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Connect Screen: Press Enter to return", 1, 1);
        for (int y = 0; y<mesg.size();y++){

            terminal.write(mesg.get(y),0,terminal.getHeightInCharacters()-y-1);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_C:
                if (ct==null){
                    Connect();
                }
                break;
            //case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_ENTER:
                return ap.Sscreen;
        }
        return this;
    }
    private void Connect(){
        try{
            ct=new CommThread(new Socket("127.0.0.1",8809),this);
            ct.start();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void addMesg(String in){
        mesg.add(in);
    }
}
