package org.ditchbuster.ocasciiconsole;
import java.awt.Color;
import asciiPanel.AsciiPanel;
/**
 * Created by CPearson on 9/12/2015.
 */
public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);

    private char glyph;
    public char getGlyph() { return glyph; }

    private Color color;
    public Color getColor() { return color; }

    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
    public boolean isDiggable(){
        return this==Tile.WALL;
        //TODO: check if any blocks/tiles are not diggable
    }
}
