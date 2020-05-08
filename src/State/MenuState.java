package State;

import java.awt.Graphics;

import Main.Handler;
import gfx.Assets;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(120, 300, 360, 70, Assets.button_play, new ClickListener() {		//tao nut play
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
				handler.getMouseManager().setUIManager(null);
			}
		}));
		
		uiManager.addObject(new UIImageButton(120, 380, 360, 70, Assets.button_settings, new ClickListener() {	//tao nut settings
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UIImageButton(120, 460, 360, 70, Assets.button_exit, new ClickListener() {		//tao nut exit
			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
		
		uiManager.addObject(new UIImageButton(530, 440, 45, 45, Assets.share, new ClickListener() {				//tao nut share
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UIImageButton(530, 490, 45, 45, Assets.google, new ClickListener() {			//tao nut google
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UIImageButton(530, 540, 45, 45, Assets.facebook, new ClickListener() {			//tao nut facebook
			@Override
			public void onClick() {
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, -100, -100, null);		//hinh nen Menu
		uiManager.render(g);
	}
}