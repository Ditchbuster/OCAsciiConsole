package org.ditchbuster.ocasciiconsole;

import org.ditchbuster.ocserver.RobotAi;

import java.awt.Color;

/**
 * Created by CPearson on 9/13/2015.
 */
public class Robot {
    private World world;

    public int x;
    public int y;

    private RobotAi ai;
    public void setRobotAi(RobotAi ai) {this.ai =ai;}

    private char glyph;
    public char getGlyph() {return glyph;}

    private Color color;
    public Color getColor() {return color;}

    public Robot(World world, char glyph, Color color){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    public void move(int x, int y){
        //TODO: should send a new destination to the server, let the server figure out how to get there
    }
    public void moveBy(int mx, int my){
        ai.onEnter(x+mx, y+my, world.tile(x+mx,y+my));
    }
}
