package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import main.Handler;
import gfx.Assets;
public class BuildingWind5 extends StaticEntity {
	public BuildingWind5(Handler handler, float x, float y) {
		super(handler, x, y, 136, 140);
		
		bounds.x = 10;
		bounds.y = 80;
		bounds.width = 113;
		bounds.height = 50;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[5], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
