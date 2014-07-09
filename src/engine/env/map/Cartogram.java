package engine.env.map;

import java.awt.*;

/**
 * Actually it's a MAP of the world. Consists of tiles.
 * Created by ogolovin on 7/7/14.
 */
public class Cartogram
{
    private Tile[][] tiles;

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private int width;
    private int height;

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Cartogram(Rectangle dimensions)
    {
        startX = dimensions.x;
        startY = dimensions.y;
        endX = startX + dimensions.width;
        endY = startY + dimensions.height;
        width = dimensions.width;
        height = dimensions.height;

        tiles = new Tile[width][height];
    }

    public void setTiles( Tile[][] newTileMap )
    {
        this.tiles = newTileMap;
    }

    public void setTile(int x, int y, Tile tile)
    {
        tiles[x-startX][y-startY] = tile;
    }

    public Tile getTile(int x, int y)
    {
        if( !isInBounds(x,y) )
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }

    public char glyph(int x, int y)
    {
        return getTile(x, y).glyph();
    }

    public Color color(int x, int y)
    {
        return getTile(x, y).color();
    }

    public void dig(int x, int y)
    {
        if (getTile(x, y).isDiggable())
            tiles[x][y] = Tile.FLOOR;
    }

    public boolean isInBounds(int x, int y)
    {
        return !((x-startX) < 0 || (x-startX) >= width || (y-startY) < 0 || (y-startY) >= height); // TODO possible optimization
    }
}
