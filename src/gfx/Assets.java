package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64;
	private static final int height = 64;

	// static entities
	public static BufferedImage rock, lavaRock, tree, snowTile1, snowTile2, snowTile3, snowTile4, snowTile5;

	// animation
	public static BufferedImage[] player_right, player_up, player_left, player_down, hurt_left, hurt_right, die_left,
			die_right;

	// attack
	public static BufferedImage[] attack_left, attack_right, extra_left, extra_right, skill;

	// direction
	public static BufferedImage[] directions;

	public static void innit() {
		// my character
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/player/rouge.png"));
		player_right = new BufferedImage[6];
		for(int i = 0; i < 6; i++) {
			player_right[i] = sheet.crop(width*(i), 0, width, height);
		}
		
		player_left = new BufferedImage[6];
		for(int i = 0; i < 6; i++) {
			player_left[i] = sheet.crop(width*(i), height, width, height);
		}
	
		player_up = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			player_up[i] = sheet.crop(width*(i), height*2, width, height);
		}
		
		player_down = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			player_down[i] = sheet.crop(width*(i), height*3, width, height);
		}
		
		//attack
		attack_right = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			attack_right[i] = sheet.crop(width*(i), height*4, width, height);
		}
		extra_right = new BufferedImage[10];
		for(int i = 0; i < 10; i++) {
			extra_right[i] = sheet.crop(width*(i), height*4, width, height);
		}
		
		attack_left = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			attack_left[i] = sheet.crop(width*(i), height*5, width, height);
		}
		extra_left = new BufferedImage[10];
		for(int i = 0; i < 10; i++) {
			extra_left[i] = sheet.crop(width*(i), height*5, width, height);
		}
		
		//hurt
		hurt_right = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			hurt_right[i] = sheet.crop(width*(i), height*6, width, height);
		}
		
		hurt_left = new BufferedImage[4];
		for(int i = 0; i < 4; i++) {
			hurt_left[i] = sheet.crop(width*(i), height*7, width, height);
		}
		
		//die
		die_right = new BufferedImage[10];
		for(int i = 0; i < 10; i++) {
			die_right[i] = sheet.crop(width*i, height*8, width, height);
		}
		die_left = new BufferedImage[10];
		for(int i = 0; i < 5; i++) {
			die_left[i] = sheet.crop(width*(i), height*9, width, height);
		}
		die_left[6] = die_right[6];
		die_left[7] = die_right[7];
		die_left[8] = die_right[8];
		die_left[9] = die_right[9];
		
		// direction
		directions = new BufferedImage[4];
		directions[0] = player_down[0];
		directions[1] = player_up[2];
		directions[3] = player_right[0];
		directions[2] = player_left[0];

		// enities
		rock = ImageLoader.loadImage("/textures/Rock1.png");
		lavaRock = ImageLoader.loadImage("/textures/LavaRock.png");
		tree = ImageLoader.loadImage("/textures/tree.png");
		snowTile1 = ImageLoader.loadImage("/textures/SnowTile1.png");
		snowTile2 = ImageLoader.loadImage("/textures/SnowTile2.png");
		snowTile3 = ImageLoader.loadImage("/textures/SnowTile3.png");
		snowTile4 = ImageLoader.loadImage("/textures/SnowTile4.png");
		snowTile5 = ImageLoader.loadImage("/textures/SnowTile5.png");
	}

}
