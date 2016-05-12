package br.com.tapflappy.engine;

import com.br.tapflappy.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import br.com.tapflappy.elements.Character;
import br.com.tapflappy.elements.GameOver;
import br.com.tapflappy.elements.Obstacle;
import br.com.tapflappy.elements.Obstacles;
import br.com.tapflappy.elements.Score;
import br.com.tapflappy.graphic.Screen;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Game extends SurfaceView implements Runnable, OnTouchListener {

	private boolean isRunning = true;
	private SurfaceHolder holder = getHolder();
	private Character character;
	private Bitmap background;
	private Screen screen;
	private Score score;
	private Sound sound;
	// private Obstacle obstacle;
	private Obstacles obstacles;
	private GameOver gameover;
	private Bitmap background2;
	private int alternador;
	private int variante1;
	private int variante2;
	private Context context;

	public Game(Context context) {
		super(context);
		this.context = context;
		screen = new Screen(context);
		sound = new Sound(context);
		setElements();
		setOnTouchListener(this);
	}

	private void setElements() {
		character = new Character(screen, sound, context);
		score = new Score();
		gameover = new GameOver();
		// obstacle = new Obstacle(screen, 275);
		obstacles = new Obstacles(screen, score);
		// background
		Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background1);
		background = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
		// background auxiliar
		Bitmap back2 = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
		background2 = Bitmap.createScaledBitmap(back2, back.getWidth(), screen.getHeight(), false);
		
		alternador = 1;
		variante1 = 0;
		variante2 = 0;

	}

	@Override
	public void run() {
		while (isRunning) {
			if (!holder.getSurface().isValid())
				continue;

			Canvas canvas = holder.lockCanvas();
			// canvas.drawBitmap(background, 0, 0, null);
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
				canvas.drawBitmap(background2, variante2, 0, null);
				variante2--;
				break;
			}

			// Character actions

			character.drawOnThe(canvas);
			// if(character.base + 100 < screen.getHeight()){
			character.drop();
			// }

			// Obstacle actions

			/*
			 * obstacle.drawOnThe(canvas); obstacle.move();
			 */
			obstacles.drawOnThe(canvas);
			obstacles.move();

			// Score actions
			// Score é desenhada depois dos canos pra ficar em cima deles, e não
			// sobreposto por eles
			// as camadas são desenhadas na ordem do código
			score.drawOnThe(canvas);

			if (new CollisionChecker(character, obstacles).hasCollision()) {
				gameover.drawOnThe(canvas, screen);
				isRunning = false;
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

}
