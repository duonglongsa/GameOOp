package gfx;

import java.awt.image.BufferedImage;

import javax.swing.SpinnerDateModel;

public class Assets {

	private static final int width = 64;
	private static final int height = 64;
	
	//Player-bar
	public static BufferedImage playerBar;
	
	//NPC
	public static BufferedImage[] npcJeweler;

	// Desert 
	public static BufferedImage desertTile;
	public static BufferedImage[] buildingDesert;
	public static BufferedImage[] stoneDesert;
	public static BufferedImage[] rockDesert;
	public static BufferedImage pyramidDesert, tentDesert, lakeDesert, roadDesert;
	public static BufferedImage[] landDesert;
	public static BufferedImage stairDesert;
	public static BufferedImage[] treeDesert;
	public static BufferedImage[] decorDesert;
	public static BufferedImage[] greeneryDesert;

	// Wind
	public static BufferedImage windTile;
	public static BufferedImage[] roadWind;
	public static BufferedImage[] buildingWind;
	public static BufferedImage[] treeWind;
	
	// animation
	public static BufferedImage[] player_right, player_up, player_left, player_down, hurt_left, hurt_right, die_left,
			die_right;

	// attack
	public static BufferedImage[] attack_left, attack_right, extra_left, extra_right, skill;
	
	public static BufferedImage[] lizard_right, lizard_left, lizard_hurt_left, lizard_hurt_right, lizard_die_left,
	lizard_die_right;

	
	public static BufferedImage[] lizard_attack_left, lizard_attack_right, lizard_skill;

	// direction
	public static BufferedImage[] directions;
	public static BufferedImage[] lizard_directions;

	//UI
	public static BufferedImage[] button_play, button_settings, share, button_exit, github, facebook, google;
	public static BufferedImage background, settings;
	
