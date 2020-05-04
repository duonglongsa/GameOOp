package Entity;

import Main.Game;
import Main.Handler;
import tile.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_CREATURE_WIDHT = 35,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = 2.5f;
		health = 100;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f)) {
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove)) {
			moveY();
		}
	}
	
	public void moveX() {
		if(xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) &&				//goc tren ben phai
			   !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //goc duoi ben phai
				x += xMove;
			}
			
		}else if(xMove < 0){
			int tx = (int) (x + xMove + bounds.x ) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) &&				//goc tren ben trai
			   !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //goc duoi ben trai
				x += xMove;
			}
		}
	}
	
	public void moveY() {
		if(yMove > 0) {
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x + bounds.width + bounds.x) / Tile.TILE_WIDTH, ty) &&
			   !collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
		}else if(yMove < 0) {
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x + bounds.width + bounds.x) / Tile.TILE_WIDTH, ty) &&
			   !collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	//GETTER - SETTER
	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}
