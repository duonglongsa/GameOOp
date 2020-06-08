package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.BufferedImage;
import java.util.IllegalFormatCodePointException;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import gfx.Animation;
import main.Handler;

public class Enemy extends Creature {

	// Animations
	protected Animation animLeft, animRight;
	protected Animation aLeft, aRight;

	// attack cooldown
	protected long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;

	// directions
	protected int direction = 3;

	protected Animation hurtLeft, hurtRight;
	protected Animation dieLeft, dieRight;
	protected boolean isHurtRight, isHurtLeft; //

	// moving
	protected boolean xMoveDirection = true;
	protected boolean yMoveDirection = false;

	// attack range
	protected Rectangle atkRange;

	private float spawnY, spawnX;

	public Enemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.spawnY = y;
		this.spawnX = x;
	}

	@Override
	public void tick() {
		this.atkRange = new Rectangle((int) (x - 80), (int) (y - 50), 200, 200);

		// Animations
		animLeft.tick();
		animRight.tick();

		hurtRight.tick();
		hurtLeft.tick();

		dieLeft.tick();
		dieRight.tick();

		// moving
		moveAfterPlayer();

		//
		aLeft.tick();
		aRight.tick();

		// attack
		checkAttack();

	}

	@Override
	public void render(Graphics g) {

		g.drawRect((int) (x - 80), (int) (y - 50), 200, 200);

		if (direction == 1 || direction == 3) { // facing up or right
			if (isLeftPlayer()) {
				g.drawImage(aLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (direction == 3) { // moving right
				g.drawImage(animRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		} else if (direction == 0 || direction == 2) {
			if (isRightPlayer()) {
				g.drawImage(aRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (direction == 2) { // moving left
				g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		}

	}

	protected boolean isNearPlayer(Rectangle a, Rectangle b) {
		if (a.intersects(b))
			return true;
		else {
			return false;
		}

	}

	protected boolean isLeftPlayer() {
		if (handler.getWorld().getEntityManager().getPlayer().getX() < this.getX()
				&& handler.getWorld().getEntityManager().getPlayer().getY() < this.getY() + 32
				&& handler.getWorld().getEntityManager().getPlayer().getY() > this.getY() - 32
				&& handler.getWorld().getEntityManager().getPlayer().getX() > this.getX() - 32) {

			return true;
		}

		return false;
	}

	protected boolean isRightPlayer() {
		if (handler.getWorld().getEntityManager().getPlayer().getX() > this.getX()
				&& handler.getWorld().getEntityManager().getPlayer().getY() < this.getY() + 32
				&& handler.getWorld().getEntityManager().getPlayer().getY() > this.getY() - 32
				&& handler.getWorld().getEntityManager().getPlayer().getX() < this.getX() + 32) {

			return true;
		}

		return false;
	}

	protected void checkAttack() {
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

		if (isLeftPlayer()) { // facing left
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (isRightPlayer()) { // facing left
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}
		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			} else if (e.equals(handler.getWorld().getEntityManager().getPlayer())) {
				if (e.getCollisionBounds(3, 0).intersects(ar)) {
					e.hurt((int) this.getAtkDame());
					e.setHurt(true);
					if (this.getHealth() < 10) {
						e.setHurt(false);
					}
				} else {
					e.setHurt(false);

				}
			}
		}

	}

	public void moveAround() {

		if (isLeftPlayer() || isRightPlayer()) {
			return;
		} else if (this.getY() < spawnY) {
			this.yMove = this.speed;
			super.moveY();
			this.y = (int) this.getY();
		} else if (this.getY() > spawnY) { // back to spawn position
			this.yMove = - this.speed;
			super.moveY();
			this.y = (int) this.getY();
		} else if (direction == 3) {
			if (this.getX() < this.spawnX + 100) {
				this.xMove = this.speed;
				super.moveX();
			} else {
				direction = 2;
			}
		} else if (direction == 2) {
			if (this.getX() > this.spawnX - 100) {
				this.xMove = - this.speed;
				super.moveX();
			} else {
				direction = 3;
			}
		}
	}

	public void moveAfterPlayer() {

		if (isNearPlayer(this.getAtkRange(),
				handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(10, 0))) {
			if (!isNearPlayer(this.getCollisionBounds(0, 0),
					handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {

				float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
				float playerY = handler.getWorld().getEntityManager().getPlayer().getY();

				this.xMove = (playerX - this.x) / 70 ;
				this.yMove = (playerY - this.y) / 70;

				if (xMove > 0) { // change direction when move after player
					this.direction = 3;
				} else {
					this.direction = 2;
				}

				super.moveX();
				super.moveY();
			}
		} else {
			moveAround();
		}
	}

	public BufferedImage getCurrentAnimationFrame() {
		if (xMoveDirection) {
			return animRight.getCurrentFrame();
		} else {
			return animLeft.getCurrentFrame();
		}

	}

	public Rectangle getAtkRange() {
		return atkRange;
	}

	public void setAtkRange(Rectangle atkRange) {
		this.atkRange = atkRange;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

}
