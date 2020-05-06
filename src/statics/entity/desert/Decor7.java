package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class Decor7 extends StaticEntity{
	public Decor7(Handler handler, float x, float y) {
		super(handler, x, y, 70, 70);
		
		bounds.x = 10;
		bounds.y = 30;
		bounds.width = 50;
		bounds.height = 30;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.decorDesert[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
