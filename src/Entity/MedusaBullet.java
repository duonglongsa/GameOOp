package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Handler;
import gfx.Assets;

public class MedusaBullet extends Creature{
	
	
	public MedusaBullet(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 10;
		bounds.height = 10;

		this.active = false;
		
		this.speed = 5.0f;
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
			medusaEnemy.temp = 0;
			handler.getWorld().getEntityManager().getEntities().remove(this);
			handler.getWorld().getEntityManager().getPlayer().isHurt = true;
			this.setActive(false);
			
		}
		
	}
	
	private void bulletMove() {
		if(this.active) {

			float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
			float playerY = handler.getWorld().getEntityManager().getPlayer().getY();
			
			float xMove = (playerX + 10 - this.x)/10;
			float yMove = (playerY + 30 - this.y)/10;
			
			
			this.setX(this.getX() + xMove);
			this.setY(this.getY() + yMove);
		
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.medusa_bullet, (int) x , (int) y , 4, 4,  null);
		
	}
	
	

	@Override
	public void die() {
		
		
	}
	
	
	
}
