package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingDesert1 extends StaticEntity{
	public BuildingDesert1(Handler handler, float x, float y) {
		super(handler, x, y, 148, 148);
		
		bounds.x = 5;
		bounds.y = 32*2 + 25;
		bounds.width = 55*2 + 20;
		bounds.height = 24*2 - 5;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingDesert[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
