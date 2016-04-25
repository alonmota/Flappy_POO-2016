package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Character {
	
	private static final float L_RECT = 100;
	private static final float R_RECT = 150;
	private static final  float RADIUS = 50;
	private float height;
	public float base;
	
	private Screen screen;
	
	private static final Paint CHAR_COLOR = Colors.getColorOfCharacter();
	
	
	public Character(Screen screen){
		
		this.screen = screen;
		this.base = 150;
		this.height = 100;
		
	}

	public void drawOnThe(Canvas canvas){
		//canvas.drawCircle(X, height, RADIUS, CHAR_COLOR);
		canvas.drawRect(L_RECT, height, R_RECT , base, CHAR_COLOR);
		
		
	}

	public void drop() {
		
		boolean floor = base > screen.getHeight();
		
		if(!floor) {
			this.height += 5;                                                                             
			this.base += 5;
		}
		
	}

	public void jump() {
		
		if(height > 0){
			this.height -= 100;
			this.base -= 100;
		}
		
	}
}
