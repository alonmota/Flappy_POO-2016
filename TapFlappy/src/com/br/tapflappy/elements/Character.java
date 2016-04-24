package com.br.tapflappy.elements;

import com.br.tapflappy.graphic.Colors;
import com.br.tapflappy.graphic.Screen;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Character {
	
	private static final float X = 100;
	private float altura;
	public float base;
	private Screen screen;
	private static final  float RAIO= 50;
	private static final Paint VERMELHO = Colors.getColorOfCharacter();
	
	
	public Character(){
		
		this.base = 150;
		this.altura = 100;
		
	}

	public void desenhaNo(Canvas canvas){
		//canvas.drawCircle(X, altura, RAIO, VERMELHO);
		canvas.drawRect(100, altura, 150, base, VERMELHO);
		
		
		
	}

	public void cai() {
		
			this.altura +=6;                                                                             
			this.base += 6;
	
		
	}

	public void pula() {
		this.altura -=150;
		this.base -=150;
		
	}
}
