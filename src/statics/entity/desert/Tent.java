package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;


import gfx.Assets;

public class Tent extends StaticEntity{
	public Tent(Handler handler, float x, float y) {
		super(handler, x, y, 100, 100);
		
		bounds.x = 100;
		bounds.height = 50;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tentDesert, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
