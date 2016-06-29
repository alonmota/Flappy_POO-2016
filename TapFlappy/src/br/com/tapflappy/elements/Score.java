package br.com.tapflappy.elements;

import br.com.tapflappy.graphic.Colors;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Score {

	private static final Paint BRANCO = Colors.getColorOfScore();
	public int score = 0;
	
	public void drawOnThe(Canvas canvas) {
		canvas.drawText(String.valueOf(score), 100, 100, BRANCO);
	}

	public void aumenta() {
		score++;
	}

}
