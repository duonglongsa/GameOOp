package statics.entity.wind;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingWind1 extends StaticEntity{
	public BuildingWind1(Handler handler, float x, float y) {
		super(handler, x, y, 126, 170);
		
		bounds.x = 18;
		bounds.y = 110;
		bounds.width = 115;
		bounds.height = 50;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingWind[1], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
