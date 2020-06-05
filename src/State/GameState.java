package State;

import java.awt.Graphics;

import Entity.Player;

import Main.Game;
import Main.Handler;
import gfx.Assets;
import utils.AudioClip;
import utils.AudioPlayer;
import world.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler, String path) {
		super(handler);
		
		//world = new World(handler, "res/world/world2.desert.txt");
		world = new World(handler, path);

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
