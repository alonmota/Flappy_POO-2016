package br.com.tapflappy.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import br.com.tapflappy.engine.Game;
import br.com.tapflappy.engine.Sound;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Coins {
	private static final int NUM_OF_COINS = 50;
	private static final int COINS_DIST = 700 ;
	private static final int COINS_INTERHORIZ_DIST = 80 ;
	private static final int COINS_INTERVERT_DIST = 20 ;
	
	private int p;
	
	private Character character;
	
	public List<Coin> coins = new ArrayList<Coin>();
	
	private Screen screen;
	private Score score;
	private Context context;
	private Random random = new Random();
	private float height;
	public int counter = 0, offset;
	public Obstacles obstacles;
	
	//private int [][]pattern = new int[5][6];
	private int newPattern(){
		int p  =(int) random.nextInt(4);
		return p;
	}
	private int [][]pattern = {{0, 1, 2 , 3, 2, 1, 0}, {0, 1, 2 , 3, 4, 5, 6}, {0, -1,-2 , -3, -2, -1, 0},{4, 2, 1 , 3, 0, 0, 0},{4,4, 1 , 2, 3, 0, 0}};
	
	public void update(){
		//int max = this.getMaxPos();
		if(coins.isEmpty())
			coins = new Coins(context, screen,  score,  character, obstacles.getMaxPos()-4*700+30, this.obstacles).coins;
		
	}
	public Coins(Context context, Screen screen, Score score, Character charac, int offset, Obstacles obst) {
		this.screen = screen;
		int position = 50; // 275 antes		
		this.character = charac;
		this.offset = offset;
		this.height = (float) (Math.random()*250 + 220);
		this.obstacles = obst;
		int p = newPattern();
		Log.d("p", "p valor: "+p);
		//LEVA DE 7 MOEDAS SEGUINDO UM PADRAO, A PARTIR DE UMA ALTURA RANDOM!
			for (int i = 0; i < 1; i++) {
				position = COINS_DIST;
//				position += COINS_DIST;
//				Coin coin1 = new Coin(context, screen, position, this.height +pattern[p][0] );
//				Coin coin2 = new Coin(context, screen, position, this.height +pattern[p][1]);
//				Coin coin3 = new Coin(context, screen, position, this.height +pattern[p][2]);
//				Coin coin4 = new Coin(context, screen, position, this.height +pattern[p][3]);
//				Coin coin5 = new Coin(context, screen, position, this.height +pattern[p][4]);
//				Coin coin6 = new Coin(context, screen, position, this.height +pattern[p][5]);
//				Coin coin7 = new Coin(context, screen, position, this.height +pattern[p][6]);
				
				Coin coin1 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST , this.height  +pattern[p][0]*COINS_INTERVERT_DIST);
				Coin coin2 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*2, this.height +pattern[p][1]*COINS_INTERVERT_DIST);
				Coin coin3 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*3, this.height +pattern[p][2]*COINS_INTERVERT_DIST);
				Coin coin4 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*4, this.height +pattern[p][3]*COINS_INTERVERT_DIST);
				Coin coin5 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*5, this.height +pattern[p][4]*COINS_INTERVERT_DIST);
				Coin coin6 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*6, this.height +pattern[p][5]*COINS_INTERVERT_DIST);
				Coin coin7 = new Coin(context, screen,offset+ position+COINS_INTERHORIZ_DIST*7, this.height +pattern[p][6]*COINS_INTERVERT_DIST);
				
				coins.add(coin1);
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
				/*score.aumenta();*/ // aumenta a pontuação quando o obstaculo sai da tela
				// gerar novo obstaculo e apagar antigo			
				iterator.remove();
				//Log.d("Saiu", "\n\n\nSaiu da tela\n\n\n");
				//Coin auxCoin = new Coin(context, screen,300, getMaxPos() + COINS_DIST);
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
