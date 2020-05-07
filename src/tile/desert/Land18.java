package tile.desert;

import gfx.Assets;
import tile.Tile;

public class Land18 extends Tile{
	public Land18(int id) {
		super(Assets.landDesert[4], id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
