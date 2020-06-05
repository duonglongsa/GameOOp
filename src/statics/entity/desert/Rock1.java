package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;

import gfx.Assets;
import tile.Tile;

public class Rock1 extends StaticEntity{
	public Rock1(Handler handler, float x, float y) {
		super(handler, x, y, 53, 39);
		
		bounds.x = 2;
		bounds.y = 20;
		bounds.width = 46;
		bounds.height = 5;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rockDesert[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
