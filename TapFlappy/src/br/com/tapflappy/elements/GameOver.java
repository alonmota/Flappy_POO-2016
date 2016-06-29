package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class GameOver {
	private static final Paint VERMELHO = Colors.getColorOfGameOver();
	private static final Paint VERDE = Colors.getColorOfScore();
	private static final Paint LARANJA = Colors.getColorBlack();
	
	private int finalScore;
	
	public void drawOnThe(Canvas canvas, Screen screen) {
		
		VERDE.setTextSize(60);
		LARANJA.setTextSize(30);
		
		canvas.drawText("Game Over", screen.getWidth() / 10, screen.getHeight() / 2, VERMELHO);
		canvas.drawText("Final Score: "+finalScore,screen.getWidth() / 10, screen.getHeight() / 2+100 , VERDE);
		
		VERMELHO.setTextSize(50);
		canvas.drawText("Press return button", screen.getWidth()/4, screen.getHeight() / 2+250 , LARANJA);
		
	}
	
	public void finalScoreCalculate(int nCoins, int score){
		finalScore = 2*nCoins + score;
	}
	
}

