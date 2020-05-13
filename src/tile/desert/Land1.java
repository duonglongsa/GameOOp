package tile.desert;

import gfx.Assets;
import tile.Tile;

public class Land1 extends Tile{
	public Land1(int id) {
		super(Assets.landDesert[1], id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
