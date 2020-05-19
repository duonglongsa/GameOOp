package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Handler;
import gfx.Animation;
import gfx.Assets;
import statics.entity.wind.NPCJeweler;

public class Player extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Animation aLeft, aRight, extraLeft, extraRight;
	// attack cooldown
	private long lastAttackTimer, attackCooldown = 50, attackTimer = attackCooldown;
	// directions
	private int direction = 0;
	//Player-bar
	private double health = 100, totalMana = 100, mana = 100;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);
		
		health =1;

		// chinh kich thuoc va cham
		bounds.x = 8;
		bounds.y = 30;
		bounds.width = 19;
		bounds.height = 30;

		// Animations
		animDown = new Animation(180, Assets.player_down, handler);
		animUp = new Animation(180, Assets.player_up, handler);
		animLeft = new Animation(180, Assets.player_left, handler);
		animRight = new Animation(180, Assets.player_right, handler);

		// attack animations
		aLeft = new Animation(180, Assets.attack_left, handler);
		aRight = new Animation(180, Assets.attack_right, handler);
	
		extraLeft = new Animation(90, Assets.extra_left, handler);
		extraRight = new Animation(90, Assets.extra_right, handler);


	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

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
		
		//skill
		extraLeft.tick();
		extraRight.tick();
			
		/*
		 * aLeft.tick(); aRight.tick(); extraLeft.tick(); extraRight.tick();
		 */
		//
		
		// attack
		checkAttack();

		
		//Player-bar
		if(handler.getKeyManager().skill) {
			if(mana > 0) {
				mana -= 0.2;
			}else {
				handler.getKeyManager().skill = false;
			}
		}
		if(mana <= totalMana) {
					mana += 0.01;
		}

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
				} 
				else if (e.getCollisionBounds(0, 0).intersects(ar)) {
						e.hurt(1);
					}
				}
			}

		}

	

	@Override
	public void die() {

	}

	@Override
	public void render(Graphics g) {
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
	
	public void postRender(Graphics g) {
		//Player-bar
		g.setColor(Color.red);
		g.fillRect(73, 30, 127, 12);				
								
		g.setColor(Color.blue);
		g.fillRect(73, 46, (int) (122 *  (mana / totalMana)), 6);
			
		g.drawImage(Assets.playerBar, 0, 0, null);
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
