package statics.entity.wind;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingWind4 extends StaticEntity{
	public BuildingWind4(Handler handler, float x, float y) {
		super(handler, x, y, 126, 170);
		
		bounds.x = 6;
		bounds.y = 100;
		bounds.width = 113;
		bounds.height = 45;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[4], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
