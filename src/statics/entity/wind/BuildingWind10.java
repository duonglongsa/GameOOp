package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind10 extends StaticEntity{
	public BuildingWind10(Handler handler, float x, float y) {
		super(handler, x, y, 130, 150);
		
		bounds.x = 5;
		bounds.y = 100;
		bounds.width = 110;
		bounds.height = 45;	
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[10], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
