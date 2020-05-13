package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;
import tile.Tile;

public class Rock3 extends StaticEntity{
	public Rock3(Handler handler, float x, float y) {
		super(handler, x, y, 70, 64);
		
		bounds.x = 5;
		bounds.y = 25;
		bounds.width = 55;
		bounds.height = 24;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rockDesert[2], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
