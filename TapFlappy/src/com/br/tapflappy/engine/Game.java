package com.br.tapflappy.engine;

import com.br.tapflappy.R;
import com.br.tapflappy.elements.Character;
import com.br.tapflappy.graphic.Screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Game extends SurfaceView implements Runnable, OnTouchListener{
	
	private boolean isRunning = true;
	private SurfaceHolder holder = getHolder();
	private Character character;
	private Bitmap background;
	private Screen screen;

	public Game(Context context) {
		super(context);
		screen = new Screen(context);
		inicializaelementos();
		setOnTouchListener(this);
	}
	
	private void inicializaelementos() {
		character = new Character();
		Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
		background = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
		
	}

	@Override
	public void run() {
		while(isRunning){
			if (!holder.getSurface().isValid()) continue;
			
			Canvas canvas = holder.lockCanvas();
			canvas.drawBitmap(background, 0,0 , null);
			
			character.desenhaNo(canvas);
		//	if(character.base + 100 < screen.getHeight()){
				character.cai();
		//	}
			holder.unlockCanvasAndPost(canvas);
		
		}
		
	}

	public void inicia() {
		isRunning = true;
		
	}

	public void pausa() {
		isRunning = false;
		
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		character.pula();
		return false;
		
	}
	
}
	

