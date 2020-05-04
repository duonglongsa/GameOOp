package State;

import java.awt.Graphics;

import Entity.Player;
import Entity.Tree;
import Main.Game;
import Main.Handler;
import gfx.Assets;
import world.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		
		world = new World(handler, "res/world/world1.txt");
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
