package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class GameOver {
	private static final Paint VERMELHO = Colors.getColorOfGameOver();

	public void drawOnThe(Canvas canvas, Screen screen) {
		canvas.drawText("Game Over", screen.getWidth() / 5, screen.getHeight() / 2, VERMELHO);

	}
	
}

