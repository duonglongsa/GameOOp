package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind7 extends StaticEntity{
	public BuildingWind7(Handler handler, float x, float y) {
		super(handler, x, y, 100, 130);
		
		bounds.x = 8;
		bounds.y = 70;
		bounds.width = 90;
		bounds.height = 40;	
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[7], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
