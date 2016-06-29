package br.com.tapflappy.elements;

import com.br.tapflappy.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.engine.Game;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;
import br.com.tapflappy.graphic.Assets;;

public class Obstacle extends Element {

	private Screen screen;
	int inferiorObstacleHeight;
	private int xPos;
	float superiorObstacleHeight;
	public static final int OBST_SIZE = 250;
	static final int OBST_WIDTH = 100;
	private int random;
	//private static final Paint OBST_COLOR = Colors.getColorOfObstacle();
	
	private Bitmap obstacleInfImg;
	private Bitmap obstacleSupImg;
	private Context context;
	private Bitmap bp[] = new Bitmap[3];

	public Obstacle(Context context, Screen screen, int xPos) {
		this.screen = screen;
		this.xPos = xPos;
		this.context = context;
	
		bp[0] = Assets.bmpObst[0];
		bp[1] = Assets.bmpObst[1];
		bp[2] = Assets.bmpObst[2];
		
		this.random = randomValue();
		
		inferiorObstacleHeight = screen.getHeight() - (OBST_SIZE + random); // Ou seja, o limite do obstaculo eh seu size...
		superiorObstacleHeight = 0 + (OBST_SIZE - random); // 0 -> topo da tela. OBS: o ponto (0,0) fica no canto superior esquerdo da tela
			
		//this.obstacleInfImg = Bitmap.createScaledBitmap(bp, (int)OBST_WIDTH, (int)(OBST_SIZE + random), false);
		//this.obstacleSupImg = Bitmap.createScaledBitmap(bp, (int)OBST_WIDTH, (int)(OBST_SIZE - random), false);
		}

	private int randomValue() {
		
		return (int) (Math.random() * 77);
	}

	public void drawOnThe(Canvas canvas) {
		drawInferiorObstacleOnThe(canvas);
		drawSuperiorObstacleOnThe(canvas);
	}

	private void drawInferiorObstacleOnThe(Canvas canvas) {
		//canvas.drawRect(position, inferiorObstacleHeight, (position + OBST_WIDTH), screen.getHeight(), OBST_COLOR);
		canvas.drawBitmap(Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()],
													(int)OBST_WIDTH,
													(int)(OBST_SIZE + random),
													false), xPos, (float) inferiorObstacleHeight, null);
		//canvas.dra
	}
	
	private void drawSuperiorObstacleOnThe(Canvas canvas) {
		//canvas.drawRect(position, 0, (position + OBST_WIDTH), superiorObstacleHeight, OBST_COLOR);
		canvas.drawBitmap(Bitmap.createScaledBitmap(bp[Game.getCurrent_environment()],
													(int)OBST_WIDTH,
													(int)(OBST_SIZE - random),
													false), xPos, 0, null);
	}

	public void move() {
		this.xPos -= 5;
	}

	public boolean outOfBounds() {
		
		return (xPos + OBST_WIDTH) < 0; /* lateral direita do obstaculo 
											sai da tela (passa da menor posicao possivel,
											 que eh o 0) = obstaculo invisivel
		 								*/
	}
	

	public int getPosition() {
		return xPos;
	}

	public boolean hasHorizontalCollisionWith(Character character) {
		
		return this.xPos < character.L_RECT+character.cRADIUS-20;/*se a posição do personagem + seu raio
		 															for maior que a posição do cano, 
		 															significa que houve colisão do passaro com a tela
		 															*/
	}

	public boolean hasVerticalCollisionWith(Character character) {
		
		return (character.height - character.cRADIUS < this.superiorObstacleHeight && character.L_RECT - character.cRADIUS < this.xPos + OBST_WIDTH)
				|| (character.height + character.cRADIUS> this.inferiorObstacleHeight && character.L_RECT - character.cRADIUS < this.xPos + OBST_WIDTH);
	}

	@Override
	public boolean hasCollisionWith(Character character) {
		if(this.hasHorizontalCollisionWith(character) 
				&& this.hasVerticalCollisionWith(character)){
			return true;
		}
		return false;
	}

}

