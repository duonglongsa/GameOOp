package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;

import Main.Handler;

public class EntityManager {

	private Handler handler;
	private Player player;

	private lizardEnemy lizardEnemy;

	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}
		
	};
 	
	public EntityManager(Handler handler, Player player,lizardEnemy lizardEnemy) {
		this.handler = handler;
		this.player = player;
		this.lizardEnemy = lizardEnemy;
		entities = new ArrayList<Entity>();
		addEntity(player);
		addEntity(lizardEnemy);
	}
	
	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i); // = entities[i]
			e.tick();

			if(!e.isActive()) {
				entities.remove(e);
			}
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
			g.setColor(Color.blue);
			g.drawRect(e.getCollisionBounds(0, 0).x, e.getCollisionBounds(0, 0).y, e.getCollisionBounds(0, 0).width, e.getCollisionBounds(0, 0).height  );
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	//GETTER - SETTER
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public lizardEnemy getLizardEnemy() {
		return lizardEnemy;
	}

	public void setLizardEnemy(lizardEnemy lizardEnemy) {
		this.lizardEnemy = lizardEnemy;
	}
	
	
	
}
