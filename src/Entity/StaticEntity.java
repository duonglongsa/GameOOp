package entity;

import main.Handler;

public abstract class StaticEntity  extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		health = 10000000;
		
	}

}
