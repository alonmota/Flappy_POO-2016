package br.com.tapflappy.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import br.com.tapflappy.engine.Game;
import br.com.tapflappy.engine.Sound;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Coins {
	private static final int NUM_OF_COINS = 50;
	private static final int COINS_DIST = 700 ;
	private Character character;
	
	public final List<Coin> coins = new ArrayList<Coin>();
	
	private Screen screen;
	private Score score;
	private Context context;
	private Random random = new Random();
	private float height;
	public int counter = 0;
	
	public Coins(Context context, Screen screen, Score score, Character charac) {
		this.screen = screen;
		int position = 275; // 275 antes		
		this.character = charac;
		this.height = random.nextInt((screen.getHeight()) + 1) + 300;
		
		for (int i = 0; i < NUM_OF_COINS; i++) {
			position += COINS_DIST;
			
			Coin coin = new Coin(context, screen, position, height );
			Coin coin2 = new Coin(context, screen, position+50, height + 35);
			Coin coin3 = new Coin(context, screen, position+100,height + 70);
			Coin coin4 = new Coin(context, screen, position+150,height + 105);
			Coin coin5 = new Coin(context, screen, position+200,height + 70);
			Coin coin6 = new Coin(context, screen, position+ 250,height + 35);
			Coin coin7 = new Coin(context, screen, position+300,height);
			
			coins.add(coin);
			coins.add(coin2);
			coins.add(coin3);
			coins.add(coin4);
			coins.add(coin5);
			coins.add(coin6);
			coins.add(coin7);
		
			
		}
		
	}

	public void drawOnThe(Canvas canvas) {
		for (Coin coin : coins) {
			
			if(coin.xPos < screen.getWidth())
				//canvas.drawCircle(coin.xPos-coin.RAIO, coin.height- coin.RAIO, coin.RAIO, Colors.getColorOfCharacter());
			    coin.drawOnThe(canvas);
			    //coin.coinAnim.drawOnThe(canvas,coin.xPos-coin.RAIO, (int) (coin.height- coin.RAIO), coin.RAIO,coin.RAIO);
			//coin.drawOnThe(canvas);
		}
	}

	public void tick(){
		for(Coin coin: coins)
			coin.coinAnim.tick();
	}
	public void move() {
		ListIterator<Coin> iterator = coins.listIterator();
		while(iterator.hasNext()){
			Coin coin = iterator.next();
			coin.move();
			
			//Log.d("Saindo", "\n\n\nVai sair a qualquer momento da tela\n\n\n");
			if(coin.outOfBounds()){
				/*score.aumenta();*/ // aumenta a pontua��o quando o obstaculo sai da tela
				// gerar novo obstaculo e apagar antigo			
				iterator.remove();
				//Log.d("Saiu", "\n\n\nSaiu da tela\n\n\n");
				//Coin auxCoin = new Coin(context, screen, getMaxPos() + COINS_DIST);
				//iterator.add(auxCoin);
			}else if (coin.hasCollisionWith(character)) {
				iterator.remove();
				counter++;
				Game.play(Sound.COIN_GET);
			}
			
		}
	}

	private int getMaxPos() {
		int max = 0;
		for (Coin coin: coins) {
			max = Math.max(coin.getPosition(), max);
		}
		return max;
	}

	public boolean hasCollisionWith(Character character) {
		for(Coin coin : coins) {
			if(coin.hasCollisionWith(character)){
				return true;
			}
		}
		return false;
	}
}
