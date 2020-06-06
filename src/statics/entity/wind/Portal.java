package statics.entity.wind;

import java.awt.Graphics;

import entity.StaticEntity;
import gfx.Assets;
import gfx.PortalAnimation;
import main.Handler;

public class Portal extends StaticEntity{

	private PortalAnimation portalAnimation;
	public static boolean check = false;
	
	public Portal(Handler handler, float x, float y) {
		super(handler, x, y, 100, 100);
		
		bounds.x = 40;
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 120;
		
		portalAnimation = new PortalAnimation(180, Assets.portal_open, handler);
	}

	@Override
	public void tick() {
		portalAnimation.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(portalAnimation.getCurrentFrame(), (int) x, (int) y, 128, 128, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
