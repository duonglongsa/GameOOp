package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind12 extends StaticEntity{
	public BuildingWind12(Handler handler, float x, float y) {
		super(handler, x, y, 105, 250);
		
		bounds.x = 13;
		bounds.y = 200;
		bounds.width = 94;
		bounds.height = 40;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[12], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
