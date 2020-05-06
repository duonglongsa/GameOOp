package tile.desert;

import gfx.Assets;
import tile.Tile;

public class Land_goc2 extends Tile {
	public Land_goc2(int id) {
		super(Assets.landDesert[8], id, 32, 32);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
