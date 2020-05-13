package gfx;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import Main.Handler;

public class AttackAnimation extends Animation implements KeyListener{

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private Handler handler;
	public boolean attack,skill;
	private int check;
	
	public AttackAnimation(int speed, BufferedImage[] frames, Handler handler) {
		super(speed, frames, handler);
		this.handler = handler;
		this.index = 0;
		this.timer = 0;
		lastTime = System.currentTimeMillis();
	}

	public void atick() {
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

	@Override
	public void keyTyped(KeyEvent e) {
		check = 1;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		check = 2;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		check = 3;
	}

		
}

