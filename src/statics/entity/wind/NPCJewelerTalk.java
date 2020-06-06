package statics.entity.wind;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import entity.StaticEntity;
import gfx.Assets;
import main.Game;
import main.Handler;

public class NPCJewelerTalk extends StaticEntity {

	public static int index;

	public NPCJewelerTalk(Handler handler, float x, float y) {
		super(handler, x, y, 50, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if (index < 7) {
			if(index == 5) {
				if(handler.getKeyManager().attack == true ) {
					index += 1;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (handler.getKeyManager().talk == true) {
				index += 1;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void render(Graphics g) {
		if(index < 7) {
			g.drawImage(Assets.npcJeweler_talk[index], (int) x, (int) y, null);
		}
	}

	@Override
	public void die() {

	}

}
