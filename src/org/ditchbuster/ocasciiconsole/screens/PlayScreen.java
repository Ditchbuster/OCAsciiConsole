package org.ditchbuster.ocasciiconsole.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import org.ditchbuster.ocasciiconsole.Robot;
import org.ditchbuster.ocasciiconsole.RobotFactory;
import org.ditchbuster.ocasciiconsole.World;
import org.ditchbuster.ocasciiconsole.WorldBuilder;


/**
 * Following tutorial @ http://trystans.blogspot.com/2011/08/roguelike-tutorial-what-and-why.html
 * Created by CPearson on 9/12/2015.
 */


public class PlayScreen implements Screen {
    private World world;
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;

    public PlayScreen(){
        screenWidth = 160;
        screenHeight = 45;
        createWorld();
    }

    private void createWorld(){
        world = new WorldBuilder(300, 50)
                .makeCaves()
                .build();
        RobotFactory rf = new RobotFactory(world);
        rf.newRobot();
    }

    public int getScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.width() - screenWidth));
    }
    public int getScrollY() {
        return Math.max(0, Math.min(centerY - screenHeight / 2, world.height() - screenHeight));
    }
    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;
                terminal.write(world.getGlyph(wx, wy), x, y, world.getColor(wx, wy));
            }
        }
        for (int i = 0; i<world.numberRobots();i++){
            Robot robot = world.getRobot(i);
            if (left<robot.x&&robot.x<left+screenWidth&&top<robot.y&&robot.y<top+screenHeight){
                terminal.write(robot.getGlyph(),robot.x-left,robot.y-top,robot.getColor());
            }
        }
    }
    private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
    }


    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);
        terminal.write('X', centerX - left, centerY - top);

    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H: scrollBy(-1, 0); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L: scrollBy( 1, 0); break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K: scrollBy( 0,-1); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J: scrollBy( 0, 1); break;
            case KeyEvent.VK_Y: scrollBy(-1,-1); break;
            case KeyEvent.VK_U: scrollBy( 1,-1); break;
            case KeyEvent.VK_B: scrollBy(-1, 1); break;
            case KeyEvent.VK_N: scrollBy( 1, 1); break; //TODO: remove Y U B N controls
        }

        return this;
    }
}