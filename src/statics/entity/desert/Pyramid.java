package statics.entity.desert;

import java.awt.Graphics;
import java.awt.image.renderable.RenderableImage;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class Pyramid extends StaticEntity{
	public Pyramid(Handler handler, float x, float y) {
		super(handler, x, y, 266, 196);
		
		bounds.x = 10;
		bounds.y = 73;
		bounds.width = 230;
		bounds.height = 105;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pyramidDesert, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
