package tile;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class LavaRockTile extends Tile{

	public LavaRockTile(int id) {
		super(Assets.lavaRock, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}
	

}
