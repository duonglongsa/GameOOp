package gfx;

import java.awt.image.BufferedImage;

import Main.Handler;

public class AttackAnimation extends Animation{

	public AttackAnimation(int speed, BufferedImage[] frames, Handler handler) {
		super(speed, frames, handler);
		
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
	
	public void coolDown() {
		
	}
}
