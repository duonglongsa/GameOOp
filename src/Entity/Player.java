package Entity;

import java.awt.Graphics;
<<<<<<< HEAD
import java.awt.image.BufferedImage;

import Main.Game;
=======
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
>>>>>>> 4f7685013dde6f2bad7d1f15a0b528de19608b39
import Main.Handler;
import gfx.Animation;
import gfx.Assets;

public class Player extends Creature {

	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//chinh kich thuoc va cham


	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Animation aLeft, aRight, extraLeft, extraRight;
	// attack cooldown
	private long lastAttackTimer, attackCooldown = 50, attackTimer = attackCooldown;
	// directions
	private int direction = 0;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);

		// chinh kich thuoc va cham
		bounds.x = 8;
		bounds.y = 30;
		bounds.width = 19;
		bounds.height = 30;


		// Animations
		animDown = new Animation(180, Assets.player_down);
		animUp = new Animation(180, Assets.player_up);
		animLeft = new Animation(180, Assets.player_left);
		animRight = new Animation(180, Assets.player_right);

		// attack animations
		aLeft = new Animation(180, Assets.attack_left);
		aRight = new Animation(180, Assets.attack_right);
		extraLeft = new Animation(180, Assets.extra_left);
		extraRight = new Animation(180, Assets.extra_right);

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = - speed;
		}
		
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		
		if(handler.getKeyManager().left) {
			xMove = - speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void tick() {
		//Animations

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}

		if (handler.getKeyManager().down) {
			yMove = speed;
		}

		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEtity(this);
		
		// attack
		aLeft.tick();
		aRight.tick();
		extraLeft.tick();
		extraRight.tick();

		getInput();
		move();
		handler.getGameCamera().centerOnEtity(this);
		// attack
		checkAttack();
	}

	private void checkAttack() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown) {
			return;
		}
		Rectangle cb = getCollisionBounds(0, 0); // get the collision bound
		Rectangle ar = new Rectangle(); // attack rectangle
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().attack || handler.getKeyManager().skill) {
			if (direction == 1) { // facing up
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			} else if (direction == 0) { // facing down
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y + cb.height;
			} else if (direction == 2) { // facing left
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			} else if (direction == 3) { // facing right
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			} else {
				return;
			}
			attackTimer = 0;

			for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if (e.equals(this)) {
					continue;
				} else {
					if (e.getCollisionBounds(0, 0).intersects(ar)) {
						e.hurt(1);
					}
				}
			}

		}

	}


	@Override
	public void die() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage( getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), 32, 64, null);
		
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//				   (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//				   bounds.width, bounds.height);
		
	}

	public BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}else {
			return animDown.getCurrentFrame();
		}
	}

	
	


		if (direction == 1 || direction == 3) { // facing up or right
			if (handler.getKeyManager().attack) {
				g.drawImage(aRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (handler.getKeyManager().skill) {
				g.drawImage(extraRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		} else if (direction == 0 || direction == 2) {
			if (handler.getKeyManager().attack) {
				g.drawImage(aLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (handler.getKeyManager().skill) {
				g.drawImage(extraLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		}

	}

	public BufferedImage getCurrentAnimationFrame() {
		if (xMove != 0 || yMove != 0) {
			if (xMove < 0) {
				direction = 2;
				return animLeft.getCurrentFrame();
			} else if (xMove > 0) {
				direction = 3;
				return animRight.getCurrentFrame();
			} else if (yMove < 0) {
				direction = 1;
				return animUp.getCurrentFrame();
			} else {
				direction = 0;
				return animDown.getCurrentFrame();
			}
		} else {
			return Assets.directions[direction];
		}

	}

}
