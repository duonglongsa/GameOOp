package statics.entity.desert;

import java.awt.Graphics;

import Entity.StaticEntity;
import Main.Handler;
import gfx.Assets;

public class BuildingDesert3 extends StaticEntity{
	public BuildingDesert3(Handler handler, float x, float y) {
		super(handler, x, y, 80, 120);
		
		bounds.x = 10;
		bounds.y = 72;
		bounds.width = 60;
		bounds.height = 38;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.buildingDesert[2], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
