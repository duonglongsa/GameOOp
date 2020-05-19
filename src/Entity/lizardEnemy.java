package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Handler;
import gfx.Animation;
import gfx.Assets;

public class lizardEnemy extends Creature{

	public lizardEnemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	// Animations
		private Animation animLeft, animRight;
		private Animation aLeft, aRight;
		private Animation hurtLeft, hurtRight;
		private Animation dieLeft, dieRight; 
		
		private boolean isHurtRight, isHurtLeft; // kiểm tra enemy đang bị đánh ở hướng nào
		
		// attack cooldown
		private long lastAttackTimer, attackCooldown = 50, attackTimer = attackCooldown;
		// directions
		private int direction = 0;

		public lizardEnemy(Handler handler, float x, float y) {
			super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);

			// chinh kich thuoc va cham
			bounds.x = 8;
			bounds.y = 30;
			bounds.width = 19;
			bounds.height = 30;

			// Animations
			animLeft = new Animation(180, Assets.lizard_left, handler);
			animRight = new Animation(180, Assets.lizard_right, handler);

			// attack animations
			aLeft = new Animation(180, Assets.lizard_attack_left, handler);
			aRight = new Animation(180, Assets.lizard_attack_right, handler);
			
			// hurt animations
			hurtLeft = new Animation(180, Assets.lizard_hurt_left, handler);
			hurtRight = new Animation(180, Assets.lizard_hurt_right, handler);
			
			// die animations
			dieLeft = new Animation(180, Assets.lizard_die_left, handler);
			dieRight = new Animation(180, Assets.lizard_die_right, handler);
			
		}


		@Override
		public void tick() {
			// Animations
			animLeft.tick();
			animRight.tick();
			
			hurtRight.tick();
			hurtLeft.tick();
			
			dieLeft.tick();
			dieRight.tick();
			
			move();
			//
			aLeft.attackTick();
			aRight.attackTick();		
			// attack
			checkAttack();
		}
		
		private boolean isNearPlayer(Rectangle a, Rectangle b) {
			if (a.intersects(b))
				return true;
			else {
				return false;
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

			if (isNearPlayer(handler.getWorld().getEntityManager().getPlayer().getBounds(), this.getBounds())  ) {
				if (isDownPlayer()) { // facing up
					ar.x = cb.x + cb.width / 2 - arSize / 2;
					ar.y = cb.y - arSize;
				} else if (isUpPlayer()) { // facing down
					ar.x = cb.x + cb.width / 2 - arSize / 2;
					ar.y = cb.y + cb.height;
				} else if (isRightPlayer()) { // facing left
					ar.x = cb.x - arSize;
					ar.y = cb.y + cb.height / 2 - arSize / 2;
				} else if (isLeftPlayer()) { // facing right
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
//							if (isLeftPlayer())
//								isHurtLeft = true;
//							if (isLeftPlayer())
//								isHurtRight = true;
//						
					}
				}
			}
			}

		

		@Override
		public void die() {
				
		}

		private boolean isLeftPlayer() {
			if (handler.getWorld().getEntityManager().getPlayer().getY() >= this.getY() + 32 && handler.getWorld().getEntityManager().getPlayer().getY() <= this.getY() - 32)
				return false;
			if (handler.getWorld().getEntityManager().getPlayer().getX() >= this.getX() + 32)
				return false;
			return true;
		}
		
		private boolean isRightPlayer() {
			if (handler.getWorld().getEntityManager().getPlayer().getY() != this.getY())
				return false;
			if (handler.getWorld().getEntityManager().getPlayer().getX() != this.getX() - 32)
				return false;
			return true;
		}
		
		private boolean isUpPlayer() {
			if (handler.getWorld().getEntityManager().getPlayer().getX() != this.getX())
				return false;
			if (handler.getWorld().getEntityManager().getPlayer().getY() != this.getY() + 1)
				return false;
			return true;
		}
		
		private boolean isDownPlayer() {
			if (handler.getWorld().getEntityManager().getPlayer().getY() != this.getY())
				return false;
			if (handler.getWorld().getEntityManager().getPlayer().getX() != this.getX() + 1)
				return false;
			return true;
		}
		
		@Override
		public void render(Graphics g) {
			if (direction == 1 || direction == 3 || direction == 0) { // facing up or right
				if (true) {
					g.drawImage(aRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
							(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
				} else {
					g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
							(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
				}
			} else if (direction == 0 || direction == 2 || direction == 1) {
				if (true) {
					g.drawImage(aLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
							(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
				} else {
					g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
							(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
				}
			}
			
			
//			if (this.health == 0 && isRightPlayer()) {	// đứng bên phải player và bị player tấn công
//				g.drawImage(dieLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
//						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
//			}
//			
//			if (this.health == 0 && isLeftPlayer()) {	// đứng bên trái player và bị player tấn công
//				g.drawImage(dieRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
//						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
//			}
			
//			if (isHurtLeft) {
//				g.drawImage(hurtLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
//					(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
//				isHurtLeft = false;
//			}
//			
//			if (isHurtRight) {
//				g.drawImage(hurtRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
//						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
//				isHurtRight = false;
//			}
				

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
					return animLeft.getCurrentFrame();
				} else {
					direction = 0;
					return animRight.getCurrentFrame();
				}
			} else {
				return Assets.lizard_directions[direction];
			}

		}
}
