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
	private boolean[] keys;
	public boolean attack,skill;
	
	public AttackAnimation(int speed, BufferedImage[] frames, Handler handler) {
		super(speed, frames, handler);
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		keys = new boolean[265];
	}

	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			for(index=0; index <= frames.length; index++) {
				index++;
			}
			index = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}
	
		
}

