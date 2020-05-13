package statics.entity.wind;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingWind13 extends StaticEntity{
	public BuildingWind13(Handler handler, float x, float y) {
		super(handler, x, y, 126, 150);
		
		bounds.x = 15;
		bounds.y = 80;
		bounds.width = 95;
		bounds.height = 70;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[13], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
