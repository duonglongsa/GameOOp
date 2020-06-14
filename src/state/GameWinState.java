package state;

import java.awt.Graphics;

import gfx.Assets;
import main.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

public class GameWinState extends State{
	
	private UIManager uiManager;
	
	public GameWinState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(1200, 650, 45, 45, Assets.exit, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
		
		uiManager.addObject(new UIImageButton(400, 440, 500, 150, Assets.thanks, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	int bgX = -890;
	int j = 1;
	
	@Override
	public void render(Graphics g) {
		j++;
		if(bgX == 0)
			g.drawImage(Assets.ninja, bgX, -220, null);
		else if(j % 10 == 0) 
			g.drawImage(Assets.ninja, bgX++, -220, null);
		else 
			g.drawImage(Assets.ninja, bgX, -220, null);
		
		g.drawImage(Assets.youwin, 150, 100, null);
		uiManager.render(g);
	}

}