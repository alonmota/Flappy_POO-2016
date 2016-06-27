package br.com.tapflappy.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Item extends Element{

	private int xPos;
	private int yPos;
	private int crazy = 1;
	
	private Context context;
	
	public static final int ITEM_SIZE = 75;
	static final int ITEM_WIDTH = 75;
	
	private Bitmap itemImg;

	
	public Item(Context context, int xPos, int yPos) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.context = context;
	
		Bitmap bp = Assets.bmpItem;
		
		this.itemImg = Bitmap.createScaledBitmap(bp, (int)ITEM_WIDTH, (int)ITEM_SIZE, false);
		
		}

	
	public void drawOnThe(Canvas canvas) {
		drawItemOnThe(canvas);
	}


	private void drawItemOnThe(Canvas canvas) {
		canvas.drawBitmap(itemImg, xPos, (float) yPos, null);
	}
	
	public void move() {
		this.xPos -= 5;
		
		this.yPos += 5 * crazy;
		
		if(yPos > 450 || yPos < 350)
			crazy *= -1;
		
		if(xPos<0)
			xPos+=1000;
		
		
	}
	
	
	
	public boolean hasHorizontalCollisionWith(Character character) {
		
		return this.xPos < Character.R_RECT;
		 										
	}
	
	public boolean hasVerticalCollisionWith(Character character) {
		
		return character.height+character.RADIUS > this.yPos
				&& character.height < this.yPos + ITEM_SIZE;
	}
	
	
	public boolean hasCollisionWith(Character character) {
		
			if(this.hasHorizontalCollisionWith(character) 
					&& this.hasVerticalCollisionWith(character)){
				xPos += 1500;
				return true;
			}
		
		return false;
	}
}
