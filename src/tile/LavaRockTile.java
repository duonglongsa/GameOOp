package tile;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class LavaRockTile extends Tile{

	public LavaRockTile(int id) {
		super(Assets.lavaRock, id, 32, 32);
		
	}
	
	public boolean isSolid() {
		return true;
	}
	

}
