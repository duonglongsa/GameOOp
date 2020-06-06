package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.Assets;
import main.Handler;

public class MedusaBullet extends Creature{
	
	
	public MedusaBullet(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 10;
		bounds.height = 10;

		this.active = false;
		
		this.speed = 3.0f;
	}

	@Override
	public void tick() {
		
		
		
		bulletMove();
		checkAttack();

	}

	private void checkAttack() {
				
		Rectangle a = new Rectangle();
		a.x = 100;
		a.y = 200;
		a.width = 300;
		a.height = 400;
		
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).
				intersects(handler.getWorld().getMedusaEnemy().getAtkRange())) {
//			handler.getWorld().getEntityManager().addEntity(new MedusaBullet(handler, 200, 200, 200, 200));
			this.setActive(true);
		}
		
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).
				intersects(this.getCollisionBounds(0, 0))) {
			MedusaEnemy.temp = 0;
			handler.getWorld().getEntityManager().getEntities().remove(this);
			handler.getWorld().getEntityManager().getPlayer().isHurt = true;
						
		}
		if(handler.getWorld().getMedusaEnemy().isActive() == false) {
			handler.getWorld().getEntityManager().getPlayer().isHurt = false;
			
		}
		
	}
	
	private void bulletMove() {
		if(this.active) {

			float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
			float playerY = handler.getWorld().getEntityManager().getPlayer().getY();
			
			float xMove = (playerX + 10 - this.x)/5;
			float yMove = (playerY + 30 - this.y)/5;
			
			
			this.setX(this.getX() + xMove);
			this.setY(this.getY() + yMove);
		
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.medusa_bullet, (int) x , (int) y , 32, 32,  null);
		
	}
	
	

	@Override
	public void die() {
		
		
	}
	
	
	
}