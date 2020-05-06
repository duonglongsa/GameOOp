package tile.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;
import tile.Tile;

public class Stair1 extends Tile{
	public Stair1(int id) {
		super(Assets.stairDesert, id, 32*3, 32*3);
	}

}
