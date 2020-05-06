package tile.desert;

import Main.Handler;
import gfx.Assets;
import tile.Tile;

public class Land extends Tile{
	public Land(int id) {
		super(Assets.landDesert[0], id, 32, 32);
	}
}
