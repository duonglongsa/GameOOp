package tile.wind;

import gfx.Assets;
import tile.Tile;

public class WindTileSolid extends Tile{
	public WindTileSolid(int id) {
		super(Assets.windTile, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
