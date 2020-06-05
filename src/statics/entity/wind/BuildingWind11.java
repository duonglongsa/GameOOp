package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;

public class BuildingWind11 extends StaticEntity{
	public BuildingWind11(Handler handler, float x, float y) {
		super(handler, x, y, 126, 170);
		
		bounds.x = 17;
		bounds.y = 105;
		bounds.width = 98;
		bounds.height = 65;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[11], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
