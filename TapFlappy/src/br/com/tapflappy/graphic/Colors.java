package br.com.tapflappy.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Colors {

	public static Paint getColorOfCharacter() {
		Paint paintChar = new Paint();
		paintChar.setColor(0xFFFFA500); // FF0000 -> Vermelho; FFA500 ->
										// Laranja;

		return paintChar;
	}

	public static Paint getColorOfObstacle() {
		Paint paintObst = new Paint();
		paintObst.setColor(0xFF10A350); // 10A350 -> Verde musgo;

		return paintObst;
	}

	public static Paint getColorOfGameOver() {
		Paint paintScore = new Paint();
		paintScore.setColor(0xFFFF0000); // FFFFFF -> Branco
		paintScore.setTextSize(80); // aumenta o tamanho do texto
		paintScore.setTypeface(Typeface.DEFAULT_BOLD);
		paintScore.setShadowLayer(3, 5, 5, 0xFF000000); // sombreia a pontuação
		return paintScore;
	}

	public static Paint getColorOfScore() {
		Paint paintScore = new Paint();
		paintScore.setColor(0xFFFFFFFF); // FFFFFF -> Branco
		paintScore.setTextSize(80); // aumenta o tamanho do texto
		paintScore.setTypeface(Typeface.DEFAULT_BOLD);
		paintScore.setShadowLayer(3, 5, 5, 0xFF000000); // sombreia a pontuação
		return paintScore;
	}
	public static Paint getColorBlack() {
		Paint paintScore = new Paint();
		paintScore.setColor(0x000000); // FFFFFF -> Branco
		paintScore.setTextSize(80); // aumenta o tamanho do texto
		paintScore.setTypeface(Typeface.DEFAULT_BOLD);
		paintScore.setShadowLayer(3, 5, 5, 0xFF000000); // sombreia a pontuação
		return paintScore;
	}
}
