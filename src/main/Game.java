package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import display.Display;
import entity.LizardEnemy;
import entity.MedusaEnemy;
import entity.Player;
import gfx.Assets;
import gfx.GameCamera;

import input.KeyManager;
import input.MouseManager;
import state.GameState;
import state.GameWinState;
import state.MenuState;
import state.State;
import statics.entity.wind.Portal;
import utils.AudioClip;
import utils.AudioPlayer;


public class Game implements Runnable {

	private Display display;
	public String title;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public static int q = 0;
	
	public static int chuyenMap = 0;
	//State
	public State menuState;
	public State gameState;
	public State gameWinState;

	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init(String path, int q) {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameCamera = new GameCamera(handler, 0, 0);
										
		if (q == 0){
			menuState = new MenuState(handler);
			State.setState(menuState);
			gameState = new GameState(handler, path);
		}
		else if(q == 1) {
			gameState = new GameState(handler, path);
			State.setState(gameState);
			handler.getMouseManager().setUIManager(null);
			AudioClip map2Music = new AudioClip("Map2Music.wav");
			if(chuyenMap <1) {
				AudioPlayer.playSound(map2Music);								//phat nhac map2
			}			
		}
		else if (q == 2){
			gameWinState = new GameWinState(handler);
			State.setState(gameWinState);
		}
	}
	
	private void tick() {
		
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}

		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {		

		String[] path = new String[3];
		path[0] = "res/world/world1.wind.txt";
		path[1] = "res/world/world2.desert.txt";
		path[2] = "res/world/world2.desert.txt";
		
		while(true) {
			
			int fps = 60;								//run 60 lan / 1s (Hz)
			double timePerTick = 1000000000 / fps;		//so nanoS can de run 1 lan (nanoS)
			double delta = 0;
			long now;
			long lastTime = System.nanoTime();
			init(path[q], q);
			running = true;
			
			while(running) {
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;		//tinh xem da du thoi gian de run tiep chua 
				lastTime = now;
			
				if(delta >= 1) {
					tick();
					render();
					delta --;
				}
				if( Portal.check && q<1) {
					q = 1;
					running = false;
					stop();
					Portal.check = false;
				}
				if( Player.check == true ) {
					chuyenMap += 1;
					q = 1;
					running = false;
					Player.check = false;
					stop();
				}
				if(Player.check == false && LizardEnemy.check == true && MedusaEnemy.check == true) {
					q = 2;
					running = false;
					MedusaEnemy.check = false;
					stop();
				}
			}
			stop();
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
