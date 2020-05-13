package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
import tile.wind.WindRoad16;
import tile.wind.WindRoad5;
import tile.wind.WindTile;
import tile.wind.WindTileSolid;

public class Tile {
	
	//add tile here
	public static Tile[] tiles = new Tile[256];
	
	// Wind Tile
	public static Tile windTile = new WindTile(0);
	public static Tile windTileSolid = new WindTileSolid(1);
	public static Tile roadWindTile16 = new WindRoad16(15);
	public static Tile roadWindTile5 = new WindRoad5(16);

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

	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32	;
	
	protected BufferedImage texture;
	
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getID() {
		return id;
	}

}
