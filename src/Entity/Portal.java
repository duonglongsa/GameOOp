package entity;

import java.awt.Graphics;

import gfx.Animation;
import gfx.Assets;
import main.Handler;

public class Portal extends StaticEntity{

	private Animation portal_apr;
	
	public Portal(Handler handler, float x, float y) {
		super(handler, x, y, 100, 100);

		portal_apr = new Animation(180, Assets.portal_apr, handler);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		portal_apr.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(portal_apr.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), 128, 128, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
