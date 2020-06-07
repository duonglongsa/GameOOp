package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class Decor7 extends StaticEntity{
	public Decor7(Handler handler, float x, float y) {
		super(handler, x, y, 67, 70);
		
		bounds.x = 17;
		bounds.y = 40;
		bounds.width = 38;
		bounds.height = 20;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.decorDesert[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
