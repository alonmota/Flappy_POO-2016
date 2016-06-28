package br.com.tapflappy.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import android.content.Context;
import android.graphics.Canvas;
import br.com.tapflappy.graphic.Screen;

public class Coins {
	private static final int NUM_OF_COINS = 5;
	private static final int COINS_DIST = 700;
	private Character character;
	
	private final List<Coin> coins = new ArrayList<Coin>();
	
	private Screen screen;
	private Score score;
	private Context context;

	public Coins(Context context, Screen screen, Score score, Character charac) {
		this.screen = screen;
		int position = 750; // 275 antes		
		this.character = charac;
		
		for (int i = 0; i < NUM_OF_COINS; i++) {
			position += COINS_DIST;
			Coin coin = new Coin(context, screen, position);
			coins.add(coin);
		}
		
	}

	public void drawOnThe(Canvas canvas) {
		for (Coin coin : coins) {
			coin.drawOnThe(canvas);
		}
	}

	public void move() {
		ListIterator<Coin> iterator = coins.listIterator();
		while(iterator.hasNext()){
			Coin coin = iterator.next();
			coin.move();
			//Log.d("Saindo", "\n\n\nVai sair a qualquer momento da tela\n\n\n");
			if(coin.outOfBounds()){
				/*score.aumenta();*/ // aumenta a pontuação quando o obstaculo sai da tela
				// gerar novo obstaculo e apagar antigo			
				iterator.remove();
				//Log.d("Saiu", "\n\n\nSaiu da tela\n\n\n");
				Coin auxCoin = new Coin(context, screen, getMaxPos() + COINS_DIST);
				iterator.add(auxCoin);
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
