package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//add tile here
	public static Tile[] tiles = new Tile[256];
	public static Tile snowTile2 = new SnowTile2(0);
	public static Tile snowTile5 = new SnowTile5(1);
	
	
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
