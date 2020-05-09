package statics.entity.wind;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingWind8 extends StaticEntity{
	public BuildingWind8(Handler handler, float x, float y) {
		super(handler, x, y, 200, 170);
		
		bounds.x = 30;
		bounds.y = 100;
		bounds.width = 150;
		bounds.height = 80;	
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[8], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
