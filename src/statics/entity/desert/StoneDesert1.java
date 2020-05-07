package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class StoneDesert1 extends StaticEntity {
	public StoneDesert1(Handler handler, float x, float y) {
		super(handler, x, y, 258, 228);
		
		bounds.x = 10;
		bounds.y = 144;
		bounds.width = 240;
		bounds.height = 50;
		
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.stoneDesert[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
