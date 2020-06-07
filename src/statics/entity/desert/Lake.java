package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class Lake extends StaticEntity{
	public Lake(Handler handler, float x, float y) {
		super(handler, x, y, 170, 80);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 170;
		bounds.height = 70;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.lakeDesert, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
