package gfx;

import java.awt.image.BufferedImage;

import main.Handler;

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

	public void skillTick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public BufferedImage getCurrentFrame() {
		return frames[index];
	}


}
