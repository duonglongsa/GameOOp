package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.cert.CertPathChecker;
import java.awt.Rectangle;

import gfx.Animation;
import gfx.Assets;
import main.Handler;
import utils.AudioClip;
import utils.AudioPlayer;

public class Player extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Animation aLeft, aRight, extraLeft, extraRight;
	private Animation dieLeft, dieRight, hurtLeft, hurtRight;

	// attack cooldown
	private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
	public static boolean check = false;
	public static boolean check2 = false;

	
	// directions
	private int direction = 0;

	// Player-bar
	private double totalHealth = HEALTH, totalMana = 100, mana = 100;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);
		this.atkDame = 3;
		this.health = HEALTH;

		// chinh kich thuoc va cham
		bounds.x = 8;
		bounds.y = 30;
		bounds.width = 19;
		bounds.height = 30;
		this.health = HEALTH;

		// Animations
		animDown = new Animation(180, Assets.player_down, handler);
		animUp = new Animation(180, Assets.player_up, handler);
		animLeft = new Animation(180, Assets.player_left, handler);
		animRight = new Animation(180, Assets.player_right, handler);

		// attack animations
		aLeft = new Animation(120, Assets.attack_left, handler);
		aRight = new Animation(120, Assets.attack_right, handler);

		extraLeft = new Animation(90, Assets.extra_left, handler);
		extraRight = new Animation(90, Assets.extra_right, handler);
		// die
		dieLeft = new Animation(30, Assets.die_left, handler);
		dieRight = new Animation(30, Assets.die_right, handler);
		// hurt
		hurtLeft = new Animation(90, Assets.hurt_left, handler);
		hurtRight = new Animation(90, Assets.hurt_right, handler);
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
		// chinh kich thuoc va cham

		if(this.isHurt()) {
			AudioClip hurtAudioClip = new AudioClip("death1.wav");
			AudioPlayer.playSound(hurtAudioClip);
		}

		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		hurtLeft.tick();
		hurtRight.tick();
		dieLeft.tick();
		dieRight.tick();

		getInput();
		move();
		handler.getGameCamera().centerOnEtity(this);

		// attack
		aLeft.tick();
		aRight.tick();

		// skill
		extraLeft.tick();
		extraRight.tick();

		// attack
		checkAttack();
		// die

		// Player-bar
		if (this.isHurt) {
			if (health > 0) {
				health -= 1;

			} else {
				active = false;
				check = true;
			}
		}
		if (handler.getKeyManager().skill) {
			if (mana > 0) {
				mana -= 0.2;
			} else {
				handler.getKeyManager().skill = false;
			}
		}
		if (mana <= totalMana) {
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
			
			AudioClip attackAudioClip = new AudioClip("skill.wav");
			AudioPlayer.playSound(attackAudioClip);
			
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
				} else if (e.getCollisionBounds(0, 0).intersects(ar)) {
					e.hurt((int) this.getAtkDame() );
					if(e.equals(handler.getWorld().getLizardEnemy())) {

						System.out.println(e.getHealth());
						
					}
				}
			}
		}

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.red);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

		if (direction == 1 || direction == 3) { // facing up or right
			if (handler.getKeyManager().attack) {
				g.drawImage(aRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (handler.getKeyManager().skill) {
				g.drawImage(extraRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (this.isActive() == false) {
				g.drawImage(dieRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);

			} else if (this.isHurt) {
				g.drawImage(hurtRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);

			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		} else if (direction == 0 || direction == 2) { // facing left or down
			if (handler.getKeyManager().attack) {
				g.drawImage(aLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (handler.getKeyManager().skill) {
				g.drawImage(extraLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (this.isActive() == false) {
				g.drawImage(dieLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (this.isHurt) {
				g.drawImage(hurtLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		}

	}

	public void postRender(Graphics g) {
		// Player-bar
		g.setColor(Color.red);
		g.fillRect(73, 30, (int) (127 * (health / totalHealth)), 12);

		g.setColor(Color.blue);
		g.fillRect(73, 46, (int) (122 * (mana / totalMana)), 6);

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

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

}
