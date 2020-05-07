package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int PLAYER_SIZE = 64;
	
	public static BufferedImage rock, lavaRock, tree, snowTile1, snowTile2, snowTile3, snowTile4, snowTile5;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	
	public static void innit() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Knight.png"));
		
		player_down = new BufferedImage[6];
		player_down[0] = sheet.crop(PLAYER_SIZE * 0, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		player_down[1] = sheet.crop(PLAYER_SIZE * 1, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		player_down[2] = sheet.crop(PLAYER_SIZE * 2, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		player_down[3] = sheet.crop(PLAYER_SIZE * 3, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		player_down[4] = sheet.crop(PLAYER_SIZE * 4, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		player_down[5] = sheet.crop(PLAYER_SIZE * 5, PLAYER_SIZE * 2, PLAYER_SIZE, PLAYER_SIZE);
		
		player_up = new BufferedImage[3];
		player_up[0] = sheet.crop(PLAYER_SIZE * 0, PLAYER_SIZE * 3, PLAYER_SIZE, PLAYER_SIZE);
		player_up[1] = sheet.crop(PLAYER_SIZE * 1, PLAYER_SIZE * 3, PLAYER_SIZE, PLAYER_SIZE);
		player_up[2] = sheet.crop(PLAYER_SIZE * 2, PLAYER_SIZE * 3, PLAYER_SIZE, PLAYER_SIZE);

		player_left = new BufferedImage[8];
		player_left[0] = sheet.crop(PLAYER_SIZE * 0, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[1] = sheet.crop(PLAYER_SIZE * 1, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[2] = sheet.crop(PLAYER_SIZE * 2, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[3] = sheet.crop(PLAYER_SIZE * 3, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[4] = sheet.crop(PLAYER_SIZE * 4, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[5] = sheet.crop(PLAYER_SIZE * 5, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[6] = sheet.crop(PLAYER_SIZE * 6, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		player_left[7] = sheet.crop(PLAYER_SIZE * 7, PLAYER_SIZE * 1, PLAYER_SIZE, PLAYER_SIZE);
		
		player_right = new BufferedImage[8];
		player_right[0] = sheet.crop(PLAYER_SIZE * 0, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[1] = sheet.crop(PLAYER_SIZE * 1, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[2] = sheet.crop(PLAYER_SIZE * 2, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[3] = sheet.crop(PLAYER_SIZE * 3, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[4] = sheet.crop(PLAYER_SIZE * 4, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[5] = sheet.crop(PLAYER_SIZE * 5, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[6] = sheet.crop(PLAYER_SIZE * 6, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		player_right[7] = sheet.crop(PLAYER_SIZE * 7, PLAYER_SIZE * 0, PLAYER_SIZE, PLAYER_SIZE);
		
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
