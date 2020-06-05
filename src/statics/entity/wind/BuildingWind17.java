package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;
public class BuildingWind17 extends StaticEntity{
	public BuildingWind17(Handler handler, float x, float y) {
		super(handler, x, y, 156, 176);
		
		bounds.x = 24;
		bounds.y = 90;
		bounds.width = 110;
		bounds.height = 80;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[17], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
