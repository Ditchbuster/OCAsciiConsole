package org.ditchbuster.ocasciiconsole;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPearson on 9/12/2015.
 */
public class World {
    private Tile[][] tiles;
    private List<Robot> robots;
    private int width;
    public int width() { return width; }

    private int height;
    public int height() { return height; }

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.robots = new ArrayList<Robot>();
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height) //check if out of bounds
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }

    public char getGlyph(int x, int y){
        return tile(x, y).getGlyph();
    }

    public Color getColor(int x, int y){
        return tile(x, y).getColor();
    }

    public Robot getRobot(int index){
        return robots.get(index);
    }
    public int numberRobots(){
        return robots.size();
    }
    public void addAt(Robot robot, int x, int y){
        robot.x =x;
        robot.y =y;
        robots.add(robot);
    }
}