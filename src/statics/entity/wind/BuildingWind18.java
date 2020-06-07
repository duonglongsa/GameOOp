package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind18 extends StaticEntity{
	public BuildingWind18(Handler handler, float x, float y) {
		super(handler, x, y, 156, 170);
		
		bounds.x = 18;
		bounds.y = 110;
		bounds.width = 135;
		bounds.height = 50;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[18], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
