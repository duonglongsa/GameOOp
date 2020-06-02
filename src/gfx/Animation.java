package gfx;

import java.awt.image.BufferedImage;

import Entity.Player;
import Main.Handler;

public class Animation {

	protected int speed, index;
	protected long lastTime, timer;
	protected BufferedImage[] frames;
	protected Handler handler;

	public Animation(int speed, BufferedImage[] frames, Handler handler) {
		this.speed = speed;
		this.frames = frames;
		this.handler = handler;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
				
			}
		}
	}

	public void attackTick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}
		}
	}

	public BufferedImage getCurrentFrame() {
			return frames[index];
		}

}
