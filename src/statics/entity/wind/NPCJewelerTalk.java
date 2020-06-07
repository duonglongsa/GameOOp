package statics.entity.wind;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import entity.StaticEntity;
import gfx.Assets;
import main.Game;
import main.Handler;

public class NPCJewelerTalk extends StaticEntity {

	public static int index;
	private static int timer = 0;

	public NPCJewelerTalk(Handler handler, float x, float y) {
		super(handler, x, y, 50, 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if (timer < 300) {
			timer++;
		} else {
			if (handler.getKeyManager().talk == true && index < 7) {

				index++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	@Override
	public void render(Graphics g) {
		if (index == 6) {
			if (handler.getWorld().getLizardEnemy().isActive() == false) {
				g.drawImage(Assets.npcJeweler_talk[index], (int) x, (int) y, null);
			}
		} else if (index < 7 && timer == 300) {
			g.drawImage(Assets.npcJeweler_talk[index], (int) x, (int) y, null);
		}
	}

	@Override
	public void die() {

	}

}
