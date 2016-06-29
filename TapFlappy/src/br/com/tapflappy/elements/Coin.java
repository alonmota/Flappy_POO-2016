package br.com.tapflappy.elements;

import java.util.Random;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import br.com.tapflappy.engine.Game;
import br.com.tapflappy.graphic.Animations;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Coin  extends Element{


	private Screen screen;
	public int xPos;
	public static final int OBST_SIZE = 250;
	public static final int OBST_WIDTH = 100;
	public static final int RAIO = 25;
	private Random random;
	//private static final Paint OBST_COLOR = Colors.getColorOfObstacle();
	

	private Context context;
	private Bitmap bp[] = new Bitmap[3];
	public float height;

	public Animations coinAnim;
	
	public Coin(Context context, Screen screen, int xPos, float height) {
		this.screen = screen;
		this.xPos = xPos;
		this.context = context;
		this.random = new Random();
		this.height = height;
	
		this.coinAnim = new Animations(1, Assets.bmpCoins, 10,44,40);
		
	
		
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
		
		//canvas.drawCircle(xPos, (float) height, RAIO, Colors.getColorOfCharacter());
		canvas.drawBitmap(Bitmap.createScaledBitmap(coinAnim.getCurrentFrame(),
							(int)RAIO*2,
							(int)RAIO*2,
							false), 
							xPos-RAIO, 
						  (float) (height- RAIO), 
						  null);
	}
	
	public void move() {
		this.xPos -= 5;
	}

	public boolean outOfBounds() {
		
		return (xPos + RAIO) < 0; /* lateral direita do obstaculo 
											sai da tela (passa da menor posicao possivel,
											 que eh o 0) = obstaculo invisivel
		 								*/
	}
	

	public int getPosition() {
		return xPos;
	}
	public float getHeight() {
		return height;
	}
	

	public boolean hasHorizontalCollisionWith(Character character) {
		
		return this.xPos < Character.R_RECT;/*se a posi��o do personagem + seu raio
		 															for maior que a posi��o do cano, 
		 															significa que houve colis�o do passaro com a tela
		 															*/
	}


	@Override
	public boolean hasCollisionWith(Character character) {
		return character.RADIUS + character.L_RECT > this.xPos-RAIO && character.height  > this.height-RAIO 
		&& character.height < this.height+RAIO;
	}

	@Override
	public boolean hasVerticalCollisionWith(Character character) {
		// TODO Auto-generated method stub
		return false;
	}


}
