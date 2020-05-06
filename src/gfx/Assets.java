package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 0;
	
	public static BufferedImage rock, lavaRock, tree, snowTile1, snowTile2, snowTile3, snowTile4, snowTile5;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	public static void innit() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SwordCharacter.png"));
		
		player_down = new BufferedImage[4];
		player_down[0] = sheet.crop(20, 500, 50, 40);
		player_down[1] = sheet.crop(70, 500, 50, 40);
		player_down[2] = sheet.crop(120, 500, 50, 40);
		player_down[3] = sheet.crop(170, 500, 50, 40);
		
		player_up = new BufferedImage[4];
		player_up[0] = sheet.crop(20, 300, 40, 50);
		player_up[1] = sheet.crop(60, 300, 45, 50);
		player_up[2] = sheet.crop(105, 300, 45, 50);
		player_up[3] = sheet.crop(150, 300, 45, 50);

		player_left = new BufferedImage[4];
		player_left[0] = sheet.crop(20, 110, 25, 40);
		player_left[1] = sheet.crop(45, 110, 35, 40);
		player_left[2] = sheet.crop(80, 110, 30, 40);
		player_left[3] = sheet.crop(110, 110, 35, 40);
		
		player_right = new BufferedImage[4];
		player_right[0] = sheet.crop(20, 110, 25, 40);
		player_right[1] = sheet.crop(45, 110, 35, 40);
		player_right[2] = sheet.crop(80, 110, 30, 40);
		player_right[3] = sheet.crop(110, 110, 35, 40);
		
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
