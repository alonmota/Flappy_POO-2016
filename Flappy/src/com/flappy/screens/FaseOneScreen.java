package com.flappy.screens;

import com.example.flappy.R;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

/*public class FaseOneScreen extends Activity { /* Essa é a classe de view para a fase 1; */

	//private boolean running = true;
	
/*	public FaseOneScreen(Context context) {
		super(context);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 /*       setContentView(R.layout-finger.fase1);
        
        playButon = (Button) findViewById(R.id.PLAY);
        quitButton = (Button) findViewById(R.id.QUIT);
          
    	playButon.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				fase1scr = new Intent(getApplicationContext(), FaseOneScreen.class);
				startActivity(fase1scr);
				
			};
		});
    	
    	quitButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/* Aqui sai do jogo; 
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				
			}
		});
    	
    }  
	
	
	@Override
	public void run() {
		while(running)
		{
			
		}
	}
	
    public void cancela() {
        this.running = false;
    }

	
	
	/*public GameView(Context context, AttributeSet attrs, int defStyleAttr,
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
	
};*/
