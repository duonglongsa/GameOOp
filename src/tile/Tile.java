package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import statics.entity.desert.Rock1;
import statics.entity.desert.Rock2;
import statics.entity.desert.Rock3;
import tile.desert.DesertTile;
import tile.desert.DesertTileSolid;
import tile.desert.Land;
import tile.desert.Land1;
import tile.desert.Land11;
import tile.desert.Land18;
import tile.desert.Land2;
import tile.desert.Land3;
import tile.desert.Land9;
import tile.desert.Land_goc1;
import tile.desert.Land_goc2;
import tile.desert.Road18;
import tile.desert.Stair1;

public class Tile {
	
	//add tile here
	public static Tile[] tiles = new Tile[256];
	public static Tile snowTile2 = new SnowTile2(0);
	public static Tile snowTile5 = new SnowTile5(1);
	
	// Desert Tile
	public static Tile desertTile = new DesertTile(2);
	public static Tile desertTileSolid = new DesertTileSolid(3);
	public static Tile land = new Land(4);
	public static Tile land1 = new Land1(5);
	public static Tile land2 = new Land2(6);
	public static Tile land3 = new Land3(7);
	public static Tile land18 = new Land18(8);
	public static Tile land9 = new Land9(9);
	public static Tile land11 = new Land11(10);
	public static Tile land_goc1 = new Land_goc1(11);
	public static Tile land_goc2 = new Land_goc2(12);
	public static Tile stair = new Stair1(13);
	public static Tile road =  new Road18(14);
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	public int width, height;
	
	protected BufferedImage texture;
	
	protected final int id;
	
	public Tile(BufferedImage texture, int id, int width, int height) {
		this.texture = texture;
		this.id = id;
		
		this.width = width;
		this.height = height;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, this.TILE_WIDTH, this.TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getID() {
		return id;
	}

}
