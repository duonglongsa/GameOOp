package state;

import java.awt.Desktop;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import entity.LizardEnemy;
import main.Handler;
import gfx.Assets;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;
import utils.AudioClip;
import utils.AudioPlayer;

public class MenuState extends State { 
	
	public static int mode ;
	
	private UIManager uiManager;
	//public static UIManager uiManager;
	public AudioClip map1Music = new AudioClip("Map1Music.wav");
	public AudioClip menuMusic = new AudioClip("MenuMusic.wav");
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		AudioPlayer.playSound(menuMusic);																		//phat nhac menu
		
		uiManager.addObject(new UIImageButton(460, 470, 360, 70, Assets.easy, new ClickListener() {				//tao nut easy
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
				handler.getMouseManager().setUIManager(null);
				AudioPlayer.stopSound(menuMusic);
				AudioPlayer.playSound(map1Music);																//phat nhac map1
				mode = 1;
				
				LizardEnemy.lizardHelath = 50;
			}
		}));
		
		uiManager.addObject(new UIImageButton(460, 550, 360, 70, Assets.hard, new ClickListener() {				//tao nut hard
			@Override
			public void onClick() {

				//State.setState(handler.getGame().chooseState);
				//handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				handler.getMouseManager().setUIManager(null);
				AudioPlayer.stopSound(menuMusic);
				AudioPlayer.playSound(map1Music);
				mode = 2;
				
				LizardEnemy.lizardHelath = 100;
			}
		}));
		
		if(handler.getGame().q == 1) {
			AudioPlayer.stopSound(map1Music);
		}
		
		uiManager.addObject(new UIImageButton(1200, 600, 45, 45, Assets.settings, new ClickListener() {			//tao nut settings
			@Override
			public void onClick() {
			}
		}));
		
		uiManager.addObject(new UIImageButton(1200, 650, 45, 45, Assets.exit, new ClickListener() {				//tao nut exit
			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
		
		//uiManager.addObject(new UIImageButton(1200, 10, 45, 45, Assets.share, new ClickListener() {			//tao nut share

		uiManager.addObject(new UIImageButton(1200, 10, 45, 45, Assets.github, new ClickListener() {			//tao nut github

			@Override
			public void onClick() {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("https://github.com/ldlongsa/GameOOp"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		
		uiManager.addObject(new UIImageButton(1200, 60, 45, 45, Assets.google, new ClickListener() {			//tao nut google
			@Override
			public void onClick() {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("https://www.google.com/"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		
		uiManager.addObject(new UIImageButton(1200, 110, 45, 45, Assets.facebook, new ClickListener() {			//tao nut facebook
			@Override
			public void onClick() {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("https://www.facebook.com/long.leduong.5"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	int bgX = -140;
	int j = 1;
	
	@Override
	public void render(Graphics g) {
		j++;
		if(bgX == 0)															//background chuyen dong
			g.drawImage(Assets.background, bgX, -10, null);
		else if(j % 10 == 0) 
			g.drawImage(Assets.background, bgX++, -10, null);
		else 
			g.drawImage(Assets.background, bgX, -10, null);
		
		g.drawImage(Assets.playBackground, 385, 375, 500, 320, null);			//render o PLAY
		uiManager.render(g);													//render cac nut
	}
	
}