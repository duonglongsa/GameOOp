package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Main.Handler;
import State.MenuState;
import gfx.Animation;
import gfx.Assets;

public class lizardEnemy extends Enemy {
	
	public static int lizardHelath;
	
	public lizardEnemy(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);

		// chinh kich thuoc va cham
		bounds.x = 0;
		bounds.y = 22;
		bounds.width = 32;
		bounds.height = 35;
		this.atkDame = 4;
		
		
		// Animations
		animLeft = new Animation(180, Assets.lizard_left, handler);
		animRight = new Animation(180, Assets.lizard_right, handler);

		// attack animations
		aLeft = new Animation(180, Assets.lizard_attack_left, handler);
		aRight = new Animation(180, Assets.lizard_attack_right, handler);

		// hurt animations
		hurtLeft = new Animation(180, Assets.lizard_hurt_left, handler);
		hurtRight = new Animation(180, Assets.lizard_hurt_right, handler);

		// die animations
		dieLeft = new Animation(180, Assets.lizard_die_left, handler);
		dieRight = new Animation(180, Assets.lizard_die_right, handler);

	}

	public void tick() {
		super.tick();
		
		
		
	}
	
	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

}
