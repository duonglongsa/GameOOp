package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind6 extends StaticEntity{
	public BuildingWind6(Handler handler, float x, float y) {
		super(handler, x, y, 110, 130);
		
		bounds.x = 10;
		bounds.y = 70;
		bounds.width = 90;
		bounds.height = 50;	
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[6], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
