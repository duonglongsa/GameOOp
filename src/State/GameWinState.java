package state;

import java.awt.Graphics;

import gfx.Assets;
import main.Handler;

public class GameWinState extends State{

	public GameWinState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics g) {
		
		int bgX = -140;
		int j = 1;
		
		j++;
		if(bgX == 0)															//background chuyen dong
			g.drawImage(Assets.background, bgX, -10, null);
		else if(j % 10 == 0) 
			g.drawImage(Assets.background, bgX++, -10, null);
		else 
			g.drawImage(Assets.background, bgX, -10, null);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
