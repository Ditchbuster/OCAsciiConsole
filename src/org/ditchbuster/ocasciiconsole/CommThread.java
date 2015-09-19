package org.ditchbuster.ocasciiconsole;

import org.ditchbuster.ocasciiconsole.screens.ConnectScreen;

import java.io.*;
import java.net.Socket;


/**
 * Created by CPearson on 9/13/2015.
 */
public class CommThread extends Thread {

    String cm;
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    ConnectScreen screen;


    public CommThread(Socket socket, ConnectScreen screen){
        this.screen = screen;
        this.socket = socket;
        System.out.println("Thread trying to create Object Input/Output");
        try{
            //PrintWriter tempOut = new PrintWriter(socket.getOutputStream(),true);

            System.out.println("Trying to write out");
            //tempOut.println("console");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e){
            System.out.println("Exception creating new Input/Output streams");
        }
    }

    @Override
    public void run() {
        // to loop until LOGOUT
        boolean keepGoing = true;
        while(keepGoing) {
            // read a String (which is an object)
            try {
                cm = in.readLine();
            }
            catch (IOException e) {
                System.out.println(e);
                break;
            }

            // the message part of the ChatMessage
            if (cm==null||(cm!="" && cm.contains("logout"))){
                System.out.println("Logoff");
                keepGoing=false;
                break;
            }else{
                screen.addMesg(cm);
            }

        }
        close();
    }
    // try to close everything
    private void close() {
        // try to close the connection
        try {
            if(out != null) out.close();
        }
        catch(Exception e) {}
        try {
            if(in != null) in.close();
        }
        catch(Exception e) {};
        try {
            if(socket != null) socket.close();
        }
        catch (Exception e) {}
    }
}
