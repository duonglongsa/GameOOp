package Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Main.Handler;
import gfx.Animation;
import gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//chinh kich thuoc va cham
		bounds.x = 8;
		bounds.y = 30;
		bounds.width = 19;
		bounds.height = 30;
		
		//Animations
		animDown = new Animation(180, Assets.player_down);
		animUp = new Animation(180, Assets.player_up);
		animLeft = new Animation(180, Assets.player_left);
		animRight = new Animation(180, Assets.player_right);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = - speed;
		}
		
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		
		if(handler.getKeyManager().left) {
			xMove = - speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEtity(this);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage( getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), 32, 64, null);
		
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//				   (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//				   bounds.width, bounds.height);
		
	}

	public BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}else {
			return animDown.getCurrentFrame();
		}
	}

	
	
}
