package br.com.tapflappy.elements;

import java.util.Random;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import br.com.tapflappy.engine.Game;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Coin  extends Element{


	private Screen screen;
	private int xPos;
	public static final int OBST_SIZE = 250;
	static final int OBST_WIDTH = 100;
	private int random;
	//private static final Paint OBST_COLOR = Colors.getColorOfObstacle();
	
	private Bitmap obstacleInfImg;
	private Bitmap obstacleSupImg;
	private Context context;
	private Bitmap bp[] = new Bitmap[3];
	private float height;

	public Coin(Context context, Screen screen, int xPos) {
		this.screen = screen;
		this.xPos = xPos;
		this.context = context;
	
		
		this.random = randomValue();
		
		 // Ou seja, o limite do obstaculo eh seu size...
		 // 0 -> topo da tela. OBS: o ponto (0,0) fica no canto superior esquerdo da tela
			
		//this.obstacleInfImg = Bitmap.createScaledBitmap(bp, (int)OBST_WIDTH, (int)(OBST_SIZE + random), false);
		//this.obstacleSupImg = Bitmap.createScaledBitmap(bp, (int)OBST_WIDTH, (int)(OBST_SIZE - random), false);
		}

	private int randomValue() {
		
		return (int) (Math.random() * 77);
	}

	public void drawOnThe(Canvas canvas) {
		drawCoin(canvas);
	}

	private void drawCoin(Canvas canvas) {
		
		height = 100;


		canvas.drawCircle(xPos, (float) height, 50, Colors.getColorOfCharacter());
	}
	
	public void move() {
		this.xPos -= 5;
	}

	public boolean outOfBounds() {
		
		return (xPos + 50) < 0; /* lateral direita do obstaculo 
											sai da tela (passa da menor posicao possivel,
											 que eh o 0) = obstaculo invisivel
		 								*/
	}
	

	public int getPosition() {
		return xPos;
	}

	public boolean hasHorizontalCollisionWith(Character character) {
		
		return this.xPos < Character.R_RECT;/*se a posição do personagem + seu raio
		 															for maior que a posição do cano, 
		 															significa que houve colisão do passaro com a tela
		 															*/
	}

	public boolean hasVerticalCollisionWith(Character character) {
		
		return character.height < this.xPos+50 || character.height < this.xPos-50;
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
