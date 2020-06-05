package state;

import java.awt.Graphics;

import entity.Player;

import main.Game;
import main.Handler;
import gfx.Assets;
import utils.AudioClip;
import utils.AudioPlayer;
import world.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler, String path) {
		super(handler);
	
		world = new World(handler, path);
		System.out.println("abc");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);

	}

}
