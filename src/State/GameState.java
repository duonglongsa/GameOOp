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
		
<<<<<<< HEAD
		world = new World(handler, "res/world/world1.txt");
=======
		world = new World(handler, "res/world/world2.desert.txt");
>>>>>>> 4f7685013dde6f2bad7d1f15a0b528de19608b39
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
