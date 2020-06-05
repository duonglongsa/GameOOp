package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;
public class BuildingWind3 extends StaticEntity{
	public BuildingWind3(Handler handler, float x, float y) {
		super(handler, x, y, 126, 100);
		
		bounds.x = 10;
		bounds.y = 60;
		bounds.width = 113;
		bounds.height = 30;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[3], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
