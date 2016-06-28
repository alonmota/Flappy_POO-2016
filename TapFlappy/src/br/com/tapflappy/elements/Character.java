package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import br.com.tapflappy.graphic.Animations;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;
import br.com.tapflappy.engine.CollisionChecker;
import br.com.tapflappy.engine.Sound;
import br.com.tapflappy.engine.Game;

import com.br.tapflappy.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class Character {

	public static final float L_RECT = 110;
	public static final float R_RECT = 190;
	public static final float RADIUS = 50;
	public double time = 0;
	public double velocidade_inicial;
	private double time_atual = 0, time_anterior = 0;
	private double gravity = 250;

	public float height;
	public float base;
	private Screen screen;
	private Sound sound;
	private Bitmap characterFrames[] = new Bitmap[10];
	private Obstacle obstacle;

	public Animations charAnim;

	private static final Paint CHAR_COLOR = Colors.getColorOfCharacter();
	public static final float X = 100;


	public Character(Screen screen, Sound sound, Context context) {

		this.screen = screen;
		this.sound = sound;
		this.base = 200;
		this.height = 100;
		this.charAnim = new Animations(1,Assets.bmpChar);
		
//		characterFrames[0] = Bitmap.createScaledBitmap(Assets.bmpChar[0],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[1] = Bitmap.createScaledBitmap(Assets.bmpChar[1],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[2] = Bitmap.createScaledBitmap(Assets.bmpChar[2],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[3] = Bitmap.createScaledBitmap(Assets.bmpChar[3],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[4] = Bitmap.createScaledBitmap(Assets.bmpChar[4],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[5] = Bitmap.createScaledBitmap(Assets.bmpChar[5],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[6] = Bitmap.createScaledBitmap(Assets.bmpChar[6],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[7] = Bitmap.createScaledBitmap(Assets.bmpChar[7],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[8] = Bitmap.createScaledBitmap(Assets.bmpChar[8],(int)RADIUS*2,(int)RADIUS*2,false);
//		characterFrames[9] = Bitmap.createScaledBitmap(Assets.bmpChar[9],(int)RADIUS*2,(int)RADIUS*2,false);
//				
		
		//Bitmap bp = Assets.bmpChar;
		//this.character = Bitmap.createScaledBitmap(bp, (int)RADIUS*2, (int)RADIUS*2, false);
	}

	public void drawOnThe(Canvas canvas) {
		//canvas.drawCircle(L_RECT, (float) height, RADIUS, CHAR_COLOR); CIRCULO VERIFICADOR
		//canvas.drawRect(L_RECT, height, R_RECT , base, CHAR_COLOR);
		
		canvas.drawBitmap(Bitmap.createScaledBitmap(charAnim.getCurrentFrame(),
							(int)RADIUS*2,
							(int)RADIUS*2,
							false), 
						  L_RECT-RADIUS, 
						  (float) (height-RADIUS), 
						  null);
	}

	public void drop() {

		boolean floor = base > screen.getHeight();

		/*
		 * if(!floor) { this.height += 5; this.base += 5; }
		 */
		if (time_anterior == 0) {
			time_atual = SystemClock.uptimeMillis() * 0.001f;
			time_anterior = SystemClock.uptimeMillis() * 0.001f;

			time = time_atual;

			velocidade_inicial = 0;

		} else {

			time_atual = SystemClock.uptimeMillis() * 0.001f;

			time = time_atual - time_anterior;

			height = (float) (height + (velocidade_inicial * time) + ((1 * gravity * time * time) / 2));
			base = (float) (height + 50);
			
			//Log.d("dq", "height -   " + height);
			//Log.d("dq", "Current -Anterioir: "+(time_atual - time_anterior));
			
			
			velocidade_inicial += (3 * gravity * time);

			time_anterior = time_atual;

		}

	}

	public void jump() {
		
		/*if (new CollisionChecker(character, obstacles).hasCollision()) {
			sound.play(Sound.COLLIDE);
			gameover.drawOnThe(canvas, screen);
			isRunning = false;
			continue; 
			/** TODO Pensar a respeito dessa colisao 
		} */
		
		// if (height > 0) {

		for (int i = 0; i < 5; i++) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			height -= 3;
			base -= 35;
			
		}

		velocidade_inicial = 0;
		sound.play(Sound.JUMP);
		// PULO é static, portanto acessado através diretamente da classe
	}

	public static Paint getCharColor() {
		return CHAR_COLOR;
	}

	

}