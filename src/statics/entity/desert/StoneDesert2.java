package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class StoneDesert2 extends StaticEntity {
	public StoneDesert2(Handler handler, float x, float y) {
		super(handler, x, y, 256, 100);
		
		bounds.x = 10;
		bounds.y = 54;
		bounds.width = 236;
		bounds.height = 20;
		
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.stoneDesert[1], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}

