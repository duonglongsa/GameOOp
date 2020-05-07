package tile.desert;

import gfx.Assets;
import tile.Tile;

public class Land3 extends Tile{
	public Land3(int id) {
		super(Assets.landDesert[3], id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
