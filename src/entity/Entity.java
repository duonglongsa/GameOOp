package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Handler;

public abstract class Entity {

	protected Handler handler;
	public static final int HEALTH = 1000;
	protected float x, y;
	protected int width, height;
	protected int health;
	protected boolean active = true; // if that entity still exit
	protected Rectangle bounds;
	protected boolean isHurt = false;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		health = HEALTH;
		this.bounds = new Rectangle((int) x, (int) y, width, height);
	}

	public abstract void tick();

	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return bounds;
	}

	public abstract void die();
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void hurt(int amt) {
		this.health -= amt;
		if(health <= 0) {
			active = false;
			
		}
	}
	
	

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffSet) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffSet), bounds.width,
				bounds.height);
	}

	// GETTER - SETTER
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	} 


	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isHurt() {
		return isHurt;
	}

	public void setHurt(boolean isHurt) {
		this.isHurt = isHurt;
	}
	


}
