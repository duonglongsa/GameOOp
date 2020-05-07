package Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Display.Display;
import State.GameState;
import State.State;
import gfx.Assets;
import gfx.GameCamera;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import input.KeyManager;

public class Game implements Runnable {

	private Display display;
	public String title;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//State
	private State gameState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.innit();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new GameState(handler);
		State.setState(gameState);
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
		
		
		//end drawing
		
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		
		init();
		
		int fps = 60;								//run 60 lan / 1s (Hz)
		double timePerTick = 1000000000 / fps;		//so nanoS can de run 1 lan (nanoS)
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;		//tinh xem da du thoi gian de run tiep chua 
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
			
				delta --;
			}
	
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
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
