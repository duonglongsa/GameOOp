package statics.entity.wind;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import entity.StaticEntity;
import gfx.Assets;
import main.Handler;



public class NPCJeweler extends StaticEntity{
	
	public static boolean check = false;

	public NPCJeweler(Handler handler, float x, float y) {
		super(handler, x, y, 50, 50);
		
		bounds.x = 0;
		bounds.y = 20;
		bounds.width = 50;
		bounds.height = 25;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void hurt(int amt) {
		// TODO Auto-generated method stub
		super.hurt(amt);
		check = true;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.npcJeweler[0], (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), 30, 64, null);
		
//		if(check) {
//			g.drawImage(Assets.npcJeweler[1], 300, 
//					200, null);
//			if(handler.getKeyManager().talk) {
//				check = false;
//			}
//		}
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public boolean getCheck() {
		return check;
	}


	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
