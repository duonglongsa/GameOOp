package statics.entity.desert;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;



public class Tree4 extends StaticEntity{
	public Tree4(Handler handler, float x, float y) {
		super(handler, x, y, 100, 150);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeDesert[4], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
