package tile.desert;

import gfx.Assets;
import tile.Tile;

public class DesertTileSolid extends Tile{
	public DesertTileSolid(int id) {
		super(Assets.desertTile, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
