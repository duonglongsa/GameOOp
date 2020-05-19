package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Handler;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;

	// attack
	public boolean attack, skill;
	public boolean talk;
	// timer
	private long lastTime, timer, cooldown = 200;
	// flag
	private boolean flag = false;
	// mana
	private int a = 10, b = 4;

	public KeyManager() {
		keys = new boolean[256];
	}

	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];

		attack = keys[KeyEvent.VK_A];
		skill = keys[KeyEvent.VK_S];
		talk = keys[KeyEvent.VK_E];
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = true;

//		lastTime = System.currentTimeMillis();
//		timer += System.currentTimeMillis() - lastTime;
//
//		if (timer < cooldown) {
//			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S) {
//				keys[e.getKeyCode()] = false;
//
//			}
//		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = false;
//		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S) {
//			keys[e.getKeyCode()] = true;
//
//		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
