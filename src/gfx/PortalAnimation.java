package gfx;

import java.awt.image.BufferedImage;

import main.Handler;
import statics.entity.wind.Portal;

public class PortalAnimation extends Animation {

	public PortalAnimation(int speed, BufferedImage[] frames, Handler handler) {
		super(speed, frames, handler);

	}

	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index == 15) {

				index = 8;

				if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(3, 0)
						.intersects(handler.getWorld().getPortal().getCollisionBounds(0, 0))) {
					 index = 16;
					 handler.getWorld().getEntityManager().getEntities().remove(handler.getWorld().getEntityManager().getPlayer());					
				}
			}
			if (index > 19) {
				handler.getWorld().getEntityManager().getEntities().remove(handler.getWorld().getPortal());
				Portal.check =  true;
			}
		}
	}

}
