package Entity;

import java.awt.Graphics;

import Main.Handler;
import State.MenuState;
import gfx.Animation;
import gfx.Assets;

public class medusaEnemy extends Enemy{
	
	public static int temp = 0;
	
	public medusaEnemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		//adjust bounds
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 32;
		bounds.height = 32;
		
		//animation
		animRight = new Animation(180, Assets.medusa_right, handler);
		animLeft = new Animation(180, Assets.medusa_left, handler);
		
		aRight = new Animation(180, Assets.medusa_attack_right, handler);
		aLeft = new Animation(180, Assets.medusa_attack_left, handler);
		
		hurtRight = new Animation(180, Assets.medusa_hurt_right, handler);
		hurtLeft = new Animation(180, Assets.medusa_hurt_left, handler);
		
		dieRight = new Animation(180, Assets.medusa_die_right, handler);
		dieLeft = new Animation(180, Assets.medusa_die_left, handler);
		
	}
	
	public void tick() {
		super.tick();
		bulletFire();
		
//		this.health = 50 * MenuState.mode;
		this.atkDame = 5 * MenuState.mode;
		this.speed = 1.0f * MenuState.mode;
	}
	
	public void render(Graphics g) {
		g.drawRect((int) (x - 80), (int) (y - 50), 200, 200);
		
		if (direction == 1 || direction == 3) { // facing up or right
			if(this.atkRange.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {
				g.drawImage(aRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}else if (direction == 3) { //moving right
				g.drawImage(animRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		} else if (direction == 0 || direction == 2 ) {
			if (this.atkRange.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {
				g.drawImage(aLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else if (direction == 2) { //moving left
				g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			} else {
				g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), 32, 64, null);
			}
		}
		
	}
	
	public void bulletFire() {
		if(this.getAtkRange().intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0))) {
			
			MedusaBullet a = new MedusaBullet(handler, this.x, this.y, 10, 10);
			if(!check()) {
				handler.getWorld().getEntityManager().addEntity(a);
				temp += 1;
			}
		}
	}
	
	public boolean check() {
		if(temp > 0) {
			return true;
		}
		
		return false;
	}
	
	
	

}