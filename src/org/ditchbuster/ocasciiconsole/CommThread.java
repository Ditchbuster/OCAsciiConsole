package org.ditchbuster.ocasciiconsole;

import org.ditchbuster.ocasciiconsole.screens.ConnectScreen;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        JSONObject temp = new JSONObject();
        while(keepGoing) {
            // read a String (which is an object)
            try {
                cm = in.readLine();
                JSONParser parser = new JSONParser();

                try {
                    temp = (JSONObject)parser.parse(cm);
                }
                catch(ParseException e){
                    System.out.println(e.getMessage()+" at " + e.getPosition());
                }
                System.out.println(temp);
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
                screen.addMesg((String)temp.get("CMD")); //TODO dear Lord remove the type casting
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
