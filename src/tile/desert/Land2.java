package tile.desert;

import gfx.Assets;
import tile.Tile;

public class Land2 extends Tile{
	public Land2(int id) {
		super(Assets.landDesert[2], id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
