package br.com.tapflappy.engine;

import com.br.tapflappy.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import br.com.tapflappy.elements.Background;
import br.com.tapflappy.elements.Character;
import br.com.tapflappy.elements.Coin;
import br.com.tapflappy.elements.Coins;
import br.com.tapflappy.elements.GameOver;
import br.com.tapflappy.elements.Item;
import br.com.tapflappy.elements.Obstacle;
import br.com.tapflappy.elements.Obstacles;
import br.com.tapflappy.elements.Score;
import br.com.tapflappy.graphic.Animations;
import br.com.tapflappy.graphic.Assets;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Game extends SurfaceView implements Runnable, OnTouchListener {

	public boolean isRunning = true;
	private SurfaceHolder holder = getHolder();
	private Character character;
	private Background background;
	// private Bitmap backgroundAux;
	private Screen screen;
	private Score score;
	public static Sound sound;
	// private Obstacle obstacle;
	private Obstacles obstacles;
	private GameOver gameover;
	private int alternador;
	// private int variante1;
	// private int variante2;
	private Context context;
	private Canvas canvas; /** TODO Verificar isso aqui */
	private Item item;
	private int collisionResult;
	private int new_environment;
	private static int current_environment;
	
	public Animations effect;
	
	public boolean effectRunning;
	public int effectXpos, effectYpos;
	private Coins coins1, coins2;
	
	
	public Game(Context context) {
		super(context);
		this.context = context;
		screen = new Screen(context);
		sound = new Sound(context);
		setElements();
		
		setOnTouchListener(this);
		
		sound.start_music();
	}

	private void setElements() {
		
		
		//Pre-Loading Assets
		Assets.loadAssets(context);
		
		current_environment = 0;
		
		item = new Item(context,1600,400);
		
		character = new Character(screen, sound, context);
		score = new Score();
		gameover = new GameOver();
		
		
		//coin = new Animations(50, Assets.bmpCoins, 10,44,40);
		effect = new Animations(50, Assets.bmpExplosion, 6,73,119);
		effectRunning = false;
		// background
		background = new Background(context, screen);
		//Bitmap back1 = BitmapFactory.decodeResource(getResources(), R.drawable.background1);
		//background = Bitmap.createScaledBitmap(back1, back1.getWidth(), screen.getHeight(), false);
		
		// background auxiliar
		//backgroundAux = Background.generateAuxiliar(context, screen);;
		//Bitmap back2 = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
		//backgroundAux = Bitmap.createScaledBitmap(back2, back2.getWidth(), screen.getHeight(), false);
				
		// obstacle = new Obstacle(screen, 275);
		obstacles = new Obstacles(context,screen, score, character);
		coins1 = new Coins(context, screen, score, character , 730, obstacles);
		coins2 = new Coins(context, screen, score, character , 30, obstacles);
				
		//alternador = 1;
		//variante1 = 0;
		//variante2 = 0;

	}

	@Override
	public void run() {
		
		int counter = 0;
		
		while (isRunning) {
			if (!holder.getSurface().isValid())
				continue;

			Canvas canvas = holder.lockCanvas();
			// canvas.drawBitmap(background, 0, 0, null);
			/*
			if (variante1 <= -1735 + screen.getWidth()) {
				variante1 = 0;
				alternador = 2;

			} else if (variante2 <= -1735 + screen.getWidth()) {
				variante2 = 0;
				alternador = 1;

			}

			switch (alternador) {
			case 1:

				canvas.drawBitmap(background, variante1, 0, null);
				variante1--;
				break;

			case 2:
				canvas.drawBitmap(backgroundAux, variante2, 0, null);
				variante2--;
				break;
			}
			*/
			background.drawOnThe(canvas);
			background.move();
			
			// Item Actions		
			item.itemAnim.tick();
			
			item.itemAnim.tick();
			
			item.drawOnThe(canvas);
			item.move();

			
			//Coins Tests Animacao
			//coin.tick();
			//coin.drawOnThe(canvas, 400, 200, 50 ,50);
			
			// Character actions
			character.charAnim.tick();
			character.drawOnThe(canvas);
			//canvas.drawCircle(character.L_RECT, character.height, character.cRADIUS, Colors.getColorOfGameOver());
			character.setNewPosition();

			// Coins actions
			coins1.update();
			coins2.update();
			
			coins1.drawOnThe(canvas);
			coins2.drawOnThe(canvas);
			
			coins1.move();
			coins2.move();
			
			for(Coin coin: coins1.coins)
				if(coin.xPos<screen.getWidth())
					coin.coinAnim.tick();
			
			for(Coin coin: coins2.coins)
				if(coin.xPos<screen.getWidth())
					coin.coinAnim.tick();
			//coins.tick();
			
			// Obstacle actions
			obstacles.drawOnThe(canvas);
			obstacles.move();
			
			
			
			
			//Effect Actions
			if(effectRunning){
				Log.d("effect", "effect true");
				effect.tick();
				effect.drawOnThe(canvas,(int) (character.L_RECT-character.RADIUS)-30,(int) (character.height-character.RADIUS)-30, 125, 125);
				
				//counter++;
				
				if(effect.getIndex() >=5  ){
					effectRunning = false;
					effect.setIndex(0);
					counter = 0;
					}
				}
			// Score actions
			// Score � desenhada depois dos canos pra ficar em cima deles, e n�o
			// sobreposto por eles
			// as camadas s�o desenhadas na ordem do c�digo
			score.drawOnThe(canvas);
			
			//canvas.drawRect(character.L_RECT , character.height, character.R_RECT , character.height + character.RADIUS, character.getCharColor());
			
			collisionResult = new CollisionChecker(character, item, obstacles, coins1, coins2).hasCollision();
			//Log.d("Giz", "Tem tijolo de contru��o "+collisionResult);
			//Log.d("Eduardo", "e Monica "+current_environment);
			if (collisionResult != 0) {
				switch(collisionResult){
				
				case 1:
					
					sound.play(Sound.COLLIDE);
					sound.stop_music();
					coins1.counter+=coins2.counter;
					gameover.finalScoreCalculate(coins1.counter, score.score);
					gameover.drawOnThe(canvas, screen);
					isRunning = false;
					break;
					
				case 2:
					//item.Animation
					sound.play(Sound.ITEM_GET);
					effectRunning = true;
					
					effectXpos = (int) character.L_RECT;
					effectYpos = (int) character.height;
					
					new_environment = (int) (Math.random() * 3);
					while(new_environment == current_environment)
						new_environment = (int) (Math.random() * 3);
					current_environment = new_environment;
					
					sound.set_music(current_environment);
					break;
					
				case 3:
					//Log.d("coin", "coin collision");
					//sound.play(Sound.COIN_GET);
					break;
					
				}
			}

			holder.unlockCanvasAndPost(canvas);
		}

	}

	public void start() {
		isRunning = true;

	}

	public void pause() {
		isRunning = false;

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
			character.resetPosition(character.height);
			sound.play(sound.JUMP);
			
		return false;
	}

	public static int getCurrent_environment() {
		return current_environment;
	}

	public void setCurrent_environment(int current_environment) {
		this.current_environment = current_environment;
	}

	public static void play(int n) {
		sound.play(sound.COIN_GET);
	}

}
