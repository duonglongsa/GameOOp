package world;

import java.awt.Color;
import java.awt.Graphics;

import javax.xml.crypto.dsig.keyinfo.X509Data;

import Entity.EntityManager;
import Entity.Player;
import Main.Game;
import Main.Handler;
import gfx.Assets;
import statics.entity.desert.BuildingDesert1;
import statics.entity.desert.BuildingDesert3;
import statics.entity.desert.Decor7;
import statics.entity.desert.Lake;
import statics.entity.desert.Pyramid;
import statics.entity.desert.Rock1;
import statics.entity.desert.Rock2;
import statics.entity.desert.Rock3;
import statics.entity.desert.StoneDesert1;
import statics.entity.desert.StoneDesert2;
import statics.entity.desert.StoneDesert3;
import statics.entity.desert.Tent;
import statics.entity.desert.Tree1;
import statics.entity.desert.Tree11;
import statics.entity.desert.Tree12;
import statics.entity.desert.Tree2;
import statics.entity.desert.Tree3;
import statics.entity.desert.Tree4;
import statics.entity.desert.Tree5;
import tile.Tile;
import utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Player-bar
	private double health = 100, totalMana = 100, mana = 100; 
	
	//entities
	private EntityManager entityManager;

	public static void addStaticEntity(Handler handler, EntityManager entityManager) {
			
		// Desert building
		entityManager.addEntity(new BuildingDesert1(handler, 200, 100));
		entityManager.addEntity(new BuildingDesert3(handler, 100, 200));
		
		// Desert stone
		entityManager.addEntity(new StoneDesert1(handler, 510, 50));
		entityManager.addEntity(new StoneDesert2(handler, 600, 700));
		entityManager.addEntity(new StoneDesert3(handler, -50, -50));
			
		// Rock 1
		entityManager.addEntity(new Rock1(handler, 100, 400));
		entityManager.addEntity(new Rock1(handler, 500, 80));
		entityManager.addEntity(new Rock1(handler, 300, 50));
		entityManager.addEntity(new Rock1(handler, 90, 800));
		entityManager.addEntity(new Rock1(handler, 20, 650));
		entityManager.addEntity(new Rock1(handler, 475, 750));
			
		// Rock 2
		entityManager.addEntity(new Rock2(handler, 80, 500));
		entityManager.addEntity(new Rock2(handler, 380, 600));
			
		// Rock 3
		entityManager.addEntity(new Rock3(handler, 150, 450));
		entityManager.addEntity(new Rock3(handler, 320, 680));
		entityManager.addEntity(new Rock3(handler, 380, 80));
		entityManager.addEntity(new Rock3(handler, 105, 750));


		// Pyramid
		entityManager.addEntity(new Pyramid(handler, 400, 360));

		// Tent
		entityManager.addEntity(new Tent(handler, 700, 40));
			
		//Lake
		entityManager.addEntity(new Lake(handler, 150, 680));
			
		// Tree
		entityManager.addEntity(new Tree1(handler, 230, 600));
		entityManager.addEntity(new Tree1(handler, 110, 500));
		entityManager.addEntity(new Tree1(handler, 30, 600));
		entityManager.addEntity(new Tree1(handler, 700, 130));
		entityManager.addEntity(new Tree2(handler, 200, 200));
		entityManager.addEntity(new Tree4(handler, 650, 600));
		entityManager.addEntity(new Tree4(handler, 100, 350));
		entityManager.addEntity(new Tree5(handler, 67, 70));
		entityManager.addEntity(new Tree3(handler, 700, 400));
		entityManager.addEntity(new Tree2(handler, 380, 660));
		entityManager.addEntity(new Tree11(handler, 350, 250));		
		entityManager.addEntity(new Tree12(handler, 600, 500));

		// Decor
		entityManager.addEntity(new Decor7(handler, 490, 540));
	}
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
		
		entityManager = new EntityManager(handler, new Player(handler, spawnX, spawnY));
		
		
		// add static
		addStaticEntity(handler, entityManager);
		
		//entityManager.addEntity(new Tree(handler, 255, 100));
		
	}
	
	public void tick() {
		entityManager.tick();
		
		//Player-bar
		if(handler.getKeyManager().skill) {
			if(mana > 0) {
				mana -= 0.2;
			}else {
				handler.getKeyManager().skill = false;
			}
		}
		if(mana <= totalMana) {
			mana += 0.01;
		}

		
	}
	
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd   = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd   = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getWidth()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
										(int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
				
		entityManager.render(g);
		
		//Player-bar
		g.setColor(Color.red);
		g.fillRect(73, 30, 127, 12);				
								
		g.setColor(Color.blue);
		g.fillRect(73, 46, (int) (122 *  (mana / totalMana)), 6);
			
		g.drawImage(Assets.playerBar, 0, 0, null);
	}
	
	public Tile getTile(int x, int y) {
		
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.desertTile;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.desertTile;
		}else
			return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		
		String[] tokens = file.split("\\s+");//ta'ch string -> array ko lay space
		
		width  = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
	
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[x + y * width + 4]);//lay int tai [x][y]
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
