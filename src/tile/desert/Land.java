package tile.desert;

import gfx.Assets;
import main.Handler;
import tile.Tile;

public class Land extends Tile{
	public Land(int id) {
		super(Assets.landDesert[0], id);
	}
}
