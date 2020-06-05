package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;
public class BuildingWind9 extends StaticEntity{
	public BuildingWind9(Handler handler, float x, float y) {
		super(handler, x, y, 130, 110);
		
		bounds.x = 10;
		bounds.y = 60;
		bounds.width = 120;
		bounds.height = 40;	
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[9], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
