package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind15 extends StaticEntity{
	public BuildingWind15(Handler handler, float x, float y) {
		super(handler, x, y, 166, 150);
		
		bounds.x = 6;
		bounds.y = 80;
		bounds.width = 155;
		bounds.height = 65;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[15], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