	public static void init() {
		
		//Player-bar
		playerBar = ImageLoader.loadImage("/player/PlayerBar.png");
		
		//NPC
		npcJeweler = new BufferedImage[2];
		npcJeweler[0] = ImageLoader.loadImage("/npc/jeweler.png");
		npcJeweler[1] = ImageLoader.loadImage("/npc/jeweler_talk.png");
		
		// menu state
		//UI
		background = ImageLoader.loadImage("/GUI/background.jpg");
		settings = ImageLoader.loadImage("/GUI/settings.png");
				
		button_play = new BufferedImage[2];
		button_play[0] = ImageLoader.loadImage("/GUI/button_play0.png");
		button_play[1] = ImageLoader.loadImage("/GUI/button_play1.png");
				
		button_settings = new BufferedImage[2];
		button_settings[0] = ImageLoader.loadImage("/GUI/button_settings0.png");
		button_settings[1] = ImageLoader.loadImage("/GUI/button_settings1.png");
				
		button_exit = new BufferedImage[2];
		button_exit[0] = ImageLoader.loadImage("/GUI/button_exit0.png");
		button_exit[1] = ImageLoader.loadImage("/GUI/button_exit1.png");
				
		share = new BufferedImage[2];
		share[0] = ImageLoader.loadImage("/GUI/share0.png");
		share[1] = ImageLoader.loadImage("/GUI/share1.png");

		github = new BufferedImage[2];
		github[0] = ImageLoader.loadImage("/GUI/github0.png");
		github[1] = ImageLoader.loadImage("/GUI/github1.png");
				
		facebook = new BufferedImage[2];
		facebook[0] = ImageLoader.loadImage("/GUI/facebook0.png");
		facebook[1] = ImageLoader.loadImage("/GUI/facebook1.png");
				
		google = new BufferedImage[2];
		google[0] = ImageLoader.loadImage("/GUI/google0.png");
		google[1] = ImageLoader.loadImage("/GUI/google1.png");
		
		
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
		
		// Manh - for Lizard
		// my character
				SpriteSheet lizard = new SpriteSheet(ImageLoader.loadImage("/enemy/lizard.png"));
				lizard_right = new BufferedImage[6];
				for(int i = 0; i < 6; i++) {
					lizard_right[i] = lizard.crop(width*(i), 0, width, height);
				}
				
				lizard_left = new BufferedImage[6];
				for(int i = 0; i < 6; i++) {
					lizard_left[i] = lizard.crop(width*(i), height, width, height);
				}
			
				
				//lizard_attack
				lizard_attack_right = new BufferedImage[5];
				for(int i = 0; i < 5; i++) {
					lizard_attack_right[i] = lizard.crop(width*(i), height*2, width, height);
				}
				
				lizard_attack_left = new BufferedImage[5];
				for(int i = 0; i < 5; i++) {
					lizard_attack_left[i] = lizard.crop(width*(i), height*3, width, height);
				}
			
				
				//hurt
				lizard_hurt_right = new BufferedImage[2];
				for(int i = 0; i < 2; i++) {
					lizard_hurt_right[i] = lizard.crop(width*(i), height*4, width, height);
				}
				
				lizard_hurt_left = new BufferedImage[2];
				for(int i = 0; i < 2; i++) {
					lizard_hurt_left[i] = lizard.crop(width*(i), height*5, width, height);
				}
				
				//lizard_die
				lizard_die_right = new BufferedImage[6];
				for(int i = 0; i < 6; i++) {
					lizard_die_right[i] = lizard.crop(width*i, height*6, width, height);
				}
				lizard_die_left = new BufferedImage[6];
				for(int i = 0; i < 6; i++) {
					lizard_die_left[i] = lizard.crop(width*(i), height*7, width, height);
				}
				
				
				// direction
				lizard_directions = new BufferedImage[4];
				lizard_directions[0] = lizard_right[0];
				lizard_directions[1] = lizard_right[0];
				lizard_directions[3] = lizard_right[0];
				lizard_directions[2] = lizard_right[0];

		// Desert Tile
		SpriteSheet desertSheet = new SpriteSheet(ImageLoader.loadImage("/desert/bg.png"));
		desertTile = desertSheet.crop(0, 0, 32*8, 32*8);
				
		//Desert building
		buildingDesert = new BufferedImage[5];
		SpriteSheet buildingDesertSheet0 = new SpriteSheet(ImageLoader.loadImage("/desert/building_1.png"));		
		SpriteSheet buildingDesertSheet1 = new SpriteSheet(ImageLoader.loadImage("/desert/building_2.png"));
		SpriteSheet buildingDesertSheet2 = new SpriteSheet(ImageLoader.loadImage("/desert/building_3.png"));
		SpriteSheet buildingDesertSheet3 = new SpriteSheet(ImageLoader.loadImage("/desert/building_4.png"));
		SpriteSheet buildingDesertSheet4 = new SpriteSheet(ImageLoader.loadImage("/desert/building_5.png"));	
				
		buildingDesert[0] = buildingDesertSheet0.crop(0, 0, 559, 549);
		buildingDesert[1] = buildingDesertSheet1.crop(0, 0, 650, 378);
		buildingDesert[2] = buildingDesertSheet2.crop(0, 0, 243, 397);
		buildingDesert[3] = buildingDesertSheet3.crop(0, 0, 303, 568);
		buildingDesert[4] = buildingDesertSheet4.crop(0, 0, 404, 507);
				
		//Desert stone
		stoneDesert = new BufferedImage[3];
		SpriteSheet stoneDesertSheet0 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_10.png"));
		SpriteSheet stoneDesertSheet1 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_11.png"));
		SpriteSheet stoneDesertSheet2 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_12.png"));
				
		stoneDesert[0] = stoneDesertSheet0.crop(0, 0, 769, 630);
		stoneDesert[1] = stoneDesertSheet1.crop(0, 0, 1422, 643);
		stoneDesert[2] = stoneDesertSheet2.crop(0, 0, 948, 660);
				
		//Desert rock
		rockDesert = new BufferedImage[3];
		SpriteSheet rockDesertSheet0 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_1.png"));
		SpriteSheet rockDesertSheet1 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_5.png"));
		SpriteSheet rockDesertSheet2 = new SpriteSheet(ImageLoader.loadImage("/desert/stones_6.png"));
				
		rockDesert[0] = rockDesertSheet0.crop(0, 0, 106, 79);
		rockDesert[1] = rockDesertSheet1.crop(0, 0, 181, 136);
		rockDesert[2] = rockDesertSheet2.crop(0, 0, 199, 188);
				
		// Desert pyramid
		SpriteSheet pyramidSheet = new SpriteSheet(ImageLoader.loadImage("/desert/decor_1.png"));
				
		pyramidDesert = pyramidSheet.crop(0, 0, 356, 296);
				
		// Desert land
		landDesert = new BufferedImage[9];
		SpriteSheet landSheet = new SpriteSheet(ImageLoader.loadImage("/desert/land_6.png"));
		SpriteSheet landSheet1 = new SpriteSheet(ImageLoader.loadImage("/desert/land_1.png"));
		SpriteSheet landSheet2 = new SpriteSheet(ImageLoader.loadImage("/desert/land_2.png"));
		SpriteSheet landSheet3 = new SpriteSheet(ImageLoader.loadImage("/desert/land_3.png"));		
		SpriteSheet landSheet18 = new SpriteSheet(ImageLoader.loadImage("/desert/land_18.png"));		
		SpriteSheet landSheet9 = new SpriteSheet(ImageLoader.loadImage("/desert/land_9.png"));		
		SpriteSheet landSheet11 = new SpriteSheet(ImageLoader.loadImage("/desert/land_11.png"));		
		SpriteSheet landSheetgoc1 = new SpriteSheet(ImageLoader.loadImage("/desert/land_goc1.png"));		
		SpriteSheet landSheetgoc2 = new SpriteSheet(ImageLoader.loadImage("/desert/land_goc2.png"));		

				
		landDesert[0] = landSheet.crop(0, 0, 256, 256);
		landDesert[1] = landSheet1.crop(0, 0, 256, 256);
		landDesert[2] = landSheet2.crop(0, 0, 256, 256);
		landDesert[3] = landSheet3.crop(0, 0, 256, 256);
		landDesert[4] = landSheet18.crop(0, 0, 256, 256);
		landDesert[5] = landSheet9.crop(0, 0, 247, 256);
		landDesert[6] = landSheet11.crop(0, 0, 247, 256);
		landDesert[7] = landSheetgoc1.crop(0, 0, 256, 247);
		landDesert[8] = landSheetgoc2.crop(0, 0, 256, 247);

		// Tent
		SpriteSheet tentSheet = new SpriteSheet(ImageLoader.loadImage("/desert/decor_2.png"));
				
		tentDesert = tentSheet.crop(0, 0, 258, 279);
				
		// Lake
		SpriteSheet lakeSheet = new SpriteSheet(ImageLoader.loadImage("/desert/lake.png"));
				
		lakeDesert = lakeSheet.crop(0, 0, 559, 221);
				
		// Stair
		SpriteSheet stairSheet = new SpriteSheet(ImageLoader.loadImage("/desert/land_13.png"));

		stairDesert = stairSheet.crop(0, 0, 256, 239);
				
		// Tree
		treeDesert = new BufferedImage[8];
				
		SpriteSheet treeSheet0 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_1.png"));
		SpriteSheet treeSheet1 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_1.png"));
		SpriteSheet treeSheet2 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_2.png"));
		SpriteSheet treeSheet3 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_3.png"));
		SpriteSheet treeSheet4 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_4.png"));
		SpriteSheet treeSheet5 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_5.png"));
		SpriteSheet treeSheet6 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_6.png"));
		SpriteSheet treeSheet7 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_7.png"));
		SpriteSheet treeSheet8 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_8.png"));
		SpriteSheet treeSheet9 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_9.png"));
		SpriteSheet treeSheet10 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_10.png"));
		SpriteSheet treeSheet11 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_11.png"));
		SpriteSheet treeSheet12 = new SpriteSheet(ImageLoader.loadImage("/desert/tree_12.png"));

		treeDesert[0] = treeSheet0.crop(0, 0, 285, 297);
		treeDesert[1] = treeSheet1.crop(0, 0, 285, 297);
		treeDesert[2] = treeSheet2.crop(0, 0, 235, 358);
		treeDesert[3] = treeSheet3.crop(0, 0, 181, 234);
		treeDesert[4] = treeSheet4.crop(0, 0, 123, 323);
		treeDesert[5] = treeSheet5.crop(0, 0, 187, 244);
		treeDesert[6] = treeSheet11.crop(0, 0, 206, 367);
		treeDesert[7] = treeSheet12.crop(0, 0, 221, 301);
				
		// Road
		SpriteSheet roadSheet = new SpriteSheet(ImageLoader.loadImage("/desert/road_18.png"));
				
		roadDesert = roadSheet.crop(0, 0, 64, 64);
				
		// Decor
		decorDesert = new BufferedImage[1];
				
		SpriteSheet decorSheet = new SpriteSheet(ImageLoader.loadImage("/desert/decor_7.png"));
				
		decorDesert[0] = decorSheet.crop(0, 0, 131, 142);
				
		// Greenery
				
		greeneryDesert = new BufferedImage[1];
				
		SpriteSheet greenerySheet = new SpriteSheet(ImageLoader.loadImage("/desert/greenery_3.png"));
				
		greeneryDesert[0] = greenerySheet.crop(0, 0, 87, 162);
		
	// Wind
		
		// Wind tile
		SpriteSheet windSheet = new SpriteSheet(ImageLoader.loadImage("/wind/land/land_1.png"));
		
		windTile = windSheet.crop(0, 0, 256, 256);
						
		// Wind Road
		roadWind = new BufferedImage[2];
		SpriteSheet roadSheet16 = new SpriteSheet(ImageLoader.loadImage("/wind/road/road_16.png"));
		SpriteSheet roadSheet5 = new SpriteSheet(ImageLoader.loadImage("/wind/road/road_5.png"));
		
		roadWind[0] = roadSheet16.crop(0, 0, 64, 64);
		roadWind[1] = roadSheet5.crop(0, 0, 64, 64);
		
		// Wind Building
		buildingWind = new BufferedImage[19];
		SpriteSheet buildingWindSheet0 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_1/building_1.png"));
		SpriteSheet buildingWindSheet1 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_1/building_1.png"));
		SpriteSheet buildingWindSheet2 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_2/building_1.png"));
		SpriteSheet buildingWindSheet3 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_3/building_1.png"));
		SpriteSheet buildingWindSheet4 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_4/building_1.png"));
		SpriteSheet buildingWindSheet5 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_5/building_1.png"));
		SpriteSheet buildingWindSheet6 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_6/building_1.png"));
		SpriteSheet buildingWindSheet7 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_7/building_1.png"));
		SpriteSheet buildingWindSheet8 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_8/building_1.png"));
		SpriteSheet buildingWindSheet9 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_9/building_1.png"));
		SpriteSheet buildingWindSheet10 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_10/building_1.png"));
		SpriteSheet buildingWindSheet11 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_11/building_1.png"));
		SpriteSheet buildingWindSheet12 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_12/building_1.png"));
		SpriteSheet buildingWindSheet13 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_13/building_1.png"));
		SpriteSheet buildingWindSheet14 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_14/building_1.png"));
		SpriteSheet buildingWindSheet15 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_15/building_1.png"));
		SpriteSheet buildingWindSheet16 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_16/building_1.png"));
		SpriteSheet buildingWindSheet17 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_17/building_1.png"));
		SpriteSheet buildingWindSheet18 = new SpriteSheet(ImageLoader.loadImage("/wind/buildings/building_18/building_1.png"));

		buildingWind[0] = buildingWindSheet0.crop(0, 0, 476, 672);
		buildingWind[1] = buildingWindSheet1.crop(0, 0, 476, 672);
		buildingWind[2] = buildingWindSheet2.crop(0, 0, 347, 423);
		buildingWind[3] = buildingWindSheet3.crop(0, 0, 404, 410);
		buildingWind[4] = buildingWindSheet4.crop(0, 0, 595, 612);
		buildingWind[5] = buildingWindSheet5.crop(0, 0, 695, 598);
		buildingWind[6] = buildingWindSheet6.crop(0, 0, 515, 757);
		buildingWind[7] = buildingWindSheet7.crop(0, 0, 515, 675);
		buildingWind[8] = buildingWindSheet8.crop(0, 0, 811, 688);
		buildingWind[9] = buildingWindSheet9.crop(0, 0, 627, 558);
		buildingWind[10] = buildingWindSheet10.crop(0, 0, 516, 603);
		buildingWind[11] = buildingWindSheet11.crop(0, 0, 477, 506);
		buildingWind[12] = buildingWindSheet12.crop(0, 0, 326, 874);
		buildingWind[13] = buildingWindSheet13.crop(0, 0, 481, 518);
		buildingWind[14] = buildingWindSheet14.crop(0, 0, 626, 751);
		buildingWind[15] = buildingWindSheet15.crop(0, 0, 553, 517);
		buildingWind[16] = buildingWindSheet16.crop(0, 0, 492, 557);
		buildingWind[17] = buildingWindSheet17.crop(0, 0, 843, 766);
		buildingWind[18] = buildingWindSheet18.crop(0, 0, 532, 523);
		
		// Tree Wind
		treeWind = new BufferedImage[2];
		SpriteSheet treeWindSheet1 = new SpriteSheet(ImageLoader.loadImage("/wind/decor/tree_1.png"));
		SpriteSheet treeWindSheet2 = new SpriteSheet(ImageLoader.loadImage("/wind/decor/tree_2.png"));
		
		treeWind[0] = treeWindSheet1.crop(0, 0, 355, 620);
		treeWind[1] = treeWindSheet2.crop(0, 0, 317, 543);
	}

}
