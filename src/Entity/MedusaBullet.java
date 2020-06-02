package Entity;

import java.awt.Graphics;
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
		
		this.speed = 2.5f;
	}

	@Override
	public void tick() {
		
		
		
		bulletMove();
		checkAttack();

	}

	private void checkAttack() {
		
		System.out.println(handler.getWorld().getMedusaEnemy().getAtkRange().getX());
		
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).
				intersects(handler.getWorld().getMedusaEnemy().getAtkRange())) {
			System.out.println("huy");
//			handler.getWorld().getEntityManager().addEntity(new MedusaBullet(handler, 200, 200, 200, 200));
			this.setActive(true);
		}
		
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).
				intersects(this.getCollisionBounds(0, 0))) {
			
			handler.getWorld().getEntityManager().getPlayer().isHurt = true;
			this.setActive(false);
			
		}
		
	}
	
	private void bulletMove() {
		if(this.active) {

			float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
			float playerY = handler.getWorld().getEntityManager().getPlayer().getY();
			
			float xMove = (playerX + 10 - this.x)/50;
			float yMove = (playerY + 30 - this.y)/50;
			
			
			this.setX(this.getX() + xMove);
			this.setY(this.getY() + yMove);
		
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.medusa_bullet, (int) x + 50, (int) y + 50, 20, 20,  null);
		
	}
	
	

	@Override
	public void die() {
		
		
	}
	
	
	
}
