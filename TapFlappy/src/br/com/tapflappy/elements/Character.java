package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;
import br.com.tapflappy.engine.Sound;

public class Character {

	public static final float L_RECT = 100;
	public static final float R_RECT = 150;
	public static final float RADIUS = 50;
	public double time = 0;
	public double velocidade_inicial;
	private double time_atual = 0, time_anterior = 0;
	private double gravity = 450;

	private double height;
	public float base;
	private Screen screen;
	private Sound sound;
	

	private static final Paint CHAR_COLOR = Colors.getColorOfCharacter();
	public static final float X = 100;


	public Character(Screen screen, Sound sound) {

		this.screen = screen;
		this.sound = sound;
		this.base = 150;
		this.height = 100;

	}

	public void drawOnThe(Canvas canvas) {
		canvas.drawCircle(L_RECT, (float) height, RADIUS, CHAR_COLOR);
		// canvas.drawRect(L_RECT, height, R_RECT , base, CHAR_COLOR);

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

			height = (height + (velocidade_inicial * time) + ((3 * gravity * time * time) / 2));
			Log.d("dq", "height -   " + height);
			velocidade_inicial += (3 * gravity * time);

			time_anterior = time_atual;

		}

	}

	public void jump() {
		// if (height > 0) {

		for (int i = 0; i < 5; i++) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			height -= 35;
		}

		velocidade_inicial = 0;
		sound.play(Sound.PULO);
		// PULO é static, portanto acessado através diretamente da classe
	}

	public double getHeight() {
		return this.height;
	}
}
