package tile.desert;

import main.Handler;
import gfx.Assets;
import tile.Tile;

public class Land extends Tile{
	public Land(int id) {
		super(Assets.landDesert[0], id);
	}
}
