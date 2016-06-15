package br.com.tapflappy.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Obstacle {

	private Screen screen;
	private int inferiorObstacleHeight;
	private int position;
	private float superiorObstacleHeight;
	public static final int OBST_SIZE = 250;
	static final int OBST_WIDTH = 100;
	private static final Paint OBST_COLOR = Colors.getColorOfObstacle();

	public Obstacle(Screen screen, int position) {
		this.screen = screen;
		this.position = position;
		inferiorObstacleHeight = screen.getHeight() - OBST_SIZE + randomValue(); // Ou seja, o limite do obstaculo eh seu size...
		superiorObstacleHeight = 0 + OBST_SIZE - randomValue(); // 0 -> topo da tela. OBS: o ponto (0,0) fica no canto superior esquerdo da tela
	}

	private int randomValue() {
		
		return (int) (Math.random() * 77);
	}

	public void drawOnThe(Canvas canvas) {
		drawInferiorObstacleOnThe(canvas);
		drawSuperiorObstacleOnThe(canvas);
	}

	private void drawInferiorObstacleOnThe(Canvas canvas) {
		canvas.drawRect(position, inferiorObstacleHeight, (position + OBST_WIDTH), screen.getHeight(), OBST_COLOR);
	}
	
	private void drawSuperiorObstacleOnThe(Canvas canvas) {
		canvas.drawRect(position, 0, (position + OBST_WIDTH), superiorObstacleHeight, OBST_COLOR);
	}

	public void move() {
		this.position -= 5;
	}

	public boolean outOfBounds() {
		
		return position + OBST_WIDTH < 0; /* lateral direita do obstaculo 
											sai da tela (passa da menor posicao possivel,
											 que eh o 0) = obstaculo invisivel
		 								*/
	}
	

	public int getPosition() {
		return position;
	}

	public boolean hasHorizontalCollisionWith(Character character) {
		
		return this.position < character.L_RECT + character.RADIUS;/*se a posição do personagem + seu raio
		 															for maior que a posição do cano, 
		 															significa que houve colisão do passaro com a tela
		 															*/
	}

	public boolean hasVerticalCollisionWith(Character character) {
		
		return character.getHeight() - character.RADIUS < this.superiorObstacleHeight
				|| character.getHeight() + character.RADIUS > this.inferiorObstacleHeight;
	}

}

