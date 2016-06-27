package br.com.tapflappy.elements;

import android.content.Context;
import android.graphics.Canvas;

public abstract class Element {

	private Context context;
	private int xPos;
	
	public abstract void move();
	public abstract void drawOnThe(Canvas canvas);
	public abstract boolean hasHorizontalCollisionWith(Character character);
	public abstract boolean hasVerticalCollisionWith(Character character);
	public abstract boolean hasCollisionWith(Character character); 
	
	public boolean outOfBounds() {
		return (xPos + 100) < 0;  
	}
	
}
