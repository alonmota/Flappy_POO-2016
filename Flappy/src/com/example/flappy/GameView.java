package com.example.flappy;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements Runnable{

	private boolean isRunning = true;
	
	public GameView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GameView(Context context) {
		super(context);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	@Override
	public void run() {
		while(isRunning) {
			
		}
	}
	
	public void cancela() {
		this.isRunning = false;
	}
	
	public void inicia() {
		this.isRunning = true;
	}
	
}
