package br.com.tapflappy.engine;

import com.br.tapflappy.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import br.com.tapflappy.elements.Character;
import br.com.tapflappy.elements.Obstacle;
import br.com.tapflappy.elements.Obstacles;
import br.com.tapflappy.graphic.Screen;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Game extends SurfaceView implements Runnable, OnTouchListener{
	
	private boolean isRunning = true;
	private SurfaceHolder holder = getHolder();
	private Character character;
	private Bitmap background;
	private Screen screen;
	// private Obstacle obstacle;
	private Obstacles obstacles;

	public Game(Context context) {
		super(context);
		screen = new Screen(context);
		setElements();
		setOnTouchListener(this);
	}
	
	private void setElements() {
		character = new Character(screen);
		// obstacle = new Obstacle(screen, 275);
		obstacles = new Obstacles(screen);
		Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
		background = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
		
	}

	@Override
	public void run() {
		while(isRunning){
			if (!holder.getSurface().isValid()) continue;
			
			Canvas canvas = holder.lockCanvas();
			canvas.drawBitmap(background, 0,0 , null);
			
			// Character actions
			
			character.drawOnThe(canvas);
		//	if(character.base + 100 < screen.getHeight()){
			character.drop();
		//	}
			
			// Obstacle actions
			
			/* obstacle.drawOnThe(canvas);
			obstacle.move(); */
			obstacles.drawOnThe(canvas);
			obstacles.move();
			
			
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
	

