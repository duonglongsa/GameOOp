package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;

public class Rock2 extends StaticEntity{
	public Rock2(Handler handler, float x, float y) {
		super(handler, x, y, 90, 68);
		
		bounds.x = 5;
		bounds.y = 40;
		bounds.width = 80;
		bounds.height = 7;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rockDesert[1], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
