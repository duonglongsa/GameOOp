package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
<<<<<<< HEAD
=======
	//attack
	public boolean attack,skill;
>>>>>>> 4f7685013dde6f2bad7d1f15a0b528de19608b39
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up 		= keys[KeyEvent.VK_UP];
		down 	= keys[KeyEvent.VK_DOWN];
		left 	= keys[KeyEvent.VK_LEFT];
		right 	= keys[KeyEvent.VK_RIGHT];
<<<<<<< HEAD
		
=======
		attack = keys[KeyEvent.VK_A];
		skill = keys[KeyEvent.VK_S];
>>>>>>> 4f7685013dde6f2bad7d1f15a0b528de19608b39
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	
}
