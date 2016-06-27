package br.com.tapflappy.elements;

import br.com.tapflappy.engine.Game;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Screen;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

	private Bitmap background1;
	private Bitmap background2;
	private Screen screen;
	private int variante;
	private int alternador = 1;
	private Context context;
	private Bitmap bp[][] = new Bitmap[3][2];
	
	public Background(Context context, Screen screen){
		//this.context = context;
		this.screen = screen;
		//this.alternador = 1;
		bp[0][0] = Assets.bmpBackground[0][0];
		bp[0][1] = Assets.bmpBackground[0][1];
		
		bp[1][0] = Assets.bmpBackground[1][0];
		bp[1][1] = Assets.bmpBackground[1][1];
		
		bp[2][0] = Assets.bmpBackground[2][0];
		bp[2][1] = Assets.bmpBackground[2][1];
	}
	
//	public void generateOriginal(Context context, Screen screen){
//		//Bitmap bp1 = Assets.bmpBackground[Game.getCurrent_environment()][0];
//		this.background1 = Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()][0], 
//													 bp[Game.getCurrent_environment()][0].getWidth(), 
//													 screen.getHeight(), 
//													 false);
//	}
//	
//	public void generateAuxiliar(Context context, Screen screen){
//		//Bitmap bp2 = Assets.bmpBackground[Game.getCurrent_environment()][1];	
//		this.background2 = Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()][1], 
//				 									bp[Game.getCurrent_environment()][1].getWidth(), 
//				 									screen.getHeight(), 
//				 									false);
//	}
	
	public void move(){
		
		if (variante <= -1000+ screen.getWidth() ) { //screen.getWidth()
			variante = 0;
			this.alternador = this.alternador*(-1);

		}
		
		variante--;
		
	}
	
	public void drawOnThe(Canvas canvas){
		switch (this.alternador) {
		case 1:
			drawOriginalBgOnThe(canvas);
			break;

		case -1:
			drawAuxiliarBgOnThe(canvas);
			break;
		}
	}
	
	public void drawOriginalBgOnThe(Canvas canvas){
		//this.generateOriginal(context, screen);
		canvas.drawBitmap(Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()][0], 
				 bp[Game.getCurrent_environment()][0].getWidth(), 
				 screen.getHeight(), 
				 false), variante, 0, null);
	}
	
	public void drawAuxiliarBgOnThe(Canvas canvas){
		//this.generateAuxiliar(context, screen);
		canvas.drawBitmap(Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()][1], 
					bp[Game.getCurrent_environment()][1].getWidth(), 
					screen.getHeight(), 
					false), variante, 0, null);
	}

}
