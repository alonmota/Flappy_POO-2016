package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;
import br.com.tapflappy.engine.Sound;

public class Character {
	
	public static final float L_RECT = 100;
	public static final float R_RECT = 150;
	public static final  float RADIUS = 50;
	private float height;
	public float base;
	
	private Screen screen;
	private Sound sound;
	
	private static final Paint CHAR_COLOR = Colors.getColorOfCharacter();
	public static final float X = 100;
	
	
	public Character(Screen screen, Sound sound){
		
		this.screen = screen;
		this.sound = sound;
		this.base = 150;
		this.height = 100;
		
	}

	public void drawOnThe(Canvas canvas){
		canvas.drawCircle(L_RECT, height, RADIUS, CHAR_COLOR);
		//canvas.drawRect(L_RECT, height, R_RECT , base, CHAR_COLOR);
		
		
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
			
			sound.play(Sound.PULO);
			//PULO � static, portanto acessado atrav�s diretamente da classe
		}
		
	}

	public float getHeight() {
		return this.height;
	}
}
