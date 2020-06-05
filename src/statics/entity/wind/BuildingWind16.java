package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;

public class BuildingWind16 extends StaticEntity{
	public BuildingWind16(Handler handler, float x, float y) {
		super(handler, x, y, 126, 140);
		
		bounds.x = 15;
		bounds.y = 80;
		bounds.width = 88;
		bounds.height = 55;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[16], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
