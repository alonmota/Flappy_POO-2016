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
import br.com.tapflappy.elements.GameOver;
import br.com.tapflappy.elements.Item;
import br.com.tapflappy.elements.Obstacle;
import br.com.tapflappy.elements.Obstacles;
import br.com.tapflappy.elements.Score;
import br.com.tapflappy.graphic.Assets;
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
	private Sound sound;
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
	
	
	public Game(Context context) {
		super(context);
		this.context = context;
		screen = new Screen(context);
		sound = new Sound(context);
		setElements();
		
		setOnTouchListener(this);
		
		sound.music(Sound.MUSIC_GAME);
	}

	private void setElements() {
		
		//Pre-Loading Assets
		Assets.loadAssets(context);
		
		current_environment = 0;
		
		item = new Item(context,1600,400);
		
		character = new Character(screen, sound, context);
		score = new Score();
		gameover = new GameOver();
		
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
				
		//alternador = 1;
		//variante1 = 0;
		//variante2 = 0;

	}

	@Override
	public void run() {
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
			item.drawOnThe(canvas);
			item.move();

			// Character actions
			character.charAnim.tick();
			character.drawOnThe(canvas);
			if(character.base < screen.getHeight()){
				character.drop();
			}

			// Obstacle actions

			/*
			 * obstacle.drawOnThe(canvas); obstacle.move();
			 */
			
			obstacles.drawOnThe(canvas);
			obstacles.move();

			// Score actions
			// Score � desenhada depois dos canos pra ficar em cima deles, e n�o
			// sobreposto por eles
			// as camadas s�o desenhadas na ordem do c�digo
			score.drawOnThe(canvas);
			
			//canvas.drawRect(character.L_RECT , character.height, character.R_RECT , character.height + character.RADIUS, character.getCharColor());
			
			collisionResult = new CollisionChecker(character, item, obstacles).hasCollision();
			//Log.d("Giz", "Tem tijolo de contru��o "+collisionResult);
			//Log.d("Eduardo", "e Monica "+current_environment);
			if (collisionResult != 0) {
				switch(collisionResult){
				
				case 1:
					sound.play(Sound.COLLIDE);
					gameover.drawOnThe(canvas, screen);
					isRunning = false;
					break;
					
				case 2:
					//item.Animation
					new_environment = (int) (Math.random() * 3);
					while(new_environment == current_environment)
						new_environment = (int) (Math.random() * 3);
					current_environment = new_environment;
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
		character.jump();
		return false;

	}

	public static int getCurrent_environment() {
		return current_environment;
	}

	public void setCurrent_environment(int current_environment) {
		this.current_environment = current_environment;
	}

}
